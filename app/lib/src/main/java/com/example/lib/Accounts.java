package com.example.lib;

public class Accounts {
    public  int manishaAdd(int a, int b){
        return  a + b;
    }

    public int supriyaAdd(int x, int y){
        try {
            Thread.sleep(15000);
            return x+y;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
