/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import com.oakeel.PtpSessionBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class Main {

    /**
     * Creates a new instance of Main
     */
    
    @Inject private PtpSessionBean ptpSessionBean;
    private String selectTheme;
    public Main() {
    }

    public void changeTheme()
    {
        if(ptpSessionBean.getUserSet()!=null)
        {
           
            ptpSessionBean.changeUserTheme(selectTheme);
        }
        
    }
    /**
     * @return the selectTheme
     */
    public String getSelectTheme() {
        return selectTheme;
    }

    /**
     * @param selectTheme the selectTheme to set
     */
    public void setSelectTheme(String selectTheme) {
        this.selectTheme = selectTheme;
    }

    /**
     * @return the ptpSessionBean
     */
    public PtpSessionBean getPtpSessionBean() {
        return ptpSessionBean;
    }

    /**
     * @param ptpSessionBean the ptpSessionBean to set
     */
    public void setPtpSessionBean(PtpSessionBean ptpSessionBean) {
        this.ptpSessionBean = ptpSessionBean;
    }
    
}
