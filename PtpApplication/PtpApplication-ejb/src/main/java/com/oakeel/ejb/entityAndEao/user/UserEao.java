/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.user;


import com.oakeel.ejb.entityAndEao.eeroot.EaoRoot;
import com.oakeel.ejb.entityAndEao.organization.OrganizationEntity;
import com.oakeel.ejb.entityAndEao.role.RoleEntity;
import java.util.List;
import java.util.Set;
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
public class UserEao extends EaoRoot<UserEntity> implements UserEaoLocal {


    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")



    @Override
    public List<UserEntity> getUsersByOrganization(OrganizationEntity org) {
        if(org==null)
            return null;
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query=builder.createQuery(UserEntity.class);
        Root<UserEntity> s=query.from(UserEntity.class);
        query.select(s).where(builder.equal(s.get(UserEntity_.organizationEntity), org));
        TypedQuery<UserEntity> q=em.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<UserEntity> getUnclassedUser() {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query=builder.createQuery(UserEntity.class);
        Root<UserEntity> s=query.from(UserEntity.class);
        query.select(s).where(s.get(UserEntity_.organizationEntity).isNull());        
        TypedQuery<UserEntity> q=em.createQuery(query);
        List<UserEntity> ss=q.getResultList();
        return q.getResultList();
    }



  

    @Override
    public void deleteRole(UserEntity user, RoleEntity role) {
        Set<RoleEntity> roles=user.getRoleEntitys();
        for(RoleEntity item:roles)
        {
            if(item.getUuid().equals(role.getUuid()))
            {
                roles.remove(item);
                break;
            }
        }
        em.merge(user);
    }

    @Override
    public void addUserRole(UserEntity user, RoleEntity role) {
        user.getRoleEntitys().add(role);
        em.merge(user);
    }

    @Override
    public UserEntity validateUserByName(String name, String password) {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query=builder.createQuery(UserEntity.class);
        Root<UserEntity> s=query.from(UserEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(UserEntity_.name), name),builder.equal(s.get(UserEntity_.password), password)));
        TypedQuery<UserEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList().get(0);
        else
            return null;
    }

    @Override
    public UserEntity validateUserByTelephone(String telephone, String password) {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query=builder.createQuery(UserEntity.class);
        Root<UserEntity> s=query.from(UserEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(UserEntity_.telephone), telephone),builder.equal(s.get(UserEntity_.password), password)));
        TypedQuery<UserEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList().get(0);
        else
            return null;
    }

    @Override
    public UserEntity validateUserByEmail(String email, String password) {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query=builder.createQuery(UserEntity.class);
        Root<UserEntity> s=query.from(UserEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(UserEntity_.email), email),builder.equal(s.get(UserEntity_.password), password)));
        TypedQuery<UserEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList().get(0);
        else
            return null;
    }

    @Override
    public UserEntity validateUserByQQ(String qq, String password) {
        
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query=builder.createQuery(UserEntity.class);
        Root<UserEntity> s=query.from(UserEntity.class);
        query.select(s).where(builder.and(builder.equal(s.get(UserEntity_.qq), qq),builder.equal(s.get(UserEntity_.password), password)));
        TypedQuery<UserEntity> q=em.createQuery(query);
        if(!q.getResultList().isEmpty())
            return q.getResultList().get(0);
        else
            return null;
    }
}
