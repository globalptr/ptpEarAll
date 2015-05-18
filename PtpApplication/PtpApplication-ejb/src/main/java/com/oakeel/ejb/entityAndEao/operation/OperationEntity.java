/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.operation;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class OperationEntity extends EntityRoot{
    private static final long serialVersionUID = 1L;
    public OperationEntity()
    {
    }
    public OperationEntity(String word,String desc)
    {
        this.permissionWord=word;
        this.permissionDesc=desc;
    }
    public OperationEntity(String word)
    {
        this.permissionWord=word;
    }
    @Column(nullable=false,length=50)
    private String permissionWord;
    @Column(length=200)
    private String permissionDesc="";


    /**
     * @return the permissionWord
     */
    public String getPermissionWord() {
        return permissionWord;
    }

    /**
     * @param permissionWord the permissionWord to set
     */
    public void setPermissionWord(String permissionWord) {
        this.permissionWord = permissionWord;
    }

    /**
     * @return the permissionDesc
     */
    public String getPermissionDesc() {
        return permissionDesc;
    }

    /**
     * @param permissionDesc the permissionDesc to set
     */
    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    
}
