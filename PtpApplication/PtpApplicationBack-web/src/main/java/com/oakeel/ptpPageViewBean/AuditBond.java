/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.ejb.entityAndEao.backUser.BackUserEaoLocal;
import com.oakeel.ejb.entityAndEao.backUser.BackUserEntity;
import com.oakeel.ejb.entityAndEao.bond.BondEaoLocal;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
    private List<BondEntity> bondEntitys;
    private List<BondEntity> bondEntitysFilter;
    private List<BackUserEntity> backUserEntitys;
    @EJB
    private BackUserEaoLocal backUserEaoLocal;
    public AuditBond() {
    }
    @PostConstruct
    public void init()
    {
        bondEntitys=bondEaoLocal.getAllEntitys();
        backUserEntitys=backUserEaoLocal.getAllEntitys();
    }
    /**
     * @return the bondEntitys
     */
    public List<BondEntity> getBondEntitys() {
        return bondEntitys;
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
    
}
