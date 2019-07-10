package com.booking.hotelkaro.Model;

import java.util.ArrayList;

public class OffersModel {

    private ArrayList<Bus> bus = new ArrayList();
    private ArrayList<Flight> flight = new ArrayList();
    private ArrayList<Hotel> hotel = new ArrayList();


    public OffersModel(ArrayList<Bus> bus, ArrayList<Flight> flight, ArrayList<Hotel> hotel) {
        this.bus = bus;
        this.flight = flight;
        this.hotel = hotel;

    }

    public ArrayList<Bus> getBus() {
        return bus;
    }

    public void setBus(ArrayList<Bus> bus) {
        this.bus = bus;
    }

    public ArrayList<Flight> getFlight() {
        return flight;
    }

    public void setFlight(ArrayList<Flight> flight) {
        this.flight = flight;
    }

    public ArrayList<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(ArrayList<Hotel> hotel) {
        this.hotel = hotel;
    }


    public class Bus {
        private int id;
        private int offer_type;
        private String offercode;
        private String offer_name;
        private String image;
        private String created_at;
        private String updated_at;
        private int off_price;
        private int used_count;


        public Bus(int id, int offer_type, String offercode, String offer_name, String image, String created_at, String updated_at, int off_price, int used_count) {
            this.id = id;
            this.offer_type = offer_type;
            this.offercode = offercode;
            this.offer_name = offer_name;
            this.image = image;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.off_price = off_price;
            this.used_count = used_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOffer_type() {
            return offer_type;
        }

        public void setOffer_type(int offer_type) {
            this.offer_type = offer_type;
        }

        public String getOffercode() {
            return offercode;
        }

        public void setOffercode(String offercode) {
            this.offercode = offercode;
        }

        public String getOffer_name() {
            return offer_name;
        }

        public void setOffer_name(String offer_name) {
            this.offer_name = offer_name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getOff_price() {
            return off_price;
        }

        public void setOff_price(int off_price) {
            this.off_price = off_price;
        }

        public int getUsed_count() {
            return used_count;
        }

        public void setUsed_count(int used_count) {
            this.used_count = used_count;
        }
    }

    public class Flight {
        private int id;
        private int offer_type;
        private String offercode;
        private String offer_name;
        private String image;
        private String created_at;
        private String updated_at;
        private int off_price;
        private int used_count;


        public Flight(int id, int offer_type, String offercode, String offer_name, String image, String created_at, String updated_at, int off_price, int used_count) {
            this.id = id;
            this.offer_type = offer_type;
            this.offercode = offercode;
            this.offer_name = offer_name;
            this.image = image;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.off_price = off_price;
            this.used_count = used_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOffer_type() {
            return offer_type;
        }

        public void setOffer_type(int offer_type) {
            this.offer_type = offer_type;
        }

        public String getOffercode() {
            return offercode;
        }

        public void setOffercode(String offercode) {
            this.offercode = offercode;
        }

        public String getOffer_name() {
            return offer_name;
        }

        public void setOffer_name(String offer_name) {
            this.offer_name = offer_name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getOff_price() {
            return off_price;
        }

        public void setOff_price(int off_price) {
            this.off_price = off_price;
        }

        public int getUsed_count() {
            return used_count;
        }

        public void setUsed_count(int used_count) {
            this.used_count = used_count;
        }
    }

    public class Hotel {
        private int id;
        private int offer_type;
        private String offercode;
        private String offer_name;
        private String image;
        private String created_at;
        private String updated_at;
        private int off_price;
        private int used_count;


        public Hotel(int id, int offer_type, String offercode, String offer_name, String image, String created_at, String updated_at, int off_price, int used_count) {
            this.id = id;
            this.offer_type = offer_type;
            this.offercode = offercode;
            this.offer_name = offer_name;
            this.image = image;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.off_price = off_price;
            this.used_count = used_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOffer_type() {
            return offer_type;
        }

        public void setOffer_type(int offer_type) {
            this.offer_type = offer_type;
        }

        public String getOffercode() {
            return offercode;
        }

        public void setOffercode(String offercode) {
            this.offercode = offercode;
        }

        public String getOffer_name() {
            return offer_name;
        }

        public void setOffer_name(String offer_name) {
            this.offer_name = offer_name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getOff_price() {
            return off_price;
        }

        public void setOff_price(int off_price) {
            this.off_price = off_price;
        }

        public int getUsed_count() {
            return used_count;
        }

        public void setUsed_count(int used_count) {
            this.used_count = used_count;
        }
    }

}

