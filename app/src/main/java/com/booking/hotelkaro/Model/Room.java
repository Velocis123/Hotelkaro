package com.booking.hotelkaro.Model;

public class Room {

    private int count;
    private int nop=1;
    private  boolean child;

    public Room(int count, int nop, boolean child) {
        this.count = count;
        this.nop = nop;
        this.child = child;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }
}
