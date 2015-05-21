/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.bond;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateful
public class IssueBond implements IssueBondLocal {
    @PersistenceContext(unitName = "ptpEjbPu")
    EntityManager em;
    BondEntity newBond;
    @Override
    public void step1(BondEntity bond) {
        if(newBond==null)
        {
            newBond=new BondEntity();
        }
        newBond.setName(bond.getName());
        newBond.setBaseAmountEnum(bond.getBaseAmountEnum());
        newBond.setBondNumber(bond.getBondNumber());
        newBond.setCompanyUserEntity(bond.getCompanyUserEntity());
        newBond.setRepayModel(bond.getRepayModel());
        newBond.setRiskControlDetails(bond.getRiskControlDetails());
        newBond.setGuaranteeCase(bond.getGuaranteeCase());
        newBond.setReverseGuaranteeCase(bond.getReverseGuaranteeCase());
    }

    @Override
    public void step2(BondEntity bond) {
        if(newBond==null)
        {
            newBond=new BondEntity();
        }
        newBond.setBondInformationEntiys(bond.getBondInformationEntiys());
    }

    @Override
    public void issue() {
        if(newBond!=null)
            em.persist(newBond);
        newBond=new BondEntity();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public BondEntity getCurrBond() {
        return newBond;
    }

    @Override
    public void createNewBond() {
        newBond=new BondEntity();
    }
}
