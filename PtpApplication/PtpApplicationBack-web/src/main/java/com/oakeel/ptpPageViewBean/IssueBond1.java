/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.backUser.BackUserEntity;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEaoLocal;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.BondType;
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
public class IssueBond1 implements Serializable{
    @Inject private PtpSessionBean ptpSessionBean;
    @EJB
    CompanyUserEaoLocal companyUserEaoLocal;
    @EJB
    FrontUserEaoLocal frontUserEaoLocal;
    private BondType[] bondTypes;
    private BondEntity bond1;
    private List<CompanyUserEntity> companyUserEntitys;
    private RepayModelEnum[] repayModelArray;//还款模型枚举列表
    private String selectUserName;
    private FrontUserEntity selectUser;
    private CompanyUserEntity selectCompany;
    private BackUserEntity issueAdmin;
    
    /**
     * Creates a new instance of IssueBond1
     */
    public IssueBond1() {
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
            bond1=new BondEntity();
        }
        if(ptpSessionBean.getIssueBondLocal().getIssueUser()!=null)
        {
            selectUser=ptpSessionBean.getIssueBondLocal().getIssueUser();
        }
        companyUserEntitys=companyUserEaoLocal.getAllEntitys();
        repayModelArray=RepayModelEnum.values();
        setBondTypes(BondType.values());
        setIssueAdmin(ptpSessionBean.getLogUser());
    }
    public String nextStep()
    {
        ptpSessionBean.getIssueBondLocal().setUser(selectUser);
        if(null!=ptpSessionBean.getLogUser())
            bond1.setIssueAdmin(ptpSessionBean.getLogUser());
        
        ptpSessionBean.getIssueBondLocal().setStep1Bond(bond1);
        return "issueBond2";
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
