/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.userAccount;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
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
public class UserAccountEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
 
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    BigDecimal availableBalance;//可用余额
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    BigDecimal freezeBalance;//冻结金额
    @Column(precision=12,scale=2) //精度为12位，小数点位数为2位
    BigDecimal notMentionBalance;//不可提现金额

}
