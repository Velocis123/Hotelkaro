package com.booking.hotelkaro.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.booking.hotelkaro.Activity.HotelDescription;
import com.booking.hotelkaro.Model.Amenities;
import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.Model.Hotel_list;
import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.OnHotelListener;

import java.util.List;

public class HotelSearchAdapter extends RecyclerView.Adapter<HotelSearchAdapter.MyViewHolder> {

    private Context mContext;
    private List<Hotel_list> hotelList;
    private List<Amenities> amenities;
    private OnHotelListener listener;

    public HotelSearchAdapter(Context mContext, List<Hotel_list> hotelList, List<Amenities> amenities, OnHotelListener listener) {
        this.mContext = mContext;
        this.hotelList = hotelList;
        this.amenities = amenities;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.cardview_layout_search, viewGroup, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
//        ImageLoader.getInstance().init(universalImageLoader.getConfig());
//        myViewHolder.imageView.setImageResource(R.drawable.ic_launcher_background);

        myViewHolder.bind(hotelList.get(i), listener);


        Hotel_list hotel = hotelList.get(i);




        myViewHolder.hotel_name.setText(hotel.getName());
        myViewHolder.distance.setText( " km from centre");
        myViewHolder.reviews.setText( " reviews");
        myViewHolder.price.setText("$ " +  "/-");
        myViewHolder.remarks.setText("");
//UniversalImageLoader.setImage(hotel.getImg(),myViewHolder.imageView,null,"https://");
//        myViewHolder.imageView.setImageResource(hotel.getImg_demo());
        myViewHolder.ratingBar.setRating(2.5f);
        ImageRecyclerAdapter imageRecyclerAdapter = new ImageRecyclerAdapter(mContext, hotelList, new OnHotelListener() {
            @Override
            public void onItemClick(Hotel_list item) {
                Intent intent = new Intent(mContext, HotelDescription.class);
                //intent.putExtra("MODEL", item);
                mContext.startActivity(intent);
            }
        });
        myViewHolder.recycle_image.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false));
        myViewHolder.recycle_image.setAdapter(imageRecyclerAdapter);

        Amenities_Search_Adapter amenitiesAdapter = new Amenities_Search_Adapter(mContext, amenities);
        myViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false));
        myViewHolder.recyclerView.setAdapter(amenitiesAdapter);


    }


    @Override
    public int getItemCount() {

        return hotelList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView hotel_name, distance, reviews, price, remarks;
        RatingBar ratingBar;
        ImageView imageView;
        RecyclerView recyclerView, recycle_image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hotel_name = itemView.findViewById(R.id.txt_hotel);
            distance = itemView.findViewById(R.id.txt_distannce);
            reviews = itemView.findViewById(R.id.txt_reviews);
            price = itemView.findViewById(R.id.txt_price);
            remarks = itemView.findViewById(R.id.txt_review);
            imageView = itemView.findViewById(R.id.img_cardv);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            recyclerView = itemView.findViewById(R.id.rec_amenities);
            recycle_image = itemView.findViewById(R.id.recycler_img);


        }

        public void bind(final Hotel_list hotel, final OnHotelListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(hotel);
                }
            });
        }

    }
}