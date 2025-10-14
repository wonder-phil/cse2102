package com.example;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Mallard Duck: quack!");
    }
    
    @Override
    public void fly() {
        System.out.println("I am a flying Mallard Duck!");
    }
}