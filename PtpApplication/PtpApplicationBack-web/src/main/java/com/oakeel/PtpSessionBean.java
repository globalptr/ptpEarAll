/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import com.oakeel.ejb.entityAndEao.backUser.BackUserEntity;
import com.oakeel.ejb.entityAndEao.backUserSet.BackUserSetEaoLocal;
import com.oakeel.ejb.entityAndEao.backUserSet.BackUserSetEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.ptpEnum.AccountModeEnum;
import com.oakeel.ejb.ptpEnum.OperationEnum;
import com.oakeel.ejb.transaction.bond.IssueBondLocal;
import com.oakeel.ejb.transaction.platformFund.IssuePlatformFundLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class PtpSessionBean implements Serializable{

    //
    private FrontUserEntity frontUserEntity;
    //
    @EJB
    private IssueBondLocal issueBondLocal;
    @EJB
    private IssuePlatformFundLocal issuePlatformFundLocal;
    private BackUserEntity logUser=null;
    private BackUserSetEntity userSet=null;
    @EJB
    private BackUserSetEaoLocal backUserSetEaoLocal;
    private AccountModeEnum logType;
    private OperationEnum operationEnum;
    
    //对于一个登录用户的session数据，统一使用此bean
    /**
     * Creates a new instance of PtpSessionBean
     */
    public PtpSessionBean() {
    }
    public void createNewCode()
    {
    }
    @PostConstruct
    public void init()
    {
    }
    public void changeUserTheme(String theme)
    {
        if(userSet!=null)
        {
            userSet.setUserTheme(theme);
            backUserSetEaoLocal.updateEntity(userSet);
        }
    }
    /**
     * @return the issueBondLocal
     */
    public IssueBondLocal getIssueBondLocal() {
        return issueBondLocal;
    }

    /**
     * @param issueBondLocal the issueBondLocal to set
     */
    public void setIssueBondLocal(IssueBondLocal issueBondLocal) {
        this.issueBondLocal = issueBondLocal;
    }


    /**
     * @return the issuePlatformFundLocal
     */
    public IssuePlatformFundLocal getIssuePlatformFundLocal() {
        return issuePlatformFundLocal;
    }

    /**
     * @param issuePlatformFundLocal the issuePlatformFundLocal to set
     */
    public void setIssuePlatformFundLocal(IssuePlatformFundLocal issuePlatformFundLocal) {
        this.issuePlatformFundLocal = issuePlatformFundLocal;
    }

    /**
     * @return the userSet
     */
    public BackUserSetEntity getUserSet() {
        return userSet;
    }

    /**
     * @param userSet the userSet to set
     */
    public void setUserSet(BackUserSetEntity userSet) {
        this.userSet = userSet;
    }

    /**
     * @return the logUser
     */
    public BackUserEntity getLogUser() {
        return logUser;
    }

    /**
     * @param logUser the logUser to set
     */
    public void setLogUser(BackUserEntity logUser) {
        this.logUser = logUser;
        if(this.logUser.getBackUserSetEntity()!=null)
            userSet=this.logUser.getBackUserSetEntity();
    }

    /**
     * @return the backUserSetEaoLocal
     */
    public BackUserSetEaoLocal getBackUserSetEaoLocal() {
        return backUserSetEaoLocal;
    }

    /**
     * @param backUserSetEaoLocal the backUserSetEaoLocal to set
     */
    public void setBackUserSetEaoLocal(BackUserSetEaoLocal backUserSetEaoLocal) {
        this.backUserSetEaoLocal = backUserSetEaoLocal;
    }

    /**
     * @return the logType
     */
    public AccountModeEnum getLogType() {
        return logType;
    }

    /**
     * @param logType the logType to set
     */
    public void setLogType(AccountModeEnum logType) {
        this.logType = logType;
    }

    /**
     * @return the operationEnum
     */
    public OperationEnum getOperationEnum() {
        return operationEnum;
    }

    /**
     * @param operationEnum the operationEnum to set
     */
    public void setOperationEnum(OperationEnum operationEnum) {
        this.operationEnum = operationEnum;
    }

    /**
     * @return the frontUserEntity
     */
    public FrontUserEntity getFrontUserEntity() {
        return frontUserEntity;
    }

    /**
     * @param frontUserEntity the frontUserEntity to set
     */
    public void setFrontUserEntity(FrontUserEntity frontUserEntity) {
        this.frontUserEntity = frontUserEntity;
    }
}
