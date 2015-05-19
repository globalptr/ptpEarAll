/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.expense;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
public class ExpenseEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;

    private BigDecimal principal;//本金
    private BigDecimal interest;//利息
        
    private BigDecimal payable;//应付
    private BigDecimal actualPayable;//实付
    @Temporal(TemporalType.TIMESTAMP)
    private Date settlementTime;//结算时间

    /**
     * @return the principal
     */
    public BigDecimal getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    /**
     * @return the interest
     */
    public BigDecimal getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    /**
     * @return the payable
     */
    public BigDecimal getPayable() {
        return payable;
    }

    /**
     * @param payable the payable to set
     */
    public void setPayable(BigDecimal payable) {
        this.payable = payable;
    }

    /**
     * @return the actualPayable
     */
    public BigDecimal getActualPayable() {
        return actualPayable;
    }

    /**
     * @param actualPayable the actualPayable to set
     */
    public void setActualPayable(BigDecimal actualPayable) {
        this.actualPayable = actualPayable;
    }

    /**
     * @return the settlementTime
     */
    public Date getSettlementTime() {
        return settlementTime;
    }

    /**
     * @param settlementTime the settlementTime to set
     */
    public void setSettlementTime(Date settlementTime) {
        this.settlementTime = settlementTime;
    }
}
