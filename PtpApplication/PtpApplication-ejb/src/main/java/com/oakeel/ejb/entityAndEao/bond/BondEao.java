/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bond;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRoot;
import com.oakeel.ejb.ptpEnum.BondStage;
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
public class BondEao extends EaoRoot<BondEntity> implements BondEaoLocal {


    @Override
    public void passAudit(BondEntity bond) {
        if(bond!=null) {
            bond.setBondStage(BondStage.审核);
            em.merge(bond);
        }
    }

    @Override
    public void backToApplication(BondEntity bond) {
        bond.setBondStage(BondStage.申请);
        em.merge(bond);
    }

    @Override
    public void logicDeleteBond(BondEntity bond) {
        bond.setActive(Boolean.FALSE);
        em.merge(bond);
    }


    @Override
    public List<BondEntity> getAllAuditBonds() {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<BondEntity> query=builder.createQuery(BondEntity.class);
        Root<BondEntity> s=query.from(BondEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(BondEntity_.active), Boolean.TRUE),builder.equal(s.get(BondEntity_.bondStage), BondStage.发布)));
        TypedQuery<BondEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList();
        else
            return null;
    }

    @Override
    public List<BondEntity> getAllLogicDeleteBonds() {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<BondEntity> query=builder.createQuery(BondEntity.class);
        Root<BondEntity> s=query.from(BondEntity.class);
        query.select(s).where(builder.equal(s.get(BondEntity_.active), Boolean.FALSE));
        TypedQuery<BondEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList();
        else
            return null;
    }
}
