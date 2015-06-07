/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.front.enums;

/**
 *
 * @author root
 */
public enum CreditLevelEnum {
    //信用等级
    AA(1000),A(700),B(100),C(50),D(30),E(10),HR(1);
    private int fundingLine;//资金额度
    private CreditLevelEnum(int line)
    {
        this.fundingLine=line;
    }

    /**
     * @return the fundingLine
     */
    public int getFundingLine() {
        return fundingLine;
    }

    /**
     * @param fundingLine the fundingLine to set
     */
    public void setFundingLine(int fundingLine) {
        this.fundingLine = fundingLine;
    }
}
