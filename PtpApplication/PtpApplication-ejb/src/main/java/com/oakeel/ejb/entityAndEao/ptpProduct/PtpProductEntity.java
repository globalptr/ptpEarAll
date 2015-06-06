/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.ptpProduct;

import com.oakeel.ejb.entityAndEao.backUser.BackUserEntity;
import com.oakeel.ejb.entityAndEao.bondState.BondStateEntity;
import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.expense.ExpenseEntity;
import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import com.oakeel.ejb.entityAndEao.frontUserHoldBond.FrontUserHoldBondEntity;
import com.oakeel.ejb.ptpEnum.BondStage;
import com.oakeel.ejb.ptpEnum.RepayModelEnum;
import com.oakeel.ejb.ptpEnum.SplitUnit;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  
public class PtpProductEntity extends EntityRoot {
    private static final long serialVersionUID = 1L;
    public PtpProductEntity()
    {
        Random rd = new Random();
        String n="";
        int getNum;
        do {
            //getNum = Math.abs(rd.nextInt())%10;//产生数字0-9的随机数
            getNum = Math.abs(rd.nextInt())%26 + 97;//产生字母a-z的随机数
            char num1 = (char)getNum;
            String dn = Character.toString(num1);
            n += dn;
        } while (n.length()<6);
        Date ddate=new Date();  
        bondNumber=(new SimpleDateFormat("yyyyMMddHHmmss")).format(ddate)+n;
    }
    @ManyToOne
    private BackUserEntity issueAdmin;//后台发标人
    @ManyToOne
    private FrontUserEntity issueUser;//发标用户
    @Enumerated(EnumType.STRING)
    private BondStage bondStage;//标的阶段
    @Temporal(TemporalType.DATE)
    private Date startDate;//开始时间
    @Column(length = 50)
    private String name;//名字
    @Column(length = 100)
    private String Details;//详情  
    private BigDecimal yearRate=new BigDecimal("0");//年利率
    @Column(length = 50)
    private String bondNumber;//标号
    private int baseAmount;//基准金额
    private int IssueCopiesNum;//发行份数
    private int transactionCopiesNum;//成交份数
    private int remainCopiesNum;//剩余份数
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private RepayModelEnum repayModelEnum;//还款模型
    @Enumerated(EnumType.STRING)
    private SplitUnit repayCycle;//还款周期
    private int repayCycleNumber;//期数
    @OneToOne(cascade = {CascadeType.ALL})//标的状态
    private BondStateEntity bondStateEntity=new BondStateEntity();
    @OneToMany(cascade = {CascadeType.PERSIST})//与支出明细是一对多的关系
    private List<ExpenseEntity> expenseEntitys=new ArrayList<>();//支出明细
    @OneToMany(mappedBy="ptpProductEntity")
    Set<FrontUserHoldBondEntity> frontUserHoldBondEntitys;//投标人
    private Boolean active=true;//是否激活
    /**
     * @return the bondStateEntity
     */
    public BondStateEntity getBondStateEntity() {
        return bondStateEntity;
    }

    /**
     * @param bondStateEntity the bondStateEntity to set
     */
    public void setBondStateEntity(BondStateEntity bondStateEntity) {
        this.bondStateEntity = bondStateEntity;
    }

    /**
     * @return the bondStage
     */
    public BondStage getBondStage() {
        return bondStage;
    }

    /**
     * @param bondStage the bondStage to set
     */
    public void setBondStage(BondStage bondStage) {
        this.bondStage = bondStage;
    }

    /**
     * @return the repayCycle
     */
    public SplitUnit getRepayCycle() {
        return repayCycle;
    }

    /**
     * @param repayCycle the repayCycle to set
     */
    public void setRepayCycle(SplitUnit repayCycle) {
        this.repayCycle = repayCycle;
    }
    

    /**
     * @return the repayCycleNumber
     */
    public int getRepayCycleNumber() {
        return repayCycleNumber;
    }

    /**
     * @param repayCycleNumber the repayCycleNumber to set
     */
    public void setRepayCycleNumber(int repayCycleNumber) {
        this.repayCycleNumber = repayCycleNumber;
    }

    /**
     * @return the bondNumber
     */
    public String getBondNumber() {
        return bondNumber;
    }

    /**
     * @param bondNumber the bondNumber to set
     */
    public void setBondNumber(String bondNumber) {
        this.bondNumber = bondNumber;
    }
    

    /**
     * @return the repayModelEnum
     */
    public RepayModelEnum getRepayModelEnum() {
        return repayModelEnum;
    }

    /**
     * @param repayModelEnum the repayModelEnum to set
     */
    public void setRepayModelEnum(RepayModelEnum repayModelEnum) {
        this.repayModelEnum = repayModelEnum;
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
     * @return the remainCopiesNum
     */
    public int getRemainCopiesNum() {
        return remainCopiesNum;
    }

    /**
     * @param remainCopiesNum the remainCopiesNum to set
     */
    public void setRemainCopiesNum(int remainCopiesNum) {
        this.remainCopiesNum = remainCopiesNum;
    }

    /**
     * @return the transactionCopiesNum
     */
    public int getTransactionCopiesNum() {
        return transactionCopiesNum;
    }

    /**
     * @param transactionCopiesNum the transactionCopiesNum to set
     */
    public void setTransactionCopiesNum(int transactionCopiesNum) {
        this.transactionCopiesNum = transactionCopiesNum;
    }

    /**
     * @return the IssueCopiesNum
     */
    public int getIssueCopiesNum() {
        return IssueCopiesNum;
    }

    /**
     * @param IssueCopiesNum the IssueCopiesNum to set
     */
    public void setIssueCopiesNum(int IssueCopiesNum) {
        this.IssueCopiesNum = IssueCopiesNum;
    }

    /**
     * @return the baseAmount
     */
    public int getBaseAmount() {
        return baseAmount;
    }

    /**
     * @param baseAmount the baseAmount to set
     */
    public void setBaseAmount(int baseAmount) {
        this.baseAmount = baseAmount;
    }

    /**
     * @return the yearRate
     */
    public BigDecimal getYearRate() {
        return yearRate;
    }

    /**
     * @param yearRate the yearRate to set
     */
    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    /**
     * @return the Details
     */
    public String getDetails() {
        return Details;
    }

    /**
     * @param Details the Details to set
     */
    public void setDetails(String Details) {
        this.Details = Details;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the issueAdmin
     */
    public BackUserEntity getIssueAdmin() {
        return issueAdmin;
    }

    /**
     * @param issueAdmin the issueAdmin to set
     */
    public void setIssueAdmin(BackUserEntity issueAdmin) {
        this.issueAdmin = issueAdmin;
    }

    /**
     * @return the issueUser
     */
    public FrontUserEntity getIssueUser() {
        return issueUser;
    }

    /**
     * @param issueUser the issueUser to set
     */
    public void setIssueUser(FrontUserEntity issueUser) {
        this.issueUser = issueUser;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

}
