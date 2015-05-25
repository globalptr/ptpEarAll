/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import com.oakeel.globaltool.ValidateCode;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.imageio.ImageIO;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class RandomImage {

    private StreamedContent graphicText;
    private ValidateCode validateCode;
   @PostConstruct
    public void init() {
        validateCode=new ValidateCode(200,50,4,10);
        validateCode.createCode();
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
     * Creates a new instance of Random
     */
    public RandomImage() {
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

    /**
     * @return the validateCode
     */
    public ValidateCode getValidateCode() {
        return validateCode;
    }

    /**
     * @param validateCode the validateCode to set
     */
    public void setValidateCode(ValidateCode validateCode) {
        this.validateCode = validateCode;
    }
    
}
