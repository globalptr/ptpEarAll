/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.globalconverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author root
 */
@FacesConverter("DateConverter")
public class DateConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = formatter.parse(value);
        } catch (ParseException ex) {
            Logger.getLogger(DateConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return birthday;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd"); 
        String hr;
        try
        {
            hr=formatter.format(value); 
        }
        catch(Exception ex)
        {
            Date temp=new Date(value.toString());
            hr=formatter.format(temp); 
            return hr;
        }
        return hr; 
    }
    
}
