package com.example.ncrpd.checkin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CheckinLogTableDao {

    @Query("select count(*) from CheckInLog")
    int count();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addToLog(CheckinLogTable checkin);

    @Query("select * from CheckInLog")
    UserTable checkLog();

    @Query("select * from CheckInLog")
    List<CheckinLogTable> newUser();

}
