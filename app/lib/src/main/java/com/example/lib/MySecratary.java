package com.example.lib;

public class MySecratary implements MobilePhone{
    @Override
    public void onSuccess(int result) {
        System.out.println("received result --"+result);
        System.out.println("releasing payment");

    }
}
