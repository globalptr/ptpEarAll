/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.entityAndEao.frontUser;

import com.oakeel.ejb.entityAndEao.bankCard.BankCardEntity;
import com.oakeel.ejb.entityAndEao.fonrUserHoldPlatBond.FrontUserHoldPlatBondEntity;
import com.oakeel.ejb.entityAndEao.frontUserAccount.FrontUserAccountEntity;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.platBond.PlatBondEntity;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import com.oakeel.ejb.ptpEnum.CreditLevelEnum;
import com.oakeel.ejb.ptpEnum.LiveCaseEnum;
import com.oakeel.ejb.ptpProductTransfer.PtpProductTransferEntity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class FrontUserEntity extends UserEntity {

    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "holdUser")//与用户控标实体是一对多的关系，主控在控标实体
    private Set<FrontUserHoldPersonalBondEntity> frontUserHoldPersonalBondEntitys;
    @OneToMany(mappedBy = "holdUser")//与用户控标实体是一对多的关系，主控在控标实体
    private Set<FrontUserHoldPlatBondEntity> frontUserHoldPlatBondEntitys;
    @OneToMany(mappedBy = "issueUser")//与用户发标实体是一对多的关系，主控在发标实体
    private Set<PersonalBondEntity> issueBondEntitys;//
    @OneToMany(targetEntity=PlatBondEntity.class,mappedBy = "issueUser")
    private Set<PlatBondEntity> platBondEntitys;
    @OneToMany(targetEntity=PtpProductTransferEntity.class,mappedBy="fromUser")
    private Set<PtpProductTransferEntity> transferOutProducts;//转让出去的产品
    @OneToMany(targetEntity=PtpProductTransferEntity.class,mappedBy="toUser")
    private Set<PtpProductTransferEntity> transferInProducts;//转让进来的产品
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

    @OneToOne(cascade = CascadeType.ALL)
    private FrontUserAccountEntity frontUserAccountEntity=new FrontUserAccountEntity();
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

    /**
     * @return the transferOutProducts
     */
    public Set<PtpProductTransferEntity> getTransferOutProducts() {
        return transferOutProducts;
    }

    /**
     * @param transferOutProducts the transferOutProducts to set
     */
    public void setTransferOutProducts(Set<PtpProductTransferEntity> transferOutProducts) {
        this.transferOutProducts = transferOutProducts;
    }

    /**
     * @return the transferInProducts
     */
    public Set<PtpProductTransferEntity> getTransferInProducts() {
        return transferInProducts;
    }

    /**
     * @param transferInProducts the transferInProducts to set
     */
    public void setTransferInProducts(Set<PtpProductTransferEntity> transferInProducts) {
        this.transferInProducts = transferInProducts;
    }


    /**
     * @return the frontUserHoldPlatBondEntitys
     */
    public Set<FrontUserHoldPlatBondEntity> getFrontUserHoldPlatBondEntitys() {
        return frontUserHoldPlatBondEntitys;
    }

    /**
     * @param frontUserHoldPlatBondEntitys the frontUserHoldPlatBondEntitys to set
     */
    public void setFrontUserHoldPlatBondEntitys(Set<FrontUserHoldPlatBondEntity> frontUserHoldPlatBondEntitys) {
        this.frontUserHoldPlatBondEntitys = frontUserHoldPlatBondEntitys;
    }

    /**
     * @return the frontUserHoldPersonalBondEntitys
     */
    public Set<FrontUserHoldPersonalBondEntity> getFrontUserHoldPersonalBondEntitys() {
        return frontUserHoldPersonalBondEntitys;
    }

    /**
     * @param frontUserHoldPersonalBondEntitys the frontUserHoldPersonalBondEntitys to set
     */
    public void setFrontUserHoldPersonalBondEntitys(Set<FrontUserHoldPersonalBondEntity> frontUserHoldPersonalBondEntitys) {
        this.frontUserHoldPersonalBondEntitys = frontUserHoldPersonalBondEntitys;
    }

    /**
     * @return the issueBondEntitys
     */
    public Set<PersonalBondEntity> getIssueBondEntitys() {
        return issueBondEntitys;
    }

    /**
     * @param issueBondEntitys the issueBondEntitys to set
     */
    public void setIssueBondEntitys(Set<PersonalBondEntity> issueBondEntitys) {
        this.issueBondEntitys = issueBondEntitys;
    }

    /**
     * @return the frontUserAccountEntity
     */
    public FrontUserAccountEntity getFrontUserAccountEntity() {
        return frontUserAccountEntity;
    }

    /**
     * @param frontUserAccountEntity the frontUserAccountEntity to set
     */
    public void setFrontUserAccountEntity(FrontUserAccountEntity frontUserAccountEntity) {
        this.frontUserAccountEntity = frontUserAccountEntity;
    }

}
