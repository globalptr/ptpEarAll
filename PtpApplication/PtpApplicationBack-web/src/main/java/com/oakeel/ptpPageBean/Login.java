/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ptpPageBean;

import com.oakeel.PtpApplicationBean;
import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.backUser.BackUserEaoLocal;
import com.oakeel.ejb.entityAndEao.backUser.BackUserEntity;
import com.oakeel.ejb.entityAndEao.backUserSet.BackUserSetEntity;
import com.oakeel.ejb.ptpEnum.SysInfo;
import com.oakeel.globaltool.ValidateCode;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class Login implements Serializable {

    /**
     * Creates a new instance of Login
     */
    private String voucher;
    private String password;
    private String validateStr;
    private @Inject
    PtpSessionBean ptpSessionBean;
    @Inject
    PtpApplicationBean ptpApplicationBean;
    @Inject ValidateCode validateCode;
    @EJB
    BackUserEaoLocal backUserEaoLocal;

    @PostConstruct
    public void init() {

        
        BackUserEntity backUser=new BackUserEntity();
        backUser.setName("2");
        backUser.setTelephone("1");
        backUser.setPassword("1");
        BackUserSetEntity backUserSetEntity=new BackUserSetEntity();
        backUserSetEntity.setUserTheme("delta");
        backUser.setBackUserSetEntity(backUserSetEntity);
        backUserEaoLocal.addEntity(backUser);
    }

    public Login() {
    }
    
    public String log() {
        if(validateCode.getCode().equals(validateStr.toLowerCase()))
        {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(voucher, password);
            try {
                subject.login(token);       
                if(backUserEaoLocal.validateUserByName(voucher, password)!=null)
                {
                    ptpSessionBean.setLogUser(backUserEaoLocal.validateUserByName(voucher, password));
                }
                else if(backUserEaoLocal.validateUserByTelephone(voucher, password)!=null)
                {
                    ptpSessionBean.setLogUser(backUserEaoLocal.validateUserByTelephone(voucher, password));
                }
                else if(backUserEaoLocal.validateUserByEmail(voucher, password)!=null)
                {
                    ptpSessionBean.setLogUser(backUserEaoLocal.validateUserByEmail(voucher, password));
                }
                return "main?faces-redirect=true";
            } 
            catch (AuthenticationException ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SysInfo.提示.toString(), "用户名/手机号/邮箱和密码不匹配"));
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    public String logout() {

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.logout();
        } catch (Exception e) {
            ptpApplicationBean.logMessage(e.toString());
        }
        return "index";
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

    /**
     * @return the voucher
     */
    public String getVoucher() {
        return voucher;
    }

    /**
     * @param voucher the voucher to set
     */
    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    /**
     * @return the validateCode
     */
    public ValidateCode getValidateCode() {
        return validateCode;
    }

    /**
     * @param validateCode the validateCode to set
     */
    public void setValidateCode(ValidateCode validateCode) {
        this.validateCode = validateCode;
    }

}
