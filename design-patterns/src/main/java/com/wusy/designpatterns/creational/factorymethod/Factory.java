package com.wusy.designpatterns.creational.factorymethod;

/**
 * @Author wushaoya
 * @date 2024-04-15
 * Time: 15:57
 */
public class Factory {
    public static Product getProduct(String productType){
        if(productType == null){
            return null;
        }
        if(productType.equalsIgnoreCase("A")){
            return new ProductA();
        } else if(productType.equalsIgnoreCase("B")){
            return new ProductB();
        }
        return null;
    }
}
