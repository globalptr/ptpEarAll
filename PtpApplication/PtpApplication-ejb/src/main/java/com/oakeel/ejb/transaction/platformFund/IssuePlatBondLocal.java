/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.transaction.platformFund;

import com.oakeel.ejb.entityAndEao.platBond.PlatBondEntity;
import javax.ejb.Local;
import javax.ejb.Remove;

/**
 *
 * @author root
 */
@Local
public interface IssuePlatBondLocal {

    public void issuePreview();

    @Remove
    public void issue();

    public PlatBondEntity getNewBond();

    public void setNewBond(PlatBondEntity newBond);

    public PlatBondEntity getPlatBond1();

    public void setPlatBond1(PlatBondEntity platBond1);

    public PlatBondEntity getPlatBond2();

    public void setPlatBond2(PlatBondEntity platBond2);
}
