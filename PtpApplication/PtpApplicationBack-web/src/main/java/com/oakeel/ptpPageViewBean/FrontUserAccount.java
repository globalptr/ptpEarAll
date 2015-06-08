/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class FrontUserAccount {

    @Inject private PtpSessionBean ptpSessionBean;
    private FrontUserEntity frontUser;
    /**
     * Creates a new instance of FrontUserAccount
     */
    public FrontUserAccount() {
    }
    @PostConstruct
    public void init()
    {
        frontUser=ptpSessionBean.getFrontUserEntity();
        System.out.println(frontUser.getBondEntitys().size());
    }

    /**
     * @return the frontUser
     */
    public FrontUserEntity getFrontUser() {
        return frontUser;
    }

    /**
     * @param frontUser the frontUser to set
     */
    public void setFrontUser(FrontUserEntity frontUser) {
        this.frontUser = frontUser;
    }

    /**
     * @return the ptpSessionBean
     */
    public PtpSessionBean getPtpSessionBean() {
        return ptpSessionBean;
    }

    /**
     * @param ptpSessionBean the ptpSessionBean to set
     */
    public void setPtpSessionBean(PtpSessionBean ptpSessionBean) {
        this.ptpSessionBean = ptpSessionBean;
    }
    
}
