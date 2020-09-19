package com.example.javabase.base.overide;


import org.junit.Test;

public class BaseTest {


    @Test
    public void test01() {

        A a = new A();
        B b = new B();
        C c = new C();
        A a2 = new C();

        b.m1();
        c.m2();
        a.m3();
        System.out.println();
        System.out.println("---------------------------------------------------");

        c.m1();
        c.m2();
        c.m3();
        System.out.println();
        System.out.println("---------------------------------------------------");

        a.m1();
        b.m2();
        c.m3();
        System.out.println();
        System.out.println("---------------------------------------------------");

        a2.m1();
        a2.m2();
        a2.m3();
        System.out.println();
        System.out.println("---------------------------------------------------");

    }


    @Test
    public void test02() {
        Monster[] ma = new Monster[3];
        ma[0] = new Vampire();
        ma[1] = new Dragon();
        ma[2] = new Monster();

        for (int i = 0; i < 3; i++) {
            ma[i].frighten(i);
        }
    }
}
