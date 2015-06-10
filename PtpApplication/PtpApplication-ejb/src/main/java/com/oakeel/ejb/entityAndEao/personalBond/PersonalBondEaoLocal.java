/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.personalBond;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PersonalBondEaoLocal  extends EaoRootLocal<PersonalBondEntity>{
    public List<PersonalBondEntity> getAllLogicDeleteBonds();
    public List<PersonalBondEntity> getAllAuditBonds() ;
    public void logicDeleteBond(PersonalBondEntity bond);
    public void backToApplication(PersonalBondEntity bond);
    public void passAudit(PersonalBondEntity bond);
}
