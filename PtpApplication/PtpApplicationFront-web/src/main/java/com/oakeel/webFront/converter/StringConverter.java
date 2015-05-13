/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.webFront.converter;

/**
 *
 * @author root
 */
import java.io.UnsupportedEncodingException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author taoxy
 */
@FacesConverter("str")
public class StringConverter implements Converter {

    /**
     *
     * @param context
     * @param component
     * @param newValues
     * @return
     * @throws ConverterException
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String newValues) throws ConverterException {
        String newstr = "";
        if (newValues == null) {
            newValues = "";
        }
        try {
            byte[] byte1 = newValues.getBytes("ISO-8859-1");
            newstr = new String(byte1, "UTF-8");
            UIInput input = (UIInput) component;//
            input.setSubmittedValue(newstr);
        } catch (UnsupportedEncodingException e) {
        }

        return newstr;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object Values) throws ConverterException {
        return (String) Values;
    }

}
