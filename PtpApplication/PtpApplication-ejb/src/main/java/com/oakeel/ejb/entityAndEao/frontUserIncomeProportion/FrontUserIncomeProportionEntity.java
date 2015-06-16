/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUserIncomeProportion;

import com.oakeel.ejb.entityAndEao.check.CheckEntity;
import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.repayItem.RepayItemEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class FrontUserIncomeProportionEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
    
    private int copiesNum;//份数
    private BigDecimal incomeYearRate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RepayItemEntity> repayItems=new ArrayList<>();//应收账单
    @OneToMany(cascade = CascadeType.ALL)
    private List<CheckEntity> checkEntitys=new ArrayList<>();//已经支付了的账单
    
    private BigDecimal proportion=BigDecimal.ZERO;//收益比例

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
     * @return the proportion
     */
    public BigDecimal getProportion() {
        return proportion;
    }

    /**
     * @param proportion the proportion to set
     */
    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    /**
     * @return the repayItems
     */
    public List<RepayItemEntity> getRepayItems() {
        return repayItems;
    }

    /**
     * @param repayItems the repayItems to set
     */
    public void setRepayItems(List<RepayItemEntity> repayItems) {
        this.repayItems = repayItems;
    }

    /**
     * @return the checkEntitys
     */
    public List<CheckEntity> getCheckEntitys() {
        return checkEntitys;
    }

    /**
     * @param checkEntitys the checkEntitys to set
     */
    public void setCheckEntitys(List<CheckEntity> checkEntitys) {
        this.checkEntitys = checkEntitys;
    }

    /**
     * @return the incomeYearRate
     */
    public BigDecimal getIncomeYearRate() {
        return incomeYearRate;
    }

    /**
     * @param incomeYearRate the incomeYearRate to set
     */
    public void setIncomeYearRate(BigDecimal incomeYearRate) {
        this.incomeYearRate = incomeYearRate;
    }

}
