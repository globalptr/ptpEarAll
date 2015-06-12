/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUserAccount;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class FrontUserAccountEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
 
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal availableBalance=BigDecimal.ZERO;//可用余额
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal freezeBalance=BigDecimal.ZERO;//冻结金额
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    private BigDecimal notMentionBalance=BigDecimal.ZERO;//不可提现金额

    /**
     * @return the availableBalance
     */
    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    /**
     * @param availableBalance the availableBalance to set
     */
    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * @return the freezeBalance
     */
    public BigDecimal getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * @param freezeBalance the freezeBalance to set
     */
    public void setFreezeBalance(BigDecimal freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    /**
     * @return the notMentionBalance
     */
    public BigDecimal getNotMentionBalance() {
        return notMentionBalance;
    }

    /**
     * @param notMentionBalance the notMentionBalance to set
     */
    public void setNotMentionBalance(BigDecimal notMentionBalance) {
        this.notMentionBalance = notMentionBalance;
    }

}
