package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tuckboxapp.DataModelPackage.User;

public class AppServices extends Menu {
    static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_services);

        user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
    }

    public void updateUserInforButtonClicked(View view) {
        Intent i = new Intent(this,UserListView.class);
        i.putExtra(MainActivity.USER_OBJECT,getIntent().getSerializableExtra(MainActivity.USER_OBJECT));
        startActivity(i);
    }

    public void placeOrderButtonClicked(View view) {
        Intent i = new Intent(this,RegionAndDeliveryTime.class);
        i.putExtra(MainActivity.USER_OBJECT,getIntent().getSerializableExtra(MainActivity.USER_OBJECT));
        startActivity(i);
    }

    public void logoutButtonClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout");
        builder.setMessage("Are you want to logout ?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                logout();
                }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                user =(User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void logout(){
        finish();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
