/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.webFront;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class NewJSFManagedBean {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    private String str;
    
    public NewJSFManagedBean() {
    }
    public String test()
    {
        return str;
    }
    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(String str) {
        this.str = str;
    }
    
}
