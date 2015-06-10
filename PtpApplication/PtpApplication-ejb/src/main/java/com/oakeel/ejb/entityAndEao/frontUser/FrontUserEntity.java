/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.entityAndEao.frontUser;

import com.oakeel.ejb.entityAndEao.bankCard.BankCardEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.frontUserHoldBond.FrontUserHoldBondEntity;
import com.oakeel.ejb.entityAndEao.platformFund.PlatBondEntity;
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
    @OneToMany(mappedBy = "holdUser")//与用户控标实体是一对多的关系，主控在控标实体
    private Set<FrontUserHoldBondEntity> frontUserBondEntitys;
    @OneToMany(targetEntity=PersonalBondEntity.class,mappedBy = "issueUser")//与用户发标实体是一对多的关系，主控在发标实体
    private Set<PersonalBondEntity> bondEntitys;
    @OneToMany(targetEntity=PlatBondEntity.class,mappedBy = "issueUser")
    private Set<PlatBondEntity> platBondEntitys;
    //////////////////////////////////////////
    @OneToMany//用户与银行卡之间是一对多的关系
    private Set<BankCardEntity> bankCardEntitys;
    @Enumerated(EnumType.STRING)
    private CreditLevelEnum creditLevelEnum;//信用等级
    private int income_start=0;//收入范围起
    private int income_end=0;//收入范围止
    private int successBorrowNumber=0;//成功借款次数
    private int extendNumber=0;//超期次数
    @Enumerated(EnumType.STRING)
    private LiveCaseEnum liveCaseEnum=LiveCaseEnum.普通商品房;

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

    /**
     * @return the frontUserBondEntitys
     */
    public Set<FrontUserHoldBondEntity> getFrontUserBondEntitys() {
        return frontUserBondEntitys;
    }

    /**
     * @param frontUserBondEntitys the frontUserBondEntitys to set
     */
    public void setFrontUserBondEntitys(Set<FrontUserHoldBondEntity> frontUserBondEntitys) {
        this.frontUserBondEntitys = frontUserBondEntitys;
    }

    /**
     * @return the bankCardEntitys
     */
    public Set<BankCardEntity> getBankCardEntitys() {
        return bankCardEntitys;
    }

    /**
     * @param bankCardEntitys the bankCardEntitys to set
     */
    public void setBankCardEntitys(Set<BankCardEntity> bankCardEntitys) {
        this.bankCardEntitys = bankCardEntitys;
    }

    /**
     * @return the bondEntitys
     */
    public Set<PersonalBondEntity> getBondEntitys() {
        return bondEntitys;
    }

    /**
     * @param bondEntitys the bondEntitys to set
     */
    public void setBondEntitys(Set<PersonalBondEntity> bondEntitys) {
        this.bondEntitys = bondEntitys;
    }

    /**
     * @return the platBondEntitys
     */
    public Set<PlatBondEntity> getPlatBondEntitys() {
        return platBondEntitys;
    }

    /**
     * @param platBondEntitys the platBondEntitys to set
     */
    public void setPlatBondEntitys(Set<PlatBondEntity> platBondEntitys) {
        this.platBondEntitys = platBondEntitys;
    }

}
