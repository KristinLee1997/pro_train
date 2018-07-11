package com.kristin.java.design_pattern.factoryMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/2 8:54
 * @desc
 **/
public class IDCardFactory extends Factory {
    private List owners = new ArrayList();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard) product).getOwner());
    }

    public List getOwners() {
        return owners;
    }
}
