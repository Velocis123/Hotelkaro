package com.booking.hotelkaro.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.booking.hotelkaro.Activity.NoOfPerson;
import com.booking.hotelkaro.Model.Room;
import com.booking.hotelkaro.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {
    private Context mContext;
    private List<Room> roomList;
    public static int GETNUM=1;
    public static int COUNTER ;
    public String ROOM_ADAPTER_DATA = "roomdata";
    SharedPreferences sharedpreferences;
    public static  Map<Integer,Integer> map=new HashMap<Integer,Integer>();

    public RoomAdapter(Context mContext, List<Room> roomList) {
        this.mContext = mContext;
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.floatingview_add_people, viewGroup, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        final Room room = roomList.get(i);

        myViewHolder.txt_room_number.setText(""+room.getCount());
        myViewHolder.child.setChecked(room.isChild());
        sharedpreferences = mContext.getSharedPreferences(ROOM_ADAPTER_DATA,Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();


        myViewHolder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GETNUM =1 ;
                room.setNop(GETNUM);
                myViewHolder.btn1.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
                myViewHolder.btn2.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                myViewHolder. btn3.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
            }
        });

        myViewHolder.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GETNUM = 2;
                room.setNop(GETNUM);
                myViewHolder.btn1.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                myViewHolder.btn2.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
                myViewHolder. btn3.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
            }
        });

        myViewHolder.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GETNUM = 3;
                room.setNop(GETNUM);

                myViewHolder.btn1.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                myViewHolder.btn2.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                myViewHolder.btn3.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));

            }
        });
        myViewHolder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                COUNTER = roomList.size() + 1;
                Room room1=new Room(COUNTER,0,false);
                NoOfPerson.updateList(room1);
                editor.putInt("room",roomList.size());
                editor.putInt("people",room.getNop());
                editor.commit();
            }
        });
            myViewHolder.cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(roomList.size()!=1) {
                        COUNTER = roomList.size() - 1;
                        roomList.remove(i);
                        NoOfPerson.roomAdapter.notifyDataSetChanged();
                    }
                }
            });

            myViewHolder.btn_add_person.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    COUNTER = roomList.size() + 1;
                    Room room1 = new Room(COUNTER, 0, false);
                    NoOfPerson.updateList(room1);


                    map.put(roomList.size(),GETNUM);

                  







                }
            });



        }
    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_room_number;
        CheckBox child;
        LinearLayout btn1,btn2,btn3,len_person,len_del;
        Button btn_add,btn_del,btn_add_person;
        ImageView cross;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_room_number= itemView.findViewById(R.id.room_no);
            child = itemView.findViewById(R.id.check_child);
            btn1 = itemView.findViewById(R.id.btn_1);
            btn2 = itemView.findViewById(R.id.btn_2);
            btn3 = itemView.findViewById(R.id.btn_3);
            btn_add = itemView.findViewById(R.id.btn_add);
            btn_del = itemView.findViewById(R.id.btn_del);
            len_person = itemView.findViewById(R.id.len_person);
            btn_add_person =itemView.findViewById(R.id.btn_person);
            len_del = itemView.findViewById(R.id.len_del);
            cross=itemView.findViewById(R.id.cross);

        }
    }

}
