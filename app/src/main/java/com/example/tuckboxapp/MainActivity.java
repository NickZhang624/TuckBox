package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tuckboxapp.DataModelPackage.UserDao;
import com.example.tuckboxapp.DataModelPackage.UserDatabase;

public class MainActivity extends AppCompatActivity {
    public static UserDao userDao;
    EditText etUserName, etUserPassword;
    public static final String USER_OBJECT = "USER_OBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDao = UserDatabase.createmyDBInstance(this).getDao();
        etUserName = findViewById(R.id.edit_user_name_login);
        etUserPassword = findViewById(R.id.edit_password_login);
    }

    public void registerButtonClicked(View view) {
        Intent i = new Intent(this,Registration.class);
        startActivity(i);
    }
}
