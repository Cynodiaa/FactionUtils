package com.flareye.ontime.utils;

public class dateSystem {
    public static dateConverter convertMiliseconds(Long miliseconds) {
        dateConverter converter = new dateConverter();
        converter.setMiliseconds(miliseconds);
        converter.setSeconds((int) (miliseconds / 1000));
        converter.setHours(converter.seconds / 60);
        converter.setDays(converter.hours / 24);
        return converter;
    }
}
