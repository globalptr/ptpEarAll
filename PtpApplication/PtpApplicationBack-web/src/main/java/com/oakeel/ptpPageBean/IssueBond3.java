/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oakeel.ptpPageBean;

import com.oakeel.PtpSessionBean;
import com.oakeel.RepayItem;
import com.oakeel.ejb.entityAndEao.bond.BondEntity;
import com.oakeel.ejb.entityAndEao.expense.ExpenseEntity;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEaoLocal;
import com.oakeel.ejb.entityAndEao.sysSet.SysSetEntity;
import com.oakeel.ejb.ptpEnum.RepayModelEnum;
import com.oakeel.ejb.ptpEnum.SplitUnit;
import com.oakeel.ejb.ptpEnum.SysInfo;
import com.oakeel.ejb.transaction.RepayModelCaculate.RepayModelCaculateLocal;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class IssueBond3 implements Serializable {

    @EJB
    SysSetEaoLocal SysSetEaoLocal;
    @EJB
    RepayModelCaculateLocal repayModelCaculateLocal;
    private List<ExpenseEntity> expenseEntitys;
    private List<RepayModelEnum> repayModelList;//还款模型枚举列表
    private BondEntity bond3;
    @Inject
    private PtpSessionBean ptpSessionBean;
    private List<RepayItem> repayItemList = new ArrayList<>();//计算得出还款的清单
    private List<SplitUnit> splitUnit;//还款单元（年月日）
    

    @PostConstruct
    public void init() {
        setSplitUnit(Arrays.asList(SplitUnit.values()));
        setRepayModelList(Arrays.asList(RepayModelEnum.values()));
        setBond3(new BondEntity());
        
        List<SysSetEntity> syss=SysSetEaoLocal.getAllEntitys();
        if(!syss.isEmpty())
        {
            bond3.setBaseAmount(syss.get(0).getDefaultBaseAmount());
            bond3.setYearRate(syss.get(0).getDefaultYearRate());
        }
        //setAllAmount(new BigDecimal("200000"));
    }

    public void caculateModel() {

        //根据输入和选择的还款模型计算还款列表
        try {
            Integer baseAmount=bond3.getBaseAmount()*bond3.getCopiesNum();
            BigDecimal allAmount=new BigDecimal(baseAmount.toString());
            setExpenseEntitys(repayModelCaculateLocal.caculateRepayModel(bond3.getRepayModelEnum(), bond3.getRepayCycle(), allAmount, bond3.getYearRate().multiply(BigDecimal.valueOf(0.01), MathContext.DECIMAL32), bond3.getRepayCycleNumber(), bond3.getStartDate()));
//            getRepayItemList().clear();
            //计算还款模型输入还款模型、还款单元、贷款总额、年利率、还款周期、开始时间
//            RepayModelCaculate.caculateRepayModel(RepayModelEnum.定额本息, SplitUnit.月, new BigDecimal("200000"), new BigDecimal("21.5").multiply(BigDecimal.valueOf(0.01),MathContext.DECIMAL32), 24, new Date(), repayItemList);
//            RepayModelCaculate.caculateRepayModel(bond3.getRepayModelEnum(), bond3.getRepayCycle(), getAllAmount(), bond3.getYearRate().multiply(BigDecimal.valueOf(0.01), MathContext.DECIMAL32), bond3.getRepayCycleNumber(), bond3.getStartDate(), getRepayItemList());
//            RepayModelCaculate.caculateRepayModel(bond3.getRepayModelEnum(), SplitUnit.月, new BigDecimal("200000"), new BigDecimal("21").multiply(BigDecimal.valueOf(0.01),MathContext.DECIMAL32), 500, new Date(), getRepayItemList());
            bond3 = new BondEntity();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    /**
     * Creates a new instance of issueBond3
     */
    public IssueBond3() {
    }

    public String toNextStep() {
        if(ptpSessionBean.getIssueBondLocal().getCurrBond()==null)
        {
            FacesContext context=FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler handler=(ConfigurableNavigationHandler)context.getApplication().getNavigationHandler();
            context.addMessage(null, new FacesMessage(SysInfo.提示.toString(),  "融资标实体未初始化!") );
            handler.performNavigation("issueBond1");
        }
        ptpSessionBean.getIssueBondLocal().setStep3Bond(getBond3());
        ptpSessionBean.getIssueBondLocal().setExpense(expenseEntitys);
        ptpSessionBean.getIssueBondLocal().issuePreview();
        System.out.println("ok");
        return "issueBond4";
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
     * @return the bond3
     */
    public BondEntity getBond3() {
        return bond3;
    }

    /**
     * @param bond3 the bond3 to set
     */
    public void setBond3(BondEntity bond3) {
        this.bond3 = bond3;
    }

    /**
     * @return the repayItemList
     */
    public List<RepayItem> getRepayItemList() {
        System.out.println("flush");
        return repayItemList;
    }

    /**
     * @param repayItemList the repayItemList to set
     */
    public void setRepayItemList(List<RepayItem> repayItemList) {
        this.repayItemList = repayItemList;
    }

    /**
     * @return the repayModelList
     */
    public List<RepayModelEnum> getRepayModelList() {
        return repayModelList;
    }

    /**
     * @param repayModelList the repayModelList to set
     */
    public void setRepayModelList(List<RepayModelEnum> repayModelList) {
        this.repayModelList = repayModelList;
    }

    /**
     * @return the splitUnit
     */
    public List<SplitUnit> getSplitUnit() {
        return splitUnit;
    }

    /**
     * @param splitUnit the splitUnit to set
     */
    public void setSplitUnit(List<SplitUnit> splitUnit) {
        this.splitUnit = splitUnit;
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

}
