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
public enum ImageUsedEnum {
    合同资料("contract"),公司资料("company"),考察资料("visit");
    private String enStr;

    /**
     *
     * @param str
     */
    private ImageUsedEnum(String str)
    {
        enStr=str;
    }
    /**
     * @return the enStr
     */
    public String getEnStr() {
        return enStr;
    }

    /**
     * @param enStr the enStr to set
     */
    public void setEnStr(String enStr) {
        this.enStr = enStr;
    }
}
