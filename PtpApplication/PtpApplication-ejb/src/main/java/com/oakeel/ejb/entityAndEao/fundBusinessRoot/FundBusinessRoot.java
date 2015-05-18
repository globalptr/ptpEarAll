/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.fundBusinessRoot;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author root
 */
@MappedSuperclass  
public class FundBusinessRoot implements Serializable {
    //资金业务父类，包括充值和提现
    private static final long serialVersionUID = 1L;
    public FundBusinessRoot()
    {
        productUuid=UUID.randomUUID().toString();
    }
    @Id
    private String productUuid;
    private String name;
    private String productDesc;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getProductUuid() != null ? getProductUuid().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FundBusinessRoot)) {
            return false;
        }
        FundBusinessRoot other = (FundBusinessRoot) object;
        if ((this.getProductUuid() == null && other.getProductUuid() != null) || (this.getProductUuid() != null && !this.productUuid.equals(other.productUuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oakeel.ejb.entityAndEao.fundBusiness.FundBusinessRoot[ id=" + getProductUuid() + " ]";
    }

    /**
     * @return the productUuid
     */
    public String getProductUuid() {
        return productUuid;
    }

    /**
     * @param productUuid the productUuid to set
     */
    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

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
