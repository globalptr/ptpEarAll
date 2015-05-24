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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class FinancingBusinessLenderEntity extends EntityRoot {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private FrontUserEntity lenderUser;//借方
    @OneToOne(cascade = {CascadeType.PERSIST})
    private FinancialProductEntity financialProductEntity;//金融产品
    @OneToMany(cascade = {CascadeType.PERSIST})//与支出明细是一对多的关系
    private List<ExpenseEntity> expenseEntitys;

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
