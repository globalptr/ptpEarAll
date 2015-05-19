/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.financingBusinessBorrower;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.financialProduct.FinancialProductEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.income.IncomeEntity;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class FinancingBusinessBorrowerEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
    //融资
    private BigDecimal amount;//金额
    @OneToOne
    private FrontUserEntity borrowUser;//贷方
    @OneToOne
    private FinancialProductEntity financialProductEntity;//金融产品

    @OneToMany//与收入明细是一对多的关系
    private Set<IncomeEntity> incomeEntitys;

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
     * @return the incomeEntitys
     */
    public Set<IncomeEntity> getIncomeEntitys() {
        return incomeEntitys;
    }

    /**
     * @param incomeEntitys the incomeEntitys to set
     */
    public void setIncomeEntitys(Set<IncomeEntity> incomeEntitys) {
        this.incomeEntitys = incomeEntitys;
    }

    /**
     * @return the borrowUser
     */
    public FrontUserEntity getBorrowUser() {
        return borrowUser;
    }

    /**
     * @param borrowUser the borrowUser to set
     */
    public void setBorrowUser(FrontUserEntity borrowUser) {
        this.borrowUser = borrowUser;
    }

}
