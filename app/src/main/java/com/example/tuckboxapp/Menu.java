package com.example.tuckboxapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                startActivity(i);
                break;
            case R.id.order:
                Intent p = new Intent(this,PlaceOrder.class);
                startActivity(p);
                break;
            case R.id.update:
                Intent up = new Intent(this,UserListView.class);
                startActivity(up);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
