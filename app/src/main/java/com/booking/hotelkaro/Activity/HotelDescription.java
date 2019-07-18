package com.booking.hotelkaro.Activity;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.booking.hotelkaro.Adapter.Amenities_Search_Adapter;
import com.booking.hotelkaro.Model.Amenities;
import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.Model.Hotel_list;
import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.Datepickerfragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class HotelDescription extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener , View.OnClickListener {

    List<Amenities> amenities = new ArrayList<>();
    RecyclerView recyclerView_des_amenities;
    TextView txt_tariffAmt, txt_hotel_name,txt_desc;
    ImageView img_hotel,img_map;
    Hotel_list hotel;
    RatingBar ratingBar;
     ImageView img_back;
    static int DATE_DIALOG = 0;
    public static final String DATE_FORMAT = "d/M/yyyy";
    TextView in,indate,out,outdate,indays,room,roomval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_description);
        ratingBar = findViewById(R.id.ratingBar);

        in=findViewById(R.id.in);
        indate=findViewById(R.id.indate);
        out=findViewById(R.id.out);
        outdate=findViewById(R.id.outdate);
        indays=findViewById(R.id.indays);
        room=findViewById(R.id.room);
        roomval=findViewById(R.id.roomval);

        img_back=findViewById(R.id.img_back);
       img_map=findViewById(R.id.img_map1);
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
        in.setOnClickListener(this);
        out.setOnClickListener(this);
        room.setOnClickListener(this);
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
        final Intent intent = new Intent(HotelDescription.this,Hotel_images.class);
        ActivityOptions options =
                ActivityOptions.makeCustomAnimation(HotelDescription.this, R.anim.fade_in, R.anim.fade_out);
        startActivity(intent,options.toBundle());



    }
});
        img_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HotelDescription.this,Map.class);
                startActivity(intent1);
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
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        if (DATE_DIALOG == 1) {
            in.setText((dayOfMonth) + "/" +
                    (month + 1) + "/" +
                    (year));
        } else if (DATE_DIALOG == 2) {
            out.setText((dayOfMonth) + "/" +
                    (month + 1) + "/" +
                    (year));
        }

        long days= getDaysBetweenDates(in.getText().toString(),out.getText().toString());
        if(days<0)
        {

            in.setText("Today");
            out.setText("Tomorrow");
            Toast.makeText(this,"Invalid Date",Toast.LENGTH_LONG).show();

        }
        else if(days==0)
        {
            indays.setText("" + 1+"N");
        }
        else {
            indays.setText("" + days+"N");
        }
        ;
    }

    public static long getDaysBetweenDates(String start, String end) {

        if(start.equals("Today"))
        {
            SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
            Date todayDate = new Date();
            start= currentDate.format(todayDate);
        }if(end.equals("Tomorrow"))
        {
            SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
            Date todayDate = new Date();
            end = currentDate.format(todayDate);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
        Date startDate, endDate;
        long numberOfDays = 0;
        try {
            startDate = dateFormat.parse(start);
            endDate = dateFormat.parse(end);
            numberOfDays = getUnitBetweenDates(startDate, endDate, TimeUnit.DAYS);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return numberOfDays;
    }
    private static long getUnitBetweenDates(Date startDate, Date endDate, TimeUnit unit) {
        long timeDiff = endDate.getTime() - startDate.getTime();
        return unit.convert(timeDiff, TimeUnit.MILLISECONDS);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.in:
                DATE_DIALOG = 1;
                DialogFragment datePicker = new Datepickerfragment();
                datePicker.show(getSupportFragmentManager(), "date picker checkin");
                break;

            case R.id.out:
                DATE_DIALOG = 2;
                DialogFragment datePicker1 = new Datepickerfragment();
                datePicker1.show(getSupportFragmentManager(), "date picker checkout");
                break;


            case R.id.room:
                startActivity(new Intent(HotelDescription.this, NoOfPerson.class));
                break;
        }


    }
}
