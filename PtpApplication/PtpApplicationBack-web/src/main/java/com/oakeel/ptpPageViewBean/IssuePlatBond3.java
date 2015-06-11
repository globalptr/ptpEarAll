/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.platBond.PlatBondEntity;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class IssuePlatBond3 {

    @Inject private PtpSessionBean ptpSessionBean;
    private PlatBondEntity platformFundEntity3=null;
    @PostConstruct
    public void init()
    {
        platformFundEntity3=ptpSessionBean.getIssuePlatBondLocal().getNewBond();
    }
    /**
     * Creates a new instance of issuePlatformFund3
     */
    public IssuePlatBond3() {
    }

    /**
     * @return the platformFundEntity3
     */
    public PlatBondEntity getPlatformFundEntity3() {
        return platformFundEntity3;
    }

    /**
     * @param platformFundEntity3 the platformFundEntity3 to set
     */
    public void setPlatformFundEntity3(PlatBondEntity platformFundEntity3) {
        this.platformFundEntity3 = platformFundEntity3;
    }
    public String issuePlatBond()
    {
        ptpSessionBean.getIssuePlatBondLocal().issue();
        return "issuePlatBond4";
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
