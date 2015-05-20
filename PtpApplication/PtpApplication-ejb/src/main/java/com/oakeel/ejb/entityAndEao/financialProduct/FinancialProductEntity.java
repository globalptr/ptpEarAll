/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.financialProduct;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.financingBusinessBorrower.FinancingBusinessBorrowerEntity;
import com.oakeel.ejb.entityAndEao.financingBusinessLender.FinancingBusinessLenderEntity;
import com.oakeel.ejb.ptpEnum.BaseAmountEnum;
import java.math.BigDecimal;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FinancialProductEntity extends EntityRoot {
    //金融产品的父类，包括融资标和聚财宝
    private static final long serialVersionUID = 1L;
    private String name;//名字
    private String Details;//详情  
    private BigDecimal yearRate=new BigDecimal("0");//年利率
    private BaseAmountEnum baseAmountEnum;//基准金额
    private int copiesNum;//份数
    @OneToMany(mappedBy="financialProductEntity")//与金融业务借方是一对多的关系，主控在业务方
    private Set<FinancingBusinessLenderEntity> financingBusinessLenderEntitys;
    @OneToMany(mappedBy="financialProductEntity")//与金融业务贷方是一对多的关系，主控在业务方
    private Set<FinancingBusinessBorrowerEntity> financingBusinessBorrowerEntitys;
    
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
     * @return the yearRate
     */
    public BigDecimal getYearRate() {
        return yearRate;
    }

    /**
     * @param yearRate the yearRate to set
     */
    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    /**
     * @return the baseAmountEnum
     */
    public BaseAmountEnum getBaseAmountEnum() {
        return baseAmountEnum;
    }

    /**
     * @param baseAmountEnum the baseAmountEnum to set
     */
    public void setBaseAmountEnum(BaseAmountEnum baseAmountEnum) {
        this.baseAmountEnum = baseAmountEnum;
    }

    /**
     * @return the copiesNum
     */
    public int getCopiesNum() {
        return copiesNum;
    }

    /**
     * @param copiesNum the copiesNum to set
     */
    public void setCopiesNum(int copiesNum) {
        this.copiesNum = copiesNum;
    }

    /**
     * @return the Details
     */
    public String getDetails() {
        return Details;
    }

    /**
     * @param Details the Details to set
     */
    public void setDetails(String Details) {
        this.Details = Details;
    }

    /**
     * @return the financingBusinessLenderEntitys
     */
    public Set<FinancingBusinessLenderEntity> getFinancingBusinessLenderEntitys() {
        return financingBusinessLenderEntitys;
    }

    /**
     * @param financingBusinessLenderEntitys the financingBusinessLenderEntitys to set
     */
    public void setFinancingBusinessLenderEntitys(Set<FinancingBusinessLenderEntity> financingBusinessLenderEntitys) {
        this.financingBusinessLenderEntitys = financingBusinessLenderEntitys;
    }

    /**
     * @return the financingBusinessBorrowerEntitys
     */
    public Set<FinancingBusinessBorrowerEntity> getFinancingBusinessBorrowerEntitys() {
        return financingBusinessBorrowerEntitys;
    }

    /**
     * @param financingBusinessBorrowerEntitys the financingBusinessBorrowerEntitys to set
     */
    public void setFinancingBusinessBorrowerEntitys(Set<FinancingBusinessBorrowerEntity> financingBusinessBorrowerEntitys) {
        this.financingBusinessBorrowerEntitys = financingBusinessBorrowerEntitys;
    }

}
