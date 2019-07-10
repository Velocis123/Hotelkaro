package com.booking.hotelkaro.API;


import com.booking.hotelkaro.Model.Cities_Main;
import com.booking.hotelkaro.Model.Hotel_list;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {


    @FormUrlEncoded
    @POST("Api_mobile/popularcity")
    Call<List<Cities_Main>> getcities(
            @Field("accesskey") String accesskey
    );

@FormUrlEncoded
    @POST("Api_mobile/hotelbycitylocality")
    Call<List<Hotel_list>> getHotelList(
  @Field("accesskey")    String accesskey,
  @Field("city_id") String city_id,
  @Field("locality_id") String locality_id


);
//
//@POST("registrationapi.php?apical=login")
//
//
//@FormUrlEncoded
//    Call<User>  loginUser(
//        @Field("username") String username,
//        @Field("password") String password
//
//);

}
