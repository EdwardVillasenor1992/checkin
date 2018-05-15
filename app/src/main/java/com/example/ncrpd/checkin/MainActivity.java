package com.example.ncrpd.checkin;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private Button mSignInBtn;
    private Button mCheckOutBtn;
    private EditText mUserId;

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;


    private String mUserIdString;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        db = DB.getInstance(this);

        mSignInBtn =(Button) findViewById(R.id.sign_in_btn);
        mCheckOutBtn = findViewById(R.id.check_out_button);
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

                        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")).getTime());

                        CheckinLogTable newCheckin = new CheckinLogTable(first, last, id, mydate);

                        db.checkinLogTableDao().addToLog(newCheckin);

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Checked In");
                        builder.setMessage("thank you for checking in " + first + " " + last );
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                mUserId.setText("");
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    }
                }
                


            }
        });

        mCheckOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                    String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")).getTime());

                    CheckOutTable newCheckout = new CheckOutTable(first, last, id, mydate);

                    db.checkOutTableDao().addToLog(newCheckout);

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Checked Out");
                    builder.setMessage("thank you for checking out " + first + " " + last );
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            mUserId.setText("");
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });


        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 5);

        Intent intent = new Intent (this, AlarmReceiverActivity.class);
        alarmIntent = PendingIntent.getActivity(this, 12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);

//        alarmMgr = (AlarmManager)this.getSystemService(Activity.ALARM_SERVICE);
//
//        alarmMgr.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),alarmIntent);




    }
}
