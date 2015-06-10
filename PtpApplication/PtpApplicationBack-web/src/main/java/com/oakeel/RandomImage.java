/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import com.oakeel.globaltool.ValidateCode;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class RandomImage {

    private ValidateCode validateCode;
   @PostConstruct
    public void init() {
        validateCode=new ValidateCode(200,50,4,10);
        validateCode.createCode();
   
    }
    /**
     * Creates a new instance of Random
     */
    public RandomImage() {
    }


    /**
     * @return the validateCode
     */
    public ValidateCode getValidateCode() {
        return validateCode;
    }

    /**
     * @param validateCode the validateCode to set
     */
    public void setValidateCode(ValidateCode validateCode) {
        this.validateCode = validateCode;
    }
    
}
