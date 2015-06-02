/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class NewClass implements Serializable {
    private String sss="ffffffffffffffffff";
    private String str = "1212";
    private String strx;
    private Boolean visible = false;
    public void change()
    {
        System.out.println("ffffffffffffff");
        visible=!visible;
    }
    public void test() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("admin")) {
            //有权限
        } else {
            //无权限
        }

    }

    public void setnewvalue() {
        str=strx;
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

    /**
     * @return the strx
     */
    public String getStrx() {
        return strx;
    }

    /**
     * @param strx the strx to set
     */
    public void setStrx(String strx) {
        this.strx = strx;
    }

    /**
     * @return the visible
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the sss
     */
    public String getSss() {
        return sss;
    }

    /**
     * @param sss the sss to set
     */
    public void setSss(String sss) {
        this.sss = sss;
    }
}
