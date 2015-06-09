/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.SysInfo;
import com.oakeel.ejb.transaction.InitEjbLocal;
import com.oakeel.ejb.transaction.Test;
import com.oakeel.ejb.transaction.TestLocal;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.apache.log4j.Logger;

/**
 *
 * @author root
 */
@Named
@ApplicationScoped
public class PtpApplicationBean {
    private static final Logger log = Logger.getLogger(LoginController.class.getClass());     
    @EJB
    InitEjbLocal initEjbLocal;
    @EJB
    TestLocal test;
    
    @PersistenceContext(unitName = "ptpEjbPu")
    EntityManager em;
    @Resource
    UserTransaction ut;
    /**
     * Creates a new instance of PtpApplicationBean
     * @param msg
     */
    
    public void ttt()
    {
        try {
            ut.begin();
            BondEntity bond1=new BondEntity();
            FrontUserEntity user=new FrontUserEntity();
            user.setName("ddd");
            user.setPassword("fsfdsf");
            em.persist(user);
            bond1.setIssueUser(user);
            em.persist(bond1);
            ut.commit();
            ut.begin();
            FrontUserEntity kk=em.merge(user);
            em.refresh(kk);
            System.out.println("fsdfsfsfsthis is"+kk.getBondEntitys().size());
        } catch (NotSupportedException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(SysInfo.提示.toString(),  "数据库初始化完毕!") );
    }
    public void logMessage(String msg)
    {
        log.info(msg); 
    }
    @PostConstruct
    public void init()
    {
//        DefaultSecurityManager securityManager = new DefaultSecurityManager(new PtpRealm());
//        //设置 authenticator 验证策略
//        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
//        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
//        securityManager.setAuthenticator(authenticator);
//        //设置 authorizer 授权策略
//        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
//        authorizer.setPermissionResolver(new WildcardPermissionResolver());
//        securityManager.setAuthorizer(authorizer);
//        //设置 Realm
//        //将 SecurityManager 设置到 SecurityUtils 方便全局使用
//        SecurityUtils.setSecurityManager(securityManager);
    }
    public PtpApplicationBean() {
    }
    public void initDB()
    {
        initEjbLocal.InitDB();
        initEjbLocal.addUsers();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(SysInfo.提示.toString(),  "数据库初始化完毕!") );
    }
    public void initSysSet()
    {
        //initEjbLocal.InitDB();
        initEjbLocal.initSet();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(SysInfo.提示.toString(),  "系统参数初始化完毕!") );
    }
}
