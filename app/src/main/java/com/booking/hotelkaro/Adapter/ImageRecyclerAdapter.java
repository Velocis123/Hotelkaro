package com.booking.hotelkaro.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.OnHotelListener;

import java.util.List;

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private List<Hotel> imageList;
    private OnHotelListener listener;

    public ImageRecyclerAdapter(Context mContext, List<Hotel> imageList, OnHotelListener listener) {
        this.mContext = mContext;
        this.imageList = imageList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_imageview, viewGroup, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Hotel hotel = imageList.get(i);
        myViewHolder.bind(imageList.get(i), listener);
        myViewHolder.imageView.setImageResource(hotel.getImg_recycle().get(i));


    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            imageView = itemView.findViewById(R.id.img_recycle);
        }

        public void bind(final Hotel hotel, final OnHotelListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(hotel);
                }
            });
        }
    }
}
