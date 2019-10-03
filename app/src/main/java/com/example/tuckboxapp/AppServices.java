package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tuckboxapp.DataModelPackage.User;

public class AppServices extends Menu {
    User user;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_services);
    }

    public void updateUserInforButtonClicked(View view) {
        Intent i = new Intent(this,UserListView.class);
        startActivity(i);
    }

    public void placeOrderButtonClicked(View view) {
        Intent i = new Intent(this,PlaceOrder.class);
        startActivity(i);
    }
}
