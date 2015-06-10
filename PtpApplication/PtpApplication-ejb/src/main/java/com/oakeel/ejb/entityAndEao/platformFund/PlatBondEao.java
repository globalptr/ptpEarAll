/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.platformFund;

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
public class PlatBondEao extends EaoRoot<PlatBondEntity> implements PlatBondEaoLocal {


    @Override
    public void passAudit(PlatBondEntity bond) {
        if(bond!=null) {
            bond.setBondStage(BondStage.审核);
            em.merge(bond);
        }
    }

    @Override
    public void backToApplication(PlatBondEntity bond) {
        bond.setBondStage(BondStage.申请);
        em.merge(bond);
    }

    @Override
    public void logicDeleteBond(PlatBondEntity bond) {
        bond.setActive(Boolean.FALSE);
        em.merge(bond);
    }


    @Override
    public List<PlatBondEntity> getAllAuditBonds() {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<PlatBondEntity> query=builder.createQuery(PlatBondEntity.class);
        Root<PlatBondEntity> s=query.from(PlatBondEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(PlatBondEntity_.active), Boolean.TRUE),builder.equal(s.get(PlatBondEntity_.bondStage), BondStage.发布)));
        TypedQuery<PlatBondEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList();
        else
            return null;
    }

    @Override
    public List<PlatBondEntity> getAllLogicDeleteBonds() {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<PlatBondEntity> query=builder.createQuery(PlatBondEntity.class);
        Root<PlatBondEntity> s=query.from(PlatBondEntity.class);
        query.select(s).where(builder.equal(s.get(PlatBondEntity_.active), Boolean.FALSE));
        TypedQuery<PlatBondEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList();
        else
            return null;
    }
}
