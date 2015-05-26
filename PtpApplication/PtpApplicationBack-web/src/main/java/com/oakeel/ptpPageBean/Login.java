/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.globaltool.ValidateCode;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class Login implements Serializable{

    /**
     * Creates a new instance of Login
     */
    private String userName;
    private String password;
    private String validateStr;
    private @Inject PtpSessionBean ptpSessionBean;
    @PostConstruct
    public void init() {
    }
    public Login() {
    }
   
    public String log()
    {
        System.out.println(validateStr);
        System.out.println(ptpSessionBean.getValidateCode().getCode());
        if(validateStr.equals(ptpSessionBean.getValidateCode().getCode()))
        {
            System.out.println("ok");
        }
        return null;
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
//        try
//        {
//            subject.login(token);
//            return "main?faces-redirect=true";
//        }
//        catch(AuthenticationException ex)
//        {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SysInfo.提示.toString(),"用户名/手机号/邮箱和密码不匹配")); 
//            return null;
//        }
        
    }

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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return the validateStr
     */
    public String getValidateStr() {
        return validateStr;
    }

    /**
     * @param validateStr the validateStr to set
     */
    public void setValidateStr(String validateStr) {
        this.validateStr = validateStr;
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
