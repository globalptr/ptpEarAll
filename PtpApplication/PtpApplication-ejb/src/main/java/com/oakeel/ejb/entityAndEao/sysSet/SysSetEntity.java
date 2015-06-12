/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.sysSet;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import java.math.BigDecimal;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class SysSetEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
    private int defaultBaseAmount=50;
    private BigDecimal defaultYearRate=new BigDecimal("0.218");
    private BigDecimal yearRate=new BigDecimal("0.252");
    private BigDecimal quarterRate=new BigDecimal("0.239");
    private BigDecimal monthRate=new BigDecimal("0.226");
    private BigDecimal dayRate=new BigDecimal("0.187");
    

    /**
     * @return the defaultBaseAmount
     */
    public int getDefaultBaseAmount() {
        return defaultBaseAmount;
    }

    /**
     * @param defaultBaseAmount the defaultBaseAmount to set
     */
    public void setDefaultBaseAmount(int defaultBaseAmount) {
        this.defaultBaseAmount = defaultBaseAmount;
    }

    /**
     * @return the defaultYearRate
     */
    public BigDecimal getDefaultYearRate() {
        return defaultYearRate;
    }

    /**
     * @param defaultYearRate the defaultYearRate to set
     */
    public void setDefaultYearRate(BigDecimal defaultYearRate) {
        this.defaultYearRate = defaultYearRate;
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
     * @return the monthRate
     */
    public BigDecimal getMonthRate() {
        return monthRate;
    }

    /**
     * @param monthRate the monthRate to set
     */
    public void setMonthRate(BigDecimal monthRate) {
        this.monthRate = monthRate;
    }

    /**
     * @return the dayRate
     */
    public BigDecimal getDayRate() {
        return dayRate;
    }

    /**
     * @param dayRate the dayRate to set
     */
    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
    }

    /**
     * @return the quarterRate
     */
    public BigDecimal getQuarterRate() {
        return quarterRate;
    }

    /**
     * @param quarterRate the quarterRate to set
     */
    public void setQuarterRate(BigDecimal quarterRate) {
        this.quarterRate = quarterRate;
    }
    
}
