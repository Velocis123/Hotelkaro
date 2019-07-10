package com.booking.hotelkaro.API;


import com.booking.hotelkaro.Model.Cities_Main;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {


    @FormUrlEncoded
    @POST("api_mobile/popularcity")
    Call<List<Cities_Main>> getcities(
            @Field("accesskey") String accesskey
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
