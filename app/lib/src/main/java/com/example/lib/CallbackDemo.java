package com.example.lib;

public class CallbackDemo {
    public static void main(String[] args) {
        Accounts accounts = new Accounts();
       int mres =  accounts.manishaAdd(10,20);
        System.out.println("manishas -- "+mres);

        MobilePhone phoneno = new MySecratary();
        new Thread(){
            @Override
            public void run() {
                super.run();
                accounts.supriyaAdd(30,40,phoneno);

            }
        }.start();
        System.out.println("im continuing my class");
        //int sres = accounts.supriyaAdd(30,40,phoneno);
        //System.out.println("supriya--"+sres);
    }


}
