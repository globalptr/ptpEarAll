/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.ejb.entityAndEao.platformFund.PlatBondEaoLocal;
import com.oakeel.ejb.entityAndEao.platformFund.PlatBondEntity;
import com.oakeel.ejb.ptpEnum.SysInfo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class PlatBondTrash {

    private List<PlatBondEntity> platBondEntitys;
    private List<PlatBondEntity> bondFilter;
    @EJB private PlatBondEaoLocal platBondEaoLocal;
    private PlatBondEntity targetBond;
    public PlatBondTrash() {
    }
    @PostConstruct
    public void init()
    {
        platBondEntitys=platBondEaoLocal.getAllLogicDeleteBonds();
    }
    public void restoreBond()
    {
        if(targetBond!=null)
        {
            platBondEntitys.remove(targetBond);
            targetBond.setActive(Boolean.TRUE);
            platBondEaoLocal.updateEntity(targetBond);
            FacesMessage msg = new FacesMessage(SysInfo.提示.toString(), "复原成功");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    public void deleteBond()
    {
        if(targetBond!=null)
        {
            platBondEntitys.remove(targetBond);
            platBondEaoLocal.removeEntity(targetBond);
            FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "删除成功");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    /**
     * @return the platBondEaoLocal
     */
    public PlatBondEaoLocal getPlatBondEaoLocal() {
        return platBondEaoLocal;
    }

    /**
     * @param platBondEaoLocal the platBondEaoLocal to set
     */
    public void setPlatBondEaoLocal(PlatBondEaoLocal platBondEaoLocal) {
        this.platBondEaoLocal = platBondEaoLocal;
    }

    /**
     * @return the platBondEntitys
     */
    public List<PlatBondEntity> getPlatBondEntitys() {
        return platBondEntitys;
    }

    /**
     * @param platBondEntitys the platBondEntitys to set
     */
    public void setPlatBondEntitys(List<PlatBondEntity> platBondEntitys) {
        this.platBondEntitys = platBondEntitys;
    }

    /**
     * @return the bondFilter
     */
    public List<PlatBondEntity> getBondFilter() {
        return bondFilter;
    }

    /**
     * @param bondFilter the bondFilter to set
     */
    public void setBondFilter(List<PlatBondEntity> bondFilter) {
        this.bondFilter = bondFilter;
    }

    /**
     * @return the targetBond
     */
    public PlatBondEntity getTargetBond() {
        return targetBond;
    }

    /**
     * @param targetBond the targetBond to set
     */
    public void setTargetBond(PlatBondEntity targetBond) {
        this.targetBond = targetBond;
    }

}
