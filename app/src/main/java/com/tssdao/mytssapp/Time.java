package com.tssdao.mytssapp;

public class Time {
    public double distance;
    public double time;
    public Time(double distance){
        this.distance = distance;
        time = 0.0;
    }

    public double getTime() {
        time = (getDistance()/30)*60;
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
