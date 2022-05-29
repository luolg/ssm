package com.luolg.service;


import com.luolg.exception.MyException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public void show1() {
        System.out.println("throw type change error");
        Object str = "jack";
        Integer num = (Integer) str;
    }

    @Override
    public void show2() {
        System.out.println("throw divide zero error");
        int i = 1 / 0;
    }

    @Override
    public void show3() throws FileNotFoundException {
        System.out.println("throw file not found error");
        InputStream inputStream = new FileInputStream("C:/xx/xx.txt");
    }

    @Override
    public void show4() {
        System.out.println("throw empty pointer error");
        String str = null;
        str.length();
    }

    @Override
    public void show5()throws MyException {
        System.out.println("throw empty pointer error");
        throw new MyException();
    }

}
