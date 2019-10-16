package com.example.tuckboxapp.DataModelPackage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "CardsTable",foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "User ID",
                childColumns = "User_ID",
                onDelete = ForeignKey.CASCADE )
})
public class Cards implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CID")
    public int CID;

    @ColumnInfo(name = "Card Number")
    public String cardNumber;

    @ColumnInfo(name = "Expired Date")
    public String expiredDate;

    @ColumnInfo(name = "User_ID")
    public int ID;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCID() {
        return CID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

}
