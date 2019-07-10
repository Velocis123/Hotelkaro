package com.booking.hotelkaro.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.booking.hotelkaro.Adapter.HotelSearchAdapter;
import com.booking.hotelkaro.Model.Amenities;
import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.Datepickerfragment;
import com.booking.hotelkaro.Utils.OnHotelListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Search extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    List<Hotel> list = new ArrayList();
    RecyclerView recyclerView;
    List<Amenities> amenities = new ArrayList<>();
    TextView txt_checkin, txt_checkout;
    String currentDateString;
    String checkOut_date;
    CardView cardView;
    FragmentManager fm = getSupportFragmentManager();
    static int DATE_DIALOG = 0;
    RelativeLayout rel1, rel2, rel3;
    List<Integer> integerList = new ArrayList<>();

EditText edt_searchbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search_screen);
        rel1 = findViewById(R.id.rel1);
        rel2 = findViewById(R.id.rel2);
        rel3 = findViewById(R.id.rel3);
        txt_checkin = findViewById(R.id.date_checkin);
        txt_checkout = findViewById(R.id.date_checkout);

edt_searchbar = findViewById(R.id.search);
        rel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Search.this, NoOfPerson.class));

            }
        });

        rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DATE_DIALOG = 1;
                DialogFragment datePicker = new Datepickerfragment();
                datePicker.show(getSupportFragmentManager(), "date picker checkin");
            }
        });

        rel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DATE_DIALOG = 2;
                DialogFragment datePicker = new Datepickerfragment();
                datePicker.show(getSupportFragmentManager(), "date picker checkout");
            }
        });

        integerList.add(R.drawable.bangalore);
        integerList.add(R.drawable.goa);
        integerList.add(R.drawable.mumbai);
        integerList.add(R.drawable.manali);
        Intent intent =getIntent();
        String value;
        value = intent.getStringExtra("SEARCH_CONTENT");
        edt_searchbar.setText(value);

        get_amenities();
        get_hotels();


    }

    public void get_amenities() {


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
        Amenities amenities13 = new Amenities("", "Taxi", R.drawable.tv_24dp);
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


    }

    public void get_hotels() {
        recyclerView = findViewById(R.id.recycle);


        Hotel hotel1 = new Hotel("", "Lemon Tree Premier",
                "3.5", "5",
                "34444", "5555",
                "Excellent", R.drawable.lamontree, integerList);

        Hotel hotel2 = new Hotel("", "Promenage",
                "4.5", "10",
                "344", "4555",
                "Excellent", R.drawable.promenade, integerList);
        Hotel hotel3 = new Hotel("", "Ashoka Hotel",
                "2.5", "8",
                "300", "3555",
                "Good", R.drawable.ashoka, integerList);

        Hotel hotel4 = new Hotel("", "Welcome Hotel",
                "1.5", "5",
                "100", "2555",
                "Poor", R.drawable.wlcome, integerList);

        list.add(hotel1);
        list.add(hotel2);
        list.add(hotel3);
        list.add(hotel4);

        HotelSearchAdapter adapter = new HotelSearchAdapter(Search.this, list, amenities, new OnHotelListener() {
            @Override
            public void onItemClick(Hotel item) {
                Intent intent = new Intent(Search.this, HotelDescription.class);
                intent.putExtra("MODEL", item);
                startActivity(intent);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        if (DATE_DIALOG == 1) {
            txt_checkin.setText((dayOfMonth) + "/" +
                    (month + 1) + "/" +
                    (year));
        } else if (DATE_DIALOG == 2) {
            txt_checkout.setText((dayOfMonth) + "/" +
                    (month + 1) + "/" +
                    (year));
        }
    }


}
