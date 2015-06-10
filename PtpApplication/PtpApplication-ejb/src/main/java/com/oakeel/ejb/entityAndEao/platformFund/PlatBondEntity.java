/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.platformFund;

import com.oakeel.ejb.entityAndEao.ptpProduct.PtpProductEntity;
import com.oakeel.ejb.ptpEnum.PlatBondTypeEnum;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class PlatBondEntity extends PtpProductEntity {
    private static final long serialVersionUID = 1L;
    private PlatBondTypeEnum platBondTypeEnum;

    /**
     * @return the platBondTypeEnum
     */
    public PlatBondTypeEnum getPlatBondTypeEnum() {
        return platBondTypeEnum;
    }

    /**
     * @param platBondTypeEnum the platBondTypeEnum to set
     */
    public void setPlatBondTypeEnum(PlatBondTypeEnum platBondTypeEnum) {
        this.platBondTypeEnum = platBondTypeEnum;
    }

    
}
