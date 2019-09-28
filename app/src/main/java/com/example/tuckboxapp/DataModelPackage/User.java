package com.example.tuckboxapp.DataModelPackage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users",indices = {
        @Index(value = "User name", unique = true)
})
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="ID")
    public int ID;

    @ColumnInfo(name = "Title")
    public String title;

    @ColumnInfo(name = "First Name")
    public String firstName;

    @ColumnInfo(name = "Last Name")
    public String lastName;

    @ColumnInfo(name = "User name")
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }
}
