package com.example.tuckboxapp.DataModelPackage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AddressTable")
public class Address implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "AID")
    public int AID;

    @ColumnInfo(name = "Address")
    public String address;
    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
