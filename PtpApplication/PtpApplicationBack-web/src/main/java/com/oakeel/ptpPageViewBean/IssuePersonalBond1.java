/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.backUser.BackUserEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEaoLocal;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.PersonalBondTypeEnum;
import com.oakeel.ejb.ptpEnum.RepayModelEnum;
import java.io.Serializable;
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
public class IssuePersonalBond1 implements Serializable{
    @Inject private PtpSessionBean ptpSessionBean;
    @EJB
    CompanyUserEaoLocal companyUserEaoLocal;
    @EJB
    FrontUserEaoLocal frontUserEaoLocal;
    private PersonalBondTypeEnum[] bondTypes;
    private PersonalBondEntity bond1;
    private List<CompanyUserEntity> companyUserEntitys;
    private RepayModelEnum[] repayModelArray;//还款模型枚举列表
    private String selectUserName;
    private CompanyUserEntity selectCompany;
    private BackUserEntity issueAdmin;
    
    /**
     * Creates a new instance of IssueBond1
     */
    public IssuePersonalBond1() {
    }
    @PostConstruct
    public void init()
    {
        if(ptpSessionBean.getIssueBondLocal().getBond1()!=null)
        {
            bond1=ptpSessionBean.getIssueBondLocal().getBond1();
        }
        else
        {
            bond1=new PersonalBondEntity();
        }
        companyUserEntitys=companyUserEaoLocal.getAllEntitys();
        repayModelArray=RepayModelEnum.values();
        setBondTypes(PersonalBondTypeEnum.values());
        setIssueAdmin(ptpSessionBean.getLogUser());
    }
    public String nextStep()
    {
        if(null!=ptpSessionBean.getLogUser())
            bond1.setIssueAdmin(ptpSessionBean.getLogUser());
        
        ptpSessionBean.getIssueBondLocal().setStep1Bond(bond1);
        return "issuePersonalBond2";
    }

    public List<FrontUserEntity> findUser(String target)
    {
        List<FrontUserEntity> userFilter=frontUserEaoLocal.getUserByName("%"+target+"%");
        return userFilter;
    }
    /**
     * @return the bond1
     */
    public PersonalBondEntity getBond1() {
        return bond1;
    }

    /**
     * @param bond1 the bond1 to set
     */
    public void setBond1(PersonalBondEntity bond1) {
        this.bond1 = bond1;
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
     * @return the selectCompany
     */
    public CompanyUserEntity getSelectCompany() {
        return selectCompany;
    }

    /**
     * @param selectCompany the selectCompany to set
     */
    public void setSelectCompany(CompanyUserEntity selectCompany) {
        this.selectCompany = selectCompany;
    }

    /**
     * @return the bondTypes
     */
    public PersonalBondTypeEnum[] getBondTypes() {
        return bondTypes;
    }

    /**
     * @param bondTypes the bondTypes to set
     */
    public void setBondTypes(PersonalBondTypeEnum[] bondTypes) {
        this.bondTypes = bondTypes;
    }

    /**
     * @return the issueAdmin
     */
    public BackUserEntity getIssueAdmin() {
        return issueAdmin;
    }

    /**
     * @param issueAdmin the issueAdmin to set
     */
    public void setIssueAdmin(BackUserEntity issueAdmin) {
        this.issueAdmin = issueAdmin;
    }

}
