/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.front.controller.home;

import com.oakeel.front.BaseController;
import com.oakeel.front.domain.PtpProduct;
import com.oakeel.front.service.home.TtjcHomeService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author zmr
 */
@ManagedBean(name = "ttjcHomeC")
public class TtjcHomeController extends BaseController {
    
    @ManagedProperty("#{ttjcHomeService}")
    private TtjcHomeService ttjcHome;
    /**
     * 抵押标
     */
    private List<PtpProduct> listMortgage;
    /**
     * 担保标
     */
    private List<PtpProduct> listSupport;
    
    /**
     * 初始化
     */
    @PostConstruct
    public void init(){
       listMortgage = ttjcHome.findProductMortgage();
       listSupport = ttjcHome.findProductSupport();
    }

    public List<PtpProduct> getListMortgage() {
        return listMortgage;
    }

    public List<PtpProduct> getListSupport() {
        return listSupport;
    }

    public void setTtjcHome(TtjcHomeService ttjcHome) {
        this.ttjcHome = ttjcHome;
    }
    
}
