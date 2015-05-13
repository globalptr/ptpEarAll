/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.webFront;

import com.oakeel.ejb.entityAndEao.user.UserEntity;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */

@Named
@SessionScoped
public class FrontSessionBean implements Serializable{
    private UserEntity logName;

    /**
     * @return the logName
     */
    public UserEntity getLogName() {
        return logName;
    }

    /**
     * @param logName the logName to set
     */
    public void setLogName(UserEntity logName) {
        this.logName = logName;
    }


}
