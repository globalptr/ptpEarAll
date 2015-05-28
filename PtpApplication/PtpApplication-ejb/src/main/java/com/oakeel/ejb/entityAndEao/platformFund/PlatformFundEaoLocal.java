/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.platformFund;

import com.oakeel.ejb.entityAndEao.eeroot.EaoRootLocal;
import com.oakeel.ejb.entityAndEao.ptpProduct.PtpProductEntity;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PlatformFundEaoLocal extends EaoRootLocal<PlatformFundEntity> {
    
}
