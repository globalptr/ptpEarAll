/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUser;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import com.oakeel.ejb.entityAndEao.frontUserHoldPersonalBond.FrontUserHoldPersonalBondEntity;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface FrontUserEaoLocal extends EaoRootLocal<FrontUserEntity> {
    public List<FrontUserEntity> getUserByName(String name);
    public List<FrontUserEntity> getUserByTelephone(String telephone);
    public List<FrontUserEntity> getUserByEmail(String email);
    public List<FrontUserEntity> getAllActiveUsers();
    public FrontUserHoldPersonalBondEntity getHoldPersonalBondEntityByPersonalBond(PersonalBondEntity personalBond,FrontUserEntity user);
}
