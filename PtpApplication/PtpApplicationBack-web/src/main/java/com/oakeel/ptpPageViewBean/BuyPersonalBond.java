/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.ejb.entityAndEao.backUser.BackUserEaoLocal;
import com.oakeel.ejb.entityAndEao.backUser.BackUserEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEntity;
import com.oakeel.ejb.entityAndEao.frontUserIncomeProportion.FrontUserIncomeProportionEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEaoLocal;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.repayItem.RepayItemEntity;
import com.oakeel.ejb.ptpEnum.BondStage;
import com.oakeel.ejb.ptpEnum.BondType;
import com.oakeel.ejb.ptpEnum.RepayModelEnum;
import com.oakeel.ejb.ptpEnum.SplitUnit;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class BuyPersonalBond {

    /**
     * Creates a new instance of PersonalBondTest
     */
    //购买用户 购买份数 所有经过审核的个人标 标筛选 所有前端用户 购买操作
    private List<FrontUserEntity> frontUserEntitys;//所有的前端用户
    @EJB FrontUserEaoLocal frontUserEaoLocal;//
    @EJB BackUserEaoLocal backUserEaoLocal;
    private List<PersonalBondEntity> bondEntitys;//所有可供出售的个人标
    private PersonalBondEntity targetBond;//选择的标
    @EJB private PersonalBondEaoLocal personalBondEaoLocal;
    @EJB private FrontUserHoldPersonalBondEaoLocal frontUserHoldPersonalBondEaoLocal;
    private PersonalBondEntity bondFilter;//标筛选
    private FrontUserEntity targetUserEntity;//选择的用户
    private int buyNum;//购买的份数
    private BondType[] bondTypes;
    private SplitUnit[] splitUnits;
    private RepayModelEnum[] repayModelEnums;
    private BondStage[] bondStages;
    
    public BuyPersonalBond() {
        bondTypes=BondType.values();
        splitUnits=SplitUnit.values();
        repayModelEnums=RepayModelEnum.values();
        bondStages=BondStage.values();
    }
    @PostConstruct
    public void init()
    {
        frontUserEntitys=frontUserEaoLocal.getAllActiveUsers();
        bondEntitys=personalBondEaoLocal.getAllAuditBonds();
    }
    public void buyTest()
    {
        //用户购买标 建立用户收益 
        FrontUserHoldPersonalBondEntity frontUserHoldBondEntity=new FrontUserHoldPersonalBondEntity();//创建控标实体
        frontUserHoldBondEntity.setAllBondNumber(buyNum);
        frontUserHoldBondEntity.setHoldUser(targetUserEntity);
        frontUserHoldBondEntity.setPersonalBondEntity(targetBond);
        BigDecimal buyNumBig=new BigDecimal(buyNum);
        BigDecimal issueNumBig=new BigDecimal(targetBond.getIssueCopiesNum());
        System.out.println("发行数"+targetBond.getIssueCopiesNum());
        BigDecimal incomeProportion=buyNumBig.divide(issueNumBig,2, BigDecimal.ROUND_HALF_EVEN);//计算收益比例
        FrontUserIncomeProportionEntity income=new FrontUserIncomeProportionEntity();//创建收益比例实体
        income.setProportion(incomeProportion);//设置收益比例
        income.setCopiesNum(buyNum);//设置收益比例对应的份数
        List<RepayItemEntity> expenseEntitys=targetBond.getExpenseEntitys();//得到目标标的支出列表
        for(RepayItemEntity item:expenseEntitys)
        {
            RepayItemEntity temp=new RepayItemEntity();
            temp.setPeriodNum(item.getPeriodNum());
            temp.setPrincipal(item.getPrincipal());
            temp.setSubTatal(item.getSubTatal());
            temp.setInterest(item.getInterest());
            temp.setBeforeBalance(item.getBeforeBalance());
            temp.setAfterBalance(item.getAfterBalance());
            temp.setSettlementTime(item.getSettlementTime());
            income.getRepayItems().add(temp);
        }
        income.setIncomeYearRate(targetBond.getYearRate());//将标的年利率设置成income的年利率
        //income.setRepayItems(expenseEntitys);//因为购买的是原始标，所以将支出列表设置为购买用户的收益列表
        frontUserHoldBondEntity.getFrontUserIncomeProportionEntitys().add(income);
        
        frontUserHoldPersonalBondEaoLocal.SaveHolePersonalBond(frontUserHoldBondEntity);//持久化控标实体
        targetUserEntity=frontUserEaoLocal.reflushEntity(targetUserEntity);
        targetBond=personalBondEaoLocal.reflushEntity(targetBond);
        System.out.println("用户拥有的控标实体数:"+targetUserEntity.getFrontUserHoldPersonalBondEntitys().size());
        System.out.println("个人标拥有的控标实体数:"+targetBond.getFrontUserHoldPersonalBondEntitys().size());
    }

    public List<FrontUserEntity> findFrontUser(String target)
    {
        List<FrontUserEntity> userFilter=frontUserEaoLocal.getUserByName("%"+target+"%");
        return userFilter;
    }
    public List<BackUserEntity> findBackUser(String target)
    {
        List<BackUserEntity> userFilter=backUserEaoLocal.getUserByName("%"+target+"%");
        return userFilter;
    }
    /**
     * @return the frontUserEntitys
     */
    public List<FrontUserEntity> getFrontUserEntitys() {
        return frontUserEntitys;
    }

    /**
     * @param frontUserEntitys the frontUserEntitys to set
     */
    public void setFrontUserEntitys(List<FrontUserEntity> frontUserEntitys) {
        this.frontUserEntitys = frontUserEntitys;
    }



    /**
     * @return the bondFilter
     */
    public PersonalBondEntity getBondFilter() {
        return bondFilter;
    }

    /**
     * @param bondFilter the bondFilter to set
     */
    public void setBondFilter(PersonalBondEntity bondFilter) {
        this.bondFilter = bondFilter;
    }

    /**
     * @return the targetUserEntity
     */
    public FrontUserEntity getTargetUserEntity() {
        return targetUserEntity;
    }

    /**
     * @param targetUserEntity the targetUserEntity to set
     */
    public void setTargetUserEntity(FrontUserEntity targetUserEntity) {
        this.targetUserEntity = targetUserEntity;
    }

    /**
     * @return the buyNum
     */
    public int getBuyNum() {
        return buyNum;
    }

    /**
     * @param buyNum the buyNum to set
     */
    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    /**
     * @return the bondTypes
     */
    public BondType[] getBondTypes() {
        return bondTypes;
    }

    /**
     * @param bondTypes the bondTypes to set
     */
    public void setBondTypes(BondType[] bondTypes) {
        this.bondTypes = bondTypes;
    }

    /**
     * @return the splitUnits
     */
    public SplitUnit[] getSplitUnits() {
        return splitUnits;
    }

    /**
     * @param splitUnits the splitUnits to set
     */
    public void setSplitUnits(SplitUnit[] splitUnits) {
        this.splitUnits = splitUnits;
    }

    /**
     * @return the repayModelEnums
     */
    public RepayModelEnum[] getRepayModelEnums() {
        return repayModelEnums;
    }

    /**
     * @param repayModelEnums the repayModelEnums to set
     */
    public void setRepayModelEnums(RepayModelEnum[] repayModelEnums) {
        this.repayModelEnums = repayModelEnums;
    }

    /**
     * @return the bondStages
     */
    public BondStage[] getBondStages() {
        return bondStages;
    }

    /**
     * @param bondStages the bondStages to set
     */
    public void setBondStages(BondStage[] bondStages) {
        this.bondStages = bondStages;
    }

    /**
     * @return the personalBondEaoLocal
     */
    public PersonalBondEaoLocal getPersonalBondEaoLocal() {
        return personalBondEaoLocal;
    }

    /**
     * @param personalBondEaoLocal the personalBondEaoLocal to set
     */
    public void setPersonalBondEaoLocal(PersonalBondEaoLocal personalBondEaoLocal) {
        this.personalBondEaoLocal = personalBondEaoLocal;
    }

    /**
     * @return the bondEntitys
     */
    public List<PersonalBondEntity> getBondEntitys() {
        return bondEntitys;
    }

    /**
     * @param bondEntitys the bondEntitys to set
     */
    public void setBondEntitys(List<PersonalBondEntity> bondEntitys) {
        this.bondEntitys = bondEntitys;
    }

    /**
     * @return the targetBond
     */
    public PersonalBondEntity getTargetBond() {
        return targetBond;
    }

    /**
     * @param targetBond the targetBond to set
     */
    public void setTargetBond(PersonalBondEntity targetBond) {
        this.targetBond = targetBond;
    }

    /**
     * @return the frontUserHoldPersonalBondEaoLocal
     */
    public FrontUserHoldPersonalBondEaoLocal getFrontUserHoldPersonalBondEaoLocal() {
        return frontUserHoldPersonalBondEaoLocal;
    }

    /**
     * @param frontUserHoldPersonalBondEaoLocal the frontUserHoldPersonalBondEaoLocal to set
     */
    public void setFrontUserHoldPersonalBondEaoLocal(FrontUserHoldPersonalBondEaoLocal frontUserHoldPersonalBondEaoLocal) {
        this.frontUserHoldPersonalBondEaoLocal = frontUserHoldPersonalBondEaoLocal;
    }

}
