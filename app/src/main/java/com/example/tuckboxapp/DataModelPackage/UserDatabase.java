package com.example.tuckboxapp.DataModelPackage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, OrderedLuch.class, Cards.class, Address.class},version = 8,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase myDB = null;

    public abstract UserDao getDao();

    public static UserDatabase createmyDBInstance(Context context){
        if(myDB == null){
            myDB = Room.databaseBuilder(
                    context.getApplicationContext(),UserDatabase.class,
                    "UserDatabase8")
                    .build();
        }
        return myDB;
    }
}

