/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.webFront;

import com.oakeel.ejb.entityAndEao.user.UserEaoLocal;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@RequestScoped
public class RegistBean {
    @EJB
    private UserEaoLocal userEao;
    private UserEntity newUser=new UserEntity();
    @Inject private FrontSessionBean frontSessionBean;
    private String str="111111111111";
    /**
     * Creates a new instance of regist
     */
  
    public RegistBean() {
    }
    public String addUser()
    {
        userEao.addUser(newUser);
        frontSessionBean.setLogName(newUser);
        return "index?redirect=true";
    }
    /**
     * @return the newUser
     */
    public UserEntity getNewUser() {
        return newUser;
    }

    /**
     * @param newUser the newUser to set
     */
    public void setNewUser(UserEntity newUser) {
        this.newUser = newUser;
    }

    /**
     * @return the frontSessionBean
     */
    public FrontSessionBean getFrontSessionBean() {
        return frontSessionBean;
    }

    /**
     * @param frontSessionBean the frontSessionBean to set
     */
    public void setFrontSessionBean(FrontSessionBean frontSessionBean) {
        this.frontSessionBean = frontSessionBean;
    }

    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(String str) {
        this.str = str;
    }
    
}
