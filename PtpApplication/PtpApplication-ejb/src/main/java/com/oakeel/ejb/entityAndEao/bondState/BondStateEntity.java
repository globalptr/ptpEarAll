/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bondState;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import javax.persistence.Entity;

/**
 *
 * @author root
 */
@Entity
public class BondStateEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
    Boolean isInformationCompleted;//资料是否齐全
}
