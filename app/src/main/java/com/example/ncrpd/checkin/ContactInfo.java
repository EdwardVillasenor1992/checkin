package com.example.ncrpd.checkin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class ContactInfo extends AppCompatActivity {

    private String fname;
    private String lname;
    private String id;

    private EditText fnameEdit;
    private EditText lnameEdit;
    private EditText idEdit;

    private DB db;
    private ListView mTaskListView;
    private ArrayAdapter<UserTable> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        db = DB.getInstance(this);



                                            //list_view_users
        mTaskListView = findViewById(R.id.);
        viewUserList();
    }

    private void viewUserList() {
                                                            // pass in parameters
        List<UserTable> userlist = db.userTableDao().contactInfo();

        if (mAdapter == null) {                                         //this and              this needs to be changed
            mAdapter = new ArrayAdapter<UserTable>(this, R.layout.list_of_checkin, R.id.user_info, userlist);
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(userlist);
            mAdapter.notifyDataSetChanged();
        }

    }



}
