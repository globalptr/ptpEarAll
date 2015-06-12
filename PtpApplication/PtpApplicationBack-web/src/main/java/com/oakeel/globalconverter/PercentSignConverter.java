/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.globalconverter;

import java.math.BigDecimal;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author root
 */
@FacesConverter("PercentSignConverter")
public class PercentSignConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) { 
        if (value != null && value.length() >= 1) {
            value = value.replaceAll("%", "");
        }
        BigDecimal percent=new BigDecimal(value);
        percent=percent.divide(new BigDecimal(100));
        return percent;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        BigDecimal percent=(BigDecimal)value;
        percent=percent.multiply(new BigDecimal(100));
        return percent.toString()+"%";
    }
    
}
