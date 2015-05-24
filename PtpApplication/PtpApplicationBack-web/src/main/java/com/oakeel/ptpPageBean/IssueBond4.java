/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class IssueBond4 {

    @Inject private PtpSessionBean ptpSessionBean;
    private BondEntity bond4;
    /**
     * Creates a new instance of IssueBond4
     */
    public IssueBond4() {
    }
    @PostConstruct
    public void init()
    {
        bond4=ptpSessionBean.getIssueBondLocal().getCurrBond();
    }
    public String issueBond() {
        
        getPtpSessionBean().getIssueBondLocal().issue();
        BondEntity temp=getPtpSessionBean().getIssueBondLocal().getCurrBond();
        return "issueBond5";
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

    /**
     * @return the bond4
     */
    public BondEntity getBond4() {
        return bond4;
    }

    /**
     * @param bond4 the bond4 to set
     */
    public void setBond4(BondEntity bond4) {
        this.bond4 = bond4;
    }
}
