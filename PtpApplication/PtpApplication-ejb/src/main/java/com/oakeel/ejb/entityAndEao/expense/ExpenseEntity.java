/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.expense;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
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

    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal principal=BigDecimal.ZERO;//本金
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal interest=BigDecimal.ZERO;//利息
        
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal payable=BigDecimal.ZERO;//应付
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal actualPayable=BigDecimal.ZERO;//实付
    @Temporal(TemporalType.TIMESTAMP)
    private Date settlementTime;//结算时间
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal beforeBalance=BigDecimal.ZERO;//期初余额
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal afterBalance=BigDecimal.ZERO;//期末余额
    private int periodNum;//还款期数

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

    /**
     * @return the beforeBalance
     */
    public BigDecimal getBeforeBalance() {
        return beforeBalance;
    }

    /**
     * @param beforeBalance the beforeBalance to set
     */
    public void setBeforeBalance(BigDecimal beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    /**
     * @return the afterBalance
     */
    public BigDecimal getAfterBalance() {
        return afterBalance;
    }

    /**
     * @param afterBalance the afterBalance to set
     */
    public void setAfterBalance(BigDecimal afterBalance) {
        this.afterBalance = afterBalance;
    }

    /**
     * @return the periodNum
     */
    public int getPeriodNum() {
        return periodNum;
    }

    /**
     * @param periodNum the periodNum to set
     */
    public void setPeriodNum(int periodNum) {
        this.periodNum = periodNum;
    }
}
