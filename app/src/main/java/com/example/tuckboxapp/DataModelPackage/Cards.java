package com.example.tuckboxapp.DataModelPackage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "CardsTable")
public class Cards implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CID")
    public int CID;

    @ColumnInfo(name = "Card Number")
    public String cardNumber;

    @ColumnInfo(name = "Expired Date")
    public String expiredDate;

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
