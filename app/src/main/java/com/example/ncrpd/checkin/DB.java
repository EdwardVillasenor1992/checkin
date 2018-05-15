package com.example.ncrpd.checkin;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Database(entities = {UserTable.class, CheckinLogTable.class, CheckOutTable.class}, version = 3, exportSchema = false)
public abstract class DB extends RoomDatabase {
    private static DB sDB;
    public abstract UserTableDao userTableDao();
    public abstract CheckinLogTableDao checkinLogTableDao();
    public abstract CheckOutTableDao checkOutTableDao();

    private static final Object sLock = new Object();

    public static DB getInstance(Context context){
        if (sDB == null) {
            sDB = Room.databaseBuilder(context.getApplicationContext(),
                    DB.class, "DB.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sDB;
    }



    public void populateInitialData() {

        if (userTableDao().count() == 0) {

            beginTransaction();

            String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());


            UserTable user = new UserTable("testF","testL", "0000","07311992",
                    "testD", "8315555555","testM", "5555555555");



            Log.d("db", String.valueOf(user));

            try{
                long test = userTableDao().addUser(user);


                Log.d("test", String.valueOf(test));
                setTransactionSuccessful();

            } finally {
                endTransaction();
            }
        }
    }

}
