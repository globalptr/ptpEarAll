/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.expense.ExpenseEntity;
import com.oakeel.ejb.entityAndEao.financingBusinessLender.FinancingBusinessLenderEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.ImageUsedEnum;
import java.math.BigDecimal;
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
    private FinancingBusinessLenderEntity financingBusinessLender;
    private BondEntity bond4;
    private FrontUserEntity frontUserEntity;
    private List<ExpenseEntity> expenseEntitys;
    private List<BondInformationEntity> bondInformationEntitys;
    private BigDecimal allAmount;
    private BondInformationEntity contractInfo ;
    private BondInformationEntity companyInfo;
    private BondInformationEntity visitInfo;
    /**
     * Creates a new instance of IssueBond4
     */
    public IssueBond4() {
    }
    @PostConstruct
    public void init()
    {
        bond4=ptpSessionBean.getIssueBondLocal().getCurrBond();
        setBondInformationEntitys(bond4.getBondInformationEntiys());
        setFrontUserEntity(ptpSessionBean.getIssueBondLocal().getCurrLender().getLenderUser());
        setExpenseEntitys(ptpSessionBean.getIssueBondLocal().getCurrLender().getExpenseEntitys());
        for(BondInformationEntity item:bondInformationEntitys)
        {
            if(item.getTitle()==ImageUsedEnum.公司资料)
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
     * @return the financingBusinessLender
     */
    public FinancingBusinessLenderEntity getFinancingBusinessLender() {
        return financingBusinessLender;
    }

    /**
     * @param financingBusinessLender the financingBusinessLender to set
     */
    public void setFinancingBusinessLender(FinancingBusinessLenderEntity financingBusinessLender) {
        this.financingBusinessLender = financingBusinessLender;
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
}
