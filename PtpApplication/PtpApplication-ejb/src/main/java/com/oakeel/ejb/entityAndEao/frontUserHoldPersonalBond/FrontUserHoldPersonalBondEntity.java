/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.frontUserIncomeProportion.FrontUserIncomeProportionEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class FrontUserHoldPersonalBondEntity extends EntityRoot {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private FrontUserEntity holdUser;
    @ManyToOne
    private PersonalBondEntity personalBondEntity;
    private int allBondNumber;//所有持标数
    @OneToMany
    private List<FrontUserIncomeProportionEntity> bondIncomeProportionEntitys; 



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
     * @return the personalBondEntity
     */
    public PersonalBondEntity getPersonalBondEntity() {
        return personalBondEntity;
    }

    /**
     * @param personalBondEntity the personalBondEntity to set
     */
    public void setPersonalBondEntity(PersonalBondEntity personalBondEntity) {
        this.personalBondEntity = personalBondEntity;
    }

}
