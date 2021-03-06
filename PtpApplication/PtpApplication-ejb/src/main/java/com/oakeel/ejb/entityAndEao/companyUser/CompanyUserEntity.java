/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.companyUser;

import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.imageInfo.ImageInfoEntity;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import com.oakeel.ejb.ptpEnum.CompanyTypeEnum;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class CompanyUserEntity extends UserEntity {
    private static final long serialVersionUID = 1L;
    @OneToOne
    private ImageInfoEntity logImage;//logo
    @OneToMany(mappedBy="companyUserEntity")
    Set<PersonalBondEntity> bondEntitys; 
    private String mainBusiness;//主营业务
    private CompanyTypeEnum companyType;//公司类型
    /**
     * @return the mainBusiness
     */

    public String getMainBusiness() {
        return mainBusiness;
    }

    /**
     * @param mainBusiness the mainBusiness to set
     */
    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    /**
     * @return the logImage
     */
    public ImageInfoEntity getLogImage() {
        return logImage;
    }

    /**
     * @param logImage the logImage to set
     */
    public void setLogImage(ImageInfoEntity logImage) {
        this.logImage = logImage;
    }

    /**
     * @return the companyType
     */
    public CompanyTypeEnum getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType the companyType to set
     */
    public void setCompanyType(CompanyTypeEnum companyType) {
        this.companyType = companyType;
    }
}
