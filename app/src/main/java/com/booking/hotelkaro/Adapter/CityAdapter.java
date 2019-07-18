package com.booking.hotelkaro.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.booking.hotelkaro.API.Api;
import com.booking.hotelkaro.API.ApiService;
import com.booking.hotelkaro.Activity.CityLocation;
import com.booking.hotelkaro.Activity.FindingLocation;
import com.booking.hotelkaro.Activity.MainActivity;
import com.booking.hotelkaro.Activity.Map;
import com.booking.hotelkaro.Model.Cities;

import com.booking.hotelkaro.Model.Cities_Main;
import com.booking.hotelkaro.Model.CityModel;
import com.booking.hotelkaro.R;
import com.booking.hotelkaro.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CityAdapter extends   RecyclerView.Adapter<CityAdapter.MyViewHolder> {

    private Context mContext;
    private List<CityModel> cityList;
    int postion;
    CityModel pos;

    public CityAdapter(Context mContext, List<CityModel> cityList) {
        this.mContext = mContext;
        this.cityList = cityList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_city, viewGroup, false);

        return new MyViewHolder(itemView);


    }



    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {


//        myViewHolder.img_city.setTag(postion);

        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());


        CityModel cities =cityList.get(i);
        postion=myViewHolder.getAdapterPosition();
        myViewHolder.img_city.setTag(postion);

        pos = cityList.get(i);


        if (i==0){

            //myViewHolder.img_city.setImageResource(cities.getCity_demo());

        }
        else
        {
            UniversalImageLoader.setImage(cities.getImage(),myViewHolder.img_city,null, Api.BASE_URL);
        }



//        myViewHolder.img_city.setImageResource(cities.getCity_demo());

        myViewHolder.txt_city.setText(cities.getName());

        Log.i("cityname",cities.getName());



        //Toast.makeText(mContext,""+postion, Toast.LENGTH_LONG).show();

        myViewHolder.img_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                int pos=(Integer)myViewHolder.img_city.getTag();
//                if(pos==0)
//                {
//
//                    //  Toast.makeText(mContext,"Location1", Toast.LENGTH_LONG).show();
//
//                    Intent i=new Intent(mContext, Map.class);
//                    mContext.startActivity(i);
//                }
//                else
//                {
//
//                }

                CityModel city=cityList.get(pos);

                Intent intent=new Intent(mContext, CityLocation.class);
                intent.putExtra("flag","c");
                intent.putExtra("MODEL",city);

                mContext.startActivity(intent);
            }
        });




    }



    @Override
    public int getItemCount() {

        return cityList.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_city;
        TextView txt_city ;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_city = itemView.findViewById(R.id.img_city);
            txt_city = itemView.findViewById(R.id.txt_city);
        }



    }
}
