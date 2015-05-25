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
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEaoLocal;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEntity;
import java.util.List;
import javax.ejb.EJB;
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
        newBond.setName(bond.getName());
        newBond.setCompanyUserEntity(bond.getCompanyUserEntity());
        newBond.setRiskControlDetails(bond.getRiskControlDetails());
        newBond.setGuaranteeCase(bond.getGuaranteeCase());
        newBond.setReverseGuaranteeCase(bond.getReverseGuaranteeCase());
        //设置默认的年利率
        //设置默认的基准金
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
    public void setUser(FrontUserEntity bondUser) {
        if(bondUser!=null)
        {
            issueBondUser=bondUser;
        }
    }

    @Override
    public void setStep3Bond(BondEntity bond) {
        newBond.setYearRate(bond.getYearRate());//年利率
        newBond.setStartDate(bond.getStartDate());//开始时间
        newBond.setBaseAmount(bond.getBaseAmount());//基准金
        newBond.setCopiesNum(bond.getCopiesNum());//份数
        newBond.setRepayModelEnum(bond.getRepayModelEnum());//还款模型
        newBond.setRepayCycle(bond.getRepayCycle());//还款周期
        newBond.setRepayCycleNumber(bond.getRepayCycleNumber());//还款次数
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

    @Override
    public FinancingBusinessLenderEntity getCurrLender() {
        return financingBusinessLenderEntity;
    }

    @Override
    public void createNewBond() {
        newBond=new BondEntity();
    }

  
}
