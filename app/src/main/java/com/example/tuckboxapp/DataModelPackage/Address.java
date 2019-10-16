package com.example.tuckboxapp.DataModelPackage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AddressTable", foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "User ID",
                        childColumns = "User_ID",
                        onDelete = ForeignKey.CASCADE)
        })
public class Address implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "AID")
    public int AID;

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
