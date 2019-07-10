package com.booking.hotelkaro.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.booking.hotelkaro.Adapter.RoomAdapter;
import com.booking.hotelkaro.Model.Room;
import com.booking.hotelkaro.R;

import java.util.ArrayList;
import java.util.List;

public class NoOfPerson extends AppCompatActivity implements View.OnClickListener {
RecyclerView recyclerView_people;
static  List<Room> rooms = new ArrayList<>();
LinearLayout btn1,btn2,btn3;
private int GETNUM = 0;
private int abc;

    public static  RoomAdapter roomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_of_person);


        recyclerView_people = findViewById(R.id.recycle_numOFPerson);
//btn1 = findViewById(R.id.btn_1);
//btn2 = findViewById(R.id.btn_2);
//btn3 = findViewById(R.id.btn_3);
//
//btn1.setOnClickListener(this);
//btn2.setOnClickListener(this);
//btn3.setOnClickListener(this);

persons();



    }

    public void persons(){

Room room = new Room(1,0,false);
//if (GETNUM ==1){
//
//    room.setNop(GETNUM);
//    Toast.makeText(NoOfPerson.this,room.getNop(),Toast.LENGTH_LONG).show();
//}
//
//else if (GETNUM ==2){
//    room.setNop(GETNUM);
//    Toast.makeText(NoOfPerson.this,room.getNop(),Toast.LENGTH_LONG).show();
//}
//
//else if (GETNUM ==3){
//    room.setNop(GETNUM);
//    Toast.makeText(NoOfPerson.this,room.getNop(),Toast.LENGTH_LONG).show();
//
//}

rooms.add(room);

         roomAdapter = new RoomAdapter(NoOfPerson.this,rooms);
        recyclerView_people.setLayoutManager(new LinearLayoutManager(this,LinearLayout.VERTICAL,false));
        recyclerView_people.setAdapter(roomAdapter);









    }


    @Override
    public void onClick(View v) {

    }


    static  public void updateList(Room room)
    {
        rooms.add(room);
        roomAdapter.notifyDataSetChanged();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        rooms.clear();
    }
}
