package com.luolg.cglib;

public class Advice {
    public void before(){
        System.out.println("before enhance ...");
    }

    public void after(){
        System.out.println("after enhance ...");
    }
}
