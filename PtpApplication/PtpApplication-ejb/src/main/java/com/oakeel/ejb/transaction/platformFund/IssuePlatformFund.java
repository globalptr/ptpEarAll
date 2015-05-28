/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.platformFund;

import com.oakeel.ejb.entityAndEao.frontUserIssueBond.FrontUserIssueBondEntity;
import com.oakeel.ejb.entityAndEao.platformFund.PlatformFundEntity;
import com.oakeel.ejb.ptpEnum.BondStage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class IssuePlatformFund implements IssuePlatformFundLocal {
    @PersistenceContext(unitName = "ptpEjbPu")
    EntityManager em;
    private PlatformFundEntity platformFundEntity1=null;
    private PlatformFundEntity platformFundEntity2=null;
    private PlatformFundEntity newRecord=null;
    FrontUserIssueBondEntity frontUserIssueBondEntity=null;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     * @return the platformFundEntity1
     */
    public PlatformFundEntity getPlatformFundEntity1() {
        return platformFundEntity1;
    }

    /**
     * @param platformFundEntity1 the platformFundEntity1 to set
     */
    @Override
    public void setPlatformFundEntity1(PlatformFundEntity platformFundEntity1) {
        this.platformFundEntity1 = platformFundEntity1;
    }

    /**
     * @return the platformFundEntity2
     */
    public PlatformFundEntity getPlatformFundEntity2() {
        return platformFundEntity2;
    }

    /**
     * @param platformFundEntity2 the platformFundEntity2 to set
     */
    @Override
    public void setPlatformFundEntity2(PlatformFundEntity platformFundEntity2) {
        this.platformFundEntity2 = platformFundEntity2;
    }

    @Override
    public void issuePreview() {
        newRecord=new PlatformFundEntity();
        if(platformFundEntity1!=null)
        {
            newRecord.setPlatformFundTypeEnum(platformFundEntity1.getPlatformFundTypeEnum());
            newRecord.setYearRate(platformFundEntity1.getYearRate());
        }
        if(platformFundEntity2!=null)
        {
            newRecord.setStartDate(platformFundEntity2.getStartDate());//开始时间
            newRecord.setBaseAmount(platformFundEntity2.getBaseAmount());//基准金
            newRecord.setIssueCopiesNum(platformFundEntity2.getIssueCopiesNum());//份数
            newRecord.setRepayModelEnum(platformFundEntity2.getRepayModelEnum());//还款模型
            newRecord.setRepayCycle(platformFundEntity2.getRepayCycle());//还款周期
            newRecord.setRepayCycleNumber(platformFundEntity2.getRepayCycleNumber());//还款次数
            newRecord.setExpenseEntitys(platformFundEntity2.getExpenseEntitys());//还款账单
        }
        newRecord.setBondStage(BondStage.发布);
        //——————————————————————————————————————————————————————————————
    }

    @Override
    public void issue() {
        em.persist(newRecord);
        frontUserIssueBondEntity=new FrontUserIssueBondEntity();
        frontUserIssueBondEntity.setPtpProductEntity(newRecord);
        em.persist(frontUserIssueBondEntity);
    }

    /**
     * @return the newRecord
     */
    @Override
    public PlatformFundEntity getNewRecord() {
        return newRecord;
    }

    /**
     * @param newRecord the newRecord to set
     */
    public void setNewRecord(PlatformFundEntity newRecord) {
        this.newRecord = newRecord;
    }

}
