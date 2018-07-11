package com.kristin.java.design_pattern.builder;

/**
 * @author hang li
 * @since 2018/5/23
 * Builder设计模式--Product
 */
public class Car {
    private String engine;

    private String transmission;

    private String chassis;

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", chassis='" + chassis + '\'' +
                '}';
    }
}
