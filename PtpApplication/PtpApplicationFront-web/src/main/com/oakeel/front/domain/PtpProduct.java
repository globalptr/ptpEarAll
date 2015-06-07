/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.front.domain;

import com.oakeel.front.enums.SplitUnit;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author zmr
 */
public class PtpProduct {
    private Date startDate;//开始时间
    private String name;//名字
    private String Details;//详情  
    private BigDecimal yearRate=new BigDecimal("0");//年利率
    private String bondNumber;//标号
    private int baseAmount;//基准金额
    private int IssueCopiesNum;//发行份数
    private int transactionCopiesNum;//成交份数
    private int remainCopiesNum;//剩余份数
    private SplitUnit repayCycle;//还款周期
    private int repayCycleNumber;//期数
    Set<FrontUserHoldBond> frontUserHoldBonds;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    public String getBondNumber() {
        return bondNumber;
    }

    public void setBondNumber(String bondNumber) {
        this.bondNumber = bondNumber;
    }

    public int getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(int baseAmount) {
        this.baseAmount = baseAmount;
    }

    public int getIssueCopiesNum() {
        return IssueCopiesNum;
    }

    public void setIssueCopiesNum(int IssueCopiesNum) {
        this.IssueCopiesNum = IssueCopiesNum;
    }

    public int getTransactionCopiesNum() {
        return transactionCopiesNum;
    }

    public void setTransactionCopiesNum(int transactionCopiesNum) {
        this.transactionCopiesNum = transactionCopiesNum;
    }

    public int getRemainCopiesNum() {
        return remainCopiesNum;
    }

    public void setRemainCopiesNum(int remainCopiesNum) {
        this.remainCopiesNum = remainCopiesNum;
    }

    public int getRepayCycleNumber() {
        return repayCycleNumber;
    }

    public void setRepayCycleNumber(int repayCycleNumber) {
        this.repayCycleNumber = repayCycleNumber;
    }

    public SplitUnit getRepayCycle() {
        return repayCycle;
    }

    public void setRepayCycle(SplitUnit repayCycle) {
        this.repayCycle = repayCycle;
    }

    public Set<FrontUserHoldBond> getFrontUserHoldBonds() {
        return frontUserHoldBonds;
    }

    public void setFrontUserHoldBonds(Set<FrontUserHoldBond> frontUserHoldBonds) {
        this.frontUserHoldBonds = frontUserHoldBonds;
    }
    
}
