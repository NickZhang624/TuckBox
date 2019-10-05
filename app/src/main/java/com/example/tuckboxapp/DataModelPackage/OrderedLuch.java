package com.example.tuckboxapp.DataModelPackage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "OrderedLunchTable")
public class OrderedLuch {
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
    @ColumnInfo(name = "New Payment")
    public String newPayment;
    @ColumnInfo(name = "Delivery Time")
    public String deliveryTime;
    @ColumnInfo(name = "New Address")
    public String newAddress;


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

    public String getNewPayment() {
        return newPayment;
    }

    public void setNewPayment(String newPayment) {
        this.newPayment = newPayment;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public OrderedLuch(int OID, String region, String meal, String choice, String note, String newPayment, String deliveryTime, String newAddress) {
        this.OID = OID;
        this.region = region;
        this.meal = meal;
        this.choice = choice;
        this.note = note;
        this.newPayment = newPayment;
        this.deliveryTime = deliveryTime;
        this.newAddress = newAddress;
    }
}
