/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.bond;

import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import javax.ejb.Local;
import javax.ejb.Remove;

/**
 *
 * @author root
 */
@Local
public interface IssueBondLocal {
    
    @Remove
    public void issue();
    public void setCurrBond(PersonalBondEntity bond);
    public void issuePreview();
    public void setUser(FrontUserEntity bondUser);
    public PersonalBondEntity getCurrBond();   
    public PersonalBondEntity getBond3();
    public PersonalBondEntity getBond2();
    public PersonalBondEntity getBond1();
    public void setStep3Bond(PersonalBondEntity bond);
    public void setStep2Bond(PersonalBondEntity bond);
    public void setStep1Bond(PersonalBondEntity bond);
}
