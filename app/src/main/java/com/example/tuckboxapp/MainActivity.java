package com.example.tuckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tuckboxapp.DataModelPackage.User;
import com.example.tuckboxapp.DataModelPackage.UserDao;
import com.example.tuckboxapp.DataModelPackage.UserDatabase;

import java.util.List;

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

//    public void loginButtonClicked(View view) {
//        if(etUserName.getText().toString().trim().isEmpty()){
//            Toast.makeText(this,
//                    "User name is required", Toast.LENGTH_LONG).show();
//        } else if(etUserPassword.getText().toString().trim().isEmpty()){
//            Toast.makeText(this,
//                    "Password is required", Toast.LENGTH_LONG).show();
//        } else {
//            new ReadUserByUName().execute(etUserName.getText().toString());
//        }
//    }
//
//    private class ReadUserByUName extends AsyncTask<String, Void, Void> {
//        List<User> users =null;
//        @Override
//        protected Void doInBackground(String... strings) {
//            users = userDao.searchUserByUserName(strings[0]);
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            if(users == null){
//                Toast.makeText(getApplicationContext(),
//                        "Read Operation Failure", Toast.LENGTH_LONG).show();
//            } else if (users.size() == 0){
//                Toast.makeText(getApplicationContext(),
//                        "User does not exist", Toast.LENGTH_LONG).show();
//            } else {
//                checkPassword(users.get(0));
//            }
//        }
//    }
//
//    private void checkPassword(User user){
//        if(etUserPassword.getText().toString().equals(user.getPassword())){
//            Intent intent = new Intent(this,AppServices.class);
//            intent.putExtra(USER_OBJECT, user);
//            startActivity(intent);
//        } else {
//            Toast.makeText(this,
//                    "Password is wrong", Toast.LENGTH_LONG).show();
//        }
//    }
}
