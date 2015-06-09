/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.folder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
public class NewEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(targetEntity = NewEntity1.class,mappedBy="sss")
    private List<NewEntity1> kkk=new ArrayList<>();
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewEntity1)) {
            return false;
        }
        NewEntity1 other = (NewEntity1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oakeel.ejb.entityAndEao.folder.NewEntity1[ id=" + id + " ]";
    }


    private String test;

    /**
     * @return the test
     */
    public String getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(String test) {
        this.test = test;
    }


    /**
     * @return the kkk
     */
    public List<NewEntity1> getKkk() {
        return kkk;
    }

    /**
     * @param kkk the kkk to set
     */
    public void setKkk(List<NewEntity1> kkk) {
        this.kkk = kkk;
    }

  
}
