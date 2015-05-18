/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bond;

import com.oakeel.ejb.entityAndEao.bondRepayPlan.BondRepayPlanEntity;
import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.bondState.BondStateEntity;
import com.oakeel.ejb.entityAndEao.financialProduct.FinancialProductEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.CreditLevelEnum;
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
public class BondEntity extends FinancialProductEntity {
    private static final long serialVersionUID = 1L;
    private BondStage bondStage;//标的阶段
    private RepayModel repayModel;//还款模型
    private BigDecimal yearRate;//年利率
    private BigDecimal allAmount;//借款总额
    private int amoutTerm;//借款期限
    private SplitUnit repayCycle;//还款周期
    private BondType bondType;//标类型
    private CreditLevelEnum creditLevel;//信用等级
    @OneToMany(cascade = {CascadeType.ALL})//每期还款明细
    private Set<BondRepayPlanEntity> bondCheckEntitys;
    @OneToMany(cascade = {CascadeType.ALL})//标的资料，一对多
    private Set<BondInformationEntity> bondInformationEntiys;
    @OneToOne(cascade = {CascadeType.ALL})
    private BondStateEntity bondStateEntity;//标的状态

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
    public CreditLevelEnum getCreditLevel() {
        return creditLevel;
    }

    /**
     * @param creditLevel the creditLevel to set
     */
    public void setCreditLevel(CreditLevelEnum creditLevel) {
        this.creditLevel = creditLevel;
    }

    /**
     * @return the bondCheckEntitys
     */
    public Set<BondRepayPlanEntity> getBondCheckEntitys() {
        return bondCheckEntitys;
    }

    /**
     * @param bondCheckEntitys the bondCheckEntitys to set
     */
    public void setBondCheckEntitys(Set<BondRepayPlanEntity> bondCheckEntitys) {
        this.bondCheckEntitys = bondCheckEntitys;
    }

    /**
     * @return the bondInformationEntiys
     */
    public Set<BondInformationEntity> getBondInformationEntiys() {
        return bondInformationEntiys;
    }

    /**
     * @param bondInformationEntiys the bondInformationEntiys to set
     */
    public void setBondInformationEntiys(Set<BondInformationEntity> bondInformationEntiys) {
        this.bondInformationEntiys = bondInformationEntiys;
    }

    
}
