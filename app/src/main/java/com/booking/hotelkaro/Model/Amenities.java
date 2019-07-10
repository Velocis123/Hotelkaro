package com.booking.hotelkaro.Model;

public class Amenities {



    private String amenities_img;
    private String amenities_name;
private int amenities_demo;

    public Amenities(String amenities_img, String amenities_name, int amenities_demo) {
        this.amenities_img = amenities_img;
        this.amenities_name = amenities_name;
        this.amenities_demo = amenities_demo;
    }

    public int getAmenities_demo() {
        return amenities_demo;
    }

    public void setAmenities_demo(int amenities_demo) {
        this.amenities_demo = amenities_demo;
    }

    public String getAmenities_img() {
        return amenities_img;
    }

    public void setAmenities_img(String amenities_img) {
        this.amenities_img = amenities_img;
    }

    public String getAmenities_name() {
        return amenities_name;
    }

    public void setAmenities_name(String amenities_name) {
        this.amenities_name = amenities_name;
    }
}
