/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.userAccount;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface UserAccountEaoLocal  extends EaoRootLocal<UserAccountEntity>{
    
}