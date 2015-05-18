/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.debit;

import com.oakeel.ejb.entityAndEao.financialProductRoot.FinancialProductRoot;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author root
 */
@Entity
public class DebitEntity implements Serializable {
    //借贷关系中的借方
    private static final long serialVersionUID = 1L;
    @Id
    String debitUuid;
    public DebitEntity()
    {
        debitUuid=UUID.randomUUID().toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (debitUuid != null ? debitUuid.hashCode() : 0);
        return hash;
    }
    FinancialProductRoot productRoot;//金融产品
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DebitEntity)) {
            return false;
        }
        DebitEntity other = (DebitEntity) object;
        if ((this.debitUuid == null && other.debitUuid != null) || (this.debitUuid != null && !this.debitUuid.equals(other.debitUuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oakeel.ejb.entityAndEao.debit.DebitEntity[ id=" + debitUuid + " ]";
    }
    
}
