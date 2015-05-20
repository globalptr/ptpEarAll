/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEaoLocal;
import com.oakeel.ejb.entityAndEao.companyUser.CompanyUserEntity;
import com.oakeel.ejb.ptpEnum.BaseAmountEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */

@Named
@SessionScoped
public class IssueBond  implements Serializable {

    private BondEntity newbond=new BondEntity();
    private BigDecimal test;
    private int bondIndex=1;
    private BaseAmountEnum[] baseAmountEnums;
    private List<CompanyUserEntity> companyUserEntitys;
    @EJB
    CompanyUserEaoLocal companyUserEaoLocal;
    private List<String> imagetest;
    public String backToIssueOverPage()
    {
        return "/index";
    }
    /**
     * Creates a new instance of IssueBond
     */
    public IssueBond() {
        baseAmountEnums=BaseAmountEnum.values();
        this.test = new BigDecimal("1");
        imagetest=new ArrayList<>();
        imagetest.add("alarm_icons_001.png");
        imagetest.add("alarm_icons_002.png");
        imagetest.add("alarm_icons_003.png");
        imagetest.add("alarm_icons_004.png");
        imagetest.add("alarm_icons_005.png");
        imagetest.add("alarm_icons_006.png");
        imagetest.add("alarm_icons_007.png");
    }
    @PostConstruct
    public void init()
    {
        companyUserEntitys=companyUserEaoLocal.getAllEntitys();
    }
    public void test()
    {
        
        System.out.println(test.toString());
    }
    public void stepBack()
    {
        if((bondIndex-1)>-1)
            bondIndex--;
    }
    public void stepFront()
    {
        if((bondIndex+1)<4)
            bondIndex++;
    }
    /**
     * @return the bondIndex
     */
    public int getBondIndex() {
        return bondIndex;
    }

    /**
     * @param bondIndex the bondIndex to set
     */
    public void setBondIndex(int bondIndex) {
        this.bondIndex = bondIndex;
    }

    /**
     * @return the test
     */
    public BigDecimal getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(BigDecimal test) {
        this.test = test;
    }



    /**
     * @return the baseAmountEnums
     */
    public BaseAmountEnum[] getBaseAmountEnums() {
        return baseAmountEnums;
    }

    /**
     * @param baseAmountEnums the baseAmountEnums to set
     */
    public void setBaseAmountEnums(BaseAmountEnum[] baseAmountEnums) {
        this.baseAmountEnums = baseAmountEnums;
    }

    /**
     * @return the newbond
     */
    public BondEntity getNewbond() {
        return newbond;
    }

    /**
     * @param newbond the newbond to set
     */
    public void setNewbond(BondEntity newbond) {
        this.newbond = newbond;
    }

    /**
     * @return the companyUserEntitys
     */
    public List<CompanyUserEntity> getCompanyUserEntitys() {
        return companyUserEntitys;
    }

    /**
     * @param companyUserEntitys the companyUserEntitys to set
     */
    public void setCompanyUserEntitys(List<CompanyUserEntity> companyUserEntitys) {
        this.companyUserEntitys = companyUserEntitys;
    }

    /**
     * @return the imagetest
     */
    public List<String> getImagetest() {
        return imagetest;
    }

    /**
     * @param imagetest the imagetest to set
     */
    public void setImagetest(List<String> imagetest) {
        this.imagetest = imagetest;
    }

    
}
