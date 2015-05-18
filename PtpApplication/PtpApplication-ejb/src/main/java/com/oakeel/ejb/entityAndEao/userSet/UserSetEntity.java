/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.userSet;

import com.oakeel.ejb.entityAndEao.user.UserEntity;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class UserSetEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public UserSetEntity()
    {
        userSetUuid=UUID.randomUUID().toString();
    }
    @Id
    @Column(length=36)
    private String userSetUuid;
    private String userTheme;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getUserSetUuid() != null ? getUserSetUuid().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSetEntity)) {
            return false;
        }
        UserSetEntity other = (UserSetEntity) object;
        if ((this.getUserSetUuid() == null && other.getUserSetUuid() != null) || (this.getUserSetUuid() != null && !this.userSetUuid.equals(other.userSetUuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oakeel.ejb.entityAndEao.userSet.UserSet[ id=" + userSetUuid + " ]";
    }

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

    /**
     * @return the userSetUuid
     */
    public String getUserSetUuid() {
        return userSetUuid;
    }

    /**
     * @param userSetUuid the userSetUuid to set
     */
    public void setUserSetUuid(String userSetUuid) {
        this.userSetUuid = userSetUuid;
    }
    
}
