/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.front.service.borrow;

import com.oakeel.front.domain.FrontUserHoldBond;
import com.oakeel.front.domain.PlatformFund;
import com.oakeel.front.enums.SplitUnit;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author zmr
 */
@ManagedBean(name = "borrowCashService")
public class BorrowCashService {
    public List<PlatformFund> find(){
       PlatformFund pl = null;
       List<PlatformFund> listpl = new ArrayList<>();
       //初始化数据
       for(int i=0;i<5;i++){
           pl = new PlatformFund();
           int amount = new Random().nextInt(1000000);
           pl.setBaseAmount(amount);
           pl.setName("倒卖小孩儿燕子"+i+1+"号");
           pl.setRepayCycle(SplitUnit.周);
           pl.setRepayCycleNumber(new Random().nextInt(12)+1);
           pl.setBondNumber("201504150208"+i);
           pl.setYearRate(new BigDecimal(1));
           int number = new Random().nextInt(10) + 1;
           FrontUserHoldBond  bf = null;
           Set<FrontUserHoldBond> bfset = new HashSet<>();
           int issueC = new Random().nextInt(1000);
           int transact = new Random().nextInt(1000);
           while(true){
               if(transact>issueC)
               {
                   issueC = new Random().nextInt(1000);
                   transact = new Random().nextInt(1000);
               }
               else
                break;
           }
            pl.setIssueCopiesNum(issueC);
           pl.setTransactionCopiesNum(transact);
           for(int k=0;k<number;k++){
               bf = new FrontUserHoldBond();
               bfset.add(bf);
           }
           pl.setFrontUserHoldBonds(bfset);
           listpl.add(pl);
       }
        
       return listpl;
    }
}
