/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEntity;
import com.oakeel.ejb.entityAndEao.frontUserIncomeProportion.FrontUserIncomeProportionEntity;
import javax.annotation.PostConstruct;
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
