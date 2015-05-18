/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ejb.entityAndEao.permission;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.operation.OperationEntity;
import com.oakeel.ejb.entityAndEao.resource.ResourceEntity;
import com.oakeel.ejb.entityAndEao.role.RoleEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class PermissionEntity extends EntityRoot {

    private static final long serialVersionUID = 1L;


    public PermissionEntity () {
    }

    public PermissionEntity(ResourceEntity resource) {
        this.resourceEntity = resource;
    }
    public PermissionEntity(RoleEntity role,ResourceEntity resource) {
        this.roleEntity=role;
        this.resourceEntity = resource;
    }
    @ManyToOne
    private ResourceEntity resourceEntity;
    @OneToMany
    private Set<OperationEntity> operationEntitys=new HashSet<>();

    @ManyToOne
    private RoleEntity roleEntity;


    /**
     * @return the resourceEntity
     */
    public ResourceEntity getResourceEntity() {
        return resourceEntity;
    }

    /**
     * @param resourceEntity the resourceEntity to set
     */
    public void setResourceEntity(ResourceEntity resourceEntity) {
        this.resourceEntity = resourceEntity;
    }

    /**
     * @return the roleEntity
     */
    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    /**
     * @param roleEntity the roleEntity to set
     */
    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    /**
     * @return the operationEntitys
     */
    public Set<OperationEntity> getOperationEntitys() {
        return operationEntitys;
    }

    /**
     * @param operationEntitys the operationEntitys to set
     */
    public void setOperationEntitys(Set<OperationEntity> operationEntitys) {
        this.operationEntitys = operationEntitys;
    }


}
