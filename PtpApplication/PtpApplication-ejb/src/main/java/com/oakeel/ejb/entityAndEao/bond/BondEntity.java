/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bond;

import com.oakeel.ejb.entityAndEao.bondCheck.BondCheckEntity;
import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.bondState.BondStateEntity;
import com.oakeel.ejb.entityAndEao.financialProductRoot.FinancialProductRoot;
import com.oakeel.ejb.ptpEnum.RepayModel;
import com.oakeel.ejb.ptpEnum.SplitUnit;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class BondEntity extends FinancialProductRoot {
    private static final long serialVersionUID = 1L;
    private BondStage bondStage;//标的阶段
    private RepayModel repayModel;//还款模型
    private BigDecimal yearRate;//年利率
    private BigDecimal allAmount;//借款总额
    private int amoutTerm;//借款期限
    private SplitUnit repayCycle;//还款周期
    private BondType bondType;//标类型
    private CreditLevel creditLevel;//信用等级
    @OneToMany(cascade = {CascadeType.ALL})
    private Set<BondCheckEntity> bondCheckEntitys;
    @OneToOne(cascade = {CascadeType.ALL})
    private BondInformationEntity bondInformationEntit;//标的信息
    @OneToOne(cascade = {CascadeType.ALL})
    private BondStateEntity bondStateEntity;//标的状态



    /**
     * @return the bondInformationEntit
     */
    public BondInformationEntity getBondInformationEntit() {
        return bondInformationEntit;
    }

    /**
     * @param bondInformationEntit the bondInformationEntit to set
     */
    public void setBondInformationEntit(BondInformationEntity bondInformationEntit) {
        this.bondInformationEntit = bondInformationEntit;
    }

    /**
     * @return the bondStateEntity
     */
    public BondStateEntity getBondStateEntity() {
        return bondStateEntity;
    }

    /**
     * @param bondStateEntity the bondStateEntity to set
     */
    public void setBondStateEntity(BondStateEntity bondStateEntity) {
        this.bondStateEntity = bondStateEntity;
    }

    /**
     * @return the bondStage
     */
    public BondStage getBondStage() {
        return bondStage;
    }

    /**
     * @param bondStage the bondStage to set
     */
    public void setBondStage(BondStage bondStage) {
        this.bondStage = bondStage;
    }

    /**
     * @return the repayModel
     */
    public RepayModel getRepayModel() {
        return repayModel;
    }

    /**
     * @param repayModel the repayModel to set
     */
    public void setRepayModel(RepayModel repayModel) {
        this.repayModel = repayModel;
    }

    /**
     * @return the yearRate
     */
    public BigDecimal getYearRate() {
        return yearRate;
    }

    /**
     * @param yearRate the yearRate to set
     */
    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    /**
     * @return the allAmount
     */
    public BigDecimal getAllAmount() {
        return allAmount;
    }

    /**
     * @param allAmount the allAmount to set
     */
    public void setAllAmount(BigDecimal allAmount) {
        this.allAmount = allAmount;
    }

    /**
     * @return the amoutTerm
     */
    public int getAmoutTerm() {
        return amoutTerm;
    }

    /**
     * @param amoutTerm the amoutTerm to set
     */
    public void setAmoutTerm(int amoutTerm) {
        this.amoutTerm = amoutTerm;
    }

    /**
     * @return the repayCycle
     */
    public SplitUnit getRepayCycle() {
        return repayCycle;
    }

    /**
     * @param repayCycle the repayCycle to set
     */
    public void setRepayCycle(SplitUnit repayCycle) {
        this.repayCycle = repayCycle;
    }

    /**
     * @return the bondType
     */
    public BondType getBondType() {
        return bondType;
    }

    /**
     * @param bondType the bondType to set
     */
    public void setBondType(BondType bondType) {
        this.bondType = bondType;
    }

    /**
     * @return the creditLevel
     */
    public CreditLevel getCreditLevel() {
        return creditLevel;
    }

    /**
     * @param creditLevel the creditLevel to set
     */
    public void setCreditLevel(CreditLevel creditLevel) {
        this.creditLevel = creditLevel;
    }

    /**
     * @return the bondCheckEntitys
     */
    public Set<BondCheckEntity> getBondCheckEntitys() {
        return bondCheckEntitys;
    }

    /**
     * @param bondCheckEntitys the bondCheckEntitys to set
     */
    public void setBondCheckEntitys(Set<BondCheckEntity> bondCheckEntitys) {
        this.bondCheckEntitys = bondCheckEntitys;
    }
    
}
