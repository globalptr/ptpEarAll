/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.platBond;

import com.oakeel.ejb.entityAndEao.fonrUserHoldPlatBond.FrontUserHoldPlatBondEntity;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEntity;
import com.oakeel.ejb.entityAndEao.ptpProduct.PtpProductEntity;
import com.oakeel.ejb.ptpEnum.PlatBondTypeEnum;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class PlatBondEntity extends PtpProductEntity {
    private static final long serialVersionUID = 1L;
    private PlatBondTypeEnum platBondTypeEnum;
    @OneToMany(mappedBy="platBondEntity")
    private Set<FrontUserHoldPlatBondEntity> frontUserHoldPlatBondEntitys;//控标实体

    /**
     * @return the platBondTypeEnum
     */
    public PlatBondTypeEnum getPlatBondTypeEnum() {
        return platBondTypeEnum;
    }

    /**
     * @param platBondTypeEnum the platBondTypeEnum to set
     */
    public void setPlatBondTypeEnum(PlatBondTypeEnum platBondTypeEnum) {
        this.platBondTypeEnum = platBondTypeEnum;
    }

    /**
     * @return the frontUserHoldPlatBondEntitys
     */
    public Set<FrontUserHoldPlatBondEntity> getFrontUserHoldPlatBondEntitys() {
        return frontUserHoldPlatBondEntitys;
    }

    /**
     * @param frontUserHoldPlatBondEntitys the frontUserHoldPlatBondEntitys to set
     */
    public void setFrontUserHoldPlatBondEntitys(Set<FrontUserHoldPlatBondEntity> frontUserHoldPlatBondEntitys) {
        this.frontUserHoldPlatBondEntitys = frontUserHoldPlatBondEntitys;
    }

    
}
