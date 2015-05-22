/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUser;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRoot;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import com.oakeel.ejb.entityAndEao.user.UserEntity_;
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
public class FrontUserEao extends EaoRoot<FrontUserEntity> implements FrontUserEaoLocal {
    @Override
    public List<FrontUserEntity> getUserByName(String name)
    {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<FrontUserEntity> query=builder.createQuery(FrontUserEntity.class);
        Root<FrontUserEntity> s=query.from(FrontUserEntity.class);
        query.select(s).where(builder.like(s.get(FrontUserEntity_.name), name));
        TypedQuery<FrontUserEntity> q=em.createQuery(query);
        return q.getResultList();
        
    }
    @Override
    public List<FrontUserEntity> getUserByTelephone(String telephone)
    {
        
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<FrontUserEntity> query=builder.createQuery(FrontUserEntity.class);
        Root<FrontUserEntity> s=query.from(FrontUserEntity.class);
        query.select(s).where(builder.like(s.get(FrontUserEntity_.telephone), telephone));
        TypedQuery<FrontUserEntity> q=em.createQuery(query);
        return q.getResultList();
    }
    @Override
    public List<FrontUserEntity> getUserByEmail(String email)
    {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<FrontUserEntity> query=builder.createQuery(FrontUserEntity.class);
        Root<FrontUserEntity> s=query.from(FrontUserEntity.class);
        query.select(s).where(builder.like(s.get(FrontUserEntity_.email), email));
        TypedQuery<FrontUserEntity> q=em.createQuery(query);
        return q.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
