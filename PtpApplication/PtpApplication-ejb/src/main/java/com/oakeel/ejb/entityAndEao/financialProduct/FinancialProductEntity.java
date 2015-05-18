/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.financialProduct;

import com.oakeel.ejb.entityAndEao.debitCredit.DebitCreditEntity;
import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FinancialProductEntity extends EntityRoot {
    //金融产品的父类，包括融资标和聚财宝
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy="financialProductEntity")//金融产品与借贷实体是一对多的关系，主控在借贷实体
    private Set<DebitCreditEntity> debitCreditEntitys;
    private String name;
    private String productDesc;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the productDesc
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * @param productDesc the productDesc to set
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /**
     * @return the debitCreditEntitys
     */
    public Set<DebitCreditEntity> getDebitCreditEntitys() {
        return debitCreditEntitys;
    }

    /**
     * @param debitCreditEntitys the debitCreditEntitys to set
     */
    public void setDebitCreditEntitys(Set<DebitCreditEntity> debitCreditEntitys) {
        this.debitCreditEntitys = debitCreditEntitys;
    }
    
}
