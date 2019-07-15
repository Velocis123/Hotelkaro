package com.booking.hotelkaro.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.booking.hotelkaro.Activity.Invite_Earn;
import com.booking.hotelkaro.Activity.MainActivity;
import com.booking.hotelkaro.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavHelper {

    public static void enableNavigation(final Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.home:
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                        break;

                    case R.id.invite:
                        Intent intent1 = new Intent(context, Invite_Earn.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.share:

                        break;


                }
                return false;
            }
        });
    }

}

