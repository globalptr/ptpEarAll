/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.backUser;

import com.oakeel.ejb.entityAndEao.backUserSet.BackUserSetEntity;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class BackUserEntity extends UserEntity{

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
}
