package com.example.lib;

public class Accounts {
    public  int manishaAdd(int a, int b){
        return  a + b;
    }

    public void supriyaAdd(int x, int y, MobilePhone phoneno){
        try {
            Thread.sleep(15000);
            phoneno.onSuccess(x+y);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
