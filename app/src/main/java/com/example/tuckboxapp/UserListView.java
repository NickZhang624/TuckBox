package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class UserListView extends AppCompatActivity {

    RecyclerView studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_view);

        studentList = findViewById(R.id.user_list_recycler_view);
        studentList.setLayoutManager(new LinearLayoutManager(this));
        studentList.setAdapter(new MyAdapter());

    }
}
