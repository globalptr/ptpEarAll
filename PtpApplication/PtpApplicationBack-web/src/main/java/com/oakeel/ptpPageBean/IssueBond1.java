/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEaoLocal;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.BaseAmountEnum;
import com.oakeel.ejb.ptpEnum.RepayModelEnum;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class IssueBond1 {
    @Inject private PtpSessionBean ptpSessionBean;
    @EJB
    CompanyUserEaoLocal companyUserEaoLocal;
    @EJB
    FrontUserEaoLocal frontUserEaoLocal;
    private BondEntity bond1;
    private BaseAmountEnum[] baseAmountEnums;
    private List<CompanyUserEntity> companyUserEntitys;
    private RepayModelEnum[] repayModelArray;//还款模型枚举列表
    private String selectUserName;
    private FrontUserEntity selectUser;
    
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
        repayModelArray=RepayModelEnum.values();
    }
    public String nextStep()
    {
        if(ptpSessionBean.getIssueBondLocal().getCurrBond()==null)
        {
            ptpSessionBean.getIssueBondLocal().createNewBond();
        }
        ptpSessionBean.getIssueBondLocal().setUser(selectUser);
        ptpSessionBean.getIssueBondLocal().setStep1Bond(getBond1());
        return "issueBond2";
    }

    public void prt()
    {
        System.out.println(selectUser.toString());
    }
    public List<FrontUserEntity> findUser(String target)
    {
        List<FrontUserEntity> userFilter=frontUserEaoLocal.getUserByName("%"+target+"%");
        return userFilter;
        
//        List<FrontUserEntity> frontUser2=frontUserEaoLocal.getUserByEmail(target);
//        List<FrontUserEntity> frontUser3=frontUserEaoLocal.getUserByTelephone(target);
//        getUsers().addAll(frontUser1);
//        getUsers().addAll(frontUser2);
//        getUsers().addAll(frontUser3);
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
     * @return the repayModelArray
     */
    public RepayModelEnum[] getRepayModelArray() {
        return repayModelArray;
    }

    /**
     * @param repayModelArray the repayModelArray to set
     */
    public void setRepayModelArray(RepayModelEnum[] repayModelArray) {
        this.repayModelArray = repayModelArray;
    }

    /**
     * @return the selectUserName
     */
    public String getSelectUserName() {
        return selectUserName;
    }

    /**
     * @param selectUserName the selectUserName to set
     */
    public void setSelectUserName(String selectUserName) {
        this.selectUserName = selectUserName;
    }

    /**
     * @return the selectUser
     */
    public FrontUserEntity getSelectUser() {
        return selectUser;
    }

    /**
     * @param selectUser the selectUser to set
     */
    public void setSelectUser(FrontUserEntity selectUser) {
        this.selectUser = selectUser;
    }

}
