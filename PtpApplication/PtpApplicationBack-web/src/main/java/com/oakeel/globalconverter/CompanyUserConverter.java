/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.globalconverter;

import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEaoLocal;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEntity;
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
@FacesConverter("companyUserConverter")
public class CompanyUserConverter  implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            CompanyUserEaoLocal userEaoLocal= (CompanyUserEaoLocal)ctx.lookup("java:global/PtpApplicationBack-web/CompanyUserEao");
            CompanyUserEntity company=userEaoLocal.findEntityById(value);
            System.out.println(company);
            
            return company;
        } catch (NamingException ex) {
            Logger.getLogger(CompanyUserConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}


