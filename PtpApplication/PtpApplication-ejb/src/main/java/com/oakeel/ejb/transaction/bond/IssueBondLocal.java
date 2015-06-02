/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.bond;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remove;

/**
 *
 * @author root
 */
@Local
public interface IssueBondLocal {
    public void setUser(FrontUserEntity bondUser);
    public void setStep1Bond(BondEntity bond);
    public void setStep2Bond(BondEntity bond);
    public void setStep3Bond(BondEntity bond);
    public void issuePreview();
    @Remove
    public void issue();
    public void setCurrBond(BondEntity bond);
    public BondEntity getCurrBond();
    public BondEntity getBond1();
    public BondEntity getBond2();
    public BondEntity getBond3();
}
