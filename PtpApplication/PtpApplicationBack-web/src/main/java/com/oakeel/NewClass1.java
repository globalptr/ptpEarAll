/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named

@ConversationScoped
public class NewClass1 implements Serializable{
    private String str="11112";
    @Inject Conversation conversation;
    @PostConstruct
    public void init()
    {
                 //仅当前页面未被post提交，且conversation是"瞬时"性时，才开始conversation
       
        System.out.println("newbean");
    }
    public void tt()
    {
        if (conversation.isTransient()) {
            System.out.println("///////////////////////////////////////////////////////start");
            conversation.begin();
            conversation.setTimeout(100000);
        }
    }
    @PreDestroy
    public void endd()
    {
        System.out.println(conversation.isTransient());
        conversation.end();
    }
    public void tx()
    {
        System.out.println("settime");
        conversation.setTimeout(1000);
        
    }
    public void addStr()
    {
        setStr(getStr() + "1");
    }

    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(String str) {
        this.str = str;
    }
}
