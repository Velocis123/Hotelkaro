package com.booking.hotelkaro.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.booking.hotelkaro.API.Api;
import com.booking.hotelkaro.API.ApiService;
import com.booking.hotelkaro.Adapter.AmenitiesAdapter;
import com.booking.hotelkaro.Adapter.CityAdapter;
import com.booking.hotelkaro.Adapter.HotelAdapter;
import com.booking.hotelkaro.Adapter.OfferAdapter;
import com.booking.hotelkaro.Model.Amenities;
import com.booking.hotelkaro.Model.Cities;
import com.booking.hotelkaro.Model.Cities_Main;
import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.Model.OffersModel;
import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.VolleySingleton;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView_hotel, recyclerView_cities, recyclerView_amenities,recyclerView_cv;
    ImageView imageView;
    List<Hotel> list = new ArrayList();
    List<Cities> cities = new ArrayList<>();
    List<Amenities> amenities = new ArrayList<>();
    EditText search;
    LinearLayout map;
    OfferAdapter offerAdapter;
    public static ArrayList<OffersModel.Bus> busList;
    RecyclerView recyclerOffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home_screen);

        search = findViewById(R.id.edt_search_home);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, CityLocation.class);
                intent.putExtra("flag","s");

                startActivity(intent);



            }
        });
recyclerView_cv = findViewById(R.id.cv);
map = findViewById(R.id.map);
map.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

Intent intent = new Intent(MainActivity.this,CityLocation.class);
intent.putExtra("flag","map");

startActivity(intent);


    }
});
        getOffer();
        recyclerOffer = findViewById(R.id.recycler_offer_one);
        recyclerOffer.setHasFixedSize(true);
        busList = new ArrayList<>();
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerOffer.setLayoutManager(layoutManager2);
        offerAdapter = new OfferAdapter(getApplication(), busList);
        recyclerOffer.setAdapter(offerAdapter);


      //  get_cities();
        get_amenities();
        get_hotels();
cities_main();


    }

    public void get_amenities() {

        recyclerView_amenities = findViewById(R.id.recycle_amenities);
        Amenities amenities1 = new Amenities("", "Phone", R.drawable.phone_24dp);
        Amenities amenities2 = new Amenities("", "Wifi", R.drawable.wifi_24dp);
        Amenities amenities3 = new Amenities("", "AC", R.drawable.air_conditioner_24dp);
        Amenities amenities4 = new Amenities("", "TV", R.drawable.tv_24dp);
        Amenities amenities5 = new Amenities("", "Lawn", R.drawable.lawn_24dp);
        Amenities amenities6 = new Amenities("", "Taxi", R.drawable.taxi_cab_24dp);
//        Amenities amenities7 =  new Amenities("api.androidhive.info/json/movies/7.jpg","New Delhi");

        amenities.add(amenities1);
        amenities.add(amenities2);
        amenities.add(amenities3);
        amenities.add(amenities4);
        amenities.add(amenities5);
        amenities.add(amenities6);
        // amenities.add(amenities7);
        AmenitiesAdapter amenitiesAdapter = new AmenitiesAdapter(MainActivity.this, amenities);
        recyclerView_amenities.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));
        recyclerView_amenities.setAdapter(amenitiesAdapter);
    }

//    public void get_cities() {
//
//        recyclerView_cities = findViewById(R.id.recycle_cities);
//        // Cities citiy1 = new Cities("", "Nearby", R.drawable.gps_24dp);
//        Cities citiy2 = new Cities("", "Goa", R.drawable.goa);
//        Cities citiy3 = new Cities("", "Mumbai", R.drawable.mumbai);
//        Cities citiy4 = new Cities("", "Banglore", R.drawable.bangalore   );
//        Cities citiy5 = new Cities("", "Hyderabad", R.drawable.haydrabad);
//        Cities citiy6 = new Cities("", "Manali", R.drawable.manali);
//        //   Cities citiy7= new Cities("","Rohtak");
//
//        //  cities.add(citiy1);
//        cities.add(citiy2);
//        cities.add(citiy3);
//        cities.add(citiy4);
//        cities.add(citiy5);
//        cities.add(citiy6);
//        //cities.add(citiy7);
//        CityAdapter adapter = new CityAdapter(MainActivity.this, cities);
//        recyclerView_cities.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));
//        recyclerView_cities.setAdapter(adapter);
//    }

    public void get_hotels() {
        recyclerView_hotel = findViewById(R.id.recycle_hotels);

        Hotel hotel1 = new Hotel("", "Lemon Tree Premier",
                "3.5", "5",
                "344", "5555",
                "Excellent", R.drawable.lamontree, null);

        Hotel hotel2 = new Hotel("", "Promenage",
                "4.5", "10",
                "344", "4555",
                "Excellent", R.drawable.promenade, null);
        Hotel hotel3 = new Hotel("", "Ashoka Hotel",
                "2.5", "8",
                "300", "3555",
                "Good", R.drawable.ashoka, null);

        Hotel hotel4 = new Hotel("", "Welcome Hotel",
                "1.5", "5",
                "100", "2555",
                "Poor", R.drawable.wlcome, null);

        list.add(hotel1);
        list.add(hotel2);
        list.add(hotel3);
        list.add(hotel4);

        HotelAdapter adapter = new HotelAdapter(MainActivity.this, list);
        recyclerView_hotel.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView_hotel.setAdapter(adapter);

    }


    private void getOffer() {


        String urlFetchOffer = "http://18.191.105.30/devapi/getoffer";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlFetchOffer,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        busList.clear();
                        Log.e("offerResponse", response);
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            int status = jsonResponse.getInt("status");
                            String message = jsonResponse.getString("message");
                            if (status == 1) {
                                JSONObject jsonData = jsonResponse.getJSONObject("data");
                                /*JSONArray jsonArrayflight = jsonData.getJSONArray("flight");
                                Gson gson = new Gson();
                                for (int i = 0; i < jsonArrayflight.length(); i++) {
                                    OffersModel.Flight flight = gson.fromJson(String.valueOf(jsonArrayflight.get(i)), OffersModel.Flight.class);
                                    flightList.add(flight);
                                }*/

                               /* JSONArray jsonArrayhotel = jsonData.getJSONArray("hotel");
                                Gson gson1 = new Gson();
                                for (int i = 0; i < jsonArrayhotel.length(); i++) {
                                    OffersModel.Hotel hotel = gson1.fromJson(String.valueOf(jsonArrayhotel.get(i)), OffersModel.Hotel.class);
                                    hotelList.add(hotel);
                                }*/

                                JSONArray jsonArrayBus = jsonData.getJSONArray("bus");
                                Gson gson2 = new Gson();
                                for (int i = 0; i < jsonArrayBus.length(); i++) {
                                    OffersModel.Bus bus = gson2.fromJson(String.valueOf(jsonArrayBus.get(i)), OffersModel.Bus.class);
                                    busList.add(bus);
                                }

                                /*JSONArray jsonArrayholiday = jsonData.getJSONArray("cab");
                                Gson gson3 = new Gson();
                                for (int i = 0; i < jsonArrayholiday.length(); i++) {
                                    OffersModel.Cab  cab= gson3.fromJson(String.valueOf(jsonArrayholiday.get(i)),OffersModel.Cab.class);
                                    holidayList.add(cab);
                                }*/

                            } else {
                                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                            }

                            offerAdapter.notifyDataSetChanged();
                            //offerFlightAdapter.notifyDataSetChanged();
                            //offerHotelAdapter.notifyDataSetChanged();
                            final int speedScroll = 900;
                            final Handler handler = new Handler();
                            final Runnable runnable = new Runnable() {
                                int count = 0;
                                boolean flag = true;

                                @Override
                                public void run() {
                                    if (count < offerAdapter.getItemCount()) {
                                        if (count == offerAdapter.getItemCount() - 1) {
                                            flag = false;
                                        } else if (count == 0) {
                                            flag = true;
                                        }
                                        if (flag) count++;
                                        else count--;
                                        recyclerOffer.smoothScrollToPosition(count);
                                        handler.postDelayed(this, speedScroll);
                                    }
                                }
                            };
                            handler.postDelayed(runnable, speedScroll);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("vollyerror", String.valueOf(error));
                    }
                });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(3000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    private void cities_main(){
        Log.d("cities main","runnning");

        recyclerView_cities = findViewById(R.id.recycle_cities);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);

        Call<List<Cities_Main>> call = service.getcities("hpt@2019");

        call.enqueue(new Callback<List<Cities_Main>>() {
            @Override
            public void onResponse(Call<List<Cities_Main>> call, retrofit2.Response<List<Cities_Main>> response) {
                //arrayList.add(response);

                List<Cities_Main> list=response.body();
                set_cities_adapter(list);
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Cities_Main>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });








    }
    private void set_cities_adapter (List<Cities_Main> list){



        CityAdapter adapter = new CityAdapter(MainActivity.this,list);
        recyclerView_cities.setLayoutManager(new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false));
        recyclerView_cities.setAdapter(adapter);




    }
}
