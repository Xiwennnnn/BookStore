package com.xiwen.test;


import org.junit.Test;

import java.lang.reflect.Method;

public class UserServletTest {
    @Test
    public void login(){
        System.out.println("dl");
    }

    @Test
    public void regist(){
        System.out.println("zc");
    }

    @Test
    public void update(){
        System.out.println("gx");
    }

    public static void main(String[] args) {
        String action = "update";

        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
