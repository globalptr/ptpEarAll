/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.user;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import com.oakeel.ejb.entityAndEao.organization.OrganizationEntity;
import com.oakeel.ejb.entityAndEao.role.RoleEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface UserEaoLocal extends EaoRootLocal<UserEntity>{
  
    public UserEntity  validateUserByName(String name,String password);
    public UserEntity  validateUserByTelephone(String telephone,String password);
    public UserEntity  validateUserByEmail(String email,String password);
    public UserEntity  validateUserByQQ(String qq,String password);
    public List<UserEntity> getUsersByOrganization(OrganizationEntity org);
    public  List<UserEntity> getUnclassedUser();
    public void deleteRole(UserEntity user,RoleEntity role);
    public void addUserRole(UserEntity user,RoleEntity role);
    
}
