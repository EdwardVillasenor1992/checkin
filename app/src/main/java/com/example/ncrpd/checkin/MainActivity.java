package com.example.ncrpd.checkin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button mSignInBtn;
    private EditText mUserId;

    private String mUserIdString;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DB.getInstance(this);

        mSignInBtn =(Button) findViewById(R.id.sign_in_btn);
        mUserId = findViewById(R.id.user_id_login);

        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mUserIdString = mUserId.getText().toString();


                if(mUserIdString.equals("5123"))
                {
                    startActivity(new Intent(MainActivity.this, AdminPage.class));
                }
                else
                {
                    if(db.userTableDao().findUserByID(mUserIdString) == null)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("does not exist");
                        builder.setMessage("try another one");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which){

                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                    else
                    {
                        String first = db.userTableDao().findUserByID(mUserIdString).getmFirstName();
                        String last = db.userTableDao().findUserByID(mUserIdString).getmLastName();
                        String id = db.userTableDao().findUserByID(mUserIdString).getUserSignInId();
                        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

                        CheckinLogTable newCheckin = new CheckinLogTable(first, last, id, mydate);

                        db.checkinLogTableDao().addToLog(newCheckin);

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Checked In");
                        builder.setMessage("thank you for checking in " + first + " " + last );
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which){

                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    }
                }
                


            }
        });

    }
}
