/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.customer;

import com.oakeel.ejb.entityAndEao.customerAccount.CustomerAccountEntity;
import com.oakeel.ejb.entityAndEao.customerBankCard.CustomerBankCardEntity;
import com.oakeel.ejb.entityAndEao.customerFundFlow.CustomerFundFlowEntity;
import com.oakeel.ejb.ptpEnum.CreateAccountModeEnum;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public CustomerEntity()
    {
        customerUuid=UUID.randomUUID().toString();
    }
    public CustomerEntity(String name)
    {
        customerUuid=UUID.randomUUID().toString();
        this.name=name;
    }
    public CustomerEntity(String tag,String password,CreateAccountModeEnum mode)
    {
        customerUuid=UUID.randomUUID().toString();
        if(mode==CreateAccountModeEnum.用户名)
            this.name=tag;
        else if(mode==CreateAccountModeEnum.电话)
            this.telephone=tag;
        else if(mode==CreateAccountModeEnum.邮箱)
            this.email=tag;
        else if(mode==CreateAccountModeEnum.QQ号)
            this.qq=tag;
        this.password=password;
    }
    public CustomerEntity(String telephone,String password)
    {
        customerUuid=UUID.randomUUID().toString();
        this.telephone=telephone;
        this.password=password;
    }
    @Id
    @Column(length=36)
    String customerUuid;
    String name;
    String password;
    String telephone;
    String email;
    String qq;
    @OneToMany(mappedBy="userEntity")//用户与收益是一对多的关系，主控在用户收益
    Set<CustomerFundFlowEntity> bondUserIncomeEntity;
    @OneToOne(cascade={CascadeType.REMOVE})//用户与用户账户是一对一的关系
    CustomerAccountEntity userAccountEntity;
    @OneToMany(fetch = FetchType.LAZY)//用户与银行卡之间是一对多的关系
    Set<CustomerBankCardEntity> userBankCardEntitys;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerUuid != null ? customerUuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerEntity)) {
            return false;
        }
        CustomerEntity other = (CustomerEntity) object;
        if ((this.customerUuid == null && other.customerUuid != null) || (this.customerUuid != null && !this.customerUuid.equals(other.customerUuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oakeel.ejb.entityAndEao.customer.CustomerEntity[ id=" + customerUuid + " ]";
    }

}
