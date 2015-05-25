/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oakeel;

import com.oakeel.globaltool.RandomValidateCode;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class CounterBean {
    private Car selectCar;
    private int count;
    private List<Car> cars;
    private RandomValidateCode randomCode;
    /**
     * Creates a new instance of CounterBean
     */
    public CounterBean() {
        randomCode=new RandomValidateCode();
        randomCode.getRandcode();
        CarService service=new CarService();
        cars=service.createCars(10);
    }
    public void increment() {
        setCount(getCount() + 1);
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the cars
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * @param cars the cars to set
     */
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * @return the selectCar
     */
    public Car getSelectCar() {
        return selectCar;
    }

    /**
     * @param selectCar the selectCar to set
     */
    public void setSelectCar(Car selectCar) {
        this.selectCar = selectCar;
    }

    /**
     * @return the randomCode
     */
    public RandomValidateCode getRandomCode() {
        return randomCode;
    }

    /**
     * @param randomCode the randomCode to set
     */
    public void setRandomCode(RandomValidateCode randomCode) {
        this.randomCode = randomCode;
    }

}
