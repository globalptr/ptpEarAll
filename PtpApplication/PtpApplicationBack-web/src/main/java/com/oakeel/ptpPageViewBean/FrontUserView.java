/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
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
public class FrontUserView {
    @EJB private FrontUserEaoLocal frontUserEaoLocal;
     
    private List<FrontUserEntity> frontUserEntitys;
    private List<FrontUserEntity> frontUserFilter;
    public FrontUserView()
    {
        
    }
    @PostConstruct
    public void init()
    {
        frontUserEntitys=frontUserEaoLocal.getAllEntitys();
    }

    /**
     * @return the frontUserEntitys
     */
    public List<FrontUserEntity> getFrontUserEntitys() {
        return frontUserEntitys;
    }

    /**
     * @param frontUserEntitys the frontUserEntitys to set
     */
    public void setFrontUserEntitys(List<FrontUserEntity> frontUserEntitys) {
        this.frontUserEntitys = frontUserEntitys;
    }

    /**
     * @return the frontUserEaoLocal
     */
    public FrontUserEaoLocal getFrontUserEaoLocal() {
        return frontUserEaoLocal;
    }

    /**
     * @param frontUserEaoLocal the frontUserEaoLocal to set
     */
    public void setFrontUserEaoLocal(FrontUserEaoLocal frontUserEaoLocal) {
        this.frontUserEaoLocal = frontUserEaoLocal;
    }

    /**
     * @return the frontUserFilter
     */
    public List<FrontUserEntity> getFrontUserFilter() {
        return frontUserFilter;
    }

    /**
     * @param frontUserFilter the frontUserFilter to set
     */
    public void setFrontUserFilter(List<FrontUserEntity> frontUserFilter) {
        this.frontUserFilter = frontUserFilter;
    }
}
