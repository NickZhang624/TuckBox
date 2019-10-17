package com.example.tuckboxapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.Cards;
import com.example.tuckboxapp.DataModelPackage.User;

public class Menu extends AppCompatActivity {
    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = (User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.main:
                Intent i = new Intent(this,AppServices.class);
                i.putExtra(MainActivity.USER_OBJECT,getIntent().getSerializableExtra(MainActivity.USER_OBJECT));
                startActivity(i);
                break;
            case R.id.order:
                Intent p = new Intent(this,RegionAndDeliveryTime.class);
                p.putExtra(MainActivity.USER_OBJECT,getIntent().getSerializableExtra(MainActivity.USER_OBJECT));
                startActivity(p);
                break;
            case R.id.update:
                Intent up = new Intent(this,UserListView.class);
                up.putExtra(MainActivity.USER_OBJECT,getIntent().getSerializableExtra(MainActivity.USER_OBJECT));
                startActivity(up);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
