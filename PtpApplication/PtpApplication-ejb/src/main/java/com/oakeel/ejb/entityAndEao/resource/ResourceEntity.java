/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.resource;

import com.oakeel.ejb.ptpEnum.ResourceTypeEnum;
import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.permission.PermissionEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class ResourceEntity extends EntityRoot {
    public ResourceEntity()
    {
    }
    public ResourceEntity(String name,String permission,ResourceTypeEnum type,Boolean available,int priority)
    {
        this.name=name;
        this.resourceDesc=permission;
        this.type=type;
        this.priority=priority;
        this.available=available;
    }
    public ResourceEntity(String name,String permission)
    {
        this.name=name;
        this.resourceDesc=permission;
        
    }
    private static final long serialVersionUID = 1L;
    @Column(nullable=false,length=50)
    private String name;//资源名
    @Enumerated(EnumType.STRING)
    @Column(length=10)
    private ResourceTypeEnum type=ResourceTypeEnum.未定义;//资源类型
    private int priority=0;//显示顺序
    @Column(length=50)
    private String resourceDesc="";//描述
    private Boolean available=true;//是否可用
    @OneToMany(mappedBy="resourceEntity")//资源与权限的关系是一对多的关系，主控必须在权限
    private Set<PermissionEntity> permissionEntitys=new HashSet<>();

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
     * @return the type
     */
    public ResourceTypeEnum getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ResourceTypeEnum type) {
        this.type = type;
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
     * @return the resourceDesc
     */
    public String getResourceDesc() {
        return resourceDesc;
    }

    /**
     * @param resourceDesc the resourceDesc to set
     */
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    /**
     * @return the permissionEntitys
     */
    public Set<PermissionEntity> getPermissionEntitys() {
        return permissionEntitys;
    }

    /**
     * @param permissionEntitys the permissionEntitys to set
     */
    public void setPermissionEntitys(Set<PermissionEntity> permissionEntitys) {
        this.permissionEntitys = permissionEntitys;
    }
    
}
