/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.front.service.home;

import com.oakeel.front.domain.PtpProduct;
import com.oakeel.front.enums.SplitUnit;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author zmr
 */
@ManagedBean(name = "ttjcHomeService")
public class TtjcHomeService {
    
    /**
     * 抵押标
     * @return 
     */
    public List<PtpProduct> findProductMortgage(){
       List<PtpProduct> list = new ArrayList<>();
       PtpProduct ptp = null;
       for(int i=0;i<2;i++){
           ptp = new PtpProduct();
           ptp.setBaseAmount(555600000);
           ptp.setYearRate(new BigDecimal(2));
           ptp.setRepayCycle(SplitUnit.日);
           ptp.setRepayCycleNumber(6);
           list.add(ptp);
       }
       return list;
    }
    /**
     * 担 保 标
     * @return 
     */
    public List<PtpProduct> findProductSupport(){
       List<PtpProduct> list = new ArrayList<>();
       PtpProduct ptp = null;
       for(int i=0;i<2;i++){
           ptp = new PtpProduct();
           list.add(ptp);
       }
       return list;
    }
}
