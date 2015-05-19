/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.ptpEnum;

/**
 *
 * @author root
 */
public enum CreditLevelEnum {
    //信用等级
    AA(1000),A(700),B(100),C(50),D(30),E(10),HR(1);
    int fundingLine;//资金额度
    private CreditLevelEnum(int line)
    {
        this.fundingLine=line;
    }
}
