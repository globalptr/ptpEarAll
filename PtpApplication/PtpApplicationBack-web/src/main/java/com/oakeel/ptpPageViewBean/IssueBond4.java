/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.expense.ExpenseEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.frontUserIssueBond.FrontUserIssueBondEntity;
import com.oakeel.ejb.ptpEnum.ImageUsedEnum;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class IssueBond4 {

    @Inject private PtpSessionBean ptpSessionBean;
    private FrontUserIssueBondEntity frontUserIssueBondEntity;
    private FrontUserEntity frontUserEntity;
    private List<ExpenseEntity> expenseEntitys;
    private List<BondInformationEntity> bondInformationEntitys;
    private BigDecimal allAmount;
    private BondInformationEntity contractInfo ;
    private BondInformationEntity companyInfo;
    private BondInformationEntity visitInfo;
    private BondEntity bond4=null;
    private Date defaultDate;
    /**
     * Creates a new instance of IssueBond4
     */
    public IssueBond4() {
        defaultDate=new Date(0);
        System.out.println(defaultDate.toString());
    }
    @PostConstruct
    public void init()
    {
        bond4=ptpSessionBean.getIssueBondLocal().getCurrBond();
        if(bond4==null)
        {
            return;
        }
        if(ptpSessionBean.getIssueBondLocal().getIssueUser()!=null)
            frontUserEntity=ptpSessionBean.getIssueBondLocal().getIssueUser();
        if(ptpSessionBean.getIssueBondLocal().getCurrBond().getExpenseEntitys()!=null)
            expenseEntitys=ptpSessionBean.getIssueBondLocal().getCurrBond().getExpenseEntitys();
        if(ptpSessionBean.getIssueBondLocal().getCurrBond().getBondInformationEntiys()!=null)
        {
            bondInformationEntitys=ptpSessionBean.getIssueBondLocal().getCurrBond().getBondInformationEntiys();
            for(BondInformationEntity item:bondInformationEntitys)
            {
                if(item.getTitle()==ImageUsedEnum.合同资料)
                {
                    contractInfo=item;
                }
                else if(item.getTitle()==ImageUsedEnum.公司资料)
                {
                    companyInfo=item;
                }
                else if(item.getTitle()==ImageUsedEnum.考察资料)
                {
                    visitInfo=item;
                }
            }
        }
    }
    public String issueBond() {
        
        getPtpSessionBean().getIssueBondLocal().issue();
        BondEntity temp=getPtpSessionBean().getIssueBondLocal().getCurrBond();
        return "issueBond5";
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
     * @return the frontUserEntity
     */
    public FrontUserEntity getFrontUserEntity() {
        return frontUserEntity;
    }

    /**
     * @param frontUserEntity the frontUserEntity to set
     */
    public void setFrontUserEntity(FrontUserEntity frontUserEntity) {
        this.frontUserEntity = frontUserEntity;
    }

    /**
     * @return the expenseEntitys
     */
    public List<ExpenseEntity> getExpenseEntitys() {
        return expenseEntitys;
    }

    /**
     * @param expenseEntitys the expenseEntitys to set
     */
    public void setExpenseEntitys(List<ExpenseEntity> expenseEntitys) {
        this.expenseEntitys = expenseEntitys;
    }

    /**
     * @return the bondInformationEntitys
     */
    public List<BondInformationEntity> getBondInformationEntitys() {
        return bondInformationEntitys;
    }

    /**
     * @param bondInformationEntitys the bondInformationEntitys to set
     */
    public void setBondInformationEntitys(List<BondInformationEntity> bondInformationEntitys) {
        this.bondInformationEntitys = bondInformationEntitys;
    }


    /**
     * @return the allAmount
     */
    public BigDecimal getAllAmount() {
        return allAmount;
    }

    /**
     * @param allAmount the allAmount to set
     */
    public void setAllAmount(BigDecimal allAmount) {
        this.allAmount = allAmount;
    }

    /**
     * @return the contractInfo
     */
    public BondInformationEntity getContractInfo() {
        return contractInfo;
    }

    /**
     * @param contractInfo the contractInfo to set
     */
    public void setContractInfo(BondInformationEntity contractInfo) {
        this.contractInfo = contractInfo;
    }

    /**
     * @return the companyInfo
     */
    public BondInformationEntity getCompanyInfo() {
        return companyInfo;
    }

    /**
     * @param companyInfo the companyInfo to set
     */
    public void setCompanyInfo(BondInformationEntity companyInfo) {
        this.companyInfo = companyInfo;
    }

    /**
     * @return the visitInfo
     */
    public BondInformationEntity getVisitInfo() {
        return visitInfo;
    }

    /**
     * @param visitInfo the visitInfo to set
     */
    public void setVisitInfo(BondInformationEntity visitInfo) {
        this.visitInfo = visitInfo;
    }

    /**
     * @return the bond4
     */
    public BondEntity getBond4() {
        return bond4;
    }

    /**
     * @param bond4 the bond4 to set
     */
    public void setBond4(BondEntity bond4) {
        this.bond4 = bond4;
    }

    /**
     * @return the defaultDate
     */
    public Date getDefaultDate() {
        return defaultDate;
    }

    /**
     * @param defaultDate the defaultDate to set
     */
    public void setDefaultDate(Date defaultDate) {
        this.defaultDate = defaultDate;
    }

    /**
     * @return the frontUserIssueBondEntity
     */
    public FrontUserIssueBondEntity getFrontUserIssueBondEntity() {
        return frontUserIssueBondEntity;
    }

    /**
     * @param frontUserIssueBondEntity the frontUserIssueBondEntity to set
     */
    public void setFrontUserIssueBondEntity(FrontUserIssueBondEntity frontUserIssueBondEntity) {
        this.frontUserIssueBondEntity = frontUserIssueBondEntity;
    }
}
