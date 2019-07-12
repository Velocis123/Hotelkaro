package com.booking.hotelkaro.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.booking.hotelkaro.Adapter.RoomAdapter;
import com.booking.hotelkaro.Model.Room;
import com.booking.hotelkaro.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class NoOfPerson extends AppCompatActivity  implements View.OnClickListener {
RecyclerView recyclerView_people;
static  List<Room> rooms = new ArrayList<>();
LinearLayout btn1,btn2,btn3;
private int GETNUM = 0;
private int abc;
private LinearLayout ll;
private ImageView cross;


    public static  RoomAdapter roomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_of_person);
        recyclerView_people = findViewById(R.id.recycle_numOFPerson);
        ll=findViewById(R.id.apply);
        ll.setOnClickListener(this);
        cross=findViewById(R.id.cross);
        cross.setOnClickListener(this);



//btn1 = findViewById(R.id.btn_1);
//btn2 = findViewById(R.id.btn_2);
//btn3 = findViewById(R.id.btn_3);
//
//btn1.setOnClickListener(this);
//btn2.setOnClickListener(this);
//btn3.setOnClickListener(this);




    }

    @Override
    protected void onResume() {
        super.onResume();
        rooms.clear();
        RoomAdapter.map.clear();
        persons();
    }

    public void persons(){

        Room room = new Room(1,1,false);
        rooms.add(room);
        RoomAdapter.map.put(1,1);
        roomAdapter = new RoomAdapter(NoOfPerson.this,rooms);
        recyclerView_people.setLayoutManager(new LinearLayoutManager(this,LinearLayout.VERTICAL,false));
        recyclerView_people.setAdapter(roomAdapter);



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

    @Override
    public void onClick(View v) {


        switch (v.getId())
        {
            case R.id.apply:







                int sum=0;

                for (Map.Entry<Integer, Integer> entry : RoomAdapter.map.entrySet()) {
                    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

                   //

                    sum=sum+entry.getValue();
                }


                Toast.makeText(this,"Sum="+sum,Toast.LENGTH_LONG).show();

                Intent i=new Intent(NoOfPerson.this,Search.class);
                i.putExtra("room",""+RoomAdapter.map.size());
                i.putExtra("person",""+sum);
                setResult(102,i);
                finish();
                break;
            case R.id.cross:

                super.onBackPressed();

                break;



        }

    }
}
