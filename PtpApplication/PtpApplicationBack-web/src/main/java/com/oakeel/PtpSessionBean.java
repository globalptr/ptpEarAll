/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import com.oakeel.ejb.transaction.bond.IssueBondLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class PtpSessionBean implements Serializable{

    @EJB
    private IssueBondLocal issueBondLocal;
    //对于一个登录用户的session数据，统一使用此bean
    /**
     * Creates a new instance of PtpSessionBean
     */
    public PtpSessionBean() {
    }
    public void test()
    {
        System.out.println("调用sessionbean");
    }
    private String userName;//保存会话期内的用户名

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the issueBondLocal
     */
    public IssueBondLocal getIssueBondLocal() {
        return issueBondLocal;
    }

    /**
     * @param issueBondLocal the issueBondLocal to set
     */
    public void setIssueBondLocal(IssueBondLocal issueBondLocal) {
        this.issueBondLocal = issueBondLocal;
    }
    

}
