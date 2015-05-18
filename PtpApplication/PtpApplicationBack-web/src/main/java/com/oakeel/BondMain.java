/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class BondMain {

    private CartesianChartModel dateModel;
    private CartesianChartModel dateModelx;
    /**
     * Creates a new instance of BondMain
     */
    public BondMain() {
    }
    @PostConstruct
    public void init()
    {
        dateModel = new BarChartModel();
        BarChartSeries series1 = new BarChartSeries();
        series1.setLabel("Series 1");
 
        series1.set("2014-01-01", 51);
        series1.set("2014-01-02", 29);
        series1.set("2014-01-03", 35);
        series1.set("2014-01-04", 96);
        series1.set("2014-01-05", 26);
        series1.set("2014-01-06", 48);
        series1.set("2014-01-07", 65);
        series1.set("2014-01-08", 75);
        series1.set("2014-01-09", 67);
        series1.set("2014-01-10", 29);
        series1.set("2014-01-11", 49);
        series1.set("2014-01-12", 65);
        series1.set("2014-01-18", 74);
        series1.set("2014-01-24", 24);
        series1.set("2014-01-30", 51);
 
 
        dateModel.addSeries(series1);
         
        dateModel.setTitle("2015年1月标额进度表");
        dateModel.setZoom(true);
        dateModel.getAxis(AxisType.Y).setLabel("标额");
        dateModel.getAxis(AxisType.X).setTickAngle(-50);
        dateModel.setShowPointLabels(true);

        
                dateModelx = new BarChartModel();
        BarChartSeries series2 = new BarChartSeries();
        series2.setLabel("Series 1");
 
        series2.set("2014-01-01", 51);
        series2.set("2014-01-02", 29);
        series2.set("2014-01-03", 35);
        series2.set("2014-01-04", 96);
        series2.set("2014-01-05", 26);
        series2.set("2014-01-06", 48);
        series2.set("2014-01-07", 65);
        series2.set("2014-01-08", 75);
        series2.set("2014-01-09", 67);
        series2.set("2014-01-10", 29);
        series2.set("2014-01-11", 49);
        series2.set("2014-01-12", 65);
        series2.set("2014-01-18", 74);
        series2.set("2014-01-24", 24);
        series2.set("2014-01-30", 51);
 
 
        dateModelx.addSeries(series2);
         
        dateModelx.setTitle("2015年1月标额进度表");
        dateModelx.setZoom(true);
        dateModelx.getAxis(AxisType.Y).setLabel("标额");
        dateModelx.getAxis(AxisType.X).setTickAngle(-50);
        dateModelx.setShowPointLabels(true);
    }

    /**
     * @return the dateModel
     */
    public CartesianChartModel getDateModel() {
        return dateModel;
    }

    /**
     * @param dateModel the dateModel to set
     */
    public void setDateModel(CartesianChartModel dateModel) {
        this.dateModel = dateModel;
    }

    /**
     * @return the dateModelx
     */
    public CartesianChartModel getDateModelx() {
        return dateModelx;
    }

    /**
     * @param dateModelx the dateModelx to set
     */
    public void setDateModelx(CartesianChartModel dateModelx) {
        this.dateModelx = dateModelx;
    }
}
