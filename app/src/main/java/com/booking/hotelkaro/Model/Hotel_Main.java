package com.booking.hotelkaro.Model;

import java.io.Serializable;

public class Hotel_Main implements Serializable {

    private String food_items_id;
    private String qtynumber;
    private String category_id;
    private String subcategory_id;
    private String subsubcate_id;
    private String subsubcate_name;
    private String rest_id;
    private String items_name;
    private String items_price;
    private String category_name;
    private String subcategory_name;
    private String restaurant_name;
    private String keyword;
    private String date_from;
    private String date_to;
    private String date;
    private String description;
    private String validity;
    private String availablity;
    private String validfor;

    private String notvalid;
    private String applicable;
    private String notapplicable;
    private String menu_food_name;
    private String menu_food_link;
    private String update_date;
    private String time;
    private String special_offer;
    private String special_offer_status;
    private String showHomeNewYrDeals;
    private String showHomeExDeals;
    private String food_item_terms;
    private String food_item_menu;
    private String food_item_quantity_change;
    private String food_item_cash;
    private String id;
    private String uid;
    private String pay_gcash_online;
    private String name;
    private String email;
    private String password;
    private String mobile_number;
    private String admin_base_url_cover;
    private String admin_base_url_logo;
    private String rest_menu_name;
    private String rest_menu_link;
    private String rest_logo_name;
    private String rest_logo_link;
    private String agreement_name;
    private String agreement_link;
    private String area;
    private String cities_id;
    private String locality_id;
    private String city;
    private String locality;
    private String open_close_time;
    private String find_location;
    private String latitude;
    private String longitude;
    private String user_type;

    private String restinfo;
    private String alluser_rating;
    private String alluser_rating_star;
    private String allrating;
    private String adv_res;
    private String status;
    private String showHome;

    public Hotel_Main(String food_items_id, String qtynumber,
                      String category_id, String subcategory_id, String subsubcate_id, String subsubcate_name,
                      String rest_id, String items_name, String items_price, String category_name, String subcategory_name,
                      String restaurant_name, String keyword, String date_from, String date_to, String date, String description, String validity, String availablity, String validfor, String notvalid, String applicable, String notapplicable, String menu_food_name, String menu_food_link, String update_date, String time, String special_offer, String special_offer_status, String showHomeNewYrDeals, String showHomeExDeals, String food_item_terms, String food_item_menu, String food_item_quantity_change, String food_item_cash, String id, String uid, String pay_gcash_online, String name, String email, String password, String mobile_number, String admin_base_url_cover, String admin_base_url_logo, String rest_menu_name, String rest_menu_link, String rest_logo_name, String rest_logo_link, String agreement_name, String agreement_link, String area, String cities_id, String locality_id, String city, String locality, String open_close_time, String find_location, String latitude, String longitude, String user_type, String restinfo, String alluser_rating, String alluser_rating_star,
                      String allrating, String adv_res, String status, String showHome) {
        this.food_items_id = food_items_id;
        this.qtynumber = qtynumber;
        this.category_id = category_id;
        this.subcategory_id = subcategory_id;
        this.subsubcate_id = subsubcate_id;
        this.subsubcate_name = subsubcate_name;
        this.rest_id = rest_id;
        this.items_name = items_name;
        this.items_price = items_price;
        this.category_name = category_name;
        this.subcategory_name = subcategory_name;
        this.restaurant_name = restaurant_name;
        this.keyword = keyword;
        this.date_from = date_from;
        this.date_to = date_to;
        this.date = date;
        this.description = description;
        this.validity = validity;
        this.availablity = availablity;
        this.validfor = validfor;
        this.notvalid = notvalid;
        this.applicable = applicable;
        this.notapplicable = notapplicable;
        this.menu_food_name = menu_food_name;
        this.menu_food_link = menu_food_link;
        this.update_date = update_date;
        this.time = time;
        this.special_offer = special_offer;
        this.special_offer_status = special_offer_status;
        this.showHomeNewYrDeals = showHomeNewYrDeals;
        this.showHomeExDeals = showHomeExDeals;
        this.food_item_terms = food_item_terms;
        this.food_item_menu = food_item_menu;
        this.food_item_quantity_change = food_item_quantity_change;
        this.food_item_cash = food_item_cash;
        this.id = id;
        this.uid = uid;
        this.pay_gcash_online = pay_gcash_online;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile_number = mobile_number;
        this.admin_base_url_cover = admin_base_url_cover;
        this.admin_base_url_logo = admin_base_url_logo;
        this.rest_menu_name = rest_menu_name;
        this.rest_menu_link = rest_menu_link;
        this.rest_logo_name = rest_logo_name;
        this.rest_logo_link = rest_logo_link;
        this.agreement_name = agreement_name;
        this.agreement_link = agreement_link;
        this.area = area;
        this.cities_id = cities_id;
        this.locality_id = locality_id;
        this.city = city;
        this.locality = locality;
        this.open_close_time = open_close_time;
        this.find_location = find_location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user_type = user_type;
        this.restinfo = restinfo;
        this.alluser_rating = alluser_rating;
        this.alluser_rating_star = alluser_rating_star;
        this.allrating = allrating;
        this.adv_res = adv_res;
        this.status = status;
        this.showHome = showHome;
    }

    public String getFood_items_id() {
        return food_items_id;
    }

    public void setFood_items_id(String food_items_id) {
        this.food_items_id = food_items_id;
    }

    public String getQtynumber() {
        return qtynumber;
    }

    public void setQtynumber(String qtynumber) {
        this.qtynumber = qtynumber;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(String subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public String getSubsubcate_id() {
        return subsubcate_id;
    }

    public void setSubsubcate_id(String subsubcate_id) {
        this.subsubcate_id = subsubcate_id;
    }

    public String getSubsubcate_name() {
        return subsubcate_name;
    }

    public void setSubsubcate_name(String subsubcate_name) {
        this.subsubcate_name = subsubcate_name;
    }

    public String getRest_id() {
        return rest_id;
    }

    public void setRest_id(String rest_id) {
        this.rest_id = rest_id;
    }

    public String getItems_name() {
        return items_name;
    }

    public void setItems_name(String items_name) {
        this.items_name = items_name;
    }

    public String getItems_price() {
        return items_price;
    }

    public void setItems_price(String items_price) {
        this.items_price = items_price;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getSubcategory_name() {
        return subcategory_name;
    }

    public void setSubcategory_name(String subcategory_name) {
        this.subcategory_name = subcategory_name;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getAvailablity() {
        return availablity;
    }

    public void setAvailablity(String availablity) {
        this.availablity = availablity;
    }

    public String getValidfor() {
        return validfor;
    }

    public void setValidfor(String validfor) {
        this.validfor = validfor;
    }

    public String getNotvalid() {
        return notvalid;
    }

    public void setNotvalid(String notvalid) {
        this.notvalid = notvalid;
    }

    public String getApplicable() {
        return applicable;
    }

    public void setApplicable(String applicable) {
        this.applicable = applicable;
    }

    public String getNotapplicable() {
        return notapplicable;
    }

    public void setNotapplicable(String notapplicable) {
        this.notapplicable = notapplicable;
    }

    public String getMenu_food_name() {
        return menu_food_name;
    }

    public void setMenu_food_name(String menu_food_name) {
        this.menu_food_name = menu_food_name;
    }

    public String getMenu_food_link() {
        return menu_food_link;
    }

    public void setMenu_food_link(String menu_food_link) {
        this.menu_food_link = menu_food_link;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpecial_offer() {
        return special_offer;
    }

    public void setSpecial_offer(String special_offer) {
        this.special_offer = special_offer;
    }

    public String getSpecial_offer_status() {
        return special_offer_status;
    }

    public void setSpecial_offer_status(String special_offer_status) {
        this.special_offer_status = special_offer_status;
    }

    public String getShowHomeNewYrDeals() {
        return showHomeNewYrDeals;
    }

    public void setShowHomeNewYrDeals(String showHomeNewYrDeals) {
        this.showHomeNewYrDeals = showHomeNewYrDeals;
    }

    public String getShowHomeExDeals() {
        return showHomeExDeals;
    }

    public void setShowHomeExDeals(String showHomeExDeals) {
        this.showHomeExDeals = showHomeExDeals;
    }

    public String getFood_item_terms() {
        return food_item_terms;
    }

    public void setFood_item_terms(String food_item_terms) {
        this.food_item_terms = food_item_terms;
    }

    public String getFood_item_menu() {
        return food_item_menu;
    }

    public void setFood_item_menu(String food_item_menu) {
        this.food_item_menu = food_item_menu;
    }

    public String getFood_item_quantity_change() {
        return food_item_quantity_change;
    }

    public void setFood_item_quantity_change(String food_item_quantity_change) {
        this.food_item_quantity_change = food_item_quantity_change;
    }

    public String getFood_item_cash() {
        return food_item_cash;
    }

    public void setFood_item_cash(String food_item_cash) {
        this.food_item_cash = food_item_cash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPay_gcash_online() {
        return pay_gcash_online;
    }

    public void setPay_gcash_online(String pay_gcash_online) {
        this.pay_gcash_online = pay_gcash_online;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getAdmin_base_url_cover() {
        return admin_base_url_cover;
    }

    public void setAdmin_base_url_cover(String admin_base_url_cover) {
        this.admin_base_url_cover = admin_base_url_cover;
    }

    public String getAdmin_base_url_logo() {
        return admin_base_url_logo;
    }

    public void setAdmin_base_url_logo(String admin_base_url_logo) {
        this.admin_base_url_logo = admin_base_url_logo;
    }

    public String getRest_menu_name() {
        return rest_menu_name;
    }

    public void setRest_menu_name(String rest_menu_name) {
        this.rest_menu_name = rest_menu_name;
    }

    public String getRest_menu_link() {
        return rest_menu_link;
    }

    public void setRest_menu_link(String rest_menu_link) {
        this.rest_menu_link = rest_menu_link;
    }

    public String getRest_logo_name() {
        return rest_logo_name;
    }

    public void setRest_logo_name(String rest_logo_name) {
        this.rest_logo_name = rest_logo_name;
    }

    public String getRest_logo_link() {
        return rest_logo_link;
    }

    public void setRest_logo_link(String rest_logo_link) {
        this.rest_logo_link = rest_logo_link;
    }

    public String getAgreement_name() {
        return agreement_name;
    }

    public void setAgreement_name(String agreement_name) {
        this.agreement_name = agreement_name;
    }

    public String getAgreement_link() {
        return agreement_link;
    }

    public void setAgreement_link(String agreement_link) {
        this.agreement_link = agreement_link;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCities_id() {
        return cities_id;
    }

    public void setCities_id(String cities_id) {
        this.cities_id = cities_id;
    }

    public String getLocality_id() {
        return locality_id;
    }

    public void setLocality_id(String locality_id) {
        this.locality_id = locality_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getOpen_close_time() {
        return open_close_time;
    }

    public void setOpen_close_time(String open_close_time) {
        this.open_close_time = open_close_time;
    }

    public String getFind_location() {
        return find_location;
    }

    public void setFind_location(String find_location) {
        this.find_location = find_location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getRestinfo() {
        return restinfo;
    }

    public void setRestinfo(String restinfo) {
        this.restinfo = restinfo;
    }

    public String getAlluser_rating() {
        return alluser_rating;
    }

    public void setAlluser_rating(String alluser_rating) {
        this.alluser_rating = alluser_rating;
    }

    public String getAlluser_rating_star() {
        return alluser_rating_star;
    }

    public void setAlluser_rating_star(String alluser_rating_star) {
        this.alluser_rating_star = alluser_rating_star;
    }

    public String getAllrating() {
        return allrating;
    }

    public void setAllrating(String allrating) {
        this.allrating = allrating;
    }

    public String getAdv_res() {
        return adv_res;
    }

    public void setAdv_res(String adv_res) {
        this.adv_res = adv_res;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShowHome() {
        return showHome;
    }

    public void setShowHome(String showHome) {
        this.showHome = showHome;
    }
}
