/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageViewBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.ejb.entityAndEao.bond.BondEaoLocal;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.bondInformation.BondInformationEntity;
import com.oakeel.ejb.entityAndEao.expense.ExpenseEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEaoLocal;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.imageInfo.ImageInfoEntity;
import com.oakeel.ejb.ptpEnum.ImageUsedEnum;
import com.oakeel.ejb.ptpEnum.SysInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class IssueBond4 implements Serializable{
    @Inject Conversation conversation;
    @Inject private PtpSessionBean ptpSessionBean;
    private List<ExpenseEntity> expenseEntitys;
    private List<BondInformationEntity> bondInformationEntitys;
    private BigDecimal allAmount;
    private BondInformationEntity contractInfo ;
    private BondInformationEntity companyInfo;
    private BondInformationEntity visitInfo;
    private List<UploadedFile> contractUploadFiles;
    private List<UploadedFile> companyUploadFiles;
    private List<UploadedFile> visitUploadFiles;
    private Date defaultDate;
    private Boolean frontUserEditable=false;
    private List<FrontUserEntity> frontUserEntitys; 
    @EJB
    private FrontUserEaoLocal frontUserEaoLocal;
    @EJB
    private BondEaoLocal bondEaoLocal;
    private FrontUserEntity targetFrontUser;
    private BondEntity bond4=null;
    private BondEntity bond4Edit;
    private Boolean baseAmountEdit=false;
    private Boolean issueCopiesNumEdit=false;
    private Boolean guaranteeCaseEdit=false;
    private Boolean reverseGuaranteeCaseEdit=false;
    private Boolean riskControlDetailEdit=false;
    private ImageUsedEnum imageUsedEnum;
    private ImageUsedEnum contractImageUsedEnum=ImageUsedEnum.合同资料;
    private ImageUsedEnum companyImageUsedEnum=ImageUsedEnum.公司资料;
    private ImageUsedEnum visitImageUsedEnum=ImageUsedEnum.考察资料;
    private String kkk="contract";
    private ImageInfoEntity targetImageInfo;
    
    /**
     * Creates a new instance of IssueBond4
     */
    
    public IssueBond4() {
        contractInfo=new BondInformationEntity() ;
        companyInfo=new BondInformationEntity() ;
        visitInfo=new BondInformationEntity() ;
        contractUploadFiles=new ArrayList<>();
        companyUploadFiles=new ArrayList<>();
        visitUploadFiles=new ArrayList<>();
    }
    @PostConstruct
    public void init()
    {
        if(bond4==null)
        {
            bond4=ptpSessionBean.getIssueBondLocal().getCurrBond();
        }
        if(bond4==null)
            return;
        bond4Edit=bond4;
         //仅当前页面未被post提交，且conversation是"瞬时"性时，才开始conversation
//  
//        if ( conversation.isTransient()) {
//            conversation.begin();
//        }
        defaultDate=new Date(0);
        frontUserEntitys=frontUserEaoLocal.getAllEntitys();
       
       
        if(ptpSessionBean.getIssueBondLocal().getCurrBond().getExpenseEntitys()!=null)
        {
            expenseEntitys=ptpSessionBean.getIssueBondLocal().getCurrBond().getExpenseEntitys();
        }
        if(ptpSessionBean.getIssueBondLocal().getCurrBond().getBondInformationEntiys()!=null)
        {
            bondInformationEntitys=ptpSessionBean.getIssueBondLocal().getCurrBond().getBondInformationEntiys();
            for(BondInformationEntity item:bondInformationEntitys)
            {
                if(item.getTitle()==ImageUsedEnum.合同资料)
                {
                    contractInfo=item;
                }
                else if(item.getTitle()==ImageUsedEnum.公司资料)
                {
                    companyInfo=item;
                }
                else if(item.getTitle()==ImageUsedEnum.考察资料)
                {
                    visitInfo=item;
                }
            }
        }
    }
    public void switchIssueUser()
    {
        bond4.getGuaranteeCase();
        bond4.getReverseGuaranteeCase();
        bond4.getRiskControlDetails();
        frontUserEditable=!frontUserEditable;
    }
    public void flushIssueUser()
    {
        bond4.setIssueUser(bond4Edit.getIssueUser());
    }
    public void startConversation()
    {
//        if ( conversation.isTransient()) {
//            System.out.println("///////////////////////////////////////////////////////start");
//            conversation.begin();
//        }
    }
    public void flushRiskControlDetail()
    {
        bond4.setRiskControlDetails(bond4.getRiskControlDetails());
    }
    public void switchRiskControlDetail()
    {
        riskControlDetailEdit=!riskControlDetailEdit;
    }
    public void flushReverseGuaranteeCase()
    {
        bond4.setReverseGuaranteeCase(bond4.getReverseGuaranteeCase());
    }
    public void switchReverseGuaranteeCase()
    {
        reverseGuaranteeCaseEdit=!reverseGuaranteeCaseEdit;
    }
    public void flushGuaranteeCase()
    {
        bond4.setGuaranteeCase(bond4Edit.getGuaranteeCase());
    }
    public void switchGuaranteeCase()
    {
        guaranteeCaseEdit=!guaranteeCaseEdit;
    }
    public void flushBaseAmount()
    {
        bond4.setBaseAmount(bond4Edit.getBaseAmount());
    }
    public void flushIssueCopiesNum()
    {
        bond4.setIssueCopiesNum(bond4Edit.getIssueCopiesNum());
    }
    
    public void switchBaseAmountEdit()
    {
        baseAmountEdit=!baseAmountEdit;
    }
    public void switchIssueCopiesNumEdit()
    {
        issueCopiesNumEdit=!issueCopiesNumEdit;
    }
    public void saveUploadFileAndEntity()
    {
        //String folder = "/bondImages/" +  bond4.getBondNumber() + "/" + imageUsedEnum.getEnStr();
        String folder = "/bondImages/test/" + imageUsedEnum.getEnStr();
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
        companyUploadFiles.clear();
        contractUploadFiles.clear();
        visitUploadFiles.clear();
    }
    public void saveUploadFileEntity(UploadedFile file,String relPath)
    {
        ImageInfoEntity image = new ImageInfoEntity();
        image.setImagePath(relPath);
        image.setImageName(file.getFileName().substring(0, file.getFileName().lastIndexOf(".")));
        image.setImageSize(file.getSize());
        System.out.println(imageUsedEnum);
        if (imageUsedEnum.equals(ImageUsedEnum.公司资料)) {
            companyInfo.getImageInfoEntitys().add(image);
        } else if (imageUsedEnum.equals(ImageUsedEnum.合同资料)) {
            contractInfo.getImageInfoEntitys().add(image);
        } else if (imageUsedEnum.equals(ImageUsedEnum.考察资料)) {
            visitInfo.getImageInfoEntitys().add(image);
        }
    }
    
    public void saveUploadFile(UploadedFile file,String path)
    {
        InputStream stream = null;
        try {
            stream = file.getInputstream();
        } catch (IOException ex) {
            Logger.getLogger(IssueBond4.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(stream==null)
            return;
        File diskfile = new File(path);
        path=path.substring(0,path.lastIndexOf("/"));
        createFolder(path);
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
            Logger.getLogger(IssueBond4.class.getName()).log(Level.SEVERE, null, ex);
        }

        int read = 0;
        byte[] bytes = new byte[1024];
        try {
            while ((read = stream.read(bytes)) != -1) {
                try {
                    if(fos!=null)
                        fos.write(bytes, 0, read);
                } catch (IOException ex) {
                    Logger.getLogger(IssueBond4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(IssueBond4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void toNextImage() {
        if (imageUsedEnum.equals(ImageUsedEnum.合同资料)) {
            List<ImageInfoEntity> images = contractInfo.getImageInfoEntitys();
            Iterator<ImageInfoEntity> it = images.iterator();
            while (it.hasNext()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.next();
                if (temp.equals(getTargetImageInfo())) {
                    if (it.hasNext()) {
                        setTargetImageInfo((ImageInfoEntity) it.next());
                        break;
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到最后一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }
        } else if (imageUsedEnum.equals(ImageUsedEnum.公司资料)) {
            List<ImageInfoEntity> images = companyInfo.getImageInfoEntitys();
            Iterator<ImageInfoEntity> it = images.iterator();
            while (it.hasNext()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.next();
                if (temp.equals(getTargetImageInfo())) {
                    if (it.hasNext()) {
                        setTargetImageInfo((ImageInfoEntity) it.next());
                        break;
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到最后一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }

        } else if (imageUsedEnum.equals(ImageUsedEnum.考察资料)) {
            List<ImageInfoEntity> images = visitInfo.getImageInfoEntitys();
            Iterator<ImageInfoEntity> it = images.iterator();
            while (it.hasNext()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.next();
                if (temp.equals(getTargetImageInfo())) {
                    if (it.hasNext()) {
                        setTargetImageInfo((ImageInfoEntity) it.next());
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
        if (imageUsedEnum.equals(ImageUsedEnum.合同资料)) {

            ListIterator<ImageInfoEntity> it = contractInfo.getImageInfoEntitys().listIterator();
            for (; it.hasNext();) {// 将游标定位到列表结尾
                it.next();
            }
            while (it.hasPrevious()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.previous();
                if (temp.equals(getTargetImageInfo())) {
                    if (it.hasPrevious()) {
                        setTargetImageInfo((ImageInfoEntity) it.previous());
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到第一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }
        } else if (imageUsedEnum.equals(ImageUsedEnum.公司资料)) {

            ListIterator<ImageInfoEntity> it = companyInfo.getImageInfoEntitys().listIterator();
            for (; it.hasNext();) {// 将游标定位到列表结尾
                it.next();
            }
            while (it.hasPrevious()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.previous();
                if (temp.equals(getTargetImageInfo())) {
                    if (it.hasPrevious()) {
                        setTargetImageInfo((ImageInfoEntity) it.previous());
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到第一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }
        } else if (imageUsedEnum.equals(ImageUsedEnum.考察资料)) {
            ListIterator<ImageInfoEntity> it = visitInfo.getImageInfoEntitys().listIterator();
            for (; it.hasNext();) {// 将游标定位到列表结尾
                it.next();
            }
            while (it.hasPrevious()) {
                ImageInfoEntity temp = (ImageInfoEntity) it.previous();
                if (temp.equals(getTargetImageInfo())) {
                    if (it.hasPrevious()) {
                        setTargetImageInfo((ImageInfoEntity) it.previous());
                    } else {
                        FacesMessage msg = new FacesMessage(SysInfo.警告.toString(), "已到第一张");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }
        }
    }
    public void createFolder(String folderName) {
        File file = new File(folderName);//在e盘的test文件夹下面 创建一个叫 a的文件夹   \\ 是转义用的  
        if (file.exists()) {
            System.out.println("文件夹" + folderName + "已经存在！");
        } else {
            //如果直接写下面的一句话，就会说：文件建立失败。因为父文件yyy不存在。
            //boolean file_true = file.mkdir();
            //但是写下面的这句话，就不会报错：文件夹建立失败。因为它会自动建立不存在的父文建夹。
            boolean file_true = file.mkdirs();
            if (file_true) {
                System.out.println("文件夹" + folderName + "建立成功");
            } else {
                System.out.println("文件夹" + folderName + "建立失败");
            }

        }
    }
    public void handleFileUpload(FileUploadEvent event) throws IOException {

        UploadedFile file = event.getFile();
        if (imageUsedEnum.equals(ImageUsedEnum.公司资料)) {
            companyUploadFiles.add(file);
        } else if (imageUsedEnum.equals(ImageUsedEnum.合同资料)) {
            contractUploadFiles.add(file);
        } else if (imageUsedEnum.equals(ImageUsedEnum.考察资料)) {
            visitUploadFiles.add(file);
        }

        //application code
    }
    public List<FrontUserEntity> findUser(String target)
    {
        List<FrontUserEntity> userFilter=frontUserEaoLocal.getUserByName("%"+target+"%");
        return userFilter;
    }
    public void endConversation()
    {
        System.out.println("setend");
//        conversation.setTimeout(1000);
        
    }
    @PreDestroy
    public void clear()
    {
//        System.out.println(conversation.isTransient());
//           System.out.println("///////////////////////////////////////////////////////end");
//           //conversation.end();
//         //如果Conversation不是“瞬时”的，则结束conversion，同时所有ConversationScoped的对象也会销毁
//        if (!conversation.isTransient()) {
//           System.out.println("///////////////////////////////////////////////////////end");
//           conversation.end();
//        }
    }
    public String issueBond() {
        
        getPtpSessionBean().getIssueBondLocal().issue();
        return "issueBond5";
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
     * @return the expenseEntitys
     */
    public List<ExpenseEntity> getExpenseEntitys() {
        return expenseEntitys;
    }

    /**
     * @param expenseEntitys the expenseEntitys to set
     */
    public void setExpenseEntitys(List<ExpenseEntity> expenseEntitys) {
        this.expenseEntitys = expenseEntitys;
    }

    /**
     * @return the bondInformationEntitys
     */
    public List<BondInformationEntity> getBondInformationEntitys() {
        return bondInformationEntitys;
    }

    /**
     * @param bondInformationEntitys the bondInformationEntitys to set
     */
    public void setBondInformationEntitys(List<BondInformationEntity> bondInformationEntitys) {
        this.bondInformationEntitys = bondInformationEntitys;
    }


    /**
     * @return the allAmount
     */
    public BigDecimal getAllAmount() {
        return allAmount;
    }

    /**
     * @param allAmount the allAmount to set
     */
    public void setAllAmount(BigDecimal allAmount) {
        this.allAmount = allAmount;
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
     * @return the defaultDate
     */
    public Date getDefaultDate() {
        return defaultDate;
    }

    /**
     * @param defaultDate the defaultDate to set
     */
    public void setDefaultDate(Date defaultDate) {
        this.defaultDate = defaultDate;
    }

    /**
     * @return the frontUserEditable
     */
    public Boolean getFrontUserEditable() {
        return frontUserEditable;
    }

    /**
     * @param frontUserEditable the frontUserEditable to set
     */
    public void setFrontUserEditable(Boolean frontUserEditable) {
        this.frontUserEditable = frontUserEditable;
    }

    /**
     * @return the frontUserEntitys
     */
    public List<FrontUserEntity> getFrontUserEntitys() {
        return frontUserEntitys;
    }

    /**
     * @param frontUserEntitys the frontUserEntitys to set
     */
    public void setFrontUserEntitys(List<FrontUserEntity> frontUserEntitys) {
        this.frontUserEntitys = frontUserEntitys;
    }

    /**
     * @return the frontUserEaoLocal
     */
    public FrontUserEaoLocal getFrontUserEaoLocal() {
        return frontUserEaoLocal;
    }

    /**
     * @param frontUserEaoLocal the frontUserEaoLocal to set
     */
    public void setFrontUserEaoLocal(FrontUserEaoLocal frontUserEaoLocal) {
        this.frontUserEaoLocal = frontUserEaoLocal;
    }

    /**
     * @return the bondEaoLocal
     */
    public BondEaoLocal getBondEaoLocal() {
        return bondEaoLocal;
    }

    /**
     * @param bondEaoLocal the bondEaoLocal to set
     */
    public void setBondEaoLocal(BondEaoLocal bondEaoLocal) {
        this.bondEaoLocal = bondEaoLocal;
    }

    /**
     * @return the targetFrontUser
     */
    public FrontUserEntity getTargetFrontUser() {
        return targetFrontUser;
    }

    /**
     * @param targetFrontUser the targetFrontUser to set
     */
    public void setTargetFrontUser(FrontUserEntity targetFrontUser) {
        this.targetFrontUser = targetFrontUser;
    }

    /**
     * @return the bond4
     */
    public BondEntity getBond4() {
        return bond4;
    }

    /**
     * @param bond4 the bond4 to set
     */
    public void setBond4(BondEntity bond4) {
        this.bond4 = bond4;
    }

    /**
     * @return the baseAmountEdit
     */
    public Boolean getBaseAmountEdit() {
        return baseAmountEdit;
    }

    /**
     * @param baseAmountEdit the baseAmountEdit to set
     */
    public void setBaseAmountEdit(Boolean baseAmountEdit) {
        this.baseAmountEdit = baseAmountEdit;
    }

    /**
     * @return the issueCopiesNumEdit
     */
    public Boolean getIssueCopiesNumEdit() {
        return issueCopiesNumEdit;
    }

    /**
     * @param issueCopiesNumEdit the issueCopiesNumEdit to set
     */
    public void setIssueCopiesNumEdit(Boolean issueCopiesNumEdit) {
        this.issueCopiesNumEdit = issueCopiesNumEdit;
    }

    /**
     * @return the bond4Edit
     */
    public BondEntity getBond4Edit() {
        return bond4Edit;
    }

    /**
     * @param bond4Edit the bond4Edit to set
     */
    public void setBond4Edit(BondEntity bond4Edit) {
        this.bond4Edit = bond4Edit;
    }

    /**
     * @return the guaranteeCaseEdit
     */
    public Boolean getGuaranteeCaseEdit() {
        return guaranteeCaseEdit;
    }

    /**
     * @param guaranteeCaseEdit the guaranteeCaseEdit to set
     */
    public void setGuaranteeCaseEdit(Boolean guaranteeCaseEdit) {
        this.guaranteeCaseEdit = guaranteeCaseEdit;
    }

    /**
     * @return the reverseGuaranteeCaseEdit
     */
    public Boolean getReverseGuaranteeCaseEdit() {
        return reverseGuaranteeCaseEdit;
    }

    /**
     * @param reverseGuaranteeCaseEdit the reverseGuaranteeCaseEdit to set
     */
    public void setReverseGuaranteeCaseEdit(Boolean reverseGuaranteeCaseEdit) {
        this.reverseGuaranteeCaseEdit = reverseGuaranteeCaseEdit;
    }

    /**
     * @return the riskControlDetailEdit
     */
    public Boolean getRiskControlDetailEdit() {
        return riskControlDetailEdit;
    }

    /**
     * @param riskControlDetailEdit the riskControlDetailEdit to set
     */
    public void setRiskControlDetailEdit(Boolean riskControlDetailEdit) {
        this.riskControlDetailEdit = riskControlDetailEdit;
    }

    /**
     * @return the imageUsedEnum
     */
    public ImageUsedEnum getImageUsedEnum() {
        return imageUsedEnum;
    }

    /**
     * @param imageUsedEnum the imageUsedEnum to set
     */
    public void setImageUsedEnum(ImageUsedEnum imageUsedEnum) {
        this.imageUsedEnum = imageUsedEnum;
    }

    /**
     * @return the contractImageUsedEnum
     */
    public ImageUsedEnum getContractImageUsedEnum() {
        return contractImageUsedEnum;
    }

    /**
     * @param contractImageUsedEnum the contractImageUsedEnum to set
     */
    public void setContractImageUsedEnum(ImageUsedEnum contractImageUsedEnum) {
        this.contractImageUsedEnum = contractImageUsedEnum;
    }

    /**
     * @return the companyImageUsedEnum
     */
    public ImageUsedEnum getCompanyImageUsedEnum() {
        return companyImageUsedEnum;
    }

    /**
     * @param companyImageUsedEnum the companyImageUsedEnum to set
     */
    public void setCompanyImageUsedEnum(ImageUsedEnum companyImageUsedEnum) {
        this.companyImageUsedEnum = companyImageUsedEnum;
    }

    /**
     * @return the visitImageUsedEnum
     */
    public ImageUsedEnum getVisitImageUsedEnum() {
        return visitImageUsedEnum;
    }

    /**
     * @param visitImageUsedEnum the visitImageUsedEnum to set
     */
    public void setVisitImageUsedEnum(ImageUsedEnum visitImageUsedEnum) {
        this.visitImageUsedEnum = visitImageUsedEnum;
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

    /**
     * @return the kkk
     */
    public String getKkk() {
        return kkk;
    }

    /**
     * @param kkk the kkk to set
     */
    public void setKkk(String kkk) {
        this.kkk = kkk;
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
