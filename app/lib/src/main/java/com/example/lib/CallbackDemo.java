package com.example.lib;

public class CallbackDemo {
    public static void main(String[] args) {
        Accounts accounts = new Accounts();
       int mres =  accounts.manishaAdd(10,20);
        System.out.println("manishas -- "+mres);

        MobilePhone phoneno = new MySecratary();
        int sres = accounts.supriyaAdd(30,40);
        System.out.println("supriya--"+sres);
    }


}
