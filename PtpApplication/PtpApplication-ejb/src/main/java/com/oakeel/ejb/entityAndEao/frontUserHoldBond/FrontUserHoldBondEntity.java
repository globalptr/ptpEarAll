/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.entityAndEao.frontUserHoldBond;

import com.oakeel.ejb.entityAndEao.ptpProductIncomeProportion.PtpProductIncomeProportionEntity;
import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.ptpProduct.PtpProductEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class FrontUserHoldBondEntity extends EntityRoot {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private FrontUserEntity holdUser;
    @ManyToOne
    private PtpProductEntity ptpProductEntity;
    private int allBondNumber;//所有持标数
    @OneToMany
    private List<PtpProductIncomeProportionEntity> bondIncomeProportionEntitys; 



    /**
     * @return the allBondNumber
     */
    public int getAllBondNumber() {
        return allBondNumber;
    }

    /**
     * @param allBondNumber the allBondNumber to set
     */
    public void setAllBondNumber(int allBondNumber) {
        this.allBondNumber = allBondNumber;
    }

    /**
     * @return the bondIncomeProportionEntitys
     */
    public List<PtpProductIncomeProportionEntity> getBondIncomeProportionEntitys() {
        return bondIncomeProportionEntitys;
    }

    /**
     * @param bondIncomeProportionEntitys the bondIncomeProportionEntitys to set
     */
    public void setBondIncomeProportionEntitys(List<PtpProductIncomeProportionEntity> bondIncomeProportionEntitys) {
        this.bondIncomeProportionEntitys = bondIncomeProportionEntitys;
    }

    /**
     * @return the ptpProductEntity
     */
    public PtpProductEntity getPtpProductEntity() {
        return ptpProductEntity;
    }

    /**
     * @param ptpProductEntity the ptpProductEntity to set
     */
    public void setPtpProductEntity(PtpProductEntity ptpProductEntity) {
        this.ptpProductEntity = ptpProductEntity;
    }

    /**
     * @return the holdUser
     */
    public FrontUserEntity getHoldUser() {
        return holdUser;
    }

    /**
     * @param holdUser the holdUser to set
     */
    public void setHoldUser(FrontUserEntity holdUser) {
        this.holdUser = holdUser;
    }

}
