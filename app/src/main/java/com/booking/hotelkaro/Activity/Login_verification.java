package com.booking.hotelkaro.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.booking.hotelkaro.R;

public class Login_verification extends AppCompatActivity {

    Button btnRegister;
    private String phoneval;
    private TextView phone,change;
    private EditText name,otp;
    private String nameval,otpval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_verification);
        phoneval=super.getIntent().getExtras().getString("phone");
        phone=findViewById(R.id.phone);
        name=findViewById(R.id.name);
        otp=findViewById(R.id.otp);
        change=findViewById(R.id.change);

        phone.setText(phoneval);

        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameval=name.getText().toString();
                otpval=name.getText().toString();

                if(valiation())
                {
                    startActivity(new Intent(Login_verification.this, MainActivity.class));
                }else
                {
                    //startActivity(new Intent(Login_verification.this, MainActivity.class));
                }




            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login_verification.super.onBackPressed();
            }
        });



    }

    public boolean valiation()
    {

        if(nameval.length()==0)
        {
            name.setError("Please enter name");
            return false;

        }
        if(otpval.length()==0)
        {

            name.setError("Please enter otp");
            return false;
        }


        return  true;

    }
}
