/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.backUser;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface BackUserEaoLocal  extends EaoRootLocal<BackUserEntity>{
    
    public BackUserEntity  validateUserByName(String name,String password);
    public BackUserEntity  validateUserByTelephone(String telephone,String password);
    public BackUserEntity  validateUserByEmail(String email,String password);
    public BackUserEntity  validateUserByQQ(String qq,String password);
}
