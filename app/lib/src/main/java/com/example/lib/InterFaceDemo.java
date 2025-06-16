package com.example.lib;

public class InterFaceDemo {
    public static void main(String[] args) {
    ISwitchBoardListener isbl = new GEAppliances(); //wiring
            //new HavellsAppliances();

    //click the switches
        isbl.switchOne();
        isbl.switchTwo();
        isbl.switchThree();
        isbl.switchFour();
    }
}