package com.example.ncrpd.checkin;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddUser extends AppCompatActivity {
    private String mFirstNameString;
    private String mLastNameString;
    private String mUseridString;
    private String mContact1String;
    private String mContact2String;
    private String mGuardian1String;
    private String mGuardian2String;
    private String mBirthdayString;


    private EditText mFirstName;
    private EditText mLastName;
    private EditText mUserid;
    private EditText mContact1;
    private EditText mContact2;
    private EditText mGuardian1;
    private EditText mGuardian2;
    private EditText mBirthday;
    private Button mAddbtn;

    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        db = DB.getInstance(this);



        mAddbtn = findViewById(R.id.new_addUser);
        mAddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirstName = findViewById(R.id.new_first_name);
                mLastName = findViewById(R.id.new_last_name);
                mUserid = findViewById(R.id.new_user_id);
                mContact1 = findViewById(R.id.new_contact1);
                mContact2 = findViewById(R.id.new_contact2);
                mGuardian1 = findViewById(R.id.new_guardian1);
                mGuardian2 = findViewById(R.id.new_guardian2);
                mBirthday = findViewById(R.id.new_birthday);

                mFirstNameString = mFirstName.getText().toString();
                mLastNameString = mLastName.getText().toString();
                mUseridString = mUserid.getText().toString();
                mContact1String = mContact1.getText().toString();
                mContact2String = mContact2.getText().toString();
                mGuardian1String = mGuardian1.getText().toString();
                mGuardian2String = mGuardian2.getText().toString();
                mBirthdayString = mBirthday.getText().toString();

                if(checkname(mFirstNameString, mLastNameString, mUseridString))
                {

                    if(db.userTableDao().findUserByID(mUseridString) == null)
                    {

                        //Toast.makeText(AddUser.this, "there it worked", Toast.LENGTH_SHORT).show();
                        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                        UserTable user = new UserTable(mFirstNameString,mLastNameString,mUseridString,mBirthdayString,
                                mGuardian1String,mContact1String,mGuardian2String,mContact2String);

                        db.userTableDao().addUser(user);

                        AlertDialog.Builder builder = new AlertDialog.Builder(AddUser.this);
                        builder.setTitle("1 User Added");
                        builder.setMessage("your account has been created");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                finish();
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    }

                    else
                    {
                        //Toast.makeText(AddUser.this, "there is no user id", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(AddUser.this);
                        builder.setTitle("User Id already exists");
                        builder.setMessage("please try another User Id");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which){

                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }
                else{
                    Toast.makeText(AddUser.this, "fields must be filled out", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }
    boolean checkname(String mFirstNameString, String mLastNameString, String mUseridString)
    {
        if(mFirstNameString.length() == 0)
        {
            mFirstName.setError("name can't be blank");
            return false;
        }

        if(mLastNameString.length() == 0)
        {
            mLastName.setError("name can't be blank");
            return false;
        }
        if(mUseridString.length() < 4)
        {
            mUserid.setError("must use 4 numbers");
            return false;
        }
        if(mUseridString.length() > 4)
        {
            mUserid.setError("must use 4 numbers");
            return false;
        }


        return true;
    }

}
