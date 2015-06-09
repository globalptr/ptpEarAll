/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.transaction;

import com.oakeel.ejb.entityAndEao.frontUser.FrontUserEntity;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author root
 */
@Local
public interface TestLocal {
    public void test(List<FrontUserEntity> list);
}
