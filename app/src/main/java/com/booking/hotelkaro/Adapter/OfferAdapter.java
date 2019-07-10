package com.booking.hotelkaro.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.booking.hotelkaro.Activity.Search;
import com.booking.hotelkaro.Model.OffersModel;
import com.booking.hotelkaro.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder> {

    ArrayList<OffersModel.Bus> listBusOffer;
    private Context mContext;


    public OfferAdapter(Context mContext, ArrayList<OffersModel.Bus> listBusOffer) {
        this.mContext = mContext;
        this.listBusOffer = listBusOffer;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_offer, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final OffersModel.Bus bus = listBusOffer.get(position);


        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        int height = displayMetrics.heightPixels / 4;
        int width = (int) (displayMetrics.widthPixels * 0.9);
        holder.itemView.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        Picasso.get()
                .load(bus.getImage())
                .placeholder(R.drawable.offer1)
                .error(R.drawable.offer1)
                .into(holder.offerImage);
        holder.offerCode.setText("Hotel Royal 20% off");


    }

    @Override
    public int getItemCount() {
        return listBusOffer.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView offerImage,iconOffer;
        TextView offerCode;

        MyViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            offerImage = itemView.findViewById(R.id.img_offer_flight);
            offerCode = itemView.findViewById(R.id.tv_offer_code_flight);
           // iconOffer = itemView.findViewById(R.id.icon_offer);
            //iconOffer.setImageDrawable(mContext.getDrawable(R.drawable.bus_white_24dp));


        }

        @Override
        public void onClick(View v) {
            final OffersModel.Bus bus = listBusOffer.get(getAdapterPosition());


         /*   Intent i = new Intent(mContext, Search.class);
//            i.putExtra("offercode",bus.getOffercode());
//            i.putExtra("offerprice",bus.getOff_price());
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);*/
           // mContext.startActivity(i);
        }
    }
}