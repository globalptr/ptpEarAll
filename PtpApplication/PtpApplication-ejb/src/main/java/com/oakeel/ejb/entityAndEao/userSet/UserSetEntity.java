/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.userSet;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class UserSetEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
    
    public UserSetEntity()
    {
    }
    private String userTheme;

    /**
     * @return the userTheme
     */
    public String getUserTheme() {
        return userTheme;
    }

    /**
     * @param userTheme the userTheme to set
     */
    public void setUserTheme(String userTheme) {
        this.userTheme = userTheme;
    }
}
