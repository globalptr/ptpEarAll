/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.eeroot;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 *
 * @author root
 * @param <T>
 */
public class EaoRoot<T> implements EaoRootLocal<T> {
    private final Class<T> clazz;
    
    @PersistenceContext(unitName="ptpEjbPu")
    protected EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public EaoRoot()
    {
        ParameterizedType param = (ParameterizedType)(this.getClass().getGenericSuperclass());
        clazz=(Class<T>) param.getActualTypeArguments()[0];
    }
    @Override
    public void addEntity(T t) {
        em.persist(t);
    }

    @Override
    public List<T> getAllEntitys() {
        try
        {
            CriteriaBuilder builder=em.getCriteriaBuilder();
            CriteriaQuery<T> query=builder.createQuery(clazz);
            Root<T> s=query.from(clazz);
            query.select(s);        
            TypedQuery<T> q=em.createQuery(query);
            return q.getResultList();
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    @Override
    public void updateEntity(T t) {
        em.merge(t);
    }

    @Override
    public void removeEntity(T t) {
        em.remove(em.merge(t));
    }

    @Override
    public T findEntityById(String uuid) {
        return em.find(clazz, uuid);
    }
}
