package com.flareye.ontime.utils;

public class dateConverter {
    public Long miliseconds;
    public int seconds;
    public int minutes;
    public int hours;
    public int days;

    public dateConverter setMiliseconds(Long miliseconds) {
        this.miliseconds = miliseconds;
        return this;
    }

    public dateConverter setSeconds(int seconds) {
        this.seconds = seconds;
        return this;
    }

    public dateConverter setMinutes(int minutes) {
        this.minutes = minutes;
        return this;
    }

    public dateConverter setHours(int hours) {
        this.hours = hours;
        return this;
    }

    public dateConverter setDays(int days) {
        this.days = days;
        return this;
    }
}
