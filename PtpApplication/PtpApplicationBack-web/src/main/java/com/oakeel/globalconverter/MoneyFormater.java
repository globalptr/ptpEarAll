/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.globalconverter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author root
 */
@FacesConverter("moneyFormater")
public class MoneyFormater implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        //将经过格式化了的字符串还原为原始字符串
        
        String formatString = "";
        if (value != null && value.length() >= 1) {
            formatString = value.replaceAll(",", "");
            formatString = formatString.replaceAll("¥", "");
        }
        return new BigDecimal(formatString);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        //将原始字符串格式化
        if (value == null || value.toString().length() < 1) {
            return "";
        }
        NumberFormat formater = null;
        int len = 2;//小数位
        double num = Double.parseDouble(value.toString());
        if (len == 0) {
            formater = new DecimalFormat("###,###");

        } else {
            StringBuffer buff = new StringBuffer();
            buff.append("###,###.");
            for (int i = 0; i < len; i++) {
                buff.append("#");
            }
            formater = new DecimalFormat(buff.toString());
        }
        return "¥"+formater.format(num);
    }

}
