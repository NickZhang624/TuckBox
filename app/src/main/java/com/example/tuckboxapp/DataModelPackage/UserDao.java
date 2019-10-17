package com.example.tuckboxapp.DataModelPackage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("select * from UsersTable")
    List<User> readAllUers();

    @Query("select * from UsersTable where `User_name` like :uName")
    List<User> searchUserByUserName(String uName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertUser(User user);

    @Update
    int updateUser(User user);

    @Delete
    int deleteUser(User user);



    @Query("select * from OrderedLunchTable")
    List<OrderedLuch> readAllOrderedLunch();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertOrderedLunch(OrderedLuch orderedLuch);

    @Update
    int updateOrderedLunch(OrderedLuch orderedLuch);

    @Delete
    int deleteOrderedLunch(OrderedLuch orderedLuch);



    @Query("select * from CardsTable")
    List<Cards> readAllCards();

    @Query("select * from CardsTable WHERE User_ID = :id")
    List<Cards> readCreditCardsByUserID(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertcard(Cards cards);

    @Update
    int updatecard(Cards cards);

    @Delete
    int deletecard(Cards cards);



    @Query("select * from AddressTable")
    List<Address> readAllAddress();

    @Query("select * from AddressTable WHERE User_ID = :id")
    List<Address> readAddressByUserID(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertaddress(Address address);

    @Update
    int updateaddress(Address address);

    @Delete
    int deleteaddress(Address address);

}
