/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.front.controller;

import com.oakeel.front.BaseController;
import com.oakeel.front.domain.PlatformFund;
import com.oakeel.front.service.InvestmentService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

/**
 * 投资列表控制器
 *
 * @author zmr
 */
@ManagedBean(name = "investmentC")
@ViewScoped
public class InvestmentController extends BaseController {

    private List<PlatformFund> platFormJucl;
    private List<PlatformFund> platFormSeason;
    private List<PlatformFund> platFormMoth;
    private List<PlatformFund> platFormDay;
    private String test="123";

    @ManagedProperty("#{inversService}")
    private InvestmentService service;

    @PostConstruct
    public void init() {
        //聚财金
        platFormJucl=service.findJucl();
        //季富金
        platFormSeason=service.findSeason();
        //月月宝
        platFormMoth=service.findMoth();
        //天天宝
        platFormDay=service.findDay();
    }

    public List<PlatformFund> getPlatFormJucl() {
        return platFormJucl;
    }

    public List<PlatformFund> getPlatFormSeason() {
        return platFormSeason;
    }

    public List<PlatformFund> getPlatFormMoth() {
        return platFormMoth;
    }

    public List<PlatformFund> getPlatFormDay() {
        return platFormDay;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
}
