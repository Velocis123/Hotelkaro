package com.booking.hotelkaro.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.booking.hotelkaro.API.Api;
import com.booking.hotelkaro.API.ApiService;
import com.booking.hotelkaro.Model.Hotel_list;
import com.booking.hotelkaro.Model.OTPModel;
import com.booking.hotelkaro.R;
import com.google.gson.JsonObject;
import com.nostra13.universalimageloader.utils.L;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    private Button btnGo;
    private EditText phone;
    private String phoneval;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnGo = findViewById(R.id.btn_login);
        phone=findViewById(R.id.phone);

         btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Login.this, Login_verification.class));
                phoneval=phone.getText().toString();

                //Remove after implement.
                Intent i=new Intent(Login.this,Login_verification.class);
                i.putExtra("phone",phoneval);
                startActivity(i);

               /* if(phoneval.length()==0)
                {
                    phone.setError("Please enter mobile number");
                }else {

                    Toast.makeText(Login.this, phoneval, Toast.LENGTH_SHORT).show();
                    getOTPService();
                }*/
            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
    }



    private void getOTPService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);

        Call<OTPModel> call = service.getOTP("hpt@2019",phoneval);



        call.enqueue(new Callback<OTPModel>() {
            @Override
            public void onResponse(Call<OTPModel> call, retrofit2.Response<OTPModel> response) {


                OTPModel model=response.body();

                if(model.getError_msg().equals("User already Registered"))
                {
                    //Toast.makeText(Login.this,model.getError_msg(),Toast.LENGTH_LONG).show();
                    phone.setError(model.getError_msg());
                    phone.setText("");


                }else {


                    // Toast.makeText(Login.this,model.getError_msg(),Toast.LENGTH_LONG).show();

                    Intent i=new Intent(Login.this,Login_verification.class);
                    i.putExtra("phone",phoneval);
                    startActivity(i);

                }











            }

            @Override
            public void onFailure(Call<OTPModel> call, Throwable t) {
                Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });







    }


}
