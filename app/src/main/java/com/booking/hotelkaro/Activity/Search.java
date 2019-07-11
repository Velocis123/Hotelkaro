package com.booking.hotelkaro.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;


import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.booking.hotelkaro.API.Api;
import com.booking.hotelkaro.API.ApiService;
import com.booking.hotelkaro.Adapter.CityAdapter;
import com.booking.hotelkaro.Adapter.HotelSearchAdapter;
import com.booking.hotelkaro.Model.Amenities;
import com.booking.hotelkaro.Model.Cities_Main;
import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.Model.Hotel_list;
import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.Datepickerfragment;
import com.booking.hotelkaro.Utils.OnHotelListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    ImageView img_back,location;
    public static final String DATE_FORMAT = "d/M/yyyy";
String id ;
EditText edt_searchbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search_screen);
        rel1 = findViewById(R.id.rel1);
        rel2 = findViewById(R.id.rel2);
        rel3 = findViewById(R.id.rel3);
        txt_checkin = findViewById(R.id.txt_checkin);
        txt_checkout = findViewById(R.id.txt_checkout);
        recyclerView = findViewById(R.id.recycle);
        id = super.getIntent().getExtras().getString("id");
        edt_searchbar = findViewById(R.id.search);
        img_back=findViewById(R.id.img_back);
        location=findViewById(R.id.location);



       edt_searchbar.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {


               Search.super.onBackPressed();
               return false;
           }
       });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //find current location

                Intent intent = new Intent(Search.this,CityLocation.class);
                intent.putExtra("flag","map");

                startActivity(intent);
            }
        });


        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Search.super.onBackPressed();
            }
        });


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
        // get_hotels();
        getCity_hotels();

    }

    private void getCity_hotels(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);

        Call<List<Hotel_list>> call = service.getHotelList("hpt@2019",id,"");

        call.enqueue(new Callback<List<Hotel_list>>() {
            @Override
            public void onResponse(Call<List<Hotel_list>> call, retrofit2.Response<List<Hotel_list>> response) {
                //arrayList.add(response);

                List<Hotel_list> list=response.body();

               set_cities_adapter(list);
                Toast.makeText(Search.this,"SUCCESS",Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<List<Hotel_list>> call, Throwable t) {
                Toast.makeText(Search.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });







    }

    private void set_cities_adapter (List<Hotel_list> list){


        HotelSearchAdapter adapter = new HotelSearchAdapter(Search.this, list, amenities, new OnHotelListener() {
            @Override
            public void onItemClick(Hotel_list item) {
                Intent intent = new Intent(Search.this, HotelDescription.class);
                intent.putExtra("MODEL", item);
                startActivity(intent);
            }


        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(adapter);


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

//    public void get_hotels() {
//        recyclerView = findViewById(R.id.recycle);
//
//
//        Hotel hotel1 = new Hotel("", "Lemon Tree Premier",
//                "3.5", "5",
//                "34444", "5555",
//                "Excellent", R.drawable.lamontree, integerList);
//
//        Hotel hotel2 = new Hotel("", "Promenage",
//                "4.5", "10",
//                "344", "4555",
//                "Excellent", R.drawable.promenade, integerList);
//        Hotel hotel3 = new Hotel("", "Ashoka Hotel",
//                "2.5", "8",
//                "300", "3555",
//                "Good", R.drawable.ashoka, integerList);
//
//        Hotel hotel4 = new Hotel("", "Welcome Hotel",
//                "1.5", "5",
//                "100", "2555",
//                "Poor", R.drawable.wlcome, integerList);
//
//        list.add(hotel1);
//        list.add(hotel2);
//        list.add(hotel3);
//        list.add(hotel4);
//
//        HotelSearchAdapter adapter = new HotelSearchAdapter(Search.this, list, amenities, new OnHotelListener() {
//            @Override
//            public void onItemClick(Hotel item) {
//                Intent intent = new Intent(Search.this, HotelDescription.class);
//                intent.putExtra("MODEL", item);
//                startActivity(intent);
//
//            }
//        });
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
//        recyclerView.setAdapter(adapter);
//
//    }

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

        long days= getDaysBetweenDates(txt_checkin.getText().toString(),txt_checkout.getText().toString());
        if(days<0)
        {

            txt_checkin.setText("Today");
            txt_checkout.setText("Tomorrow");
            Toast.makeText(this,"Invalid Date",Toast.LENGTH_LONG).show();

        }else {
           // indays.setText("" + days+"N");
        }
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
}
