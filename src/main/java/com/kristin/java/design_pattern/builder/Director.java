package com.kristin.java.design_pattern.builder;

/**
 * @author hang li
 * @since 2018/5/23
 * Builder设计模式--Direct指挥者
 */
public class Director {
    private Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public static void main(String[] args) {
        Builder builder = new CarBuilder();
        Car car = new Director(builder).createCar("engine", "transmission", "chassis");
        System.out.println(car);
    }

    public Car createCar(String engine, String transmission, String chassis) {
        builder.builderEngine(engine);
        builder.builderTransmission(transmission);
        builder.builderChassis(chassis);
        return builder.build();
    }
}
