/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.front.service;

import com.oakeel.front.domain.PlatformFund;
import com.oakeel.front.enums.PlatformFundTypeEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author zmr
 */
@ManagedBean(name = "inversService")
@ApplicationScoped
public class InvestmentService {
    /**
     * 聚财宝
     * @return 
     */
    public List<PlatformFund> findJucl(){
        PlatformFund plat = null;
        List<PlatformFund> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            plat = new PlatformFund();
            plat.setName("车辆周转贷 "+new Date().getYear());
            plat.setBondNumber("626期");
            plat.setPlatformFundTypeEnum(PlatformFundTypeEnum.聚财宝);
            plat.setRepayCycleNumber(3);
            list.add(plat);
        }
        return list;
    }
    /**
     * 季富宝
     * @return 
     */
    public List<PlatformFund> findSeason(){
        PlatformFund plat = null;
        List<PlatformFund> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            plat = new PlatformFund();
            plat.setName("车辆周转贷 "+new Date().getYear());
            plat.setBondNumber("626期");
            plat.setPlatformFundTypeEnum(PlatformFundTypeEnum.季富宝);
            plat.setRepayCycleNumber(3);
            list.add(plat);
        }
        return list;
    }
    /**
     * 月月宝
     * @return 
     */
    public List<PlatformFund> findMoth(){
        PlatformFund plat = null;
        List<PlatformFund> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            plat = new PlatformFund();
            plat.setName("车辆周转贷 "+new Date().getYear());
            plat.setBondNumber("626期");
            plat.setPlatformFundTypeEnum(PlatformFundTypeEnum.月月宝);
            plat.setRepayCycleNumber(3);
            list.add(plat);
        }
        return list;
    }
    /**
     * 天天宝
     * @return 
     */
    public List<PlatformFund> findDay(){
        PlatformFund plat = null;
        List<PlatformFund> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            plat = new PlatformFund();
            plat.setName("车辆周转贷 "+new Date().getYear());
            plat.setBondNumber("626期");
            plat.setPlatformFundTypeEnum(PlatformFundTypeEnum.天天宝);
            plat.setRepayCycleNumber(3);
            list.add(plat);
        }
        return list;
    }
}
