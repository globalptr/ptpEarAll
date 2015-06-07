/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.front.domain;

import com.oakeel.front.enums.PlatformFundTypeEnum;

/**
 *
 * @author zmr
 */
public class PlatformFund extends PtpProduct{
    private PlatformFundTypeEnum platformFundTypeEnum;

    public PlatformFundTypeEnum getPlatformFundTypeEnum() {
        return platformFundTypeEnum;
    }

    public void setPlatformFundTypeEnum(PlatformFundTypeEnum platformFundTypeEnum) {
        this.platformFundTypeEnum = platformFundTypeEnum;
    }
    
}
