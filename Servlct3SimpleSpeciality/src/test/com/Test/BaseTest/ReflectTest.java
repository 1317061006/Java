package com.Test.BaseTest;

import java.lang.reflect.Method;

/**
 * Created by han on 2017/1/13.
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {

            Class<?> cl1= (Class<?>) Class.forName("com.Test.Controller.CountyController");
            Class<?> superclass = cl1.getSuperclass();
            System.out.println(superclass.getName());

            java.lang.reflect.Field[] fields=cl1.getDeclaredFields();
            for (int i=0;i<fields.length;i++){
                System.out.println("类中的成员"+fields[i]);
            }

            Method[] methods=cl1.getDeclaredMethods();
            for (int i=0;i<methods.length;i++){
                System.out.println(methods[i].getName());
                System.out.println(methods[i].getReturnType());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void ceshi(Object... objects) {
        System.out.println(objects.length);
        System.out.println(objects.clone());
    }
}
