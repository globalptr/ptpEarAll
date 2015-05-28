/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUserIssueBond;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.ptpProduct.PtpProductEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
public class FrontUserIssueBondEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private FrontUserEntity user;//发标用户
    @Temporal(TemporalType.DATE)
    private Date issueDate;//发标时间
    @OneToOne
    private PtpProductEntity ptpProductEntity;//标

    /**
     * @return the issueDate
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate the issueDate to set
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the user
     */
    public FrontUserEntity getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(FrontUserEntity user) {
        this.user = user;
    }

    /**
     * @return the ptpProductEntity
     */
    public PtpProductEntity getPtpProductEntity() {
        return ptpProductEntity;
    }

    /**
     * @param ptpProductEntity the ptpProductEntity to set
     */
    public void setPtpProductEntity(PtpProductEntity ptpProductEntity) {
        this.ptpProductEntity = ptpProductEntity;
    }
}
