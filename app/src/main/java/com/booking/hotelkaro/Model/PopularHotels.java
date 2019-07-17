package com.booking.hotelkaro.Model;

import android.widget.ImageView;

import java.util.List;

public class PopularHotels {

    private String img;
    private String hotel_name;
    private String about;
    private String tag;
    private int img_demo;

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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public PopularHotels(String img, String hotel_name, String about, String tag, int img_demo, List<Integer> img_recycle) {
        this.img = img;
        this.hotel_name = hotel_name;
        this.about = about;
        this.tag = tag;
        this.img_demo = img_demo;
        this.img_recycle = img_recycle;
    }

    private List<Integer> img_recycle ;

}
