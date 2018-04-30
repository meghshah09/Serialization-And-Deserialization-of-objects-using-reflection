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
public class MyAllTypesFirst extends SerializableObject{
    
    private int myInt;
    private long myLong;
    private String myString;
    private boolean myBoolean;
    private int myOtherInt;
    private long myOtherLong;

    public MyAllTypesFirst(int myInt, long myLong, String myString, boolean myBoolean, int myOtherInt, long myOtherLong) {
        this.myInt = myInt;
        this.myLong = myLong;
        this.myString = myString;
        this.myBoolean = myBoolean;
        this.myOtherInt = myOtherInt;
        this.myOtherLong = myOtherLong;
    }

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public long getMyLong() {
        return myLong;
    }

    public void setMyLong(long myLong) {
        this.myLong = myLong;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public boolean isMyBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    public int getMyOtherInt() {
        return myOtherInt;
    }

    public void setMyOtherInt(int myOtherInt) {
        this.myOtherInt = myOtherInt;
    }

    public long getMyOtherLong() {
        return myOtherLong;
    }

    public void setMyOtherLong(long myOtherLong) {
        this.myOtherLong = myOtherLong;
    }

    
    
    
    
}
