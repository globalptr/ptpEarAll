/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.ejb.entityAndEao.platformFund.PlatBondEaoLocal;
import com.oakeel.ejb.entityAndEao.platformFund.PlatBondEntity;
import com.oakeel.ejb.ptpEnum.PlatBondTypeEnum;
import com.oakeel.ejb.ptpEnum.RepayModelEnum;
import com.oakeel.ejb.ptpEnum.SplitUnit;
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
public class PlatBondManage {

    /**
     * Creates a new instance of PlatBondManage
     */
    private List<PlatBondEntity> platBondEntitys;
    private PlatBondEntity targetBond=null;
    @EJB private PlatBondEaoLocal platBondEaoLocal;
    private PlatBondTypeEnum[] platBondTypeEnums;
    private SplitUnit[] splitUnits;
    private RepayModelEnum[] repayModelEnums;
    public PlatBondManage() {
    }
    @PostConstruct
    public void init()
    {
        platBondEntitys=platBondEaoLocal.getAllAuditBonds();
        platBondTypeEnums=PlatBondTypeEnum.values();
        splitUnits=SplitUnit.values();
        repayModelEnums=RepayModelEnum.values();
    }

    /**
     * @return the platBondEntitys
     */
    public List<PlatBondEntity> getPlatBondEntitys() {
        return platBondEntitys;
    }
    public void backBond()
    {
        if(targetBond!=null)
        {
            
        }
    }
    public void bondDetail()
    {
        if(targetBond!=null)
        {
            
        }
    }
    public void logicDeleteBond()
    {
        if(targetBond!=null)
        {
            
        }
    }
    public void passAudit()
    {
        if(targetBond!=null)
        {
            
        }
    }
    /**
     * @param platBondEntitys the platBondEntitys to set
     */
    public void setPlatBondEntitys(List<PlatBondEntity> platBondEntitys) {
        this.platBondEntitys = platBondEntitys;
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
