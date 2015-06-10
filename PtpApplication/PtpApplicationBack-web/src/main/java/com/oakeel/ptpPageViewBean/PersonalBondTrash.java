/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEaoLocal;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
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
public class PersonalBondTrash {

    private PersonalBondEntity targetBond;
    private List<PersonalBondEntity> bondEntitys;
    private List<PersonalBondEntity> bondFilter=null;
    @EJB PersonalBondEaoLocal bondEaoLocal;
    /**
     * Creates a new instance of BondTrash
     */
    public PersonalBondTrash() {
    }
    @PostConstruct
    public void init()
    {
        bondEntitys=bondEaoLocal.getAllLogicDeleteBonds();
    }
    public void restoreBond()
    {
        if(targetBond!=null)
        {
            targetBond.setActive(Boolean.TRUE);
            bondEaoLocal.updateEntity(targetBond);
            bondEntitys.remove(targetBond);
        }
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
    public PersonalBondEntity getTargetBond() {
        return targetBond;
    }

    /**
     * @param targetBond the targetBond to set
     */
    public void setTargetBond(PersonalBondEntity targetBond) {
        this.targetBond = targetBond;
    }

    /**
     * @return the bondEntitys
     */
    public List<PersonalBondEntity> getBondEntitys() {
        return bondEntitys;
    }

    /**
     * @param bondEntitys the bondEntitys to set
     */
    public void setBondEntitys(List<PersonalBondEntity> bondEntitys) {
        this.bondEntitys = bondEntitys;
    }

    /**
     * @return the bondFilter
     */
    public List<PersonalBondEntity> getBondFilter() {
        return bondFilter;
    }

    /**
     * @param bondFilter the bondFilter to set
     */
    public void setBondFilter(List<PersonalBondEntity> bondFilter) {
        this.bondFilter = bondFilter;
    }
    
}
