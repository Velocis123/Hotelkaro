package com.booking.hotelkaro.Model;

import com.google.gson.annotations.SerializedName;

public class Cities_Main {

    private int city_demo;

    public int getCity_demo() {
        return city_demo;
    }

    public void setCity_demo(int city_demo) {
        this.city_demo = city_demo;
    }

    @SerializedName("homecity_id")
private String homecity_id;

    @SerializedName("id")
    private String id;

    @SerializedName("homecity_name")
    private String homecity_name;

    @SerializedName("homecity_bgimg")
    private String homecity_bgimg;

    @SerializedName("homecity_bgimg_link")
    private String homecity_bgimg_link;

    @SerializedName("name")
    private String name;


    @SerializedName("state_id")
    private String state_id;

    public String getHomecity_id() {
        return homecity_id;
    }

    public void setHomecity_id(String homecity_id) {
        this.homecity_id = homecity_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHomecity_name() {
        return homecity_name;
    }

    public void setHomecity_name(String homecity_name) {
        this.homecity_name = homecity_name;
    }

    public String getHomecity_bgimg() {
        return homecity_bgimg;
    }

    public void setHomecity_bgimg(String homecity_bgimg) {
        this.homecity_bgimg = homecity_bgimg;
    }

    public String getHomecity_bgimg_link() {
        return homecity_bgimg_link;
    }

    public void setHomecity_bgimg_link(String homecity_bgimg_link) {
        this.homecity_bgimg_link = homecity_bgimg_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public Cities_Main(int city_demo, String homecity_id, String id, String homecity_name, String homecity_bgimg, String homecity_bgimg_link, String name, String state_id) {
        this.city_demo = city_demo;
        this.homecity_id = homecity_id;
        this.id = id;
        this.homecity_name = homecity_name;
        this.homecity_bgimg = homecity_bgimg;
        this.homecity_bgimg_link = homecity_bgimg_link;
        this.name = name;
        this.state_id = state_id;
    }
}
