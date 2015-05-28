/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.platformFund.PlatformFundEntity;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEaoLocal;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEntity;
import com.oakeel.ejb.ptpEnum.PlatformFundTypeEnum;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class issuePlatformFund1 {
    @Inject
    private PtpSessionBean ptpSessionBean;
    private PlatformFundTypeEnum[] platformFundTypeEnums;
    private PlatformFundEntity platformFundEntity1;
    @EJB
    private SysSetEaoLocal sysSetEaoLocal;
    private SysSetEntity sysSetEntity=null;
    /**
     * Creates a new instance of issuePlatformFund1
     */
    public issuePlatformFund1() {
    }
    @PostConstruct
    public void init()
    {
        if(!sysSetEaoLocal.getAllEntitys().isEmpty())
        {
            sysSetEntity=sysSetEaoLocal.getAllEntitys().get(0);
        }
        if(ptpSessionBean.getIssuePlatformFundLocal().getPlatformFundEntity1()==null)
        {
            platformFundEntity1=new PlatformFundEntity();
        }
        else 
        {
            platformFundEntity1=ptpSessionBean.getIssuePlatformFundLocal().getPlatformFundEntity1();
        }
        platformFundTypeEnums=PlatformFundTypeEnum.values();
    }
    public void setPlatformFundType()
    {
        if(platformFundEntity1.getPlatformFundTypeEnum()==PlatformFundTypeEnum.天天宝)
        {
            if(sysSetEntity!=null)
                platformFundEntity1.setYearRate(sysSetEntity.getDayRate());
            else 
                platformFundEntity1.setYearRate(new BigDecimal("0"));
                
        }
        else if(platformFundEntity1.getPlatformFundTypeEnum()==PlatformFundTypeEnum.季富宝)
        {
            if(sysSetEntity!=null)
                platformFundEntity1.setYearRate(sysSetEntity.getQuarterRate());
            else 
                platformFundEntity1.setYearRate(new BigDecimal("0"));
        }
        else if(platformFundEntity1.getPlatformFundTypeEnum()==PlatformFundTypeEnum.月月宝)
        {
            if(sysSetEntity!=null)
                platformFundEntity1.setYearRate(sysSetEntity.getMonthRate());
            else 
                platformFundEntity1.setYearRate(new BigDecimal("0"));
        }
        else if(platformFundEntity1.getPlatformFundTypeEnum()==PlatformFundTypeEnum.聚财宝)
        {
            if(sysSetEntity!=null)
                platformFundEntity1.setYearRate(sysSetEntity.getYearRate());
            else 
                platformFundEntity1.setYearRate(new BigDecimal("0"));
        }
    }
    public String toNextStep()
    {
        ptpSessionBean.getIssuePlatformFundLocal().setPlatformFundEntity1(platformFundEntity1);
        return "issuePlatformFund2";
    }
    /**
     * @return the platformFundTypeEnums
     */
    public PlatformFundTypeEnum[] getPlatformFundTypeEnums() {
        return platformFundTypeEnums;
    }

    /**
     * @param platformFundTypeEnums the platformFundTypeEnums to set
     */
    public void setPlatformFundTypeEnums(PlatformFundTypeEnum[] platformFundTypeEnums) {
        this.platformFundTypeEnums = platformFundTypeEnums;
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
     * @return the platformFundEntity1
     */
    public PlatformFundEntity getPlatformFundEntity1() {
        return platformFundEntity1;
    }

    /**
     * @param platformFundEntity1 the platformFundEntity1 to set
     */
    public void setPlatformFundEntity1(PlatformFundEntity platformFundEntity1) {
        this.platformFundEntity1 = platformFundEntity1;
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
