package com.example.ncrpd.checkin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPage extends AppCompatActivity {
    private Button mAddUserBtn;
    private Button mCheckLogBtn;
    private Button mEmergencyContact;
    private Button mDeleteUserBtn;
    private Button mLogOutBtn;
    private DB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        db = DB.getInstance(this);
        db.populateInitialData();

        mAddUserBtn = findViewById(R.id.add_user_btn);
        mCheckLogBtn = findViewById(R.id.check_log_btn);
        mEmergencyContact = findViewById(R.id.emergency_contact_btn);
        mDeleteUserBtn = findViewById(R.id.delete_user_btn);
        mLogOutBtn = findViewById(R.id.log_out_btn);

        mAddUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPage.this, AddUser.class));
            }
        });
        mCheckLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPage.this, CheckingLog.class));
            }
        });
        mEmergencyContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPage.this,ContactInfo.class));
            }
        });
        mLogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPage.this,MainActivity.class));
                finish();
            }
        });
        mDeleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPage.this, DeleteUser.class));
            }
        });



    }

}
