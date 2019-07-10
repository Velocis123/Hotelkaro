package com.booking.hotelkaro.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.booking.hotelkaro.Activity.NoOfPerson;
import com.booking.hotelkaro.Model.Room;
import com.booking.hotelkaro.R;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {
    private Context mContext;
    private List<Room> roomList;
    public static int GETNUM=0;
    public static int COUNTER ;


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

//myViewHolder.len_person.setVisibility(View.GONE);
//myViewHolder.len_del.setVisibility(View.INVISIBLE);

for (int x =1 ;x<= roomList.size()-1;x++ ){

    myViewHolder.len_person.setVisibility(View.GONE);
myViewHolder.len_del.setVisibility(View.GONE);

}





            }
        });


//        if (COUNTER >1){
//            myViewHolder.len_person.setVisibility(View.INVISIBLE);
//            myViewHolder.len_del.setVisibility(View.VISIBLE);
//
//
//
//        }


        if(COUNTER== 1) {

     myViewHolder.len_person.setVisibility(View.VISIBLE);
     myViewHolder.len_del.setVisibility(View.INVISIBLE);

        }
//    else if(roomList.size()>1)
//        {
//       myViewHolder.len_person.setVisibility(View.INVISIBLE);
//       myViewHolder.len_del.setVisibility(View.VISIBLE);
//
//        }

            myViewHolder.btn_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    COUNTER = roomList.size() - 1;
                    roomList.remove(i);
                    NoOfPerson.roomAdapter.notifyDataSetChanged();





                }
            });

        /*if(i==0)
        {
            myViewHolder.btn_del.setVisibility(View.INVISIBLE);
            myViewHolder.btn_add.setVisibility(View.INVISIBLE);
            myViewHolder.btn_add_person.setVisibility(View.VISIBLE);
        }
        else {
            myViewHolder.btn_del.setVisibility(View.VISIBLE);
            myViewHolder.btn_add.setVisibility(View.VISIBLE);
            myViewHolder.btn_add_person.setVisibility(View.INVISIBLE);

        }*/

            myViewHolder.btn_add_person.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    COUNTER = roomList.size() + 1;


                    Room room1 = new Room(COUNTER, 0, false);

                    NoOfPerson.updateList(room1);


//
//
//                   myViewHolder.len_person.setVisibility(View.INVISIBLE);
//                   myViewHolder.len_del.setVisibility(View.VISIBLE);



        if (COUNTER >1){
            myViewHolder.len_person.setVisibility(View.INVISIBLE);
            myViewHolder.len_del.setVisibility(View.VISIBLE);



        }
//
//        }


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
        }
    }


//    class Listener implements View.OnClickListener
//    {
//
//
//        @Override
//        public void onClick(View v) {
//
//            switch (v.getId()){
//
//                case R.id.btn_1 : GETNUM =1 ;
//                    btn1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                    btn2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//                    btn3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//                    break;
//
//                case R.id.btn_2 : GETNUM = 2;
//                    btn1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//                    btn2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                    btn3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//
//                    break;
//
//                case R.id.btn_3 : GETNUM = 3;
//                    btn1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//                    btn2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//                    btn3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//
//        }
//    }
}
