/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.bond;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.expense.ExpenseEntity;
import com.oakeel.ejb.entityAndEao.financingBusinessLender.FinancingBusinessLenderEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateful
public class IssueBond implements IssueBondLocal {
    @PersistenceContext(unitName = "ptpEjbPu")
    EntityManager em;
    BondEntity newBond;
    FrontUserEntity issueBondUser;
    FinancingBusinessLenderEntity financingBusinessLenderEntity;
    List<ExpenseEntity> expenseEntitys;
    
    @Override
    public void setStep1Bond(BondEntity bond) {
        newBond=new BondEntity();
        newBond.setName(bond.getName());
        newBond.setBaseAmountEnum(bond.getBaseAmountEnum());
        newBond.setCopiesNum(bond.getCopiesNum());
        newBond.setCompanyUserEntity(bond.getCompanyUserEntity());
        newBond.setRiskControlDetails(bond.getRiskControlDetails());
        newBond.setGuaranteeCase(bond.getGuaranteeCase());
        newBond.setReverseGuaranteeCase(bond.getReverseGuaranteeCase());
    }

    @Override
    public void setStep2Bond(BondEntity bond) {
        newBond.setBondInformationEntiys(bond.getBondInformationEntiys());
    }

    @Override
    public void issue() {
        em.persist(financingBusinessLenderEntity);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public BondEntity getCurrBond() {
        return newBond;
    }

    @Override
    public void createNewBond() {
        newBond=new BondEntity();
    }

    @Override
    public void setUser(FrontUserEntity bondUser) {
        if(bondUser!=null)
        {
            issueBondUser=bondUser;
        }
    }

    @Override
    public void setStep3Bond(BondEntity bond) {
        newBond.setYearRate(bond.getYearRate());
        newBond.setRepayModelEnum(bond.getRepayModelEnum());
        newBond.setRepayCycle(bond.getRepayCycle());
        newBond.setRepayCycleNumber(bond.getRepayCycleNumber());
    }

    @Override
    public void setExpense(List<ExpenseEntity> expenseEntitys) {
        this.expenseEntitys=expenseEntitys;
    }

    @Override
    public void issuePreview() {
        if(newBond==null)
        {
            System.out.println("标为空");
            return;
        }
        if(expenseEntitys==null)
        {
            System.out.println("支出列表为空");
            return;
        }
        if(issueBondUser==null)
        {
            System.out.println("发标用户为空");
            return;
            
        }
        financingBusinessLenderEntity=new FinancingBusinessLenderEntity();
        financingBusinessLenderEntity.setExpenseEntitys(expenseEntitys);
        financingBusinessLenderEntity.setFinancialProductEntity(newBond);
        financingBusinessLenderEntity.setLenderUser(issueBondUser);
    }

  
}
