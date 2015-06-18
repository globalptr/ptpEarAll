/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bond;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import com.oakeel.ejb.entityAndEao.permission.PermissionEntity;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface BondEaoLocal  extends EaoRootLocal<BondEntity>{
    
}
