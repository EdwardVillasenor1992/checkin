package com.example.ncrpd.checkin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserTableDao {

    @Query("select count(*) from UserTable")
    int count();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addUser(UserTable user);

    @Query("select * from UserTable where first_Name = :first_Name")
    UserTable findUsersByFirstName(String first_Name);

    @Query("select * from UserTable where last_name = :last_name")
    UserTable findUsersByLastName(String last_name);

    @Query("select * from UserTable where parent1 = :parent1")
    UserTable findUserByParent1(String parent1);

    @Query("select * from UserTable where parent2 = :parent2")
    UserTable findUserByParent2(String parent2);

    @Query("select * from UserTable where user_sign_in_id = :userID")
    UserTable findUserByID(String userID);


    @Query("select * from UserTable where user_sign_in_id  = :id")
    List<UserTable> contactInfoId(String id);

    @Query("select * from UserTable where first_Name = :fname")
    List<UserTable> contactInfoFname(String fname);

    @Query("select * from UserTable where last_name = :lname")
    List<UserTable> contactInfoLname(String lname);

    @Query("DELETE from usertable where first_Name = :fname and last_name = :lname and user_sign_in_id = :id")
    public void deleteUser(String fname, String lname, String id);

    @Delete
    public void deleteUsers(UserTable users);


}
