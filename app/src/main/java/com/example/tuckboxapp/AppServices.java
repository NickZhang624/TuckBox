package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tuckboxapp.DataModelPackage.User;

public class AppServices extends Menu {
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_services);
    }

    public void updateUserInforButtonClicked(View view) {
        Intent i = new Intent(this,UserUpdateInfo.class);
        i.putExtra(MainActivity.USER_OBJECT,user);
        startActivity(i);
    }
}
