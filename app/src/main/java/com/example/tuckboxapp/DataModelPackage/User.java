package com.example.tuckboxapp.DataModelPackage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "UsersTable")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="User ID")
    public int ID;

    @ColumnInfo(name = "Title")
    public String title;

    @ColumnInfo(name = "First Name")
    public String firstName;

    @ColumnInfo(name = "Last Name")
    public String lastName;

    @ColumnInfo(name = "User_name")
    public String userName;

    @ColumnInfo(name = "Password")
    public String password;

    @ColumnInfo(name = "Mobile Number")
    public String mobileNumber;

    @ColumnInfo(name = "Email")
    public String email;

    @ColumnInfo(name = "Delivery address")
    public String deliveryAddress;

    @ColumnInfo(name = "Credit Number")
    public String creditNumber;

    @ColumnInfo(name = "Expired date")
    public String expiredDate;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }



    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public String getExpiredDate() {
        return expiredDate;
    }
}
