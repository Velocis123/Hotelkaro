package com.booking.hotelkaro.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.booking.hotelkaro.API.Api;
import com.booking.hotelkaro.API.ApiService;
import com.booking.hotelkaro.Model.Cities_Main;
import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.Datepickerfragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CityLocation extends AppCompatActivity implements  GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener , View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private static final String TAG = "MainActivity";
    private TextView mLatitudeTextView;
    private TextView mLongitudeTextView;
    private GoogleApiClient mGoogleApiClient;
    private Location mLocation;
    private LocationManager mLocationManager;
    private LocationRequest mLocationRequest;
    private com.google.android.gms.location.LocationListener listener;
    private long UPDATE_INTERVAL = 2 * 1000;  /* 10 secs */
    private long FASTEST_INTERVAL = 2000; /* 2 sec */
    Cities_Main cities_main;
    private LocationManager locationManager;
    private String state;
    private String locality;
    String flag;
    StringBuilder sb;
    String result;
    EditText edt_searchbox;
    ImageView img_search,img_back;
    String id ;
    TextView in,indate,out,outdate,indays,room,roomval;
    static int DATE_DIALOG = 0;
    public static final String DATE_FORMAT = "d/M/yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_location);
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        sb = new StringBuilder();
        checkLocation(); //check whether location service is enable or not in your  phone


        edt_searchbox  = findViewById(R.id.edt_searchtext);
        img_search = findViewById(R.id.img_search);
        img_back= findViewById(R.id.img_back);
        flag=super.getIntent().getExtras().getString("flag");

        in=findViewById(R.id.in);
        indate=findViewById(R.id.indate);
        out=findViewById(R.id.out);
        outdate=findViewById(R.id.outdate);
        indays=findViewById(R.id.indays);
        room=findViewById(R.id.room);
        roomval=findViewById(R.id.roomval);


        in.setOnClickListener(this);
        out.setOnClickListener(this);
        room.setOnClickListener(this);


        if(flag.equals("c"))
        {
            cities_main=(Cities_Main) super.getIntent().getExtras().get("id");

         //show layout
//            if (edt_searchbox.requestFocus() == true){
//
              edt_searchbox.setText("Where is " + cities_main.getHomecity_name() + "?");

//
//
//            }


        }else if (flag.equals("s"))
        {
            edt_searchbox.requestFocus();
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            //open key here and set focus
            edt_searchbox.setText("");


        }

            edt_searchbox.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        edt_searchbox.setText("");
    }
});

            img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_search;

                get_search = edt_searchbox.getText().toString();

                Intent intent = new Intent(CityLocation.this,Search.class);
                intent.putExtra("SEARCH_CONTENT",cities_main.getName());
               // intent.putExtra("id",cities_main.getId());
                startActivity(intent);




            }
        });
            img_back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        onBackPressed();
    }
});

    }

    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        startLocationUpdates();

        mLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if(mLocation == null){
            startLocationUpdates();
        }
        if (mLocation != null) {

            // mLatitudeTextView.setText(String.valueOf(mLocation.getLatitude()));
            //mLongitudeTextView.setText(String.valueOf(mLocation.getLongitude()));
        } else {
            Toast.makeText(this, "Location not Detected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Connection Suspended");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(TAG, "Connection failed. Error: " + connectionResult.getErrorCode());
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    protected void startLocationUpdates() {
        // Create the location request
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL);
        // Request location updates
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                mLocationRequest, this);
        Log.d("reque", "--->>>>");
    }

    @Override
    public void onLocationChanged(Location location) {

        String msg = "Updated Location: " +
                Double.toString(location.getLatitude()) + "," +
                Double.toString(location.getLongitude());

       // Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        flag=super.getIntent().getExtras().getString("flag");

        Geocoder geocoder=new Geocoder(this);
        try {


            List<Address> addressList = geocoder.getFromLocation(
                    location.getLatitude(), location.getLongitude(), 1);
            if (addressList != null && addressList.size() > 0) {
                Address address = addressList.get(0);

                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    sb.append(address.getAddressLine(i)).append("\n");
                }
               state = address.getLocality();
                locality = address.getSubLocality();
//               sb.append(address.getLocality()).append("\n");
//                sb.append(address.getPostalCode()).append("\n");
//                sb.append(address.getCountryName());
              result = sb.toString();
if (flag.equals("map")){

    edt_searchbox.setText(state + "," + locality);

}
               // Toast.makeText(this,result,Toast.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            Log.e(TAG, "Unable connect to Geocoder", e);
        } finally {




        }

    }

    private boolean checkLocation() {
        if(!isLocationEnabled())
            showAlert();
        return isLocationEnabled();
    }

    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Enable Location")
                .setMessage("Your Locations Settings is set to 'Off'.\nPlease Enable Location to " +
                        "use this app")
                .setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                    }
                });
        dialog.show();
    }

    private boolean isLocationEnabled() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
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
                startActivity(new Intent(CityLocation.this, NoOfPerson.class));
                break;
        }


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
}
