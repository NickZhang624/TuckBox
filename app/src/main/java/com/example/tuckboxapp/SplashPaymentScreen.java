package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.User;

public class SplashPaymentScreen extends AppCompatActivity {
    User user;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_payment_screen);
        user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
        textView =findViewById(R.id.splash_name);
        textView.setText(user.getFirstName());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashPaymentScreen.this,AppServices.class);
                i.putExtra(MainActivity.USER_OBJECT,user);
                startActivity(i);
                finish();
            }
        },8000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),
                        "Order Successfully! Your meal is on the way now.", Toast.LENGTH_LONG).show();
                finish();
            }
        },9000);

    }


}
