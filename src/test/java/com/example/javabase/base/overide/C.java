package com.example.javabase.base.overide;

public class C extends B {

    @Override
    void m3() {
        System.out.print("C's m3 , " + (ivar + 6));
    }
}
