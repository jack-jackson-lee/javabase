package com.example.javabase.base.overide;

public class Vampire extends Monster {
    @Override
    boolean frighten(int x) {
        System.out.println("arrrgh");
        return true;
    }
}
