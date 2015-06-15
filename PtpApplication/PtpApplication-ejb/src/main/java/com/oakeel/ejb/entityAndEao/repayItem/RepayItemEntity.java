/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.repayItem;

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
public class RepayItemEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;

    private int periodNum;//还款期数
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal principal=BigDecimal.ZERO;//本金
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal interest=BigDecimal.ZERO;//利息
        
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal subTatal=BigDecimal.ZERO;//小计
    @Temporal(TemporalType.TIMESTAMP)
    private Date settlementTime;//结算时间
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal beforeBalance=BigDecimal.ZERO;//期初余额
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal afterBalance=BigDecimal.ZERO;//期末余额
    
    
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal actualPrincipal=BigDecimal.ZERO;//实际偿还本金
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal actualInterest=BigDecimal.ZERO;//实际偿还利息
        
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal actualSubTatal=BigDecimal.ZERO;//实际偿还小计
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualSettlementTime;//结算时间
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal actualBeforeBalance=BigDecimal.ZERO;//实际偿还期初余额
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal actualAfterBalance=BigDecimal.ZERO;//实际偿还期末余额
    private Boolean isSettle;//是否结清

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

    /**
     * @return the subTatal
     */
    public BigDecimal getSubTatal() {
        return subTatal;
    }

    /**
     * @param subTatal the subTatal to set
     */
    public void setSubTatal(BigDecimal subTatal) {
        this.subTatal = subTatal;
    }

    /**
     * @return the actualPrincipal
     */
    public BigDecimal getActualPrincipal() {
        return actualPrincipal;
    }

    /**
     * @param actualPrincipal the actualPrincipal to set
     */
    public void setActualPrincipal(BigDecimal actualPrincipal) {
        this.actualPrincipal = actualPrincipal;
    }

    /**
     * @return the actualInterest
     */
    public BigDecimal getActualInterest() {
        return actualInterest;
    }

    /**
     * @param actualInterest the actualInterest to set
     */
    public void setActualInterest(BigDecimal actualInterest) {
        this.actualInterest = actualInterest;
    }

    /**
     * @return the actualSubTatal
     */
    public BigDecimal getActualSubTatal() {
        return actualSubTatal;
    }

    /**
     * @param actualSubTatal the actualSubTatal to set
     */
    public void setActualSubTatal(BigDecimal actualSubTatal) {
        this.actualSubTatal = actualSubTatal;
    }

    /**
     * @return the actualSettlementTime
     */
    public Date getActualSettlementTime() {
        return actualSettlementTime;
    }

    /**
     * @param actualSettlementTime the actualSettlementTime to set
     */
    public void setActualSettlementTime(Date actualSettlementTime) {
        this.actualSettlementTime = actualSettlementTime;
    }

    /**
     * @return the actualBeforeBalance
     */
    public BigDecimal getActualBeforeBalance() {
        return actualBeforeBalance;
    }

    /**
     * @param actualBeforeBalance the actualBeforeBalance to set
     */
    public void setActualBeforeBalance(BigDecimal actualBeforeBalance) {
        this.actualBeforeBalance = actualBeforeBalance;
    }

    /**
     * @return the actualAfterBalance
     */
    public BigDecimal getActualAfterBalance() {
        return actualAfterBalance;
    }

    /**
     * @param actualAfterBalance the actualAfterBalance to set
     */
    public void setActualAfterBalance(BigDecimal actualAfterBalance) {
        this.actualAfterBalance = actualAfterBalance;
    }

    /**
     * @return the isSettle
     */
    public Boolean getIsSettle() {
        return isSettle;
    }

    /**
     * @param isSettle the isSettle to set
     */
    public void setIsSettle(Boolean isSettle) {
        this.isSettle = isSettle;
    }
}
