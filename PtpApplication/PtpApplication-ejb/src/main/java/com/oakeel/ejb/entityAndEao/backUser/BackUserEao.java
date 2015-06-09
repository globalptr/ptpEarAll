/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.backUser;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRoot;
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
public class BackUserEao extends EaoRoot<BackUserEntity> implements BackUserEaoLocal {
    @Override
    public List<BackUserEntity> getUserByName(String name)
    {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<BackUserEntity> query=builder.createQuery(BackUserEntity.class);
        Root<BackUserEntity> s=query.from(BackUserEntity.class);
        query.select(s).where(builder.like(s.get(BackUserEntity_.name), name));
        TypedQuery<BackUserEntity> q=em.createQuery(query);
        return q.getResultList();
    }
    @Override
    public BackUserEntity validateUserByName(String name, String password) {
        System.out.println(name+":"+password);
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<BackUserEntity> query=builder.createQuery(BackUserEntity.class);
        Root<BackUserEntity> s=query.from(BackUserEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(BackUserEntity_.name), name),builder.equal(s.get(BackUserEntity_.password), password)));
        TypedQuery<BackUserEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList().get(0);
        else
            return null;
    }

    @Override
    public BackUserEntity validateUserByTelephone(String telephone, String password) {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<BackUserEntity> query=builder.createQuery(BackUserEntity.class);
        Root<BackUserEntity> s=query.from(BackUserEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(BackUserEntity_.telephone), telephone),builder.equal(s.get(BackUserEntity_.password), password)));
        TypedQuery<BackUserEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList().get(0);
        else
            return null;
    }

    @Override
    public BackUserEntity validateUserByEmail(String email, String password) {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<BackUserEntity> query=builder.createQuery(BackUserEntity.class);
        Root<BackUserEntity> s=query.from(BackUserEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(BackUserEntity_.email), email),builder.equal(s.get(BackUserEntity_.password), password)));
        TypedQuery<BackUserEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList().get(0);
        else
            return null;
    }

    @Override
    public BackUserEntity validateUserByQQ(String qq, String password) {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<BackUserEntity> query=builder.createQuery(BackUserEntity.class);
        Root<BackUserEntity> s=query.from(BackUserEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(BackUserEntity_.qq), qq),builder.equal(s.get(BackUserEntity_.password), password)));
        TypedQuery<BackUserEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList().get(0);
        else
            return null;
    }

}
