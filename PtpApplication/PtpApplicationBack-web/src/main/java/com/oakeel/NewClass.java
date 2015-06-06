/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.event.SelectEvent;

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
    private BondEntity bond=new BondEntity();
    private Date date1;
    public void change()
    {
        System.out.println(bond);
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
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
    public void ttt()
    {
        System.out.println("change");
    }
    public void yyy()
    {
        System.out.println("blur");
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

    /**
     * @return the bond
     */
    public BondEntity getBond() {
        return bond;
    }

    /**
     * @param bond the bond to set
     */
    public void setBond(BondEntity bond) {
        this.bond = bond;
    }

    /**
     * @return the date1
     */
    public Date getDate1() {
        return date1;
    }

    /**
     * @param date1 the date1 to set
     */
    public void setDate1(Date date1) {
        this.date1 = date1;
    }
}
