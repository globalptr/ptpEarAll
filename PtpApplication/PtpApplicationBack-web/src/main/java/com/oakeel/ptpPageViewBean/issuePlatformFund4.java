/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class issuePlatformFund4 {

    /**
     * Creates a new instance of issuePlatformFund4
     */
    public issuePlatformFund4() {
    }
    private int sec=5;
    public void backToMain()
    {
        if(getSec()==0)
        {
            FacesContext context=FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler handler=(ConfigurableNavigationHandler)context.getApplication().getNavigationHandler();
            handler.performNavigation("platformFundMain");
        }
        else
        {
            setSec(getSec() - 1);
        }
    }

    /**
     * @return the sec
     */
    public int getSec() {
        return sec;
    }

    /**
     * @param sec the sec to set
     */
    public void setSec(int sec) {
        this.sec = sec;
    }
}
