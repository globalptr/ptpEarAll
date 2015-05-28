/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.shiro;

import com.oakeel.ejb.entityAndEao.backUser.BackUserEaoLocal;
import com.oakeel.ejb.entityAndEao.user.UserEaoLocal;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 *
 * @author root
 */
public class PtpRealm extends AuthorizingRealm {

    BackUserEaoLocal backUserEaoLocal;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
        try {
            InitialContext ic=new InitialContext();
            backUserEaoLocal=(BackUserEaoLocal)ic.lookup("java:global/PtpApplicationBack-web/BackUserEao");
        } catch (NamingException ex) {
            Logger.getLogger(PtpRealm.class.getName()).log(Level.SEVERE, null, ex);
        }
        String voucher = (String) at.getPrincipal(); //得到凭证
        String password = Arrays.toString((char[])at.getCredentials()); //得到密码
        password=password.substring(1,password.length()-1);//去掉方括号
        //三种验证方式：用户名-密码；手机-密码；邮箱-密码
        Boolean pass=false;
        if(backUserEaoLocal.validateUserByName(voucher, password)!=null)
        {
            pass=true;
        }
        else if(backUserEaoLocal.validateUserByTelephone(voucher, password)!=null)
        {
            pass=true;
        }
        else if(backUserEaoLocal.validateUserByEmail(voucher, password)!=null)
        {
            pass=true;
        }
        if(!pass) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        AuthenticationInfo info=new SimpleAuthenticationInfo(voucher, password,voucher);
        return info;
    }
}
