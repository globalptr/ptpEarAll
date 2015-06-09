/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

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
public class BondTrash {

    private BondEntity targetBond;
    private List<BondEntity> bondEntitys;
    private List<BondEntity> bondFilter=null;
    @EJB BondEaoLocal bondEaoLocal;
    /**
     * Creates a new instance of BondTrash
     */
    public BondTrash() {
    }
    @PostConstruct
    public void init()
    {
        bondEntitys=bondEaoLocal.getAllLogicDeleteBonds();
    }
    public void deleteBond()
    {
        if(targetBond!=null)
        {
            bondEaoLocal.removeEntity(targetBond);
            bondEntitys.remove(targetBond);
            if(bondFilter!=null)
                bondFilter.remove(targetBond);
        }
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
     * @return the bondFilter
     */
    public List<BondEntity> getBondFilter() {
        return bondFilter;
    }

    /**
     * @param bondFilter the bondFilter to set
     */
    public void setBondFilter(List<BondEntity> bondFilter) {
        this.bondFilter = bondFilter;
    }
    
}
