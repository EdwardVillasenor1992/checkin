package com.example.ncrpd.checkin;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "CheckOutLog")
public class CheckOutTable {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "first_Name")
    public String mFirstName;

    @ColumnInfo(name = "last_name")
    public String mLastName;

    @ColumnInfo(name = "user_sign_in_id")
    public String userSignInId;

    @ColumnInfo(name = "date")
    public String mDate;

    public CheckOutTable(String mFirstName, String mLastName, String userSignInId, String mDate) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.userSignInId = userSignInId;
        this.mDate = mDate;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getUserSignInId() {
        return userSignInId;
    }

    public void setUserSignInId(String userSignInId) {
        this.userSignInId = userSignInId;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    @Override
    public String toString() {
        return "First Name: " + mFirstName +"\n" +
                "Last Name: " + mLastName + "\n" +
                "id: " + userSignInId + "\n" +
                "Date: " + mDate;
    }
}