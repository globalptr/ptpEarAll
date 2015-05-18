/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.operation;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRoot;
import com.oakeel.ejb.entityAndEao.permission.PermissionEaoLocal;
import com.oakeel.ejb.entityAndEao.permission.PermissionEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author root
 */
@Stateless
public class OperationEao extends EaoRoot<OperationEntity> implements OperationEaoLocal {

    @EJB
    PermissionEaoLocal permissionEaoLocal;


    @Override
    public void deleteOperation(OperationEntity operation) {
        em.remove(em.merge(operation));
        //删除操作，必须把所有的权限中的此操作全部删除才行
        List<PermissionEntity> permissions=permissionEaoLocal.getAllEntitys();
        for(PermissionEntity item:permissions)
        {
            item.getOperationEntitys().remove(operation);
        }
    }

}
