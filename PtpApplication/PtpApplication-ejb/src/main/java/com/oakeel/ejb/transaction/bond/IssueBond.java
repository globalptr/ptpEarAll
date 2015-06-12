/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.transaction.bond;

import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.BondStage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class IssueBond implements IssueBondLocal {

    @PersistenceContext(unitName = "ptpEjbPu")
    EntityManager em;
    PersonalBondEntity newBond;
    FrontUserEntity issPersonalBondEntity;
    PersonalBondEntity bond1 = null;
    PersonalBondEntity bond2 = null;
    PersonalBondEntity bond3 = null;
    FrontUserEntity issueBondUser;

    @Override
    public void setStep1Bond(PersonalBondEntity bond) {
        bond1 = bond;
    }

    @Override
    public void setStep2Bond(PersonalBondEntity bond) {
        bond2 = bond;
    }

    @Override
    public void setStep3Bond(PersonalBondEntity bond) {
        bond3 = bond;
    }

    @Override
    public PersonalBondEntity getBond1() {
        return bond1;
    }

    @Override
    public PersonalBondEntity getBond2() {
        return bond2;
    }

    @Override
    public PersonalBondEntity getBond3() {
        return bond3;
    }

    @Override
    public void issue() {
        em.persist(newBond);
        FrontUserEntity user =em.merge( newBond.getIssueUser());
        em.refresh(user);
    }

    @Override
    public PersonalBondEntity getCurrBond() {
        return newBond;
    }

    @Override
    public void setUser(FrontUserEntity bondUser) {
        if (bondUser != null) {
            issueBondUser = bondUser;
        }
    }

    @Override
    public void issuePreview() {

        if (bond1 == null) {
            System.out.println("bond1为空");
            return;
        } else if (bond2 == null) {
            System.out.println("bond2为空");
            return;
        } else if (bond3 == null) {
            System.out.println("bond3为空");
            return;
        }
        newBond = new PersonalBondEntity();
        //——————————————————————————————————————————————————————————————
        if (bond1 != null) {
            newBond.setName(bond1.getName());
            newBond.setIssueAdmin(bond1.getIssueAdmin());
            newBond.setDetails(bond1.getDetails());
            newBond.setBondType(bond1.getBondType());
            newBond.setCompanyUserEntity(bond1.getCompanyUserEntity());
            newBond.setRiskControlDetails(bond1.getRiskControlDetails());
            newBond.setGuaranteeCase(bond1.getGuaranteeCase());
            newBond.setReverseGuaranteeCase(bond1.getReverseGuaranteeCase());
            newBond.setIssueUser(bond1.getIssueUser());
            newBond.setIssueDate(bond1.getIssueDate());//开始时间
        }
        //——————————————————————————————————————————————————————————————
        if (bond2 != null) {
            newBond.setBondNumber(bond2.getBondNumber());
            newBond.setBondInformationEntiys(bond2.getBondInformationEntiys());
        }
        //——————————————————————————————————————————————————————————————
        if (bond3 != null) {
            newBond.setStartDate(bond3.getStartDate());//开始时间
            newBond.setYearRate(bond3.getYearRate());//年利率
            newBond.setBaseAmount(bond3.getBaseAmount());//基准金
            newBond.setIssueCopiesNum(bond3.getIssueCopiesNum());//份数
            newBond.setAllAmount(bond3.getIssueCopiesNum()*bond3.getBaseAmount());//总金额
            newBond.setRepayModelEnum(bond3.getRepayModelEnum());//还款模型
            newBond.setRepayCycle(bond3.getRepayCycle());//还款周期
            newBond.setRepayCycleNumber(bond3.getRepayCycleNumber());//还款次数
            newBond.setExpenseEntitys(bond3.getExpenseEntitys());//还款账单
        }
        newBond.setBondStage(BondStage.发布);

        //————————PersonalBondEntity————————————————————————————————————————————
    }

    @Override
    public void setCurrBond(PersonalBondEntity bond) {
        newBond = bond;
    }

}
