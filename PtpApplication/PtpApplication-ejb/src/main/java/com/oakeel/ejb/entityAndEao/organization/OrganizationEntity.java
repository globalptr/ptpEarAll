/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.organization;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class OrganizationEntity extends EntityRoot{
    //整个机构是个树形必须从根开始顺序初始化，不能反向，即先初始化根，再初始化子
    public OrganizationEntity(){
    }
    public OrganizationEntity(String name,int priority,int organizationLevel)
    {
        this.name=name;
        this.priority=priority;
        this.organizationLevel=organizationLevel;
    }
    public OrganizationEntity(String name)
    {
        this.name=name;
        this.priority=999;
        this.organizationLevel=-1;
    }
    private static final long serialVersionUID = 1L;
    @Column(nullable=false,length=50)
    private String name;//名字
    private int priority;//显示顺序
    private int organizationLevel;//层级
    //子机构一对多的关系
    @Column(length=36)
    private String parentUuid;
    @OneToMany(cascade = {CascadeType.REMOVE})
    private Set<OrganizationEntity> childOrganizationEntitys=new HashSet();
    //机构与用户是一对多的关系，主控在用户,如果删除机构，则需要将属于此机构的用户的机构字段设置为null
    @OneToMany(mappedBy="organizationEntity")
    private Set<UserEntity> userEntitys;
    private Boolean available;



    @Override
    public String toString() {
        return name;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the available
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    /**
     * @return the organizationLevel
     */
    public int getOrganizationLevel() {
        return organizationLevel;
    }

    /**
     * @param organizationLevel the organizationLevel to set
     */
    public void setOrganizationLevel(int organizationLevel) {
        this.organizationLevel = organizationLevel;
    }

    /**
     * @return the childOrganizationEntitys
     */
    public Set<OrganizationEntity> getChildOrganizationEntitys() {
        return childOrganizationEntitys;
    }

    /**
     * @param childOrganizationEntitys the childOrganizationEntitys to set
     */
    public void setChildOrganizationEntitys(Set<OrganizationEntity> childOrganizationEntitys) {
        this.childOrganizationEntitys = childOrganizationEntitys;
    }

    /**
     * @return the parentUuid
     */
    public String getParentUuid() {
        return parentUuid;
    }

    /**
     * @param parentUuid the parentUuid to set
     */
    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    /**
     * @return the userEntitys
     */
    public Set<UserEntity> getUserEntitys() {
        return userEntitys;
    }

    /**
     * @param userEntitys the userEntitys to set
     */
    public void setUserEntitys(Set<UserEntity> userEntitys) {
        this.userEntitys = userEntitys;
    }





    
}
