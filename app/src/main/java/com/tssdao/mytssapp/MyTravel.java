package com.tssdao.mytssapp;

import java.io.Serializable;
import java.time.LocalTime;

public class MyTravel implements Serializable {
    private String arriveTimeEstimated;
    private String toDestinyTimeEstimated;
    private double totalPrice;

    public static String PREFIX = "my_travel";

    public MyTravel(String arriveTimeEstimated, String toDestinyTimeEstimated, double totalPrice) {
        this.arriveTimeEstimated =  arriveTimeEstimated;
        this.toDestinyTimeEstimated = toDestinyTimeEstimated;
        this.totalPrice = totalPrice;
    }

    public String getArriveTimeEstimated() {
        return arriveTimeEstimated;
    }

    public void setArriveTimeEstimated(String arriveTimeEstimated) {
        this.arriveTimeEstimated = arriveTimeEstimated;
    }

    public String getToDestinyTimeEstimated() {
        return toDestinyTimeEstimated;
    }

    public void setToDestinyTimeEstimated(String toDestinyTimeEstimated) {
        this.toDestinyTimeEstimated = toDestinyTimeEstimated;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
