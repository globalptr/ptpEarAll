/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author root
 */
@MappedSuperclass  
public class EntityRoot  implements Serializable {
    public EntityRoot()
    {
        uuid=UUID.randomUUID().toString();
    }
    private String uuid;

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
