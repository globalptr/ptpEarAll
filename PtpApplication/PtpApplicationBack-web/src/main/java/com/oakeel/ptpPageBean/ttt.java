/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean
@SessionScoped
public class ttt  {
    private String tt;
    /**
     * Creates a new instance of ttt
     */
    public ttt() {
    }
public void kk()
{
    System.out.println("value:"+getTt());
}

    /**
     * @return the tt
     */
    public String getTt() {
        return tt;
    }

    /**
     * @param tt the tt to set
     */
    public void setTt(String tt) {
        this.tt = tt;
    }

    
}
