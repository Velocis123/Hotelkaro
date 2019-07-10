package com.booking.hotelkaro.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.booking.hotelkaro.Model.Amenities;
import com.booking.hotelkaro.R;

import java.util.List;

public class Amenities_Search_Adapter extends   RecyclerView.Adapter<Amenities_Search_Adapter.MyViewHolder> {

    private Context mContext;
    private List<Amenities> amenitiesList;

    public Amenities_Search_Adapter(Context mContext, List<Amenities> amenitiesList) {
        this.mContext = mContext;
        this.amenitiesList = amenitiesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_amenities1, viewGroup, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
//        ImageLoader.getInstance().init(universalImageLoader.getConfig());
        Amenities amenities = amenitiesList.get(i);
//
//        UniversalImageLoader.setImage(amenities.getAmenities_img(),myViewHolder.img_amenities,null,"https://");

        myViewHolder.img_amenities.setImageResource(amenities.getAmenities_demo());

    }



    @Override
    public int getItemCount() {

        return amenitiesList.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_amenities;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           img_amenities = itemView.findViewById(R.id.img_amenity);

        }


    }
}
