/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericCheckpointing.util;

import java.util.Objects;

/**
 *
 * @author Megh Shah
 */
public class MyAllTypesFirst extends SerializableObject{
    
    private int myInt;
    private long myLong;
    private String myString ;
    private boolean myBoolean;
    private int myOtherInt;
    private long myOtherLong ;
/**
 * Default Constructor
 */
    public MyAllTypesFirst() {
    }
/**
 * Parameterized Constructor
 * @param myInt
 * @param myLong
 * @param myString
 * @param myBoolean
 * @param myOtherInt
 * @param myOtherLong 
 */
    public MyAllTypesFirst(int myInt, long myLong, String myString, boolean myBoolean, int myOtherInt, long myOtherLong) {
        this.myInt = myInt;
        this.myLong = myLong;
        this.myString = myString;
        this.myBoolean = myBoolean;
        this.myOtherInt = myOtherInt;
        this.myOtherLong = myOtherLong;
    }
/**
 * 
 * @return Interger 
 */
    public int getMyInt() {
        return myInt;
    }
/**
 * 
 * @param myInt Contains Integer 
 */
    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }
/**
 * 
 * @return the long 
 */
    public long getMyLong() {
        return myLong;
    }
/**
 * 
 * @param myLong contains Long
 */
    public void setMyLong(long myLong) {
        this.myLong = myLong;
    }
/**
 * 
 * @return the String 
 */
    public String getMyString() {
        return myString;
    }
/**
 * 
 * @param myString st=ets the String type 
 */
    public void setMyString(String myString) {
        this.myString = myString;
    }
/**
 * 
 * @return the Boolean parameter 
 */
    public boolean isMyBoolean() {
        return myBoolean;
    }
/**
 * 
 * @param myBoolean sets the Boolean Parameter 
 */
    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }
/**
 * 
 * @return the OtherInt Parameter 
 */
    public int getMyOtherInt() {
        return myOtherInt;
    }
/**
 * 
 * @param myOtherInt set the Other Int Parameter.
 */
    public void setMyOtherInt(int myOtherInt) {
        this.myOtherInt = myOtherInt;
    }
/**
 * 
 * @return the OtherLong Parameter 
 */
    public long getMyOtherLong() {
        return myOtherLong;
    }
/**
 * 
 * @param myOtherLong sets the Other Long Parameter
 */
    public void setMyOtherLong(long myOtherLong) {
        this.myOtherLong = myOtherLong;
    }
/**
 * 
 * @return the HAshCode of type int
 */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.myInt;
        hash = 71 * hash + (int) (this.myLong ^ (this.myLong >>> 32));
        hash = 71 * hash + Objects.hashCode(this.myString);
        hash = 71 * hash + (this.myBoolean ? 1 : 0);
        hash = 71 * hash + this.myOtherInt;
        hash = 71 * hash + (int) (this.myOtherLong ^ (this.myOtherLong >>> 32));
        return hash;
    }
/**
 * 
 * @param obj the The Object as parameter
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
        final MyAllTypesFirst other = (MyAllTypesFirst) obj;
        if (this.myInt != other.myInt) {
            return false;
        }
        if (this.myLong != other.myLong) {
            return false;
        }
        if (this.myBoolean != other.myBoolean) {
            return false;
        }
        if (this.myOtherInt != other.myOtherInt) {
            return false;
        }
        if (this.myOtherLong != other.myOtherLong) {
            return false;
        }

        return true;
    }
/**
 * 
 * @return the String of the current Object
 */
    @Override
    public String toString(){
       String str = "MyAllTypesFirst \n{ myInt :"+this.myInt+", myString : "+this.myString+", myBoolean : "+this.myBoolean+", myLong : "+this.myLong+", myOtherLong : "+this.myOtherLong+", myOtherInt : "+this.myOtherInt+" }";
       return str;
    }

}
