/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.role;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRoot;
import com.oakeel.ejb.entityAndEao.permission.PermissionEntity;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class RoleEao extends EaoRoot<RoleEntity> implements RoleEaoLocal {

    @Override
    public void deletePermission(RoleEntity role, PermissionEntity permission) {
        role.getPermissions().remove(permission);
        em.merge(role);
    }
}
