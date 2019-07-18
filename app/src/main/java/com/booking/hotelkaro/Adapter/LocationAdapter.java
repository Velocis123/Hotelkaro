package com.booking.hotelkaro.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.booking.hotelkaro.API.Api;
import com.booking.hotelkaro.Activity.CityLocation;
import com.booking.hotelkaro.Activity.MainActivity;
import com.booking.hotelkaro.Model.CityModel;
import com.booking.hotelkaro.Model.LocationModel;
import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class LocationAdapter extends   RecyclerView.Adapter<LocationAdapter.MyViewHolder> {

    private Context mContext;
    private List<LocationModel> cityList;


    public LocationAdapter(Context mContext, List<LocationModel> cityList) {
        this.mContext = mContext;
        this.cityList = cityList;
    }

    @NonNull
    @Override
    public LocationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.location_item, viewGroup, false);

        return new LocationAdapter.MyViewHolder(itemView);



    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());


        LocationModel cities =cityList.get(i);

        myViewHolder.txt_loc.setText(cities.getName());

        Toast.makeText(mContext,""+cities.getName(), Toast.LENGTH_LONG).show();

        Log.i("cityname",cities.getName());





    }



    @Override
    public int getItemCount() {

        Log.i("locsize",""+cityList.size());
        return cityList.size() ;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_loc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_loc = itemView.findViewById(R.id.loc);
        }



    }



}
