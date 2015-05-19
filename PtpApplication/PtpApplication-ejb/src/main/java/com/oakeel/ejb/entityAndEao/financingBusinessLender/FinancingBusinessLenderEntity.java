/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.entityAndEao.financingBusinessLender;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.expense.ExpenseEntity;
import com.oakeel.ejb.entityAndEao.financialProduct.FinancialProductEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.income.IncomeEntity;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class FinancingBusinessLenderEntity extends EntityRoot {

    private static final long serialVersionUID = 1L;
    //融资
    private BigDecimal amount;//金额
    @OneToOne
    private FrontUserEntity lenderUser;//借方
    @OneToOne
    private FinancialProductEntity financialProductEntity;//金融产品
    @OneToMany//与支出明细是一对多的关系
    private Set<ExpenseEntity> expenseEntitys;

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the financialProductEntity
     */
    public FinancialProductEntity getFinancialProductEntity() {
        return financialProductEntity;
    }

    /**
     * @param financialProductEntity the financialProductEntity to set
     */
    public void setFinancialProductEntity(FinancialProductEntity financialProductEntity) {
        this.financialProductEntity = financialProductEntity;
    }

    /**
     * @return the expenseEntitys
     */
    public Set<ExpenseEntity> getExpenseEntitys() {
        return expenseEntitys;
    }

    /**
     * @param expenseEntitys the expenseEntitys to set
     */
    public void setExpenseEntitys(Set<ExpenseEntity> expenseEntitys) {
        this.expenseEntitys = expenseEntitys;
    }

    /**
     * @return the lenderUser
     */
    public FrontUserEntity getLenderUser() {
        return lenderUser;
    }

    /**
     * @param lenderUser the lenderUser to set
     */
    public void setLenderUser(FrontUserEntity lenderUser) {
        this.lenderUser = lenderUser;
    }


}
