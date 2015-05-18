/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.BankCard;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class BankCardEntity extends EntityRoot{
    private static final long serialVersionUID = 1L;
    private String bankName;
    private String cardNumber;
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
