/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUser;

import com.oakeel.ejb.entityAndEao.debitCredit.DebitCreditEntity;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class FrontUserEntity extends UserEntity {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy="userEntity")//用户与借贷实体是一对多的关系，主控在借贷实体
    private Set<DebitCreditEntity> debitCreditEntitys;
    public FrontUserEntity() {
    }

    /**
     * @return the debitCreditEntitys
     */
    public Set<DebitCreditEntity> getDebitCreditEntitys() {
        return debitCreditEntitys;
    }

    /**
     * @param debitCreditEntitys the debitCreditEntitys to set
     */
    public void setDebitCreditEntitys(Set<DebitCreditEntity> debitCreditEntitys) {
        this.debitCreditEntitys = debitCreditEntitys;
    }


}
