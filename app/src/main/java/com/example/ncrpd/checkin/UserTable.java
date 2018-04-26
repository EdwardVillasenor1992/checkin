package com.example.ncrpd.checkin;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "UserTable")
public class UserTable {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "first_Name")
    public String mFirstName;

    @ColumnInfo(name = "last_name")
    public String mLastName;

    @ColumnInfo(name = "user_sign_in_id")
    public String userSignInId;

    @ColumnInfo(name = "birth_day")
    public String mBirthDay;

    @ColumnInfo(name="parent1")
    public String mParent1;

    @ColumnInfo(name = "emergency_contact1_number")
    public  String mEmergencyContactNum1;

    @ColumnInfo(name = "parent2")
    public String mParent2;

    @ColumnInfo(name = "emergency_contact2_number")
    public  String mEmergencyContactNum2;




    public UserTable(String mFirstName, String mLastName, String userSignInId, String mBirthDay,
                     String mParent1, String mEmergencyContactNum1, String mParent2,
                     String mEmergencyContactNum2)
    {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.userSignInId = userSignInId;
        this.mBirthDay = mBirthDay;
        this.mParent1 = mParent1;
        this.mEmergencyContactNum1 = mEmergencyContactNum1;
        this.mParent2 = mParent2;
        this.mEmergencyContactNum2 = mEmergencyContactNum2;
       // this.mDate = mDate;
    }

    // getters and setters
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
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

    public String getmBirthDay() {
        return mBirthDay;
    }

    public void setmBirthDay(String mBirthDay) {
        this.mBirthDay = mBirthDay;
    }

    public String getmParent1() {
        return mParent1;
    }

    public void setmParent1(String mParent1) {
        this.mParent1 = mParent1;
    }

    public String getmEmergencyContactNum1() {
        return mEmergencyContactNum1;
    }

    public void setmEmergencyContactNum1(String mEmergencyContactNum1) {
        this.mEmergencyContactNum1 = mEmergencyContactNum1;
    }

    public String getmEmergencyContactNum2() {
        return mEmergencyContactNum2;
    }

    public void setmEmergencyContactNum2(String mEmergencyContactNum2) {
        this.mEmergencyContactNum2 = mEmergencyContactNum2;
    }

    public String getUserSignInId() {
        return userSignInId;
    }

    public void setUserSignInId(String userSignInId) {
        this.userSignInId = userSignInId;
    }

    public String getmParent2() {
        return mParent2;
    }

    public void setmParent2(String mParent2) {
        this.mParent2 = mParent2;
    }

    @Override
    public String toString() {
        return  "Name: " + mFirstName + " " + mLastName + "\n"+
                "Pin: " + userSignInId + "\n"+
                "DOB: " + mBirthDay + "\n" +
                "Guardian 1: " + mParent1 + '\n' +
                "Guardian 1 phone: " + mEmergencyContactNum1 + '\n' +
                "Guardian 2: " + mParent2 + '\n' +
                "Guardian 2 phone: " + mEmergencyContactNum2;
    }
}
