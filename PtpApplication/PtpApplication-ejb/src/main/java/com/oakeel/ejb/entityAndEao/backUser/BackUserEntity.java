/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.backUser;

import com.oakeel.ejb.entityAndEao.backUserSet.BackUserSetEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class BackUserEntity extends UserEntity{

    
    @OneToMany(mappedBy="issueAdmin")
    private Set<BondEntity> ptpProductEntitys;//发布的融资标
    @OneToOne(cascade = {CascadeType.ALL})
    private BackUserSetEntity backUserSetEntity;

    /**
     * @return the backUserSetEntity
     */
    public BackUserSetEntity getBackUserSetEntity() {
        return backUserSetEntity;
    }

    /**
     * @param backUserSetEntity the backUserSetEntity to set
     */
    public void setBackUserSetEntity(BackUserSetEntity backUserSetEntity) {
        this.backUserSetEntity = backUserSetEntity;
    }

    /**
     * @return the ptpProductEntitys
     */
    public Set<BondEntity> getPtpProductEntitys() {
        return ptpProductEntitys;
    }

    /**
     * @param ptpProductEntitys the ptpProductEntitys to set
     */
    public void setPtpProductEntitys(Set<BondEntity> ptpProductEntitys) {
        this.ptpProductEntitys = ptpProductEntitys;
    }


}
