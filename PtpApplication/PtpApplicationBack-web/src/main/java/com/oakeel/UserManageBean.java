/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import com.oakeel.ejb.entityAndEao.organization.OrganizationEaoLocal;
import com.oakeel.ejb.entityAndEao.organization.OrganizationEntity;
import com.oakeel.ejb.entityAndEao.user.UserEaoLocal;
import com.oakeel.ejb.entityAndEao.user.UserEntity;
import com.oakeel.ejb.ptpEnum.SysInfoEnum;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class UserManageBean {

    /**
     * Creates a new instance of UserManageBean
     */
    @EJB
    UserEaoLocal userEaoLocal;
    private UserEntity newUser=new UserEntity();
    private List<UserEntity> userEntitys;//用户表数据源
    private List<UserEntity> userFilter;//用户表数据源
    private TreeNode rootNode;//机构树根节点
    private TreeNode selectNode;//选择的机构树
    private List<OrganizationEntity> orglist;
    private UserEntity deleteUserEntity;
    @EJB
    OrganizationEaoLocal orginazationEaoLocal;
    
    public UserManageBean() {
    }
   
    @PostConstruct
    public void init()
    {
        orglist=orginazationEaoLocal.getAllEntitys();
        OrganizationEntity rootOrg=orginazationEaoLocal.getRoot();
        if(rootOrg!=null)
        {
            rootNode=new DefaultTreeNode("department",rootOrg , null);
            getAllNode(rootOrg,rootNode);
        }
        userEntitys=userEaoLocal.getAllEntitys();
        int i=0;
    }
     public void updateUser(RowEditEvent event) {
         UserEntity temp=(UserEntity) event.getObject();
         userEaoLocal.updateEntity(temp);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SysInfoEnum.提示.toString(), "修改成功！"));
    }
     public void deleteUser()
     {
         if(deleteUserEntity!=null)
         {
            userEaoLocal.removeEntity(deleteUserEntity);
            userEntitys=userEaoLocal.getAllEntitys();
         }
     }
     public void addNewUser()
     {

         if(!"".equals(newUser.getName()))
         {
            userEaoLocal.addEntity(newUser);
            newUser=new UserEntity();
            userEntitys=userEaoLocal.getAllEntitys();
         }
     }
    public void getAllNode(OrganizationEntity org,TreeNode node)
    {
        Set<OrganizationEntity> orglist=org.getChildOrganizationEntitys();
        TreeNode child = new DefaultTreeNode("department", org, node);
        if(!orglist.isEmpty())
        {
            Iterator i = orglist.iterator();//先迭代出来  
          
            while(i.hasNext()){//遍历  
                getAllNode((OrganizationEntity) i.next(),child);
            } 
        }
    }
    public void unclassedUser()
    {
        setUserFilter(userEaoLocal.getUnclassedUser());
        setUserEntitys(userEaoLocal.getUnclassedUser());
        int i=0;
    }
    public void allUser()
    {
        setUserFilter(userEaoLocal.getAllEntitys());
        setUserEntitys(userEaoLocal.getAllEntitys());
    }
    public List<OrganizationEntity> getAllOrganization()
    {
        return orginazationEaoLocal.getAllEntitys();
    }
    public void listOrganizationUsers_sub(OrganizationEntity org)
    {
        Set<OrganizationEntity> orgs=org.getChildOrganizationEntitys();
        for (OrganizationEntity temp : orgs) {
            Set<UserEntity> users=temp.getUserEntitys();
            for(UserEntity user:users)
            {
                getUserFilter().add(user);
                getUserEntitys().add(user);
            }
            listOrganizationUsers_sub(temp);
        }
    }


    /**
     * @return the rootNode
     */
    public TreeNode getRootNode() {
        return rootNode;
    }

    /**
     * @param rootNode the rootNode to set
     */
    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * @return the selectNode
     */
    public TreeNode getSelectNode() {
        return selectNode;
    }

    /**
     * @param selectNode the selectNode to set
     */
    public void setSelectNode(TreeNode selectNode) {
        this.selectNode = selectNode;
    }

    /**
     * @return the userEntitys
     */
    public List<UserEntity> getUserEntitys() {
        return userEntitys;
    }

    /**
     * @param userEntitys the userEntitys to set
     */
    public void setUserEntitys(List<UserEntity> userEntitys) {
        this.userEntitys = userEntitys;
    }

    /**
     * @return the orglist
     */
    public List<OrganizationEntity> getOrglist() {
        return orglist;
    }

    /**
     * @param orglist the orglist to set
     */
    public void setOrglist(List<OrganizationEntity> orglist) {
        this.orglist = orglist;
    }

    /**
     * @return the newUser
     */
    public UserEntity getNewUser() {
        return newUser;
    }

    /**
     * @param newUser the newUser to set
     */
    public void setNewUser(UserEntity newUser) {
        this.newUser = newUser;
    }

    /**
     * @return the deleteUserEntity
     */
    public UserEntity getDeleteUserEntity() {
        return deleteUserEntity;
    }

    /**
     * @param deleteUserEntity the deleteUserEntity to set
     */
    public void setDeleteUserEntity(UserEntity deleteUserEntity) {
        this.deleteUserEntity = deleteUserEntity;
    }

    /**
     * @return the userFilter
     */
    public List<UserEntity> getUserFilter() {
        return userFilter;
    }

    /**
     * @param userFilter the userFilter to set
     */
    public void setUserFilter(List<UserEntity> userFilter) {
        this.userFilter = userFilter;
    }
}
