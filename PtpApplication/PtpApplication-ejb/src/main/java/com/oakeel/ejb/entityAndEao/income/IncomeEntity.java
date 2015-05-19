/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.income;

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
public class IncomeEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;

    private BigDecimal principal;//本金
    private BigDecimal interest;//利息
    private BigDecimal receivable;//应收
    private BigDecimal actualReceivable;//实收
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
     * @return the receivable
     */
    public BigDecimal getReceivable() {
        return receivable;
    }

    /**
     * @param receivable the receivable to set
     */
    public void setReceivable(BigDecimal receivable) {
        this.receivable = receivable;
    }

    /**
     * @return the actualReceivable
     */
    public BigDecimal getActualReceivable() {
        return actualReceivable;
    }

    /**
     * @param actualReceivable the actualReceivable to set
     */
    public void setActualReceivable(BigDecimal actualReceivable) {
        this.actualReceivable = actualReceivable;
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
