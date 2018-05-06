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
    
    private double myDoubleT=0;
    private float myFloatT=0;
    private char myCharT=0;
    private short myShortT=0;
    private double myOtherDoubleT=0;
/**
 * Default Constructor
 */
    public MyAllTypesSecond() {
    }
/**
 * Parameterized Constructor
 * @param myDoubleT
 * @param myFloatT
 * @param myCharT
 * @param myShortT
 * @param myOtherDoubleT 
 */
    public MyAllTypesSecond(double myDoubleT, float myFloatT, char myCharT, short myShortT, double myOtherDoubleT) {
        this.myDoubleT = myDoubleT;
        this.myFloatT = myFloatT;
        this.myCharT = myCharT;
        this.myShortT = myShortT;
        this.myOtherDoubleT = myOtherDoubleT;
    }
/**
 * 
 * @return the Double
 */
    public double getMyDoubleT() {
        return myDoubleT;
    }
/**
 * 
 * @param myDoubleT set the Parameter
 */
    public void setMyDoubleT(double myDoubleT) {
        this.myDoubleT = myDoubleT;
    }
/**
 * 
 * @return the float 
 */
    public float getMyFloatT() {
        return myFloatT;
    }
/**
 * 
 * @param myFloatT sets the the parameter
 */
    public void setMyFloatT(float myFloatT) {
        this.myFloatT = myFloatT;
    }
/**
 * 
 * @return the parameter 
 */
    public char getMyCharT() {
        return myCharT;
    }
/**
 * 
 * @param myCharT sets the the parameter 
 */
    public void setMyCharT(char myCharT) {
        this.myCharT = myCharT;
    }
/**
 * 
 * @return the parameter 
 */
    public short getMyShortT() {
        return myShortT;
    }
/**
 * 
 * @param myShortT sets the the parameter
 */
    public void setMyShortT(short myShortT) {
        this.myShortT = myShortT;
    }
/**
 * 
 * @return the parameter 
 */
    public double getMyOtherDoubleT() {
        return myOtherDoubleT;
    }
/**
 * 
 * @param myOtherDoubleT sets the the parameter
 */
    public void setMyOtherDoubleT(double myOtherDoubleT) {
        this.myOtherDoubleT = myOtherDoubleT;
    }
    /**
     * 
     * @param obj  the The Object as parameter
     * @return the Boolean whether the object is equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyAllTypesSecond other = (MyAllTypesSecond) obj;
        if (Double.doubleToLongBits(this.myDoubleT) != Double.doubleToLongBits(other.myDoubleT)) {
            return false;
        }
        if (Float.floatToIntBits(this.myFloatT) != Float.floatToIntBits(other.myFloatT)) {
            return false;
        }
        if (this.myCharT != other.myCharT) {
            return false;
        }
        if (this.myShortT != other.myShortT) {
            return false;
        }
        if (Double.doubleToLongBits(this.myOtherDoubleT) != Double.doubleToLongBits(other.myOtherDoubleT)) {
            return false;
        }
        return true;
    }
/**
 * 
 * @return the HAshCode of type int
 */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.myDoubleT) ^ (Double.doubleToLongBits(this.myDoubleT) >>> 32));
        hash = 97 * hash + Float.floatToIntBits(this.myFloatT);
        hash = 97 * hash + this.myCharT;
        hash = 97 * hash + this.myShortT;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.myOtherDoubleT) ^ (Double.doubleToLongBits(this.myOtherDoubleT) >>> 32));
        return hash;
    }
 /**
 * 
 * @return the String of the current Object
 */
    @Override
     public String toString(){
       String str = "MyAllTypesSecond  \n{ myCharT :"+this.myCharT+", myDoubleT : "+this.myDoubleT+", myFloatT : "+this.myFloatT+", myOtherDoubleT : "+this.myOtherDoubleT+", myShortT : "+this.myShortT+" }";
       return str;
    }
}
