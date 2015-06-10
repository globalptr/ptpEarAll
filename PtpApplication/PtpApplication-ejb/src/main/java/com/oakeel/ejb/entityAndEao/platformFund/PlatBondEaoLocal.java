/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.platformFund;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PlatBondEaoLocal extends EaoRootLocal<PlatBondEntity> {
    
    public List<PlatBondEntity> getAllLogicDeleteBonds();
    public List<PlatBondEntity> getAllAuditBonds() ;
    public void logicDeleteBond(PlatBondEntity bond);
    public void backToApplication(PlatBondEntity bond);
    public void passAudit(PlatBondEntity bond);
}
