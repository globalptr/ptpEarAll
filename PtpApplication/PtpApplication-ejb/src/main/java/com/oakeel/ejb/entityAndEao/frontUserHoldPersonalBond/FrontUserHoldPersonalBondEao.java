/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRoot;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author root
 */
@Stateless
public class FrontUserHoldPersonalBondEao extends EaoRoot<FrontUserHoldPersonalBondEntity> implements FrontUserHoldPersonalBondEaoLocal {

    @Override
    public void SaveHolePersonalBond(FrontUserHoldPersonalBondEntity holdBond) {
        //保存的同时反向刷新前端用户和个人标
        em.persist(holdBond);
        FrontUserEntity user=em.merge(holdBond.getHoldUser());
        em.refresh(user);
        PersonalBondEntity bond=em.merge(holdBond.getPersonalBondEntity()) ;
        em.refresh(bond);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
