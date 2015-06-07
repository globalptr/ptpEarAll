/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.front.controller.borrow;

import com.oakeel.front.BaseController;
import com.oakeel.front.domain.PlatformFund;
import com.oakeel.front.service.borrow.BorrowCashService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * 借款控制器
 * @author zmr
 */
@ManagedBean(name = "borrowC")
public class BorrowCashController extends BaseController {
    
    @ManagedProperty("#{borrowCashService}")
    private BorrowCashService borrowCashService;
    private List<PlatformFund> listPro;
    
    @PostConstruct
    public void init(){
        listPro = borrowCashService.find();
    }

    public void setBorrowCashService(BorrowCashService borrowCashService) {
        this.borrowCashService = borrowCashService;
    }

    public List<PlatformFund> getListPro() {
        return listPro;
    }
}
