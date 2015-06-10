/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.personalBond.PersonalBondEntity;
import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.imageInfo.ImageInfoEntity;
import com.oakeel.ejb.ptpEnum.ImageUsedEnum;
import com.oakeel.ejb.ptpEnum.SysInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class IssuePersonalBond2 {

    /**
     * Creates a new instance of IssueBond2
     */
    @Inject
    private PtpSessionBean ptpSessionBean;
    PersonalBondEntity bond2;
    private ImageUsedEnum selectImageUsedEnum;
    private BondInformationEntity contractInfo;
    private BondInformationEntity companyInfo;
    private BondInformationEntity visitInfo;
    private ImageInfoEntity targetImageInfo;
    
    private List<UploadedFile> contractUploadFiles;
    private List<UploadedFile> companyUploadFiles;
    private List<UploadedFile> visitUploadFiles;

    public IssuePersonalBond2() {
        contractUploadFiles=new ArrayList<>();
        companyUploadFiles=new ArrayList<>();
        visitUploadFiles=new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        selectImageUsedEnum = ImageUsedEnum.合同资料;
        bond2 = new PersonalBondEntity();
        contractInfo = new BondInformationEntity();
        contractInfo.setTitle(ImageUsedEnum.合同资料);
        companyInfo = new BondInformationEntity();
        companyInfo.setTitle(ImageUsedEnum.公司资料);
        visitInfo = new BondInformationEntity();
        visitInfo.setTitle(ImageUsedEnum.考察资料);
        createFolder(selectImageUsedEnum.getEnStr());
        if(ptpSessionBean.getIssueBondLocal().getBond2()==null)
            return;
        if (ptpSessionBean.getIssueBondLocal().getBond2().getBondInformationEntiys() != null) {
            List<BondInformationEntity> temp = ptpSessionBean.getIssueBondLocal().getBond2().getBondInformationEntiys();
            for (BondInformationEntity item : temp) {
                if (item.getTitle() == ImageUsedEnum.合同资料) {
                    List<ImageInfoEntity> images = item.getImageInfoEntitys();
                    for (ImageInfoEntity imageItem : images) {
                        contractInfo.getImageInfoEntitys().add(imageItem);
                    }
                } else if (item.getTitle() == ImageUsedEnum.公司资料) {
                    List<ImageInfoEntity> images = item.getImageInfoEntitys();
                    for (ImageInfoEntity imageItem : images) {
                        companyInfo.getImageInfoEntitys().add(imageItem);
                    }
                } else if (item.getTitle() == ImageUsedEnum.考察资料) {
                    List<ImageInfoEntity> images = item.getImageInfoEntitys();
                    for (ImageInfoEntity imageItem : images) {
                        visitInfo.getImageInfoEntitys().add(imageItem);
                    }
                }
            }
        }
    }

    public String toNextStep() {

//            FacesContext context = FacesContext.getCurrentInstance();
//            ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
//            context.addMessage(null, new FacesMessage(SysInfo.提示.toString(), "融资标实体未初始化!"));
//            handler.performNavigation("issueBond1");

        bond2.getBondInformationEntiys().add(visitInfo);
        bond2.getBondInformationEntiys().add(companyInfo);
        bond2.getBondInformationEntiys().add(contractInfo);
        ptpSessionBean.getIssueBondLocal().setStep2Bond(bond2);
        return "issuePersonalBond3";
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
                createFolder(getSelectImageUsedEnum().getEnStr());
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

    public void createFolder(String folderName) {
        String folder = "/ptpImageFolder/bondImages/" + bond2.getBondNumber() + "/" + folderName;
        File file = new File(folder);//在e盘的test文件夹下面 创建一个叫 a的文件夹   \\ 是转义用的  
        if (file.exists()) {
            System.out.println("文件夹" + folder + "已经存在！");
        } else {
            //如果直接写下面的一句话，就会说：文件建立失败。因为父文件yyy不存在。
            //boolean file_true = file.mkdir();
            //但是写下面的这句话，就不会报错：文件夹建立失败。因为它会自动建立不存在的父文建夹。
            boolean file_true = file.mkdirs();
            if (file_true) {
                System.out.println("文件夹" + folder + "建立成功");
            } else {
                System.out.println("文件夹" + folder + "建立失败");
            }

        }
    }
    public void closeUploadDlg()
    {
        
        companyUploadFiles.clear();
        contractUploadFiles.clear();
        visitUploadFiles.clear();
    }
    public void saveUploadFileAndEntity()
    {
        String folder = "/bondImages/" +  bond2.getBondNumber() + "/" + selectImageUsedEnum.getEnStr();
        if(!companyUploadFiles.isEmpty())
        {
            for(UploadedFile item:companyUploadFiles)
            {
                String imageRelPath = folder + "/" + item.getFileName();
                String imagePath = "/ptpImageFolder" + imageRelPath;
                saveUploadFile(item,imagePath);
                saveUploadFileEntity(item, imageRelPath);
            }
        }
        if(!contractUploadFiles.isEmpty())
        {
            for(UploadedFile item:contractUploadFiles)
            {
                String imageRelPath = folder + "/" + item.getFileName();
                String imagePath = "/ptpImageFolder" + imageRelPath;
                saveUploadFile(item,imagePath);
                saveUploadFileEntity(item, imageRelPath);
            }
        }
        if(!visitUploadFiles.isEmpty())
        {
            for(UploadedFile item:visitUploadFiles)
            {
                String imageRelPath = folder + "/" + item.getFileName();
                String imagePath = "/ptpImageFolder" + imageRelPath;
                saveUploadFile(item,imagePath);
                saveUploadFileEntity(item, imageRelPath);
            }
        }
        closeUploadDlg();
    }
    
    public void saveUploadFileEntity(UploadedFile file,String relPath)
    {
        ImageInfoEntity image = new ImageInfoEntity();
        image.setImagePath(relPath);
        image.setImageName(file.getFileName().substring(0, file.getFileName().lastIndexOf(".")));
        image.setImageSize(file.getSize());
        if (selectImageUsedEnum.equals(ImageUsedEnum.公司资料)) {
            companyInfo.getImageInfoEntitys().add(image);
        } else if (selectImageUsedEnum.equals(ImageUsedEnum.合同资料)) {
            contractInfo.getImageInfoEntitys().add(image);
        } else if (selectImageUsedEnum.equals(ImageUsedEnum.考察资料)) {
            visitInfo.getImageInfoEntitys().add(image);
        }
    }
    
    public void saveUploadFile(UploadedFile file,String path)
    {
        InputStream stream = null;
        try {
            stream = file.getInputstream();
        } catch (IOException ex) {
            Logger.getLogger(IssuePersonalBond2.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(stream==null)
            return;
        File diskfile = new File(path);
        path=path.substring(0,path.lastIndexOf("/"));
        if (diskfile.exists()) {
            System.out.println("创建单个文件" + path + "失败，目标文件已存在！");
            return;
        }
        if (path.endsWith(File.separator)) {
            System.out.println("创建单个文件" + path + "失败，目标不能是目录！");
            return;
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(diskfile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IssuePersonalBond2.class.getName()).log(Level.SEVERE, null, ex);
        }

        int read = 0;
        byte[] bytes = new byte[1024];
        try {
            while ((read = stream.read(bytes)) != -1) {
                try {
                    if(fos!=null)
                        fos.write(bytes, 0, read);
                } catch (IOException ex) {
                     Logger.getLogger(IssuePersonalBond2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex){
            Logger.getLogger(IssuePersonalBond2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void handleFileUpload(FileUploadEvent event)  {
        
        UploadedFile file = event.getFile();
        if (selectImageUsedEnum.equals(ImageUsedEnum.公司资料)) {
            companyUploadFiles.add(file);
        } else if (selectImageUsedEnum.equals(ImageUsedEnum.合同资料)) {
            contractUploadFiles.add(file);
        } else if (selectImageUsedEnum.equals(ImageUsedEnum.考察资料)) {
            visitUploadFiles.add(file);
        }
//        UploadedFile file = event.getFile();
//        InputStream stream = file.getInputstream();
//        String folder = "/bondImages/" +  bond2.getBondNumber() + "/" + getSelectImageUsedEnum().getEnStr();
//        String imageRelPath = folder + "/" + file.getFileName();
//        String imagePath = "/ptpImageFolder" + imageRelPath;
//
//        File diskfile = new File(imagePath);
//        if (diskfile.exists()) {
//            System.out.println("创建单个文件" + imagePath + "失败，目标文件已存在！");
//            return;
//        }
//        if (imagePath.endsWith(File.separator)) {
//            System.out.println("创建单个文件" + imagePath + "失败，目标不能是目录！");
//            return;
//        }
//
//        FileOutputStream fos = new FileOutputStream(diskfile);
//
//        int read = 0;
//        byte[] bytes = new byte[1024];
//        while ((read = stream.read(bytes)) != -1) {
//            fos.write(bytes, 0, read);
//        }
//        ImageInfoEntity image = new ImageInfoEntity();
//        image.setImagePath(imageRelPath);
//        image.setImageName(file.getFileName().substring(0, file.getFileName().lastIndexOf(".")));
//        System.out.println(file.getFileName());
//        if (selectImageUsedEnum.equals(ImageUsedEnum.公司资料)) {
//            companyInfo.getImageInfoEntitys().add(image);
//        } else if (selectImageUsedEnum.equals(ImageUsedEnum.合同资料)) {
//            contractInfo.getImageInfoEntitys().add(image);
//        } else if (selectImageUsedEnum.equals(ImageUsedEnum.考察资料)) {
//            visitInfo.getImageInfoEntitys().add(image);
//        }

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

    /**
     * @return the ptpSessionBean
     */
    public PtpSessionBean getPtpSessionBean() {
        return ptpSessionBean;
    }

    /**
     * @param ptpSessionBean the ptpSessionBean to set
     */
    public void setPtpSessionBean(PtpSessionBean ptpSessionBean) {
        this.ptpSessionBean = ptpSessionBean;
    }

    /**
     * @return the contractUploadFiles
     */
    public List<UploadedFile> getContractUploadFiles() {
        return contractUploadFiles;
    }

    /**
     * @param contractUploadFiles the contractUploadFiles to set
     */
    public void setContractUploadFiles(List<UploadedFile> contractUploadFiles) {
        this.contractUploadFiles = contractUploadFiles;
    }

    /**
     * @return the companyUploadFiles
     */
    public List<UploadedFile> getCompanyUploadFiles() {
        return companyUploadFiles;
    }

    /**
     * @param companyUploadFiles the companyUploadFiles to set
     */
    public void setCompanyUploadFiles(List<UploadedFile> companyUploadFiles) {
        this.companyUploadFiles = companyUploadFiles;
    }

    /**
     * @return the visitUploadFiles
     */
    public List<UploadedFile> getVisitUploadFiles() {
        return visitUploadFiles;
    }

    /**
     * @param visitUploadFiles the visitUploadFiles to set
     */
    public void setVisitUploadFiles(List<UploadedFile> visitUploadFiles) {
        this.visitUploadFiles = visitUploadFiles;
    }

}
