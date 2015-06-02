/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.ptpProductIncomeProportion;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import java.math.BigDecimal;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class PtpProductIncomeProportionEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
    
    private int copiesNum;//份数
    private BigDecimal proportion;//收益比例

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
}
