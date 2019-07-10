package com.booking.hotelkaro.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.booking.hotelkaro.Model.Hotel;
import com.booking.hotelkaro.R;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder> {

    private Context mContext;
    private List<Hotel> hotelList;

    public HotelAdapter(Context mContext, List<Hotel> hotelList) {
        this.mContext = mContext;
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.cardview_layout, viewGroup, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
//        ImageLoader.getInstance().init(universalImageLoader.getConfig());
//        myViewHolder.imageView.setImageResource(R.drawable.ic_launcher_background);


        Hotel hotel = hotelList.get(i);
        myViewHolder.hotel_name.setText(hotel.getHotel_name());
        myViewHolder.distance.setText(hotel.getDistance() + " km from centre");
        myViewHolder.reviews.setText(hotel.getReviews() + " reviews");
        myViewHolder.price.setText("$ " + hotel.getPrice() + "/-");
        myViewHolder.remarks.setText(hotel.getRemarks());
//UniversalImageLoader.setImage(hotel.getImg(),myViewHolder.imageView,null,"https://");
        myViewHolder.imageView.setImageResource(hotel.getImg_demo());
        myViewHolder.ratingBar.setRating(Float.parseFloat(hotel.getRatings()));

    }

    @Override
    public int getItemCount() {

        return hotelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView hotel_name, distance, reviews, price, remarks;
        RatingBar ratingBar;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hotel_name = itemView.findViewById(R.id.txt_hotel);
            distance = itemView.findViewById(R.id.txt_distannce);
            reviews = itemView.findViewById(R.id.txt_reviews);
            price = itemView.findViewById(R.id.txt_price);
            remarks = itemView.findViewById(R.id.txt_review);
            imageView = itemView.findViewById(R.id.img_cardv);
            ratingBar = itemView.findViewById(R.id.ratingBar);

        }


    }
}
