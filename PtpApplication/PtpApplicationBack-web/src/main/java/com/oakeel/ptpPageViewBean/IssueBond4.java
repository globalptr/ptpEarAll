/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.bond.BondEaoLocal;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.expense.ExpenseEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.ImageUsedEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@ConversationScoped
public class IssueBond4 implements Serializable{
    @Inject Conversation conversation;
    @Inject private PtpSessionBean ptpSessionBean;
    private List<ExpenseEntity> expenseEntitys;
    private List<BondInformationEntity> bondInformationEntitys;
    private BigDecimal allAmount;
    private BondInformationEntity contractInfo ;
    private BondInformationEntity companyInfo;
    private BondInformationEntity visitInfo;
    private Date defaultDate;
    private Boolean frontUserEditable=false;
    private List<FrontUserEntity> frontUserEntitys; 
    @EJB
    private FrontUserEaoLocal frontUserEaoLocal;
    @EJB
    private BondEaoLocal bondEaoLocal;
    private FrontUserEntity targetFrontUser;
    private BondEntity bond4=null;
    /**
     * Creates a new instance of IssueBond4
     */
    
    public IssueBond4() {
    }
    public void test()
    {
        frontUserEditable=!frontUserEditable;
    }
    public void startConversation()
    {
        if ( conversation.isTransient()) {
            System.out.println("///////////////////////////////////////////////////////start");
            conversation.begin();
        }
    }
    public void endConversation()
    {
        System.out.println("setend");
        conversation.setTimeout(1000);
        
    }
    @PreDestroy
    public void clear()
    {
        System.out.println(conversation.isTransient());
           System.out.println("///////////////////////////////////////////////////////end");
           //conversation.end();
         //如果Conversation不是“瞬时”的，则结束conversion，同时所有ConversationScoped的对象也会销毁
        if (!conversation.isTransient()) {
//           System.out.println("///////////////////////////////////////////////////////end");
//           conversation.end();
        }
    }
    @PostConstruct
    public void init()
    {
        if(bond4==null)
        {
            bond4=ptpSessionBean.getIssueBondLocal().getCurrBond();
        }
        if(bond4==null)
            return;
         //仅当前页面未被post提交，且conversation是"瞬时"性时，才开始conversation
  
        if ( conversation.isTransient()) {
            conversation.begin();
        }
        defaultDate=new Date(0);
        frontUserEntitys=frontUserEaoLocal.getAllEntitys();
       
       
        if(ptpSessionBean.getIssueBondLocal().getCurrBond().getExpenseEntitys()!=null)
        {
            expenseEntitys=ptpSessionBean.getIssueBondLocal().getCurrBond().getExpenseEntitys();
        }
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
     * @return the frontUserEditable
     */
    public Boolean getFrontUserEditable() {
        return frontUserEditable;
    }

    /**
     * @param frontUserEditable the frontUserEditable to set
     */
    public void setFrontUserEditable(Boolean frontUserEditable) {
        this.frontUserEditable = frontUserEditable;
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
     * @return the bondEaoLocal
     */
    public BondEaoLocal getBondEaoLocal() {
        return bondEaoLocal;
    }

    /**
     * @param bondEaoLocal the bondEaoLocal to set
     */
    public void setBondEaoLocal(BondEaoLocal bondEaoLocal) {
        this.bondEaoLocal = bondEaoLocal;
    }

    /**
     * @return the targetFrontUser
     */
    public FrontUserEntity getTargetFrontUser() {
        return targetFrontUser;
    }

    /**
     * @param targetFrontUser the targetFrontUser to set
     */
    public void setTargetFrontUser(FrontUserEntity targetFrontUser) {
        this.targetFrontUser = targetFrontUser;
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
        System.out.println(bond4.getBondNumber());
        this.bond4 = bond4;
    }

}
