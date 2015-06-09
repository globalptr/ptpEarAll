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
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.BondType;
import com.oakeel.ejb.ptpEnum.OperationEnum;
import com.oakeel.ejb.ptpEnum.RepayModelEnum;
import com.oakeel.ejb.ptpEnum.SplitUnit;
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
    private BondType[] bondTypes;
    private SplitUnit[] splitUnits;
    private RepayModelEnum[] repayModelEnums;
    @EJB
    private BackUserEaoLocal backUserEaoLocal;
    @Inject PtpSessionBean ptpSessionBean;
    private List<FrontUserEntity> frontUserEntitys;
    @EJB FrontUserEaoLocal frontUserEaoLocal;
    public AuditBond() {
        bondTypes=BondType.values();
        repayModelEnums=RepayModelEnum.values();
        splitUnits=SplitUnit.values();
    }
    @PostConstruct
    public void init()
    {
        bondEntitys=bondEaoLocal.getAllAuditBonds();
        backUserEntitys=backUserEaoLocal.getAllEntitys();
        frontUserEntitys=frontUserEaoLocal.getAllEntitys();
    }
    
    public List<FrontUserEntity> findFrontUser(String target)
    {
        List<FrontUserEntity> userFilter=frontUserEaoLocal.getUserByName("%"+target+"%");
        return userFilter;
    }
    public List<BackUserEntity> findBackUser(String target)
    {
        List<BackUserEntity> userFilter=backUserEaoLocal.getUserByName("%"+target+"%");
        return userFilter;
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
    public String bondDetail()
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
     * @return the bondTypes
     */
    public BondType[] getBondTypes() {
        return bondTypes;
    }

    /**
     * @param bondTypes the bondTypes to set
     */
    public void setBondTypes(BondType[] bondTypes) {
        this.bondTypes = bondTypes;
    }

    /**
     * @return the repayModelEnums
     */
    public RepayModelEnum[] getRepayModelEnums() {
        return repayModelEnums;
    }

    /**
     * @param repayModelEnums the repayModelEnums to set
     */
    public void setRepayModelEnums(RepayModelEnum[] repayModelEnums) {
        this.repayModelEnums = repayModelEnums;
    }

    /**
     * @return the splitUnits
     */
    public SplitUnit[] getSplitUnits() {
        return splitUnits;
    }

    /**
     * @param splitUnits the splitUnits to set
     */
    public void setSplitUnits(SplitUnit[] splitUnits) {
        this.splitUnits = splitUnits;
    }
    
}
