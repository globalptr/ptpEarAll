/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.backUser.BackUserEaoLocal;
import com.oakeel.ejb.entityAndEao.backUser.BackUserEntity;
import com.oakeel.ejb.entityAndEao.bond.BondEaoLocal;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.ptpEnum.OperationEnum;
import com.oakeel.ejb.ptpEnum.SysInfo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
public class AuditBond {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    @EJB
    BondEaoLocal bondEaoLocal;
    private BondEntity targetBond;
    private List<BondEntity> bondEntitys;
    private List<BondEntity> bondEntitysFilter;
    private List<BackUserEntity> backUserEntitys;
    @EJB
    private BackUserEaoLocal backUserEaoLocal;
    @Inject PtpSessionBean ptpSessionBean;
    public AuditBond() {
    }
    @PostConstruct
    public void init()
    {
        bondEntitys=bondEaoLocal.getAllAuditBonds();
        backUserEntitys=backUserEaoLocal.getAllEntitys();
    }
    public void passAudit()
    {
        if(targetBond!=null)
            bondEaoLocal.passAudit(targetBond);
    }
    public void backBond()
    {
        if(targetBond!=null)
        {
            bondEaoLocal.backToApplication(targetBond);
            bondEntitys.remove(targetBond);
        }
        else
        {
            FacesMessage msg = new FacesMessage(SysInfo.错误.toString(), "查看的目标融资标为空");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    /**
     * @return the bondEntitys
     */
    public List<BondEntity> getBondEntitys() {
        return bondEntitys;
    }
    public String setTargetBond()
    {
        if(targetBond!=null)
        {
            ptpSessionBean.getIssueBondLocal().setCurrBond(targetBond);
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
    public void logicDeleteBond()
    {
        if(targetBond!=null)
        {
            bondEaoLocal.logicDeleteBond(targetBond);
            bondEntitys.remove(targetBond);
        }
    }
    /**
     * @param bondEntitys the bondEntitys to set
     */
    public void setBondEntitys(List<BondEntity> bondEntitys) {
        this.bondEntitys = bondEntitys;
    }

    /**
     * @return the bondEntitysFilter
     */
    public List<BondEntity> getBondEntitysFilter() {
        return bondEntitysFilter;
    }

    /**
     * @param bondEntitysFilter the bondEntitysFilter to set
     */
    public void setBondEntitysFilter(List<BondEntity> bondEntitysFilter) {
        this.bondEntitysFilter = bondEntitysFilter;
    }

    /**
     * @return the backUserEntitys
     */
    public List<BackUserEntity> getBackUserEntitys() {
        return backUserEntitys;
    }

    /**
     * @param backUserEntitys the backUserEntitys to set
     */
    public void setBackUserEntitys(List<BackUserEntity> backUserEntitys) {
        this.backUserEntitys = backUserEntitys;
    }

    /**
     * @return the backUserEaoLocal
     */
    public BackUserEaoLocal getBackUserEaoLocal() {
        return backUserEaoLocal;
    }

    /**
     * @param backUserEaoLocal the backUserEaoLocal to set
     */
    public void setBackUserEaoLocal(BackUserEaoLocal backUserEaoLocal) {
        this.backUserEaoLocal = backUserEaoLocal;
    }

    /**
     * @return the targetBond
     */
    public BondEntity getTargetBond() {
        return targetBond;
    }

    /**
     * @param targetBond the targetBond to set
     */
    public void setTargetBond(BondEntity targetBond) {
        this.targetBond = targetBond;
    }
    
}
