/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel.ejb.entityAndEao.eeroot;

import java.util.List;


/**
 *
 * @author root
 */
public interface EaoRootLocal<T> {
    public void addEntity(T t);
    public List<T> getAllEntitys();
    public void updateEntity(T t);
    public void removeEntity(T t);
    public T findEntityById(String uuid);
    public T reflushEntity(T t);
}
