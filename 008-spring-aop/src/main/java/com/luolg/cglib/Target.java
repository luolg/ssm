package com.luolg.cglib;

import com.luolg.proxy.jdk.TargetInterface;

// jdk dynamically proxy
//public class Target implements TargetInterface {
//
//    @Override
//    public void save() {
//        System.out.println("save running based on jdk reflect...");
//    }
//}

public class Target {
    public void save(){
        System.out.println("save running based on cglib");
    }
}