package com.kristin.java.design_pattern.factoryMethod;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/2 8:51
 * @desc
 **/
public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }

    public String getOwner() {
        return owner;
    }
}
