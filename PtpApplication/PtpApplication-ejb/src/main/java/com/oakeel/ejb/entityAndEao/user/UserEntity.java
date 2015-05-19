/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.user;

import com.oakeel.ejb.entityAndEao.eeroot.EntityRoot;
import com.oakeel.ejb.entityAndEao.organization.OrganizationEntity;
import com.oakeel.ejb.entityAndEao.role.RoleEntity;
import com.oakeel.ejb.entityAndEao.userSet.UserSetEntity;
import com.oakeel.ejb.ptpEnum.CreateAccountModeEnum;
import com.oakeel.ejb.ptpEnum.SexEnum;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)  
public class UserEntity extends EntityRoot{

    public UserEntity() {
    }
 
    public UserEntity(String param,String password,CreateAccountModeEnum userEnum)
    {
        if(userEnum==CreateAccountModeEnum.用户名)
            this.name=param;
        if(userEnum==CreateAccountModeEnum.电话)
            this.telephone=param;
        if(userEnum==CreateAccountModeEnum.邮箱)
            this.email=param;
        this.password=password;
    }
    public UserEntity(String name,String telephone,String email,String password,int priority)
    {
        this.name=name;
        this.telephone=telephone;
        this.email=email;
        this.password=password;
        this.priority=priority;
    }
    public UserEntity(String name,String telephone,String email,String password,int priority,String qq)
    {
        this.name=name;
        this.telephone=telephone;
        this.email=email;
        this.password=password;
        this.priority=priority;
        this.qq=qq;
    }
    static long serialVersionUID = 1L;
    @Column(nullable=false)
    private String name;
    private int priority=0;
    @Column(nullable=false)
    private String password;
    
    private String telephone="";
    private String email="";
    private String qq="";
    private String salt="";
    private Boolean locked=false;
    private int age;//年龄
    @Enumerated(EnumType.STRING)
    private SexEnum sexEnum;
    //用户与机构是多对一关系，主控在用户
    @ManyToOne(cascade={CascadeType.MERGE})//级联修改user=>org
    private OrganizationEntity organizationEntity;
    //用户与角色是多对多的关系，主控在用户
    @ManyToMany(cascade={CascadeType.MERGE})//级联修改user=>role
    private Set<RoleEntity> roleEntitys=new HashSet<>();
    @OneToOne//用户与用户设置是一对一的关系
    UserSetEntity userSetEntity;


    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return the locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked the locked to set
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
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
     * @return the roleEntitys
     */
    public Set<RoleEntity> getRoleEntitys() {
        return roleEntitys;
    }

    /**
     * @param roleEntitys the roleEntitys to set
     */
    public void setRoleEntitys(Set<RoleEntity> roleEntitys) {
        this.roleEntitys = roleEntitys;
    }



    /**
     * @return the organizationEntity
     */
    public OrganizationEntity getOrganizationEntity() {
        return organizationEntity;
    }

    /**
     * @param organizationEntity the organizationEntity to set
     */
    public void setOrganizationEntity(OrganizationEntity organizationEntity) {
        this.organizationEntity = organizationEntity;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq the qq to set
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the sexEnum
     */
    public SexEnum getSexEnum() {
        return sexEnum;
    }

    /**
     * @param sexEnum the sexEnum to set
     */
    public void setSexEnum(SexEnum sexEnum) {
        this.sexEnum = sexEnum;
    }

 
    
}
