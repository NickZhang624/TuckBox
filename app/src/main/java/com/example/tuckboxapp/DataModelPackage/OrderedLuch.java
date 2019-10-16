package com.example.tuckboxapp.DataModelPackage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "OrderedLunchTable",foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "User ID",
                childColumns = "User_ID",
                onDelete = ForeignKey.CASCADE )})
public class OrderedLuch implements Serializable {
    public OrderedLuch(int OID, String region, String meal, String choice, String note, String payment, String deliveryTime, String address) {
        this.OID = OID;
        this.region = region;
        this.meal = meal;
        this.choice = choice;
        this.note = note;
        this.payment = payment;
        this.deliveryTime = deliveryTime;
        this.address = address;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Order ID")
    public int OID;
    @ColumnInfo(name = "Region")
    public String region;
    @ColumnInfo(name = "Meal")
    public String meal;
    @ColumnInfo(name = "Choice")
    public String choice;
    @ColumnInfo(name = "Note")
    public String note;
    @ColumnInfo(name = "Payment")
    public String payment;
    @ColumnInfo(name = "Delivery Time")
    public String deliveryTime;
    @ColumnInfo(name = "Address")
    public String address;
    @ColumnInfo(name = "User_ID")
    public int ID;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
