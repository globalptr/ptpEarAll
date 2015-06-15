/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEntity;
import com.oakeel.ejb.entityAndEao.frontUserIncomeProportion.FrontUserIncomeProportionEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import java.math.BigDecimal;
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
    @EJB private FrontUserEaoLocal frontUserEaoLocal;
    @Inject private PtpSessionBean ptpSessionBean;
    private FrontUserHoldPersonalBondEntity srcHoldPersonalBond;//原始控标实体
    private PersonalBondEntity srcPersonalBondEntity;//原始个人标实体
    private FrontUserIncomeProportionEntity srcFrontUserIncomeItem;//原始收益条目实体
    private int transferNum;//转让数
    private BigDecimal transferRate;//转让利率
    private FrontUserEntity buyer;//买方
    private FrontUserIncomeProportionEntity sellerIncomeChangeParts;//卖方收益变动部分
    private FrontUserIncomeProportionEntity sellerIncomeFixParts;//卖方收益固定部分
    private FrontUserIncomeProportionEntity currSellerIncomePart;//卖方交易期收益变动
    
    private FrontUserIncomeProportionEntity buyerIncomeChangeParts;//买方收益变动部分
    private FrontUserIncomeProportionEntity currBuyerIncomePart;//买方交易期收益变动
    
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
    }

    public void caculateTransfer()
    {
        int srcCopiesNum=srcFrontUserIncomeItem.getCopiesNum();
        srcCopiesNum=srcCopiesNum-transferNum;
        //原始收益系数*转让利率/原利率 等于买方收益系数
        //原始收益系数*（原利率-转让利率）/原利率 等于卖方变动部分的收益系数
        BigDecimal buyerRate=srcFrontUserIncomeItem.getProportion().multiply(transferRate.divide(srcPersonalBondEntity.getYearRate(),2, BigDecimal.ROUND_HALF_EVEN));
        BigDecimal sellerChangeRate=srcFrontUserIncomeItem.getProportion().multiply(srcPersonalBondEntity.getYearRate().subtract(transferRate).divide(srcPersonalBondEntity.getYearRate(),2, BigDecimal.ROUND_HALF_EVEN));
        
        
        sellerIncomeFixParts=new FrontUserIncomeProportionEntity();
        sellerIncomeFixParts.setProportion(srcFrontUserIncomeItem.getProportion());//固定部分收益不动
        sellerIncomeFixParts.setCopiesNum(srcCopiesNum);
        sellerIncomeFixParts.setRepayItems(srcFrontUserIncomeItem.getRepayItems());
        
        sellerIncomeChangeParts=new FrontUserIncomeProportionEntity();
        sellerIncomeChangeParts.setProportion(sellerChangeRate);
        sellerIncomeChangeParts.setCopiesNum(transferNum);
        sellerIncomeChangeParts.setRepayItems(srcFrontUserIncomeItem.getRepayItems());
        
        buyerIncomeChangeParts=new FrontUserIncomeProportionEntity();
        buyerIncomeChangeParts.setProportion(buyerRate);
        buyerIncomeChangeParts.setCopiesNum(transferNum);
        buyerIncomeChangeParts.setRepayItems(srcFrontUserIncomeItem.getRepayItems());
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
    
}
