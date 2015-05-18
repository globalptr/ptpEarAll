/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bondRepayPlanItem;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
public class bondRepayPlanItemEntity extends EntityRoot{
    private static final long serialVersionUID = 1L;
    @ManyToOne
    FrontUserEntity userEntity;
    @Temporal(TemporalType.TIMESTAMP)
    Date repayDate;//还款时间
    
    
}
