/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */

@Named
@FlowScoped("issueBondCtrl")
public class IssueBond  implements Serializable {

    private int bondIndex=1;
    public String backToIssueOverPage()
    {
        return "/index";
    }
    /**
     * Creates a new instance of IssueBond
     */
    public IssueBond() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx...");
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
    
}
