/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.util;

/**
 *
 * @author Megh Shah
 */
public class MyAllTypesSecond extends SerializableObject{
    
    private double myDoubleT;
    private float myFloatT;
    private char myCharT;
    private short myShortT;
    private double myOtherDoubleT;

    public MyAllTypesSecond(double myDoubleT, float myFloatT, char myCharT, short myShortT, double myOtherDoubleT) {
        this.myDoubleT = myDoubleT;
        this.myFloatT = myFloatT;
        this.myCharT = myCharT;
        this.myShortT = myShortT;
        this.myOtherDoubleT = myOtherDoubleT;
    }

    public double getMyDoubleT() {
        return myDoubleT;
    }

    public void setMyDoubleT(double myDoubleT) {
        this.myDoubleT = myDoubleT;
    }

    public float getMyFloatT() {
        return myFloatT;
    }

    public void setMyFloatT(float myFloatT) {
        this.myFloatT = myFloatT;
    }

    public char getMyCharT() {
        return myCharT;
    }

    public void setMyCharT(char myCharT) {
        this.myCharT = myCharT;
    }

    public short getMyShortT() {
        return myShortT;
    }

    public void setMyShortT(short myShortT) {
        this.myShortT = myShortT;
    }

    public double getMyOtherDoubleT() {
        return myOtherDoubleT;
    }

    public void setMyOtherDoubleT(double myOtherDoubleT) {
        this.myOtherDoubleT = myOtherDoubleT;
    }
    
}
