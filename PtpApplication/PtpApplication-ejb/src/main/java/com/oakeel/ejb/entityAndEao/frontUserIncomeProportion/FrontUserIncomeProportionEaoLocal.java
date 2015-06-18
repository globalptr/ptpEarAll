/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.frontUserIncomeProportion;

import com.oakeel.ejb.entityAndEao.check.CheckEntity;
import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface FrontUserIncomeProportionEaoLocal extends EaoRootLocal<FrontUserIncomeProportionEntity>  {
    public void clearAllRepayItems(FrontUserIncomeProportionEntity frontUserIncomeProportionEntity);
    public void dealCurrRepayItem(FrontUserIncomeProportionEntity frontUserIncomeProportionEntity,CheckEntity check);//结算当期账单
}
