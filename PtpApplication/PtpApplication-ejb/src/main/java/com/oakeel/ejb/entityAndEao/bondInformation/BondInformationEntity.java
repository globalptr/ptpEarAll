/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.bondInformation;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.imageInfo.ImageInfoEntity;
import com.oakeel.ejb.ptpEnum.ImageUsedEnum;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class BondInformationEntity extends EntityRoot{
    private static final long serialVersionUID = 1L;
    @Enumerated(EnumType.STRING)
    private ImageUsedEnum title;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ImageInfoEntity> imageInfoEntitys=new ArrayList<>();



    /**
     * @return the title
     */
    public ImageUsedEnum getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(ImageUsedEnum title) {
        this.title = title;
    }

    /**
     * @return the imageInfoEntitys
     */
    public List<ImageInfoEntity> getImageInfoEntitys() {
        return imageInfoEntitys;
    }

    /**
     * @param imageInfoEntitys the imageInfoEntitys to set
     */
    public void setImageInfoEntitys(List<ImageInfoEntity> imageInfoEntitys) {
        this.imageInfoEntitys = imageInfoEntitys;
    }

}
