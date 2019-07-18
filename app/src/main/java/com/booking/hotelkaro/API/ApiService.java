package com.booking.hotelkaro.API;


import com.booking.hotelkaro.Model.Cities_Main;
import com.booking.hotelkaro.Model.CityModel;
import com.booking.hotelkaro.Model.Hotel_list;
import com.booking.hotelkaro.Model.LocationModel;
import com.booking.hotelkaro.Model.OTPModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("Api_mobile/popularcity")
    Call<List<CityModel>> getcities(
            @Field("accesskey") String accesskey
    );

    @FormUrlEncoded
    @POST("Api_mobile/hotelbycitylocality")
    Call<List<Hotel_list>> getHotelList(
    @Field("accesskey")    String accesskey,
    @Field("city_id") String city_id,
     @Field("locality_id") String locality_id
    );

    @FormUrlEncoded
    @POST("Api_mobile/sendOTPuser")
    Call<OTPModel> getOTP(
            @Field("accesskey") String accesskey,
            @Field("phone") String phone);


    @FormUrlEncoded
    @POST("Api_mobile//locality")
    Call<List<LocationModel>> getLocality(
            @Field("accesskey") String accesskey,
            @Field("city_id") String phone);



   /* @FormUrlEncoded
    @POST("Api_mobile/register")
    Call<OTPModel> getOTP(
            @Field("accesskey") String accesskey,
            @Field("phone") String phone);
*/


}
