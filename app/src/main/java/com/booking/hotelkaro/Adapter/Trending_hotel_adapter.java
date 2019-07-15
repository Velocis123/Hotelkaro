package com.booking.hotelkaro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.booking.hotelkaro.Model.Trending_Hotel;
import com.booking.hotelkaro.R;

import java.util.List;

public class Trending_hotel_adapter extends RecyclerView.Adapter<Trending_hotel_adapter.MyViewHolder> {

    private Context mContext;
    private List<Trending_Hotel> hotelList;

    public Trending_hotel_adapter(Context mContext, List<Trending_Hotel> hotelList) {
        this.mContext = mContext;
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.cardview_trending_hotels, viewGroup, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
//        ImageLoader.getInstance().init(universalImageLoader.getConfig());
//        myViewHolder.imageView.setImageResource(R.drawable.ic_launcher_background);


        Trending_Hotel trending_hotels = hotelList.get(i);
       myViewHolder.hotel_name.setText(trending_hotels.getHotel_name());
    
//UniversalImageLoader.setImage(hotel.getImg(),myViewHolder.imageView,null,"https://");
        myViewHolder.imageView.setImageResource(trending_hotels.getImg_demo());
     

    }

    @Override
    public int getItemCount() {

        return hotelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView hotel_name;
      
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hotel_name = itemView.findViewById(R.id.txt_hotel_name);
            imageView = itemView.findViewById(R.id.img_hotel);
           
        }


    }




}
