/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bondInformation;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.imageInfo.ImageInfoEntity;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class BondInformationEntity extends EntityRoot{
    private static final long serialVersionUID = 1L;
    String title;
    @OneToMany
    Set<ImageInfoEntity> imageInfoEntitys;
}
