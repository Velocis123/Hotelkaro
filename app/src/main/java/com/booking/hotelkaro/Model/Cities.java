package com.booking.hotelkaro.Model;

public class Cities {

    private String city_img;
    private String city_name;
    private int city_demo;

    public Cities(String city_img, String city_name, int city_demo) {
        this.city_img = city_img;
        this.city_name = city_name;
        this.city_demo = city_demo;
    }

    public int getCity_demo() {
        return city_demo;
    }

    public void setCity_demo(int city_demo) {
        this.city_demo = city_demo;
    }

    public String getCity_img() {
        return city_img;
    }

    public void setCity_img(String city_img) {
        this.city_img = city_img;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
