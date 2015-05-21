/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEaoLocal;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEntity;
import com.oakeel.ejb.ptpEnum.BaseAmountEnum;
import com.oakeel.ejb.transaction.bond.IssueBondLocal;
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
public class IssueBond1 {
    @EJB
    IssueBondLocal issueBondLocal;
    @EJB
    CompanyUserEaoLocal companyUserEaoLocal;
    private BondEntity bond1;
    private BaseAmountEnum[] baseAmountEnums;
    private List<CompanyUserEntity> companyUserEntitys;
    /**
     * Creates a new instance of IssueBond1
     */
    public IssueBond1() {
    }
    @PostConstruct
    public void init()
    {
        setBond1(new BondEntity());
        baseAmountEnums=BaseAmountEnum.values();
        companyUserEntitys=companyUserEaoLocal.getAllEntitys();
    }
    public String nextStep()
    {
        if(issueBondLocal.getCurrBond()==null)
        {
            issueBondLocal.createNewBond();
        }
        issueBondLocal.step1(getBond1());
        return "issueBond2";
    }

    /**
     * @return the bond1
     */
    public BondEntity getBond1() {
        return bond1;
    }

    /**
     * @param bond1 the bond1 to set
     */
    public void setBond1(BondEntity bond1) {
        this.bond1 = bond1;
    }

    /**
     * @return the baseAmountEnums
     */
    public BaseAmountEnum[] getBaseAmountEnums() {
        return baseAmountEnums;
    }

    /**
     * @param baseAmountEnums the baseAmountEnums to set
     */
    public void setBaseAmountEnums(BaseAmountEnum[] baseAmountEnums) {
        this.baseAmountEnums = baseAmountEnums;
    }

    /**
     * @return the companyUserEntitys
     */
    public List<CompanyUserEntity> getCompanyUserEntitys() {
        return companyUserEntitys;
    }

    /**
     * @param companyUserEntitys the companyUserEntitys to set
     */
    public void setCompanyUserEntitys(List<CompanyUserEntity> companyUserEntitys) {
        this.companyUserEntitys = companyUserEntitys;
    }
}
