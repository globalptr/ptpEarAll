/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.ejb.entityAndEao.sysSet.SysSetEaoLocal;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEntity;
import com.oakeel.ejb.transaction.InitEjbLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class SysSet {
    
    /**
     * Creates a new instance of SysSet
     */
    @EJB
    InitEjbLocal initEjb;
    @EJB
    private SysSetEaoLocal sysSetEaoLocal;
    private SysSetEntity sysSetEntity;
    public SysSet() {
    }
    @PostConstruct
    public void init()
    {
        if(!getSysSetEaoLocal().getAllEntitys().isEmpty())
        {
            setSysSetEntity(getSysSetEaoLocal().getAllEntitys().get(0));
        }
        else
        {
            initEjb.initSet();
            setSysSetEntity(getSysSetEaoLocal().getAllEntitys().get(0));
        }
    }
    public void updateSysSet()
    {
        sysSetEaoLocal.updateEntity(sysSetEntity);
    }
    /**
     * @return the sysSetEntity
     */
    public SysSetEntity getSysSetEntity() {
        return sysSetEntity;
    }

    /**
     * @param sysSetEntity the sysSetEntity to set
     */
    public void setSysSetEntity(SysSetEntity sysSetEntity) {
        this.sysSetEntity = sysSetEntity;
    }

    /**
     * @return the sysSetEaoLocal
     */
    public SysSetEaoLocal getSysSetEaoLocal() {
        return sysSetEaoLocal;
    }

    /**
     * @param sysSetEaoLocal the sysSetEaoLocal to set
     */
    public void setSysSetEaoLocal(SysSetEaoLocal sysSetEaoLocal) {
        this.sysSetEaoLocal = sysSetEaoLocal;
    }
}
