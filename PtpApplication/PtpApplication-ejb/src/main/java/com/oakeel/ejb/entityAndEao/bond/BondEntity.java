/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bond;

import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEntity;
import com.oakeel.ejb.entityAndEao.folder.NewEntity;
import com.oakeel.ejb.entityAndEao.ptpProduct.PtpProductEntity;
import com.oakeel.ejb.ptpEnum.BondType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class BondEntity extends PtpProductEntity {
    private static final long serialVersionUID = 1L;
 
    //担保公司实体
    @ManyToOne
    private CompanyUserEntity companyUserEntity;//担保公司
    @Column(length = 100)
    private String riskControlDetails;//风险担保详情
    @Column(length = 100)
    private String guaranteeCase;//担保情况
    @Column(length = 100)
    private String reverseGuaranteeCase;//反担保情况
    private BondType bondType;//标类型
    @OneToMany(cascade = {CascadeType.ALL})//标的资料，一对多
    private List<BondInformationEntity> bondInformationEntiys=new ArrayList<>();

    


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

    /**
     * @return the companyUserEntity
     */
    public CompanyUserEntity getCompanyUserEntity() {
        return companyUserEntity;
    }

    /**
     * @param companyUserEntity the companyUserEntity to set
     */
    public void setCompanyUserEntity(CompanyUserEntity companyUserEntity) {
        this.companyUserEntity = companyUserEntity;
    }

    /**
     * @return the bondInformationEntiys
     */
    public List<BondInformationEntity> getBondInformationEntiys() {
        return bondInformationEntiys;
    }

    /**
     * @param bondInformationEntiys the bondInformationEntiys to set
     */
    public void setBondInformationEntiys(List<BondInformationEntity> bondInformationEntiys) {
        this.bondInformationEntiys = bondInformationEntiys;
    }

    
}
