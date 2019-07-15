package com.booking.hotelkaro.Model;

import java.io.Serializable;
import java.util.List;

public class Trending_Hotel implements Serializable {

    private String img;
    private String hotel_name;
    private String price;
    private String remarks;
    private int img_demo;
    private List<Integer> img_recycle ;

    public Trending_Hotel(String img, String hotel_name, String price, String remarks, int img_demo, List<Integer> img_recycle) {
        this.img = img;
        this.hotel_name = hotel_name;
        this.price = price;
        this.remarks = remarks;
        this.img_demo = img_demo;
        this.img_recycle = img_recycle;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getImg_demo() {
        return img_demo;
    }

    public void setImg_demo(int img_demo) {
        this.img_demo = img_demo;
    }

    public List<Integer> getImg_recycle() {
        return img_recycle;
    }

    public void setImg_recycle(List<Integer> img_recycle) {
        this.img_recycle = img_recycle;
    }
}
