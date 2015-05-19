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
public enum BaseAmountEnum {
    标准一(1),标准二(50),标准三(100),标准四(500),标准五(1000);
    int baseValue;
    private BaseAmountEnum(int value)
    {
        this.baseValue=value;
    }
}
