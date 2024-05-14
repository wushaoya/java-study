package com.wusy.designpatterns.behavioral.interpreter;

import com.sun.org.apache.xpath.internal.operations.And;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 14:01
 */
public class Client {
    public static void main(String[] args) {
        // 规则1   狗和猫是动物
        Expression dog = new TerminalExpression("狗");
        Expression cat = new TerminalExpression("猫");
        Expression judgeDog = new OrExpression(dog, cat);
        System.out.println("狗是动物?" + judgeDog.interpret("狗"));

        // 规则二 狗是犬科，猫是猫科
        Expression dog1 = new TerminalExpression("犬科");
        Expression cat1 = new TerminalExpression("猫科");
        Expression judgeDog1 = new AndExpression(dog, dog1);
        Expression judgeCat = new AndExpression(cat, cat1);
        System.out.println("狗是犬科动物?" + judgeDog1.interpret("狗 犬科"));
        System.out.println("狗是猫科动物?" + judgeDog1.interpret("狗 猫科"));
        System.out.println("猫是猫科动物?" + judgeCat.interpret("猫 猫科"));

    }
}
