package com.wusy.designpatterns.creational.abstractfactory;

/**
 * @Author wushaoya
 * @date 2024-04-12
 * Time: 15:39
 */
public class Client {
    public static Factory getFactory(String factoryType){
        if(factoryType == null){
            return null;
        }
        if(factoryType.equalsIgnoreCase("A")){
            return new FactoryA();
        } else if(factoryType.equalsIgnoreCase("B")){
            return new FactoryB();
        }
        return null;
    }
    public static void main(String[] args) {
        // 创建具体工厂A
        Factory factoryA = getFactory("A");
        // 使用具体工厂A创建产品
        Product productA = factoryA.create();
        // 操作产品A
        productA.produce();

        // 创建具体工厂B
        Factory factoryB = getFactory("B");
        // 使用具体工厂B创建产品
        Product productB = factoryB.create();
        // 操作产品B
        productB.produce();
    }
}
