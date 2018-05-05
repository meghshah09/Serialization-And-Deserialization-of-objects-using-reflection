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
    
    private int myInt=0 ;
    private long myLong= 0;
    private String myString= null ;
    private boolean myBoolean= true;
    private int myOtherInt = 0;
    private long myOtherLong = 0;

    public MyAllTypesFirst() {
    }

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


}
