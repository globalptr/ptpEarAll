/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUser;

import com.oakeel.ejb.entityAndEao.bankCard.BankCardEntity;
import com.oakeel.ejb.entityAndEao.financingBusinessBorrower.FinancingBusinessBorrowerEntity;
import com.oakeel.ejb.entityAndEao.financingBusinessLender.FinancingBusinessLenderEntity;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import com.oakeel.ejb.ptpEnum.CreditLevelEnum;
import com.oakeel.ejb.ptpEnum.LiveCaseEnum;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class FrontUserEntity extends UserEntity {
    private static final long serialVersionUID = 1L;
    //用户与债权债务是一对多的关系，
    @OneToMany(mappedBy="lenderUser")//借方的业务实体，主控方在业务
    private Set<FinancingBusinessLenderEntity> financingBusinessLenderEntitys;
    @OneToMany(mappedBy="borrowUser")//贷方的业务实体,主控方在业务
    private Set<FinancingBusinessBorrowerEntity> financingBusinessBorrowerEntitys;
    //////////////////////////////////////////
    @OneToMany//用户与银行卡之间是一对多的关系
    Set<BankCardEntity> bankCardEntitys;
    @Enumerated(EnumType.STRING)
    CreditLevelEnum creditLevelEnum;//信用等级
    int income_start;//收入范围起
    int income_end;//收入范围止
    int successBorrowNumber;//成功借款次数
    int extendNumber;//超期次数
    @Enumerated(EnumType.STRING)
    LiveCaseEnum liveCaseEnum;

    /**
     * @return the financingBusinessLenderEntitys
     */
    public Set<FinancingBusinessLenderEntity> getFinancingBusinessLenderEntitys() {
        return financingBusinessLenderEntitys;
    }

    /**
     * @param financingBusinessLenderEntitys the financingBusinessLenderEntitys to set
     */
    public void setFinancingBusinessLenderEntitys(Set<FinancingBusinessLenderEntity> financingBusinessLenderEntitys) {
        this.financingBusinessLenderEntitys = financingBusinessLenderEntitys;
    }

    /**
     * @return the financingBusinessBorrowerEntitys
     */
    public Set<FinancingBusinessBorrowerEntity> getFinancingBusinessBorrowerEntitys() {
        return financingBusinessBorrowerEntitys;
    }

    /**
     * @param financingBusinessBorrowerEntitys the financingBusinessBorrowerEntitys to set
     */
    public void setFinancingBusinessBorrowerEntitys(Set<FinancingBusinessBorrowerEntity> financingBusinessBorrowerEntitys) {
        this.financingBusinessBorrowerEntitys = financingBusinessBorrowerEntitys;
    }
}
