/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.entityAndEao.frontUserHoldBond;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.bondIncomeProportion.BondIncomeProportionEntity;
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
    private FrontUserEntity user;
    @ManyToOne
    private PtpProductEntity ptpProductEntity;
    private int allBondNumber;//所有持标数
    @OneToMany
    private List<BondIncomeProportionEntity> bondIncomeProportionEntitys; 


    /**
     * @return the user
     */
    public FrontUserEntity getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(FrontUserEntity user) {
        this.user = user;
    }

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
    public List<BondIncomeProportionEntity> getBondIncomeProportionEntitys() {
        return bondIncomeProportionEntitys;
    }

    /**
     * @param bondIncomeProportionEntitys the bondIncomeProportionEntitys to set
     */
    public void setBondIncomeProportionEntitys(List<BondIncomeProportionEntity> bondIncomeProportionEntitys) {
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

}
