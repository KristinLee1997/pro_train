package com.kristin.java.design_pattern.builder;

/**
 * @author hang li
 * @since 2018/5/23
 * Builder设计模式--Builder
 */
public abstract class Builder {
    public abstract void builderEngine(String engine);

    public abstract void builderTransmission(String transmission);

    public abstract void builderChassis(String chassis);

    public abstract Car build();
}
