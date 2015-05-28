/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.platformFund;

import com.oakeel.ejb.entityAndEao.ptpProduct.PtpProductEntity;
import com.oakeel.ejb.ptpEnum.PlatformFundTypeEnum;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class PlatformFundEntity extends PtpProductEntity {
    private static final long serialVersionUID = 1L;
    private PlatformFundTypeEnum platformFundTypeEnum;

    /**
     * @return the platformFundTypeEnum
     */
    public PlatformFundTypeEnum getPlatformFundTypeEnum() {
        return platformFundTypeEnum;
    }

    /**
     * @param platformFundTypeEnum the platformFundTypeEnum to set
     */
    public void setPlatformFundTypeEnum(PlatformFundTypeEnum platformFundTypeEnum) {
        this.platformFundTypeEnum = platformFundTypeEnum;
    }
    
}
