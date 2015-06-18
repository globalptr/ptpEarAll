/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEntity;
import com.oakeel.ejb.entityAndEao.frontUserIncomeProportion.FrontUserIncomeProportionEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUserIncomeProportion.FrontUserIncomeProportionEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.repayItem.RepayItemEntity;
import com.oakeel.ejb.ptpEnum.BondNatureEnum;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class TransferPersonalBond {

    /**
     * Creates a new instance of TransferPersonalBond
     */
    @EJB FrontUserIncomeProportionEaoLocal frontUserIncomeProportionEaoLocal;
    @EJB FrontUserHoldPersonalBondEaoLocal frontUserHoldPersonalEaoLocal;
    @EJB private FrontUserEaoLocal frontUserEaoLocal;
    @Inject private PtpSessionBean ptpSessionBean;
    private FrontUserHoldPersonalBondEntity srcHoldPersonalBond;//原始控标实体
    private PersonalBondEntity srcPersonalBondEntity;//原始个人标实体
    private FrontUserIncomeProportionEntity srcFrontUserIncomeItem;//原始收益条目实体
    private int transferNum;//转让数
    private BigDecimal transferRate;//转让利率
    private Date transferDate;//转让时间
    private FrontUserEntity buyer;//买方
    private FrontUserIncomeProportionEntity sellerIncomeChangeParts;//卖方收益变动部分
    private FrontUserIncomeProportionEntity sellerIncomeFixParts;//卖方收益固定部分
    private FrontUserIncomeProportionEntity currSellerIncomePart;//卖方交易期收益变动
    
    private FrontUserIncomeProportionEntity buyerIncomeChangeParts;//买方收益变动部分
    private FrontUserIncomeProportionEntity currBuyerIncomePart;//买方交易期收益变动
    

    private BigDecimal beforeRatio;
    private BigDecimal afterRatio;
    public TransferPersonalBond() {
    }
    @PostConstruct
    public void init()
    {
        srcHoldPersonalBond=ptpSessionBean.getSelectHoldPersonalBond();
        srcPersonalBondEntity=srcHoldPersonalBond.getPersonalBondEntity();
        sellerIncomeFixParts=srcFrontUserIncomeItem=ptpSessionBean.getSelectFrontUserIncomeItem();
        transferNum=srcFrontUserIncomeItem.getCopiesNum();
        transferRate=srcPersonalBondEntity.getYearRate();
        currSellerIncomePart=new FrontUserIncomeProportionEntity();
        currBuyerIncomePart=new FrontUserIncomeProportionEntity();
    }

    public void caculateTransfer()
    {
        
        BigDecimal one=new BigDecimal(1);
        int srcCopiesNum=srcFrontUserIncomeItem.getCopiesNum();
        int bondCopiesNum=srcPersonalBondEntity.getIssueCopiesNum();
        int sellerCopies=srcCopiesNum-transferNum;
        BigDecimal sellerCopiesBig=new BigDecimal(sellerCopies);
        BigDecimal buyerCopiesBig=new BigDecimal(transferNum);
        BigDecimal bondCopiesNumBig=new BigDecimal(bondCopiesNum);
        BigDecimal sellerCopiesProportion=sellerCopiesBig.divide(bondCopiesNumBig);
        BigDecimal buyerCopiesProportion=buyerCopiesBig.divide(bondCopiesNumBig,2, BigDecimal.ROUND_HALF_EVEN);
        
        //原始收益系数*转让利率/原利率 等于买方收益系数
        //原始收益系数*（原利率-转让利率）/原利率 等于卖方变动部分的收益系数
        BigDecimal sellerChangeRate=one.subtract(transferRate);//卖方剩余的收益比例
        
        
        beforeRatio=getBeforeRatio(transferDate);//选择日期过去天数占总天数的比例
        afterRatio=one.subtract(beforeRatio);
        
        
        //               利息*系数*剩余天数比例*买方剩余年利率比例     
        //交易期买方新利率=------------------------------------=系数*剩余天数比例*买方剩余年利率比例
        //                             利息
        BigDecimal currBuyerRate=afterRatio.multiply(buyerCopiesProportion).multiply(transferRate);
        BigDecimal currSellerRate=srcFrontUserIncomeItem.getProportion().subtract(currBuyerRate);//原系数-买方系数=卖方新系数
        
        RepayItemEntity currItem=srcFrontUserIncomeItem.getRepayItems().get(0);//当期账单
        List<RepayItemEntity> surplusItems=srcFrontUserIncomeItem.getRepayItems();//剩余的账单
        surplusItems.remove(currItem);
        
        sellerIncomeFixParts=new FrontUserIncomeProportionEntity();
        sellerIncomeFixParts.setProportion(srcFrontUserIncomeItem.getProportion());//固定部分收益不动
        sellerIncomeFixParts.setCopiesNum(sellerCopies);
        sellerIncomeFixParts.setRepayItems(surplusItems);
        sellerIncomeFixParts.setBondNatureEnum(srcFrontUserIncomeItem.getBondNatureEnum());
        sellerIncomeFixParts.setTransferLevel(srcFrontUserIncomeItem.getTransferLevel()+1);
        srcHoldPersonalBond.getFrontUserIncomeProportionEntitys().add(sellerIncomeFixParts);
        
        sellerIncomeChangeParts=new FrontUserIncomeProportionEntity();
        sellerIncomeChangeParts.setProportion(sellerChangeRate.multiply(srcFrontUserIncomeItem.getProportion()));
        sellerIncomeChangeParts.setCopiesNum(transferNum);
        sellerIncomeChangeParts.setRepayItems(surplusItems);
        sellerIncomeFixParts.setTransferLevel(srcFrontUserIncomeItem.getTransferLevel()+1);
        if(srcFrontUserIncomeItem.getBondNatureEnum().equals(BondNatureEnum.原始标))
            sellerIncomeChangeParts.setBondNatureEnum(BondNatureEnum.原始转让标);
        else
            sellerIncomeChangeParts.setBondNatureEnum(srcFrontUserIncomeItem.getBondNatureEnum());
            
        srcHoldPersonalBond.getFrontUserIncomeProportionEntitys().add(sellerIncomeChangeParts);
        
        //根据选择的日期进行分割
        //这里，卖方的交易当期收益由两部分构成，一个是过去时间卖方占全部的收益，一个是剩余的后面时间里，买方和卖方共同占有
        //               利息*原系数*过去天数比例+利息*新系数*剩余天数比例*卖方剩余年利率比例     
        //交易期卖方新利率=---------------------------------------------------------=原系数*过去天数比例+系数*剩余天数比例*卖方剩余年利率比例
        //                                   利息
        //BigDecimal currSellerRate=beforeRatio.multiply(srcFrontUserIncomeItem.getProportion()).add(afterRatio.multiply(sellerCopiesProportion).multiply(sellerChangeRate));
      
        currSellerIncomePart.getRepayItems().add(currItem);
        currSellerIncomePart.setCopiesNum(srcCopiesNum);
        currSellerIncomePart.setProportion(currSellerRate);
        currSellerIncomePart.setBondNatureEnum(srcFrontUserIncomeItem.getBondNatureEnum());
        srcHoldPersonalBond.getFrontUserIncomeProportionEntitys().add(currSellerIncomePart);
        frontUserHoldPersonalEaoLocal.updateEntity(srcHoldPersonalBond);
        

        buyerIncomeChangeParts=new FrontUserIncomeProportionEntity();
        buyerIncomeChangeParts.setProportion(transferRate.multiply(srcFrontUserIncomeItem.getProportion()));
        buyerIncomeChangeParts.setCopiesNum(transferNum);
        buyerIncomeChangeParts.setRepayItems(surplusItems);
        buyerIncomeChangeParts.setBondNatureEnum(BondNatureEnum.转让标);
        buyerIncomeChangeParts.setTransferLevel(srcFrontUserIncomeItem.getTransferLevel()+1);
               
        currBuyerIncomePart.getRepayItems().add(currItem);
        currBuyerIncomePart.setCopiesNum(transferNum);
        currBuyerIncomePart.setProportion(currBuyerRate);
        currBuyerIncomePart.setBondNatureEnum(BondNatureEnum.转让标);
        currBuyerIncomePart.setTransferLevel(srcFrontUserIncomeItem.getTransferLevel()+1);
        if(buyer!=null)
        {
            FrontUserHoldPersonalBondEntity holdBond=frontUserEaoLocal.getHoldPersonalBondEntityByPersonalBond(srcPersonalBondEntity, buyer);
            if(holdBond==null)
            {
                FrontUserHoldPersonalBondEntity item=new FrontUserHoldPersonalBondEntity();
                item.setAllBondNumber(transferNum);
                item.setPersonalBondEntity(srcPersonalBondEntity);
                item.setHoldUser(buyer);
                frontUserHoldPersonalEaoLocal.SaveHolePersonalBond(item);
                item.getFrontUserIncomeProportionEntitys().add(buyerIncomeChangeParts);
                item.getFrontUserIncomeProportionEntitys().add(currBuyerIncomePart);
                frontUserHoldPersonalEaoLocal.updateEntity(item);
                frontUserEaoLocal.reflushEntity(buyer);
            }
            else
            {
                holdBond.getFrontUserIncomeProportionEntitys().add(buyerIncomeChangeParts);
                holdBond.getFrontUserIncomeProportionEntitys().add(currBuyerIncomePart);
                frontUserHoldPersonalEaoLocal.updateEntity(holdBond);
                frontUserEaoLocal.reflushEntity(buyer);
            }
        }
        //分割完毕之后清除原FrontUserIncomeEntity中的未付账单
        frontUserIncomeProportionEaoLocal.clearAllRepayItems(srcFrontUserIncomeItem);
    }
//    public RepayItemEntity getRepayItemByDate(FrontUserIncomeProportionEntity income,Date date)
//    {
//        List<RepayItemEntity> repays=income.getActualRepayItems();
//        for(RepayItemEntity item:repays)
//        {
//            Date itemDate=item.getSettlementTime();
//            if(judgeDate(itemDate,date,srcHoldPersonalBond.getPersonalBondEntity().getRepayCycle()))
//            {
//                return item;
//            }
//        }
//        return null;
//    }
//    //判断srcDate和targetDate是否在一个周期内
//    public Boolean judgeDate(Date targetDate,Date srcDate,SplitUnit split)
//    {
//        if(split==SplitUnit.月)
//        {
//            if(targetDate.getMonth()==srcDate.getMonth())
//            {
//                return true;
//            }
//        }
//        else if(split==SplitUnit.季度)
//        {
//            if(getQuarterNum(targetDate)==getQuarterNum(srcDate))
//            {
//                return true;
//            }
//        }
//        else if(split==SplitUnit.年)
//        {
//            if(targetDate.getYear()==srcDate.getYear())
//            {
//                return true;
//            }
//        }
//        return false;
//    }
    public int getQuarterNum(Date date)
    {
        if(date.getMonth()==1||date.getMonth()==2||date.getMonth()==3)
            return 1;
        else if(date.getMonth()==4||date.getMonth()==5||date.getMonth()==6)
            return 2;
        else if(date.getMonth()==7||date.getMonth()==8||date.getMonth()==9)
            return 3;
        else if(date.getMonth()==10||date.getMonth()==11||date.getMonth()==12)
            return 4;
        return -1;
    }
    public BigDecimal getBeforeRatio(Date date)
    {
        int dayNum=getMonthLastDay(date.getYear(),date.getMonth());
        System.out.println(dayNum);
        int beforeDayNum=date.getDate();
        System.out.println(beforeDayNum);
        int afterDayNum=dayNum-beforeDayNum;
        System.out.println(afterDayNum);
        BigDecimal beforeDayNumBig=new BigDecimal(beforeDayNum);
        BigDecimal afterDayNumBig=new BigDecimal(afterDayNum);
        BigDecimal dayNumBig=new BigDecimal(dayNum);
        System.out.println(beforeDayNumBig);
        System.out.println(dayNumBig);
        BigDecimal hr=beforeDayNumBig.divide(dayNumBig,2, BigDecimal.ROUND_HALF_EVEN);
        return hr;
    }
    //得到当月总天数
    public int getMonthLastDay(int year, int month)  
    {  
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    } 
    public String transfer()
    {
        //将卖方原始的FrontUserIncomeProportionEntity删除，添加在债权转让过程中产生的三个FrontUserIncomeProportionEntity
        //添加买方的由债权转让所产生的两个FrontUserIncomeProportionEntity
        return null;
    }
    public List<FrontUserEntity> findUser(String target)
    {
        List<FrontUserEntity> userFilter=getFrontUserEaoLocal().getUserByName("%"+target+"%");
        return userFilter;
    }
    /**
     * @return the srcHoldPersonalBond
     */
    public FrontUserHoldPersonalBondEntity getSrcHoldPersonalBond() {
        return srcHoldPersonalBond;
    }

    /**
     * @param srcHoldPersonalBond the srcHoldPersonalBond to set
     */
    public void setSrcHoldPersonalBond(FrontUserHoldPersonalBondEntity srcHoldPersonalBond) {
        this.srcHoldPersonalBond = srcHoldPersonalBond;
    }

    /**
     * @return the srcPersonalBondEntity
     */
    public PersonalBondEntity getSrcPersonalBondEntity() {
        return srcPersonalBondEntity;
    }

    /**
     * @param srcPersonalBondEntity the srcPersonalBondEntity to set
     */
    public void setSrcPersonalBondEntity(PersonalBondEntity srcPersonalBondEntity) {
        this.srcPersonalBondEntity = srcPersonalBondEntity;
    }

    /**
     * @return the srcFrontUserIncomeItem
     */
    public FrontUserIncomeProportionEntity getSrcFrontUserIncomeItem() {
        return srcFrontUserIncomeItem;
    }

    /**
     * @param srcFrontUserIncomeItem the srcFrontUserIncomeItem to set
     */
    public void setSrcFrontUserIncomeItem(FrontUserIncomeProportionEntity srcFrontUserIncomeItem) {
        this.srcFrontUserIncomeItem = srcFrontUserIncomeItem;
    }

    /**
     * @return the transferNum
     */
    public int getTransferNum() {
        return transferNum;
    }

    /**
     * @param transferNum the transferNum to set
     */
    public void setTransferNum(int transferNum) {
        this.transferNum = transferNum;
    }

    /**
     * @return the transferRate
     */
    public BigDecimal getTransferRate() {
        return transferRate;
    }

    /**
     * @param transferRate the transferRate to set
     */
    public void setTransferRate(BigDecimal transferRate) {
        this.transferRate = transferRate;
    }

    /**
     * @return the buyer
     */
    public FrontUserEntity getBuyer() {
        return buyer;
    }

    /**
     * @param buyer the buyer to set
     */
    public void setBuyer(FrontUserEntity buyer) {
        this.buyer = buyer;
    }

    /**
     * @return the frontUserEaoLocal
     */
    public FrontUserEaoLocal getFrontUserEaoLocal() {
        return frontUserEaoLocal;
    }

    /**
     * @param frontUserEaoLocal the frontUserEaoLocal to set
     */
    public void setFrontUserEaoLocal(FrontUserEaoLocal frontUserEaoLocal) {
        this.frontUserEaoLocal = frontUserEaoLocal;
    }

    /**
     * @return the ptpSessionBean
     */
    public PtpSessionBean getPtpSessionBean() {
        return ptpSessionBean;
    }

    /**
     * @param ptpSessionBean the ptpSessionBean to set
     */
    public void setPtpSessionBean(PtpSessionBean ptpSessionBean) {
        this.ptpSessionBean = ptpSessionBean;
    }

    /**
     * @return the sellerIncomeChangeParts
     */
    public FrontUserIncomeProportionEntity getSellerIncomeChangeParts() {
        return sellerIncomeChangeParts;
    }

    /**
     * @param sellerIncomeChangeParts the sellerIncomeChangeParts to set
     */
    public void setSellerIncomeChangeParts(FrontUserIncomeProportionEntity sellerIncomeChangeParts) {
        this.sellerIncomeChangeParts = sellerIncomeChangeParts;
    }

    /**
     * @return the sellerIncomeFixParts
     */
    public FrontUserIncomeProportionEntity getSellerIncomeFixParts() {
        return sellerIncomeFixParts;
    }

    /**
     * @param sellerIncomeFixParts the sellerIncomeFixParts to set
     */
    public void setSellerIncomeFixParts(FrontUserIncomeProportionEntity sellerIncomeFixParts) {
        this.sellerIncomeFixParts = sellerIncomeFixParts;
    }

    /**
     * @return the currSellerIncomePart
     */
    public FrontUserIncomeProportionEntity getCurrSellerIncomePart() {
        return currSellerIncomePart;
    }

    /**
     * @param currSellerIncomePart the currSellerIncomePart to set
     */
    public void setCurrSellerIncomePart(FrontUserIncomeProportionEntity currSellerIncomePart) {
        this.currSellerIncomePart = currSellerIncomePart;
    }

    /**
     * @return the buyerIncomeChangeParts
     */
    public FrontUserIncomeProportionEntity getBuyerIncomeChangeParts() {
        return buyerIncomeChangeParts;
    }

    /**
     * @param buyerIncomeChangeParts the buyerIncomeChangeParts to set
     */
    public void setBuyerIncomeChangeParts(FrontUserIncomeProportionEntity buyerIncomeChangeParts) {
        this.buyerIncomeChangeParts = buyerIncomeChangeParts;
    }

    /**
     * @return the currBuyerIncomePart
     */
    public FrontUserIncomeProportionEntity getCurrBuyerIncomePart() {
        return currBuyerIncomePart;
    }

    /**
     * @param currBuyerIncomePart the currBuyerIncomePart to set
     */
    public void setCurrBuyerIncomePart(FrontUserIncomeProportionEntity currBuyerIncomePart) {
        this.currBuyerIncomePart = currBuyerIncomePart;
    }

    /**
     * @return the transferDate
     */
    public Date getTransferDate() {
        return transferDate;
    }

    /**
     * @param transferDate the transferDate to set
     */
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    /**
     * @return the beforeRatio
     */
    public BigDecimal getBeforeRatio() {
        return beforeRatio;
    }

    /**
     * @param beforeRatio the beforeRatio to set
     */
    public void setBeforeRatio(BigDecimal beforeRatio) {
        this.beforeRatio = beforeRatio;
    }

    /**
     * @return the afterRatio
     */
    public BigDecimal getAfterRatio() {
        return afterRatio;
    }

    /**
     * @param afterRatio the afterRatio to set
     */
    public void setAfterRatio(BigDecimal afterRatio) {
        this.afterRatio = afterRatio;
    }

    
}
