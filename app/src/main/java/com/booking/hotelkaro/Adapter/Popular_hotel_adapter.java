package com.booking.hotelkaro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.booking.hotelkaro.Model.PopularHotels;
import com.booking.hotelkaro.Model.Trending_Hotel;
import com.booking.hotelkaro.R;

import java.util.List;

public class Popular_hotel_adapter extends RecyclerView.Adapter<Popular_hotel_adapter.MyViewHolder> {

    private Context mContext;
    private List<PopularHotels> hotelList;

    public Popular_hotel_adapter(Context mContext, List<PopularHotels> hotelList) {
        this.mContext = mContext;
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.cardview_popular_hotel, viewGroup, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
//        ImageLoader.getInstance().init(universalImageLoader.getConfig());
//        myViewHolder.imageView.setImageResource(R.drawable.ic_launcher_background);


        PopularHotels trending_hotels = hotelList.get(i);
      //  myViewHolder.about.setText(trending_hotels.getAbout());

//UniversalImageLoader.setImage(hotel.getImg(),myViewHolder.imageView,null,"https://");
        myViewHolder.imageView.setImageResource(trending_hotels.getImg_demo());


    }

    @Override
    public int getItemCount() {

        return hotelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView about;
TextView hotel_name;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            about = itemView.findViewById(R.id.txt_abt_hotel);
            imageView = itemView.findViewById(R.id.img_hotel);

        }


    }



}
