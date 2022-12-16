package com.tssdao.mytssapp;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MyTravel implements Serializable {
    private String arriveTimeEstimated;
    private String toDestinyTimeEstimated;
    private double totalPrice;
    private Agencias agenciesFromMyCarCome;
    private int numberOfCars;
    private int numberOfPassanger;

    public static String PREFIX = "my_travel";

    public MyTravel(String arriveTimeEstimated, String toDestinyTimeEstimated, double totalPrice, Agencias agencyFromMyCarCome, int numberOfCars, int numberOfPassanger) {
        this.arriveTimeEstimated =  arriveTimeEstimated;
        this.toDestinyTimeEstimated = toDestinyTimeEstimated;
        this.totalPrice = totalPrice;
        this.agenciesFromMyCarCome = agencyFromMyCarCome;
        this.numberOfCars = numberOfCars;
        this.numberOfPassanger = numberOfPassanger;
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

    public Agencias getAgenciesFromMyCarCome() {
        return agenciesFromMyCarCome;
    }

    public void setAgenciesFromMyCarCome(Agencias agenciesFromMyCarCome) {
        this.agenciesFromMyCarCome = agenciesFromMyCarCome;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public int getNumberOfPassanger() {
        return numberOfPassanger;
    }

    public void setNumberOfPassanger(int numberOfPassanger) {
        this.numberOfPassanger = numberOfPassanger;
    }
}
