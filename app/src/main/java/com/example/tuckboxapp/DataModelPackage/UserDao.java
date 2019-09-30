package com.example.tuckboxapp.DataModelPackage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("select * from UsersTable")
    List<User> readAllUers();

    @Query("select * from userstable where `User_name` like :uName")
    List<User> searchUserByUserName(String uName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertUser(User user);

    @Update
    int updateUser(User user);

}
