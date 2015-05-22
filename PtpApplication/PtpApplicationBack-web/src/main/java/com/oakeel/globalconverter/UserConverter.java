/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.globalconverter;

import com.oakeel.ejb.entityAndEao.user.UserEaoLocal;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author root
 */
@FacesConverter("userConverter")
public class UserConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            UserEaoLocal userEaoLocal= (UserEaoLocal)ctx.lookup("java:global/PtpApplicationBack-web/UserEao");
            return userEaoLocal.findEntityById(value);
        } catch (NamingException ex) {
            Logger.getLogger(UserConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        UserEntity user=(UserEntity)value;
        return user.getUuid();
    }
    
}
