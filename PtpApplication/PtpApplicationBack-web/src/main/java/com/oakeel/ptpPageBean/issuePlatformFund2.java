/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ptpPageBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.RepayItem;
import com.oakeel.ejb.entityAndEao.expense.ExpenseEntity;
import com.oakeel.ejb.entityAndEao.platformFund.PlatformFundEntity;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEaoLocal;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEntity;
import com.oakeel.ejb.ptpEnum.RepayModelEnum;
import com.oakeel.ejb.ptpEnum.SplitUnit;
import com.oakeel.ejb.transaction.RepayModelCaculate.RepayModelCaculateLocal;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class issuePlatformFund2 {

    @EJB
    SysSetEaoLocal SysSetEaoLocal;
    @EJB
    RepayModelCaculateLocal repayModelCaculateLocal;
    private List<ExpenseEntity> expenseEntitys;
    private RepayModelEnum[] repayModelList;//还款模型枚举列表
    private PlatformFundEntity platformFundEntity2;
    @Inject
    private PtpSessionBean ptpSessionBean;
    private List<RepayItem> repayItemList = new ArrayList<>();//计算得出还款的清单
    private SplitUnit[] splitUnit;//还款单元（年月日）
    @PostConstruct
    public void init()
    {
        repayModelList=RepayModelEnum.values();
        setSplitUnit(SplitUnit.values());
        platformFundEntity2=new PlatformFundEntity();
        platformFundEntity2.setYearRate(ptpSessionBean.getIssuePlatformFundLocal().getPlatformFundEntity1().getYearRate());
        List<SysSetEntity> syss = SysSetEaoLocal.getAllEntitys();

        if (ptpSessionBean.getIssuePlatformFundLocal().getPlatformFundEntity2() != null) {
            platformFundEntity2=ptpSessionBean.getIssuePlatformFundLocal().getPlatformFundEntity2();
        }
        else
        {
            platformFundEntity2=new PlatformFundEntity();
            if (!syss.isEmpty()) {
                platformFundEntity2.setBaseAmount(syss.get(0).getDefaultBaseAmount());
                platformFundEntity2.setYearRate(syss.get(0).getDefaultYearRate());
            }
        }
    }
    public String toNextStep()
    {
        platformFundEntity2.setExpenseEntitys(expenseEntitys);
        ptpSessionBean.getIssuePlatformFundLocal().setPlatformFundEntity2(platformFundEntity2);
        ptpSessionBean.getIssuePlatformFundLocal().issuePreview();
        platformFundEntity2 = new PlatformFundEntity();
        return "issuePlatformFund3";
    }
    public void caculateModel() {

        //根据输入和选择的还款模型计算还款列表
        try {
            Integer baseAmount = platformFundEntity2.getBaseAmount() * platformFundEntity2.getIssueCopiesNum();
            BigDecimal allAmount = new BigDecimal(baseAmount.toString());
            
//            expenseEntitys=repayModelCaculateLocal.caculateRepayModel(RepayModelEnum.定额本息, SplitUnit.月, new BigDecimal("200000"), new BigDecimal("21.5").multiply(BigDecimal.valueOf(0.01),MathContext.DECIMAL32), 24, new Date());
            expenseEntitys=repayModelCaculateLocal.caculateRepayModel(platformFundEntity2.getRepayModelEnum(), platformFundEntity2.getRepayCycle(), allAmount, platformFundEntity2.getYearRate().multiply(BigDecimal.valueOf(0.01), MathContext.DECIMAL32), platformFundEntity2.getRepayCycleNumber(), platformFundEntity2.getStartDate());
            

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    /**
     * Creates a new instance of issuePlatformFund2
     */
    public issuePlatformFund2() {
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
     * @return the repayItemList
     */
    public List<RepayItem> getRepayItemList() {
        return repayItemList;
    }

    /**
     * @param repayItemList the repayItemList to set
     */
    public void setRepayItemList(List<RepayItem> repayItemList) {
        this.repayItemList = repayItemList;
    }

    /**
     * @return the platformFundEntity2
     */
    public PlatformFundEntity getPlatformFundEntity2() {
        return platformFundEntity2;
    }

    /**
     * @param platformFundEntity2 the platformFundEntity2 to set
     */
    public void setPlatformFundEntity2(PlatformFundEntity platformFundEntity2) {
        this.platformFundEntity2 = platformFundEntity2;
    }

    /**
     * @return the repayModelList
     */
    public RepayModelEnum[] getRepayModelList() {
        return repayModelList;
    }

    /**
     * @param repayModelList the repayModelList to set
     */
    public void setRepayModelList(RepayModelEnum[] repayModelList) {
        this.repayModelList = repayModelList;
    }

    /**
     * @return the splitUnit
     */
    public SplitUnit[] getSplitUnit() {
        return splitUnit;
    }

    /**
     * @param splitUnit the splitUnit to set
     */
    public void setSplitUnit(SplitUnit[] splitUnit) {
        this.splitUnit = splitUnit;
    }
    
}
