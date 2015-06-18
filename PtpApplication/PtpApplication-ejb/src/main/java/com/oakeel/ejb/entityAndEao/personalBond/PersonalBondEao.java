/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.oakeel.ejb.entityAndEao.personalBond;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRoot;
import com.oakeel.ejb.ptpEnum.BondStageEnum;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author root
 */
@Stateless
public class PersonalBondEao extends EaoRoot<PersonalBondEntity> implements PersonalBondEaoLocal {


    @Override
    public void passAudit(PersonalBondEntity bond) {
        if(bond!=null) {
            bond.setBondStage(BondStageEnum.审核);
            em.merge(bond);
        }
    }

    @Override
    public void backToApplication(PersonalBondEntity bond) {
        bond.setBondStage(BondStageEnum.申请);
        em.merge(bond);
    }

    @Override
    public void logicDeleteBond(PersonalBondEntity bond) {
        bond.setActive(Boolean.FALSE);
        em.merge(bond);
    }


    @Override
    public List<PersonalBondEntity> getAllAuditBonds() {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<PersonalBondEntity> query=builder.createQuery(PersonalBondEntity.class);
        Root<PersonalBondEntity> s=query.from(PersonalBondEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(PersonalBondEntity_.active), Boolean.TRUE),builder.equal(s.get(PersonalBondEntity_.bondStage), BondStageEnum.发布)));
        TypedQuery<PersonalBondEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList();
        else
            return null;
    }

    @Override
    public List<PersonalBondEntity> getAllLogicDeleteBonds() {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<PersonalBondEntity> query=builder.createQuery(PersonalBondEntity.class);
        Root<PersonalBondEntity> s=query.from(PersonalBondEntity.class);
        query.select(s).where(builder.equal(s.get(PersonalBondEntity_.active), Boolean.FALSE));
        TypedQuery<PersonalBondEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList();
        else
            return null;
    }
}
