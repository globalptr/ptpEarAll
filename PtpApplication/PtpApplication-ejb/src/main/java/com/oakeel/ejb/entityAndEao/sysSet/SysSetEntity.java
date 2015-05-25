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
    private BigDecimal defaultYearRate=new BigDecimal("21.5");

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
    
}
