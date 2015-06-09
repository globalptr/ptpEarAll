/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction;

import com.oakeel.ejb.entityAndEao.folder.NewEntity;
import com.oakeel.ejb.entityAndEao.folder.NewEntity1;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class Test implements TestLocal {

    @PersistenceContext(unitName = "ptpEjbPu")
    EntityManager em;
    @Resource
    UserTransaction ut;
    @Override
    public void test(List<FrontUserEntity> list) {
        for(FrontUserEntity item:list)
        {
        }
//        try {
//            ut.begin();
//            NewEntity1 test=new NewEntity1();
//            NewEntity entity=new NewEntity();
//            test.setSss(entity);
//            em.persist(test);
//            ut.commit();
//            em.refresh(em.merge(entity));
//            System.out.println(entity.getSsf().size());
//        } catch (NotSupportedException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SystemException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (RollbackException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (HeuristicMixedException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (HeuristicRollbackException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SecurityException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalStateException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
