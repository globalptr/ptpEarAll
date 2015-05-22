/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.bond;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.financingBusinessLender.FinancingBusinessLenderEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
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
    FrontUserEntity issueBondUser;
    FinancingBusinessLenderEntity financingBusinessLenderEntity;
    
    
    @Override
    public void setStep1Bond(BondEntity bond) {
        if(newBond==null)
        {
            newBond=new BondEntity();
        }
        newBond.setName(bond.getName());
        newBond.setBaseAmountEnum(bond.getBaseAmountEnum());
        newBond.setCopiesNum(bond.getCopiesNum());
        newBond.setCompanyUserEntity(bond.getCompanyUserEntity());
        newBond.setRepayModelEnum(bond.getRepayModelEnum());
        newBond.setRiskControlDetails(bond.getRiskControlDetails());
        newBond.setGuaranteeCase(bond.getGuaranteeCase());
        newBond.setReverseGuaranteeCase(bond.getReverseGuaranteeCase());
    }

    @Override
    public void setStep2Bond(BondEntity bond) {
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

    @Override
    public void setUser(FrontUserEntity bondUser) {
        if(issueBondUser!=null)
        {
            issueBondUser=bondUser;
        }
    }

  
}
