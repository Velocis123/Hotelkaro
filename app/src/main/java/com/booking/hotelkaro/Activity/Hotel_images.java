package com.booking.hotelkaro.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.booking.hotelkaro.Adapter.HotelImages_Adapter;
import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Hotel_images extends AppCompatActivity {
RecyclerView recyclerView;
ImageView imageView;
List<Integer> image = new ArrayList<>();
List<Hotel> hotels = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hotel_images);


        recyclerView = findViewById(R.id.rec_hotel_image);

imageView = findViewById(R.id.close);
imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        onBackPressed();
    }
});

getImage();

    }

    private void getImage(){

        image.add(R.drawable.ashoka);
        image.add(R.drawable.promanade);
        image.add(R.drawable.welcome);
        image.add(R.drawable.lamontree);

        Hotel hotel1= new Hotel("","","","","","","",0,image);
        Hotel hotel2= new Hotel("","","","","","","",0,image);
        Hotel hotel3= new Hotel("","","","","","","",0,image);
        Hotel hotel4= new Hotel("","","","","","","",0,image);



        hotels.add(hotel1);
        hotels.add(hotel2);
        hotels.add(hotel3);
        hotels.add(hotel4);


        HotelImages_Adapter hotelImages_adapter = new HotelImages_Adapter(this,hotels);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        recyclerView.setAdapter(hotelImages_adapter);










    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}
