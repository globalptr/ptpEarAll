/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@RequestScoped
public class NewClass {
    private String str="1212";

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
