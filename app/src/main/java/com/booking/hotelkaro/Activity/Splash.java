package com.booking.hotelkaro.Activity;

import android.content.Intent;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.booking.hotelkaro.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_splash);



        new Thread(){

            @Override
            public  void run() {


                try{


                    Thread.sleep(3000);

                    startActivity(new Intent(Splash.this,Login.class));
                    Splash.super.finish();

                }catch (Exception e)
                {

                }
            }
        }.start();


    }
}
