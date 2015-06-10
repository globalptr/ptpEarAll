/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.OperationEnum;
import com.oakeel.ejb.ptpEnum.SysInfo;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class FrontUserAccount {

    @Inject private PtpSessionBean ptpSessionBean;
    
    private FrontUserEntity frontUser;
    private PersonalBondEntity targetBond;
    /**
     * Creates a new instance of FrontUserAccount
     */
    public FrontUserAccount() {
    }
    @PostConstruct
    public void init()
    {
        frontUser=ptpSessionBean.getFrontUserEntity();
        System.out.println(frontUser.getBondEntitys().size());
    }

    public String bondDetail()
    {
        if(getTargetBond()!=null)
        {
            ptpSessionBean.getIssueBondLocal().setCurrBond(getTargetBond());
            ptpSessionBean.setOperationEnum(OperationEnum.查询);
            return "issueBond4";
        }
        else
        {
            FacesMessage msg = new FacesMessage(SysInfo.错误.toString(), "查看的目标融资标为空");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
    }
    /**
     * @return the frontUser
     */
    public FrontUserEntity getFrontUser() {
        return frontUser;
    }

    /**
     * @param frontUser the frontUser to set
     */
    public void setFrontUser(FrontUserEntity frontUser) {
        this.frontUser = frontUser;
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
     * @return the targetBond
     */
    public PersonalBondEntity getTargetBond() {
        return targetBond;
    }

    /**
     * @param targetBond the targetBond to set
     */
    public void setTargetBond(PersonalBondEntity targetBond) {
        this.targetBond = targetBond;
    }

    
}
