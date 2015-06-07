/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bond;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface BondEaoLocal  extends EaoRootLocal<BondEntity>{
    public void passAudit(BondEntity bond);
    public void backToApplication(BondEntity bond);
    public void logicDeleteBond(BondEntity bond);
    public List<BondEntity> getAllAuditBonds();
    public List<BondEntity> getAllLogicDeleteBonds();
    
}
