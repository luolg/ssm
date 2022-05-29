package com.luolg.cglib;

import com.luolg.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        // create the target object
         Target target = new Target();

        // get the enhanced object
         Advice advice = new Advice();

//        // return the dynamically generated proxy object based on jdk reflect
//        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
//                //target object class loader
//                target.getClass().getClassLoader(),
//                // target object interface array
//                target.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    // invoke proxy object any methods, actually executing the invoke method
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//                        advice.before(); //before enhance
//
//                        method.invoke(target, args);  //execute target object methods
//
//                        advice.after(); //after enhance
//                        return null;
//                    }
//                }
//        );
//
//        // invoke the proxy object methods
//        proxy.save();

        //return the dynamically generated proxy object based on cglib
        // 1 create enhancer

        Enhancer enhancer = new Enhancer();
        // 2 set the super class
        enhancer.setSuperclass(Target.class);
        // 3 set recall
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before(); //execute before enhance

                Object invoke = method.invoke(target, args);  // execute target

                advice.after();  // execute after enhance

                return invoke;
            }
        });
        // 4 generate the proxy object
        Target proxy = (Target) enhancer.create();


        proxy.save();

    }
}
