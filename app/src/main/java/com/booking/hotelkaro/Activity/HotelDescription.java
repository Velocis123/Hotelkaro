package com.booking.hotelkaro.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.booking.hotelkaro.Adapter.Amenities_Search_Adapter;
import com.booking.hotelkaro.Model.Amenities;
import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.Model.Hotel_list;
import com.booking.hotelkaro.R;

import java.util.ArrayList;
import java.util.List;

public class HotelDescription extends AppCompatActivity {

    List<Amenities> amenities = new ArrayList<>();
    RecyclerView recyclerView_des_amenities;
    TextView txt_tariffAmt, txt_hotel_name,txt_desc;
    ImageView img_hotel;
    Hotel_list hotel;
    RatingBar ratingBar;
     ImageView img_back;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_description);
        ratingBar = findViewById(R.id.ratingBar);
        img_back=findViewById(R.id.img_back);
        txt_desc = findViewById(R.id.txt_description);
        txt_desc.setText("Other will travel/book and pay you can get a Free Travel/Stay! \n" +
                " Invite your friends to HotelKaro.When they departure/check- \n" +
                " out,you get Free Stay/Travel.Also,they get Rs200 extra off \n" +
                "on their first stay/travel");



        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HotelDescription.super.onBackPressed();
            }
        });

        txt_tariffAmt = findViewById(R.id.txt_amount_tariff);
        txt_hotel_name = findViewById(R.id.txt_hotelname);
        img_hotel = findViewById(R.id.img_hotel);
        txt_tariffAmt.setText(R.string.price_placeholder+"800");
        txt_tariffAmt.setPaintFlags(txt_tariffAmt.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        //hotel = (Hotel_list) super.getIntent().getExtras().get("MODEL");


//        img_hotel.setImageResource(hotel.getImg_demo());
//        txt_hotel_name.setText(hotel.getHotel_name());
//        ratingBar.setRating(Float.parseFloat(hotel.getRatings()));

        get_amenities();
img_hotel = findViewById(R.id.img_hotel);
img_hotel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HotelDescription.this,Hotel_images.class);
        ActivityOptions options =
                ActivityOptions.makeCustomAnimation(HotelDescription.this, R.anim.fade_in, R.anim.fade_out);
        startActivity(intent,options.toBundle());
    }
});

    }

    public void get_amenities() {
        recyclerView_des_amenities = findViewById(R.id.recycle_amen_description);

        Amenities amenities1 = new Amenities("", "Phone", R.drawable.phone_24dp);
        Amenities amenities2 = new Amenities("", "Wifi", R.drawable.wifi_24dp);
        Amenities amenities3 = new Amenities("", "AC", R.drawable.air_conditioner_24dp);
        Amenities amenities4 = new Amenities("", "TV", R.drawable.tv_24dp);
        Amenities amenities5 = new Amenities("", "Lawn", R.drawable.lawn_24dp);
        Amenities amenities6 = new Amenities("", "Taxi", R.drawable.taxi_cab_24dp);
        Amenities amenities8 = new Amenities("", "Phone", R.drawable.phone_24dp);
        Amenities amenities9 = new Amenities("", "Wifi", R.drawable.wifi_24dp);
        Amenities amenities10 = new Amenities("", "AC", R.drawable.air_conditioner_24dp);
        Amenities amenities11 = new Amenities("", "TV", R.drawable.tv_24dp);
        Amenities amenities12 = new Amenities("", "Lawn", R.drawable.lawn_24dp);
        Amenities amenities13 = new Amenities("", "Taxi", R.drawable.taxi_cab_24dp);
//        Amenities amenities7 =  new Amenities("api.androidhive.info/json/movies/7.jpg","New Delhi");

        amenities.add(amenities1);
        amenities.add(amenities2);
        amenities.add(amenities3);
        amenities.add(amenities4);
        amenities.add(amenities5);
        amenities.add(amenities6);
        amenities.add(amenities8);
        amenities.add(amenities9);
        amenities.add(amenities10);
        amenities.add(amenities11);
        amenities.add(amenities12);
        amenities.add(amenities13);
        // amenities.add(amenities7);

        Amenities_Search_Adapter amenitiesAdapter = new Amenities_Search_Adapter(HotelDescription.this, amenities);
        recyclerView_des_amenities.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));
        recyclerView_des_amenities.setAdapter(amenitiesAdapter);
    }
}
