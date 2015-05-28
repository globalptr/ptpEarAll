/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.platformFund;

import com.oakeel.ejb.entityAndEao.platformFund.PlatformFundEntity;
import javax.ejb.Local;
import javax.ejb.Remove;

/**
 *
 * @author root
 */
@Local
public interface IssuePlatformFundLocal {
    public void setPlatformFundEntity1(PlatformFundEntity platformFundEntity1);
    public void setPlatformFundEntity2(PlatformFundEntity platformFundEntity2);
    public void issuePreview();
    @Remove
    public void issue();
    public PlatformFundEntity getNewRecord();
    public PlatformFundEntity getPlatformFundEntity1();
    public PlatformFundEntity getPlatformFundEntity2();
}
