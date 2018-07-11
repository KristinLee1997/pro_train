package com.kristin.java.design_pattern.builder;

/**
 * @author hang li
 * @since 2018/5/23
 * Builder设计模式--具体Builder
 */
public class CarBuilder extends Builder {
    private Car car = new Car();

    @Override
    public void builderEngine(String engine) {
        car.setEngine(engine);
    }

    @Override
    public void builderTransmission(String transmission) {
        car.setTransmission(transmission);
    }

    @Override
    public void builderChassis(String chassis) {
        car.setChassis(chassis);
    }

    @Override
    public Car build() {
        return car;
    }
}
