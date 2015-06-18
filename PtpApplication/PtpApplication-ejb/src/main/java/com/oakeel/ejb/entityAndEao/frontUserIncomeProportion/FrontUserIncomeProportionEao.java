/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUserIncomeProportion;

import com.oakeel.ejb.entityAndEao.check.CheckEntity;
import com.oakeel.ejb.entityAndEao.eeroot.EaoRoot;
import com.oakeel.ejb.entityAndEao.repayItem.RepayItemEaoLocal;
import com.oakeel.ejb.entityAndEao.repayItem.RepayItemEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class FrontUserIncomeProportionEao extends EaoRoot<FrontUserIncomeProportionEntity>  implements FrontUserIncomeProportionEaoLocal {

    @EJB RepayItemEaoLocal repayItemEntityEaoLocal;
    @Override
    public void clearAllRepayItems(FrontUserIncomeProportionEntity frontUserIncomeProportionEntity) {
        List<RepayItemEntity> items=frontUserIncomeProportionEntity.getRepayItems();
        for(RepayItemEntity item:items)
        {
            repayItemEntityEaoLocal.removeEntity(item);
        }
        frontUserIncomeProportionEntity.setRepayItems(null);
        em.merge(frontUserIncomeProportionEntity);
    }

    @Override
    public void dealCurrRepayItem(FrontUserIncomeProportionEntity frontUserIncomeProportionEntity,CheckEntity check) {
        RepayItemEntity item=frontUserIncomeProportionEntity.getRepayItems().get(0);
        frontUserIncomeProportionEntity.getRepayItems().remove(item);
        frontUserIncomeProportionEntity.getCheckEntitys().add(check);
        if(check.getUuid()==null)
            em.persist(check);
        em.merge(frontUserIncomeProportionEntity);
    }

    
}
