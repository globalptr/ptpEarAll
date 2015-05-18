/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.organization;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface OrganizationEaoLocal  extends EaoRootLocal<OrganizationEntity>{
    public OrganizationEntity AddNewOrganization(OrganizationEntity organization,OrganizationEntity parent);
    public OrganizationEntity getRoot();
    public List<OrganizationEntity> getOrganizationEntityByName(String name);
}
