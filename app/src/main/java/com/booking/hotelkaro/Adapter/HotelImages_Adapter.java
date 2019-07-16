package com.booking.hotelkaro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.booking.hotelkaro.Model.Amenities;
import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.Model.Hotel_Main;
import com.booking.hotelkaro.Model.Hotel_list;
import com.booking.hotelkaro.R;

import java.util.List;

public class HotelImages_Adapter extends   RecyclerView.Adapter<HotelImages_Adapter.MyViewHolder> {

    private Context mContext;
    private List<Hotel> hotelList;

    public HotelImages_Adapter(Context mContext, List<Hotel> hotelList) {
        this.mContext = mContext;
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_hotel_images, viewGroup, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
//        ImageLoader.getInstance().init(universalImageLoader.getConfig());
Hotel hotel = hotelList.get(i);
//
//        UniversalImageLoader.setImage(amenities.getAmenities_img(),myViewHolder.img_amenities,null,"https://");
myViewHolder.img_hotel.setImageResource(hotel.getImg_recycle().get(i));

    }



    @Override
    public int getItemCount() {

        return hotelList.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_hotel;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
 img_hotel = itemView.findViewById(R.id.hotel_image);

        }


    }
}
