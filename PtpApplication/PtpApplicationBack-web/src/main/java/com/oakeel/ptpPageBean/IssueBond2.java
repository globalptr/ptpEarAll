/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ptpPageBean;

import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.imageInfo.ImageInfoEntity;
import com.oakeel.ejb.ptpEnum.ImageUsedEnum;
import com.oakeel.ejb.ptpEnum.SysInfo;
import com.oakeel.ejb.transaction.bond.IssueBondLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class IssueBond2 {

    /**
     * Creates a new instance of IssueBond2
     */
    @EJB
    IssueBondLocal issueBondLocal;
    BondEntity bond2;
    private ImageUsedEnum selectImageUsedEnum = ImageUsedEnum.合同资料;
    private BondInformationEntity contractInfo = new BondInformationEntity();
    private BondInformationEntity companyInfo = new BondInformationEntity();
    private BondInformationEntity visitInfo = new BondInformationEntity();
    private ImageInfoEntity targetImageInfo;

    public IssueBond2() {
    }

    @PostConstruct
    public void init() {
        bond2 = new BondEntity();
    }

    public String issueBond() {
        bond2.getBondInformationEntiys().add(contractInfo);
        bond2.getBondInformationEntiys().add(companyInfo);
        bond2.getBondInformationEntiys().add(visitInfo);
        issueBondLocal.step2(bond2);
        issueBondLocal.issue();
        return "issueBond3";
    }

    public void onTabChange(TabChangeEvent event) {
        //如果更换选项卡，首先判断标的信息集合中是否有对应的选项卡内容，如果没有，新建

        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        String title = event.getTab().getTitle();
        ImageUsedEnum[] imageUsedEnums = ImageUsedEnum.values();
        for (ImageUsedEnum item : imageUsedEnums) {
            if (title.equals(item.toString())) {
                setSelectImageUsedEnum(item);
                System.out.println(getSelectImageUsedEnum().toString());
                break;
            }
        }

    }

    public void toNextImage() {
        if (selectImageUsedEnum.equals(ImageUsedEnum.合同资料)) {
            List<ImageInfoEntity> images = contractInfo.getImageInfoEntitys();
            Iterator<ImageInfoEntity> it = images.iterator();
            while (it.hasNext()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.next();
                if (temp.equals(targetImageInfo)) {
                    if (it.hasNext()) {
                        targetImageInfo = (ImageInfoEntity) it.next();
                        break;
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到最后一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }
        } else if (selectImageUsedEnum.equals(ImageUsedEnum.公司资料)) {
            List<ImageInfoEntity> images = companyInfo.getImageInfoEntitys();
            Iterator<ImageInfoEntity> it = images.iterator();
            while (it.hasNext()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.next();
                if (temp.equals(targetImageInfo)) {
                    if (it.hasNext()) {
                        targetImageInfo = (ImageInfoEntity) it.next();
                        break;
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到最后一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }

        } else if (selectImageUsedEnum.equals(ImageUsedEnum.考察资料)) {
            List<ImageInfoEntity> images = visitInfo.getImageInfoEntitys();
            Iterator<ImageInfoEntity> it = images.iterator();
            while (it.hasNext()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.next();
                if (temp.equals(targetImageInfo)) {
                    if (it.hasNext()) {
                        targetImageInfo = (ImageInfoEntity) it.next();
                        break;
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到最后一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }

        }
    }

    public void toPrevImage() {
        if (selectImageUsedEnum.equals(ImageUsedEnum.合同资料)) {

            ListIterator<ImageInfoEntity> it = contractInfo.getImageInfoEntitys().listIterator();
            for (; it.hasNext();) {// 将游标定位到列表结尾
                it.next();
            }
            while (it.hasPrevious()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.previous();
                if (temp.equals(targetImageInfo)) {
                    if (it.hasPrevious()) {
                        targetImageInfo = (ImageInfoEntity) it.previous();
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到第一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }
        } else if (selectImageUsedEnum.equals(ImageUsedEnum.公司资料)) {

            ListIterator<ImageInfoEntity> it = companyInfo.getImageInfoEntitys().listIterator();
            for (; it.hasNext();) {// 将游标定位到列表结尾
                   it.next();
            }
            while (it.hasPrevious()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.previous();
                if (temp.equals(targetImageInfo)) {
                    if (it.hasPrevious()) {
                        targetImageInfo = (ImageInfoEntity) it.previous();
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到第一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }
        } else if (selectImageUsedEnum.equals(ImageUsedEnum.考察资料)) {
            ListIterator<ImageInfoEntity> it = visitInfo.getImageInfoEntitys().listIterator();
            for (; it.hasNext();) {// 将游标定位到列表结尾
                it.next();
            }
            while (it.hasPrevious()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.previous();
                if (temp.equals(targetImageInfo)) {
                    if (it.hasPrevious()) {
                        targetImageInfo = (ImageInfoEntity) it.previous();
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到第一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }
        }
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        if (issueBondLocal.getCurrBond() == null) {
            issueBondLocal.createNewBond();
        }
        UploadedFile file = event.getFile();
        InputStream stream = file.getInputstream();
        String folder = "/bondImages/" + issueBondLocal.getCurrBond().getProductId();
        String imagerelPath = folder + "/" + file.getFileName();
        String imagePath = "/ptpImageFolder" + imagerelPath;
        System.out.println(file.getFileName());

        File diskfile = new File(imagePath);
        if (diskfile.exists()) {
            System.out.println("创建单个文件" + imagePath + "失败，目标文件已存在！");
            return;
        }
        if (imagePath.endsWith(File.separator)) {
            System.out.println("创建单个文件" + imagePath + "失败，目标不能是目录！");
            return;
        }
        if (!diskfile.getParentFile().exists()) {
            System.out.println("目标文件所在路径不存在，准备创建。。。");
            if (!diskfile.getParentFile().mkdirs()) {
                System.out.println("创建目录文件所在的目录失败！");
                return;
            }
        }

        FileOutputStream fos = new FileOutputStream(new File(imagePath));

        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = stream.read(bytes)) != -1) {
            fos.write(bytes, 0, read);
        }
        ImageInfoEntity image = new ImageInfoEntity();
        image.setImagePath(imagerelPath);
        image.setImageName(file.getFileName().substring(0, file.getFileName().lastIndexOf(".")));
        System.out.println(file.getFileName());
        if (selectImageUsedEnum.equals(ImageUsedEnum.公司资料)) {
            companyInfo.getImageInfoEntitys().add(image);
        } else if (selectImageUsedEnum.equals(ImageUsedEnum.合同资料)) {
            contractInfo.getImageInfoEntitys().add(image);
        } else if (selectImageUsedEnum.equals(ImageUsedEnum.考察资料)) {
            visitInfo.getImageInfoEntitys().add(image);
        }

        //application code
    }

    /**
     * @return the selectImageUsedEnum
     */
    public ImageUsedEnum getSelectImageUsedEnum() {
        return selectImageUsedEnum;
    }

    /**
     * @param selectImageUsedEnum the selectImageUsedEnum to set
     */
    public void setSelectImageUsedEnum(ImageUsedEnum selectImageUsedEnum) {
        this.selectImageUsedEnum = selectImageUsedEnum;
    }

    /**
     * @return the contractInfo
     */
    public BondInformationEntity getContractInfo() {
        return contractInfo;
    }

    /**
     * @param contractInfo the contractInfo to set
     */
    public void setContractInfo(BondInformationEntity contractInfo) {
        this.contractInfo = contractInfo;
    }

    /**
     * @return the companyInfo
     */
    public BondInformationEntity getCompanyInfo() {
        return companyInfo;
    }

    /**
     * @param companyInfo the companyInfo to set
     */
    public void setCompanyInfo(BondInformationEntity companyInfo) {
        this.companyInfo = companyInfo;
    }

    /**
     * @return the visitInfo
     */
    public BondInformationEntity getVisitInfo() {
        return visitInfo;
    }

    /**
     * @param visitInfo the visitInfo to set
     */
    public void setVisitInfo(BondInformationEntity visitInfo) {
        this.visitInfo = visitInfo;
    }

    /**
     * @return the targetImageInfo
     */
    public ImageInfoEntity getTargetImageInfo() {
        return targetImageInfo;
    }

    /**
     * @param targetImageInfo the targetImageInfo to set
     */
    public void setTargetImageInfo(ImageInfoEntity targetImageInfo) {
        this.targetImageInfo = targetImageInfo;
    }

}
