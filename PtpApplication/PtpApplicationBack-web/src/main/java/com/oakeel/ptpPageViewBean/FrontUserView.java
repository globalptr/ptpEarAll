/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.CreditLevelEnum;
import com.oakeel.ejb.ptpEnum.LiveCaseEnum;
import com.oakeel.ejb.ptpEnum.SexEnum;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class FrontUserView {
    @EJB private FrontUserEaoLocal frontUserEaoLocal;
    private FrontUserEntity targetFrontUser;
    private List<FrontUserEntity> frontUserEntitys;
    private List<FrontUserEntity> frontUserFilter;
    private SexEnum[] sexEnums;
    @Inject private PtpSessionBean ptpSessionBean;
    private CreditLevelEnum[] creditLevelEnums;
    private LiveCaseEnum[] liveCaseEnums;
    public FrontUserView()
    {
        sexEnums=SexEnum.values();
        creditLevelEnums=CreditLevelEnum.values();
        liveCaseEnums=LiveCaseEnum.values();
    }
    @PostConstruct
    public void init()
    {
        frontUserEntitys=frontUserEaoLocal.getAllEntitys();
    }
    public String toUserAccountPage()
    {
        if(targetFrontUser!=null)
        {
            ptpSessionBean.setFrontUserEntity(targetFrontUser);
            return "frontUserAccount";
        }
        return null;
    }
    public void rowEdit(RowEditEvent event)
    {
        FrontUserEntity editUser=(FrontUserEntity)event.getObject();
        frontUserEaoLocal.updateEntity(editUser);
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

    /**
     * @return the sexEnums
     */
    public SexEnum[] getSexEnums() {
        return sexEnums;
    }

    /**
     * @param sexEnums the sexEnums to set
     */
    public void setSexEnums(SexEnum[] sexEnums) {
        this.sexEnums = sexEnums;
    }

    /**
     * @return the targetFrontUser
     */
    public FrontUserEntity getTargetFrontUser() {
        return targetFrontUser;
    }

    /**
     * @param targetFrontUser the targetFrontUser to set
     */
    public void setTargetFrontUser(FrontUserEntity targetFrontUser) {
        this.targetFrontUser = targetFrontUser;
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
     * @return the creditLevelEnums
     */
    public CreditLevelEnum[] getCreditLevelEnums() {
        return creditLevelEnums;
    }

    /**
     * @param creditLevelEnums the creditLevelEnums to set
     */
    public void setCreditLevelEnums(CreditLevelEnum[] creditLevelEnums) {
        this.creditLevelEnums = creditLevelEnums;
    }

    /**
     * @return the liveCaseEnums
     */
    public LiveCaseEnum[] getLiveCaseEnums() {
        return liveCaseEnums;
    }

    /**
     * @param liveCaseEnums the liveCaseEnums to set
     */
    public void setLiveCaseEnums(LiveCaseEnum[] liveCaseEnums) {
        this.liveCaseEnums = liveCaseEnums;
    }
}
