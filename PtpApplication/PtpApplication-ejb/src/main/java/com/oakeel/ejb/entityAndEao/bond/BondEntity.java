/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bond;

import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.bondState.BondStateEntity;
import com.oakeel.ejb.entityAndEao.financialProduct.FinancialProductEntity;
import com.oakeel.ejb.ptpEnum.BondStage;
import com.oakeel.ejb.ptpEnum.BondType;
import com.oakeel.ejb.ptpEnum.RepayModel;
import com.oakeel.ejb.ptpEnum.SplitUnit;
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
    private String bondNumber;
    //担保公司实体
    private String riskControlDetails;//风险担保详情
    private String guaranteeCase;//担保情况
    private String reverseGuaranteeCase;//反担保情况
    private BondStage bondStage;//标的阶段
    private RepayModel repayModel;//还款模型
    private SplitUnit repayCycle;//还款周期
    private int repayCycleNumber;//期数
    private BondType bondType;//标类型
    @OneToMany(cascade = {CascadeType.ALL})//标的资料，一对多
    private Set<BondInformationEntity> bondInformationEntiys;
    @OneToOne(cascade = {CascadeType.ALL})//标的状态
    private BondStateEntity bondStateEntity;

    
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

    /**
     * @return the repayCycleNumber
     */
    public int getRepayCycleNumber() {
        return repayCycleNumber;
    }

    /**
     * @param repayCycleNumber the repayCycleNumber to set
     */
    public void setRepayCycleNumber(int repayCycleNumber) {
        this.repayCycleNumber = repayCycleNumber;
    }

    /**
     * @return the bondNumber
     */
    public String getBondNumber() {
        return bondNumber;
    }

    /**
     * @param bondNumber the bondNumber to set
     */
    public void setBondNumber(String bondNumber) {
        this.bondNumber = bondNumber;
    }

    /**
     * @return the guaranteeCase
     */
    public String getGuaranteeCase() {
        return guaranteeCase;
    }

    /**
     * @param guaranteeCase the guaranteeCase to set
     */
    public void setGuaranteeCase(String guaranteeCase) {
        this.guaranteeCase = guaranteeCase;
    }

    /**
     * @return the reverseGuaranteeCase
     */
    public String getReverseGuaranteeCase() {
        return reverseGuaranteeCase;
    }

    /**
     * @param reverseGuaranteeCase the reverseGuaranteeCase to set
     */
    public void setReverseGuaranteeCase(String reverseGuaranteeCase) {
        this.reverseGuaranteeCase = reverseGuaranteeCase;
    }

    /**
     * @return the riskControlDetails
     */
    public String getRiskControlDetails() {
        return riskControlDetails;
    }

    /**
     * @param riskControlDetails the riskControlDetails to set
     */
    public void setRiskControlDetails(String riskControlDetails) {
        this.riskControlDetails = riskControlDetails;
    }

    
}
