/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction.RepayModelCaculate;

import com.oakeel.ejb.entityAndEao.repayItem.RepayItemEntity;
import com.oakeel.ejb.ptpEnum.RepayModelEnum;
import com.oakeel.ejb.ptpEnum.SplitUnitEnum;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface RepayModelCaculateLocal {
    public  List<RepayItemEntity> caculateRepayModel(RepayModelEnum repayModel, SplitUnitEnum splitUnit, BigDecimal totalLoan, BigDecimal yearRate, int repayPeriod, Date startDate);
}
