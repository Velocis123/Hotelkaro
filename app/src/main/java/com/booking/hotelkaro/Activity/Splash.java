package com.booking.hotelkaro.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.booking.hotelkaro.R;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.ACCESS_WIFI_STATE;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Splash extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_splash);
        requestPermission();
        if (!checkPermission()) {


        }
        else {

            new Thread() {

                @Override
                public void run() {


                    try {


                        Thread.sleep(3000);

                        startActivity(new Intent(Splash.this, Login.class));
                        Splash.super.finish();

                    } catch (Exception e) {

                    }
                }
            }.start();

        }


    }
    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{ ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_CODE);
        /**/

    }

    private boolean checkPermission() {
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        int result2 = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_COARSE_LOCATION);

        return result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED ;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {


                    boolean finloc = grantResults[0] == getPackageManager().PERMISSION_GRANTED;
                    boolean coarseloc = grantResults[1] == getPackageManager().PERMISSION_GRANTED;


                    if (finloc && coarseloc) {

                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                    }

                    else {

                        new Thread() {

                            @Override
                            public void run() {


                                try {


                                    Thread.sleep(3000);

                                    startActivity(new Intent(Splash.this, Login.class));
                                    Splash.super.finish();

                                } catch (Exception e) {

                                }
                            }
                        }.start();
                    }
                    finish();
                }
        }

    }



}
