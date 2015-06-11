/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.ptpProductTransfer;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
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
public class PtpProductTransferEntity extends EntityRoot {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private FrontUserEntity fromUser;//出让债权的用户
    @ManyToOne
    private FrontUserEntity toUser;//转到目标用户
    private int transferNum;//转让份数
    private BigDecimal transferOutProportion;//转让出的收益
    @Temporal(TemporalType.DATE)
    private Date transferDate;//转让时间

    /**
     * @return the fromUser
     */
    public FrontUserEntity getFromUser() {
        return fromUser;
    }

    /**
     * @param fromUser the fromUser to set
     */
    public void setFromUser(FrontUserEntity fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * @return the toUser
     */
    public FrontUserEntity getToUser() {
        return toUser;
    }

    /**
     * @param toUser the toUser to set
     */
    public void setToUser(FrontUserEntity toUser) {
        this.toUser = toUser;
    }

    /**
     * @return the transferNum
     */
    public int getTransferNum() {
        return transferNum;
    }

    /**
     * @param transferNum the transferNum to set
     */
    public void setTransferNum(int transferNum) {
        this.transferNum = transferNum;
    }


    /**
     * @return the transferDate
     */
    public Date getTransferDate() {
        return transferDate;
    }

    /**
     * @param transferDate the transferDate to set
     */
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    /**
     * @return the transferOutProportion
     */
    public BigDecimal getTransferOutProportion() {
        return transferOutProportion;
    }

    /**
     * @param transferOutProportion the transferOutProportion to set
     */
    public void setTransferOutProportion(BigDecimal transferOutProportion) {
        this.transferOutProportion = transferOutProportion;
    }

}
