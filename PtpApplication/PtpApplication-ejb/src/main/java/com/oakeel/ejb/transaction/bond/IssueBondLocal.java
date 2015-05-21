/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.bond;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import javax.ejb.Local;
import javax.ejb.Remove;

/**
 *
 * @author root
 */
@Local
public interface IssueBondLocal {
    public void step1(BondEntity bond);
    public void step2(BondEntity bond);
    @Remove
    public void issue();
    public BondEntity getCurrBond();
    public void createNewBond();
}
