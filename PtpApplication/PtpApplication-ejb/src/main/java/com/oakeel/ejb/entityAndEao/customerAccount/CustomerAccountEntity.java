/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.customerAccount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author root
 */
@Entity
public class CustomerAccountEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public CustomerAccountEntity()
    {
        CustomerAccountUuid=UUID.randomUUID().toString();
    }
    @Id
    String CustomerAccountUuid;
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    BigDecimal availableBalance;//可用余额
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    BigDecimal freezeBalance;//冻结金额
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    BigDecimal notMentionBalance;//不可提现金额
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (CustomerAccountUuid != null ? CustomerAccountUuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerAccountEntity)) {
            return false;
        }
        CustomerAccountEntity other = (CustomerAccountEntity) object;
        if ((this.CustomerAccountUuid == null && other.CustomerAccountUuid != null) || (this.CustomerAccountUuid != null && !this.CustomerAccountUuid.equals(other.CustomerAccountUuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oakeel.ejb.entityAndEao.userAccount.UserAccountEntity[ id=" + CustomerAccountUuid + " ]";
    }
    
}
