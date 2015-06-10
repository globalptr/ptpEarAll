/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.platformFund.PlatBondEntity;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEaoLocal;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEntity;
import com.oakeel.ejb.ptpEnum.PlatBondTypeEnum;
import java.math.BigDecimal;
import java.util.List;
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
public class IssuePlatBond1 {
    @Inject
    private PtpSessionBean ptpSessionBean;
    private PlatBondTypeEnum[] platBondTypeEnums;
    private PlatBondEntity platformFundEntity1;
    @EJB
    private SysSetEaoLocal sysSetEaoLocal;
    private SysSetEntity sysSetEntity=null;
    @EJB FrontUserEaoLocal fontUserEaoLocal;
    /**
     * Creates a new instance of issuePlatformFund1
     */
    public IssuePlatBond1() {
    }
    @PostConstruct
    public void init()
    {
        if(!sysSetEaoLocal.getAllEntitys().isEmpty())
        {
            sysSetEntity=sysSetEaoLocal.getAllEntitys().get(0);
        }
        if(ptpSessionBean.getIssuePlatBondLocal().getPlatBond1()==null)
        {
            platformFundEntity1=new PlatBondEntity();
        }
        else 
        {
            platformFundEntity1=ptpSessionBean.getIssuePlatBondLocal().getPlatBond1();
        }
        platBondTypeEnums=PlatBondTypeEnum.values();
    }
    public void setPlatformFundType()
    {
        if(platformFundEntity1.getPlatBondTypeEnum()==PlatBondTypeEnum.天天宝)
        {
            if(sysSetEntity!=null)
                platformFundEntity1.setYearRate(sysSetEntity.getDayRate());
            else 
                platformFundEntity1.setYearRate(new BigDecimal("0"));
                
        }
        else if(platformFundEntity1.getPlatBondTypeEnum()==PlatBondTypeEnum.季富宝)
        {
            if(sysSetEntity!=null)
                platformFundEntity1.setYearRate(sysSetEntity.getQuarterRate());
            else 
                platformFundEntity1.setYearRate(new BigDecimal("0"));
        }
        else if(platformFundEntity1.getPlatBondTypeEnum()==PlatBondTypeEnum.月月宝)
        {
            if(sysSetEntity!=null)
                platformFundEntity1.setYearRate(sysSetEntity.getMonthRate());
            else 
                platformFundEntity1.setYearRate(new BigDecimal("0"));
        }
        else if(platformFundEntity1.getPlatBondTypeEnum()==PlatBondTypeEnum.聚财宝)
        {
            if(sysSetEntity!=null)
                platformFundEntity1.setYearRate(sysSetEntity.getYearRate());
            else 
                platformFundEntity1.setYearRate(new BigDecimal("0"));
        }
    }
    public List<FrontUserEntity> findUser(String target)
    {
        List<FrontUserEntity> userFilter=fontUserEaoLocal.getUserByName("%"+target+"%");
        return userFilter;
    }
    public String toNextStep()
    {
        ptpSessionBean.getIssuePlatBondLocal().setPlatBond1(platformFundEntity1);
        return "issuePlatBond2";
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
    public PlatBondEntity getPlatformFundEntity1() {
        return platformFundEntity1;
    }

    /**
     * @param platformFundEntity1 the platformFundEntity1 to set
     */
    public void setPlatformFundEntity1(PlatBondEntity platformFundEntity1) {
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

    /**
     * @return the platBondTypeEnums
     */
    public PlatBondTypeEnum[] getPlatBondTypeEnums() {
        return platBondTypeEnums;
    }

    /**
     * @param platBondTypeEnums the platBondTypeEnums to set
     */
    public void setPlatBondTypeEnums(PlatBondTypeEnum[] platBondTypeEnums) {
        this.platBondTypeEnums = platBondTypeEnums;
    }

}
