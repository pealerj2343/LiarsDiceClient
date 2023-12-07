package com.example.liarsdiceclient;

public class Dice {
    private int number;
    public Dice(){
        roll();
    }
    public void roll(){
        number = (int)((Math.random()*6) + 1);
    }
    public Dice(int num){
        number = num;
    }
    public int getNumber() {
        return number;
    }
    @Override
    public String toString(){
        return "Dice value: " + number;
    }
}
