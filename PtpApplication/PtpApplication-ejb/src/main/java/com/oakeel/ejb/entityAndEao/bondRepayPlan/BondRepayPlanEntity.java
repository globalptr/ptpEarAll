/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bondRepayPlan;

import com.oakeel.ejb.entityAndEao.bondRepayPlanItem.bondRepayPlanItemEntity;
import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class BondRepayPlanEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
 
    @OneToMany(cascade = {CascadeType.ALL})//删除掉还款记录就删除掉用户收益
    Set<bondRepayPlanItemEntity> DebitCreditEntitys;//每一条还款记录对应多条还款计划条目

}
