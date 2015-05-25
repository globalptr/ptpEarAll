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
    @OneToMany(mappedBy = "lenderUser")//借方的业务实体，主控方在业务
    private Set<FinancingBusinessLenderEntity> financingBusinessLenderEntitys;
    @OneToMany(mappedBy = "borrowUser")//贷方的业务实体,主控方在业务
    private Set<FinancingBusinessBorrowerEntity> financingBusinessBorrowerEntitys;
    //////////////////////////////////////////
    @OneToMany//用户与银行卡之间是一对多的关系
    Set<BankCardEntity> bankCardEntitys;
    @Enumerated(EnumType.STRING)
    private CreditLevelEnum creditLevelEnum;//信用等级
    private int income_start;//收入范围起
    private int income_end;//收入范围止
    private int successBorrowNumber;//成功借款次数
    private int extendNumber;//超期次数
    @Enumerated(EnumType.STRING)
    private LiveCaseEnum liveCaseEnum;

    /**
     * @return the financingBusinessLenderEntitys
     */
    public Set<FinancingBusinessLenderEntity> getFinancingBusinessLenderEntitys() {
        return financingBusinessLenderEntitys;
    }

    /**
     * @param financingBusinessLenderEntitys the financingBusinessLenderEntitys
     * to set
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
     * @param financingBusinessBorrowerEntitys the
     * financingBusinessBorrowerEntitys to set
     */
    public void setFinancingBusinessBorrowerEntitys(Set<FinancingBusinessBorrowerEntity> financingBusinessBorrowerEntitys) {
        this.financingBusinessBorrowerEntitys = financingBusinessBorrowerEntitys;
    }

    /**
     * @return the income_start
     */
    public int getIncome_start() {
        return income_start;
    }

    /**
     * @param income_start the income_start to set
     */
    public void setIncome_start(int income_start) {
        this.income_start = income_start;
    }

    /**
     * @return the income_end
     */
    public int getIncome_end() {
        return income_end;
    }

    /**
     * @param income_end the income_end to set
     */
    public void setIncome_end(int income_end) {
        this.income_end = income_end;
    }

    /**
     * @return the successBorrowNumber
     */
    public int getSuccessBorrowNumber() {
        return successBorrowNumber;
    }

    /**
     * @param successBorrowNumber the successBorrowNumber to set
     */
    public void setSuccessBorrowNumber(int successBorrowNumber) {
        this.successBorrowNumber = successBorrowNumber;
    }

    /**
     * @return the extendNumber
     */
    public int getExtendNumber() {
        return extendNumber;
    }

    /**
     * @param extendNumber the extendNumber to set
     */
    public void setExtendNumber(int extendNumber) {
        this.extendNumber = extendNumber;
    }

    /**
     * @return the liveCaseEnum
     */
    public LiveCaseEnum getLiveCaseEnum() {
        return liveCaseEnum;
    }

    /**
     * @param liveCaseEnum the liveCaseEnum to set
     */
    public void setLiveCaseEnum(LiveCaseEnum liveCaseEnum) {
        this.liveCaseEnum = liveCaseEnum;
    }

    /**
     * @return the creditLevelEnum
     */
    public CreditLevelEnum getCreditLevelEnum() {
        return creditLevelEnum;
    }

    /**
     * @param creditLevelEnum the creditLevelEnum to set
     */
    public void setCreditLevelEnum(CreditLevelEnum creditLevelEnum) {
        this.creditLevelEnum = creditLevelEnum;
    }
}
