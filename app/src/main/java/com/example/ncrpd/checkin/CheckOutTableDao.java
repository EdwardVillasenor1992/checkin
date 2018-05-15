package com.example.ncrpd.checkin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CheckOutTableDao {
    @Query("select count(*) from CheckOutLog")
    int count();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addToLog(CheckOutTable checkout);

    @Query("select * from CheckOutLog")
    UserTable checkLog();

    @Query("select * from CheckOutLog")
    List<CheckOutTable> newCheckout();
}
