/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.platformFund;

import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.platBond.PlatBondEntity;
import com.oakeel.ejb.ptpEnum.BondStage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class IssuePlatBond implements IssuePlatBondLocal {
    @PersistenceContext(unitName = "ptpEjbPu")
    EntityManager em;
    private PlatBondEntity platBond1=null;
    private PlatBondEntity platBond2=null;
    private PlatBondEntity newBond=null;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    @Override
    public void issuePreview() {
        newBond=new PlatBondEntity();
        if(platBond1!=null)
        {
            newBond.setPlatBondTypeEnum(platBond1.getPlatBondTypeEnum());
            newBond.setYearRate(platBond1.getYearRate());
            newBond.setIssueUser(platBond1.getIssueUser());
        }
        if(platBond2!=null)
        {
            newBond.setStartDate(platBond2.getStartDate());//开始时间
            newBond.setBaseAmount(platBond2.getBaseAmount());//基准金
            newBond.setIssueCopiesNum(platBond2.getIssueCopiesNum());//份数
            newBond.setRepayModelEnum(platBond2.getRepayModelEnum());//还款模型
            newBond.setRepayCycle(platBond2.getRepayCycle());//还款周期
            newBond.setRepayCycleNumber(platBond2.getRepayCycleNumber());//还款次数
            newBond.setExpenseEntitys(platBond2.getExpenseEntitys());//还款账单
        }
        newBond.setBondStage(BondStage.发布);
        //——————————————————————————————————————————————————————————————
    }

    @Override
    public void issue() {
        try {
            em.persist(newBond);
            FrontUserEntity user=em.merge(newBond.getIssueUser());
            if(user!=null)
                em.refresh(user);
            else
                throw new Exception();
        } catch (Exception ex) {
            Logger.getLogger(IssuePlatBond.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * @return the newBond
     */
    @Override
    public PlatBondEntity getNewBond() {
        return newBond;
    }

    /**
     * @param newBond the newBond to set
     */
    @Override
    public void setNewBond(PlatBondEntity newBond) {
        this.newBond = newBond;
    }

    /**
     * @return the platBond1
     */
    @Override
    public PlatBondEntity getPlatBond1() {
        return platBond1;
    }

    /**
     * @param platBond1 the platBond1 to set
     */
    @Override
    public void setPlatBond1(PlatBondEntity platBond1) {
        this.platBond1 = platBond1;
    }

    /**
     * @return the platBond2
     */
    @Override
    public PlatBondEntity getPlatBond2() {
        return platBond2;
    }

    /**
     * @param platBond2 the platBond2 to set
     */
    @Override
    public void setPlatBond2(PlatBondEntity platBond2) {
        this.platBond2 = platBond2;
    }



}
