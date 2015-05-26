/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import com.oakeel.globaltool.RandomValidateCode;
import com.oakeel.globaltool.ValidateCode;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileCacheImageOutputStream;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class NewJSFManagedBean {
    
    private ValidateCode randomCode;
    private StreamedContent image;    
    private StreamedContent graphicText;
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean(){

    }
    public StreamedContent getImage() {
    return this.image;
    }
    public String test()
    {
        return "issueBond2";
    }
   @PostConstruct
    public void init() {
        try {
            //Graphic Text
            BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImg.createGraphics();
            g2.drawString("This is a text", 0, 10);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImg, "png", os);
            graphicText=new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @return the randomCode
     */
    public ValidateCode getRandomCode() {
        return randomCode;
    }

    /**
     * @param randomCode the randomCode to set
     */
    public void setRandomCode(ValidateCode randomCode) {
        this.randomCode = randomCode;
    }

    /**
     * @param image the image to set
     */
    public void setImage(StreamedContent image) {
        this.image = image;
    }

    /**
     * @return the graphicText
     */
    public StreamedContent getGraphicText() {
        return graphicText;
    }

    /**
     * @param graphicText the graphicText to set
     */
    public void setGraphicText(StreamedContent graphicText) {
        this.graphicText = graphicText;
    }

}
