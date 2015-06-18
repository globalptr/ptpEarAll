/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.check.CheckEntity;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEntity;
import com.oakeel.ejb.entityAndEao.frontUserIncomeProportion.FrontUserIncomeProportionEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUserIncomeProportion.FrontUserIncomeProportionEntity;
import com.oakeel.ejb.entityAndEao.repayItem.RepayItemEntity;
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
public class FrontUserPersonalBondIncomeDetail {

    private FrontUserHoldPersonalBondEntity srcHoldPersonalBond=null;
    @Inject PtpSessionBean ptpSessionBean;
    private FrontUserIncomeProportionEntity targetIncomeProportion=null;
    @EJB FrontUserIncomeProportionEaoLocal frontUserIncomeProportionEaoLocal;
    /**
     * Creates a new instance of FrontUserPersonalBondIncomeDetail
     */
    public FrontUserPersonalBondIncomeDetail() {
    }

    @PostConstruct
    public void init()
    {
        if(ptpSessionBean.getSelectHoldPersonalBond()!=null)
        {
            srcHoldPersonalBond=ptpSessionBean.getSelectHoldPersonalBond();
        }
    }
    
    public String repayPrincipalInterest()
    {
        if(targetIncomeProportion!=null)
        {
            RepayItemEntity item=targetIncomeProportion.getRepayItems().get(0);//取出第一个计算收益之后放入账单
            CheckEntity check=new CheckEntity();
            check.setPrincipal(item.getPrincipal());
            check.setInterest(item.getInterest());
            check.setSettlementTime(item.getSettlementTime());
            check.setPeriodNum(item.getPeriodNum());
            check.setSubTatal(item.getSubTatal());
            check.setBeforeBalance(item.getBeforeBalance());
            check.setAfterBalance(item.getAfterBalance());
            check.setActualPrincipal(item.getPrincipal().multiply(targetIncomeProportion.getProportion()));
            check.setActualInterest(item.getInterest().multiply(targetIncomeProportion.getProportion()));
            check.setActualSubTatal(item.getSubTatal().multiply(targetIncomeProportion.getProportion()));
            check.setActualBeforeBalance(item.getBeforeBalance().multiply(targetIncomeProportion.getProportion()));
            check.setActualAfterBalance(item.getAfterBalance().multiply(targetIncomeProportion.getProportion()));
            check.setActualSettlementTime(item.getSettlementTime());
            frontUserIncomeProportionEaoLocal.dealCurrRepayItem(targetIncomeProportion, check);
        }
        return null;
    }
    public String toTransferPersonalPage()
    {
        if(srcHoldPersonalBond!=null&&targetIncomeProportion!=null)
        {
            ptpSessionBean.setSelectFrontUserIncomeItem(targetIncomeProportion);
            return "transferPersonalBond";
        }
        return null;
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
     * @return the targetIncomeProportion
     */
    public FrontUserIncomeProportionEntity getTargetIncomeProportion() {
        return targetIncomeProportion;
    }

    /**
     * @param targetIncomeProportion the targetIncomeProportion to set
     */
    public void setTargetIncomeProportion(FrontUserIncomeProportionEntity targetIncomeProportion) {
        this.targetIncomeProportion = targetIncomeProportion;
    }
    
}
