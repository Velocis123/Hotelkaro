package com.booking.hotelkaro.Model;

import android.widget.ImageView;

import java.util.List;

public class PopularHotels {

    private String img;
    private String hotel_name;
    private String address;
    private String price;
    private String rating;
    private String type;
    private int img_demo;
    private List<Integer> img_recycle ;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public PopularHotels(String img, String hotel_name, String address, String price, String rating, String type, int img_demo, List<Integer> img_recycle) {
        this.img = img;
        this.hotel_name = hotel_name;
        this.address = address;
        this.price = price;
        this.rating = rating;
        this.type = type;
        this.img_demo = img_demo;
        this.img_recycle = img_recycle;
    }
}
