/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.fundBusiness;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author root
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)  
public class FundBusinessEntity extends EntityRoot {
    //资金业务父类，包括充值和提现
    private static final long serialVersionUID = 1L;
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
    
}
