/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.customerBankCard;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author root
 */
@Entity
public class CustomerBankCardEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    String userBankCardUuid;
    private String bankName;
    private String cardNumber;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userBankCardUuid != null ? userBankCardUuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerBankCardEntity)) {
            return false;
        }
        CustomerBankCardEntity other = (CustomerBankCardEntity) object;
        if ((this.userBankCardUuid == null && other.userBankCardUuid != null) || (this.userBankCardUuid != null && !this.userBankCardUuid.equals(other.userBankCardUuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oakeel.ejb.entityAndEao.userBankCard.UserBankCardEntity[ id=" + userBankCardUuid + " ]";
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
}
