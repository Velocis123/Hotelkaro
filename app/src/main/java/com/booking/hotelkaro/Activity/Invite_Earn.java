package com.booking.hotelkaro.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.BottomNavHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Invite_Earn extends AppCompatActivity {
    Context context = Invite_Earn.this;
    private static final int ACTIVITY_NUM = 1;
TextView txt_intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite__earn);
txt_intro = findViewById(R.id.txt_intro);
txt_intro.setText("Other will travel/book and pay you can get a Free Travel/Stay! \n" +
        " Invite your friends to HotelKaro.When they departure/check- \n" +
        " out,you get Free Stay/Travel.Also,they get Rs200 extra off \n" +
        "on their first stay/travel");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        BottomNavHelper.enableNavigation(context,bottomNavigationView);


        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }
}
