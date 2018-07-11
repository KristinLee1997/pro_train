package com.kristin.java.design_pattern.factoryMethod;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/2 8:48
 * @desc
 **/
public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}
