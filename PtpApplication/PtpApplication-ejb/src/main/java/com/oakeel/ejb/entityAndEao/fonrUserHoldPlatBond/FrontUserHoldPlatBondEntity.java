/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.fonrUserHoldPlatBond;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.frontUserIncomeProportion.FrontUserIncomeProportionEntity;
import com.oakeel.ejb.entityAndEao.platBond.PlatBondEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class FrontUserHoldPlatBondEntity extends EntityRoot {
  
    @ManyToOne
    private FrontUserEntity holdUser;
    @ManyToOne
    private PlatBondEntity platBondEntity;
    private int allBondNumber;//所有持标数
    @OneToMany
    private List<FrontUserIncomeProportionEntity> bondIncomeProportionEntitys; 

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
    public List<FrontUserIncomeProportionEntity> getBondIncomeProportionEntitys() {
        return bondIncomeProportionEntitys;
    }

    /**
     * @param bondIncomeProportionEntitys the bondIncomeProportionEntitys to set
     */
    public void setBondIncomeProportionEntitys(List<FrontUserIncomeProportionEntity> bondIncomeProportionEntitys) {
        this.bondIncomeProportionEntitys = bondIncomeProportionEntitys;
    }

    /**
     * @return the platBondEntity
     */
    public PlatBondEntity getPlatBondEntity() {
        return platBondEntity;
    }

    /**
     * @param platBondEntity the platBondEntity to set
     */
    public void setPlatBondEntity(PlatBondEntity platBondEntity) {
        this.platBondEntity = platBondEntity;
    }
}
