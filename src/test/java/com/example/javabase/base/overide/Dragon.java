package com.example.javabase.base.overide;

public class Dragon extends Monster {

    @Override
    boolean frighten(int x) {

        System.out.println("breath fire");
        return true;
    }
}
