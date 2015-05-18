/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.debitCredit;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.financialProduct.FinancialProductEntity;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import com.oakeel.ejb.ptpEnum.FundOperationEnum;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
public class DebitCreditEntity extends EntityRoot{
    private static final long serialVersionUID = 1L;
    //借贷实体是已发生的金额为准，所列的数据必须已经发生
    @ManyToOne
    UserEntity userEntity;//用户
    @ManyToOne
    FinancialProductEntity financialProductEntity;//金融产品
    BigDecimal amount;//金额
    @Temporal(TemporalType.TIMESTAMP)
    Date occurDate;//发生时间
    FundOperationEnum fundOperationEnum;//借还是贷
    Boolean isOccur;//是否发生
}
