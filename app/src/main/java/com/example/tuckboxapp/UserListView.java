package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tuckboxapp.DataModelPackage.User;

public class UserListView extends Menu {

    User user;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_view);

        user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
        Log.d("CUSTOMER", "Customer ID is " + user.getID());

        recyclerView = findViewById(R.id.user_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());

    }

    public void addCardButtonClicked(View view) {
        Intent i = new Intent(this,AddCard.class);
        i.putExtra(MainActivity.USER_OBJECT,user);
        startActivity(i);
    }

    public void addAddressButtonClicked(View view) {
        Intent i = new Intent(this,AddAddress.class);
        i.putExtra(MainActivity.USER_OBJECT,user);
        startActivity(i);
    }
}
