package com.example.ncrpd.checkin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ContactInfo extends AppCompatActivity {

    private String fname;
    private String lname;
    private String id;

    private EditText fnameEdit;
    private EditText lnameEdit;
    private EditText idEdit;


    private DB db;

    private ArrayAdapter<UserTable> mAdapter;
    private ListView lsContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        lsContact = findViewById(R.id.listview_contact);

        db = DB.getInstance(this);

        fnameEdit = findViewById(R.id.find_Fname);
        lnameEdit = findViewById(R.id.find_Lname);
        idEdit = findViewById(R.id.find_by_id);


        id = idEdit.getText().toString();

        fnameEdit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    String fname = fnameEdit.getText().toString();
                    searchByFname(fname);
                    return true;
                }
                return false;
            }
        });

        lnameEdit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    Toast.makeText(ContactInfo.this, "in if statement", Toast.LENGTH_SHORT).show();
                    String lname = lnameEdit.getText().toString();
                    searchByLname(lname);
                    return true;
                }
                return false;
            }

        });

        idEdit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    String id = idEdit.getText().toString();
                    searchByid(id);
                    return true;
                }
                return false;
            }
        });



    }

    private void searchByFname(String fname)
    {
        Log.d("TESTEST", fname+"TERERERSFAF");
        List<UserTable> userlist = db.userTableDao().contactInfoFname(fname);
        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<UserTable>(this,R.layout.list_of_users, R.id.user_contact_info, userlist);
            lsContact.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(userlist);
            mAdapter.notifyDataSetChanged();
        }
    }


    private void searchByLname(String lname)
    {
        List<UserTable> userlist = db.userTableDao().contactInfoLname(lname);
        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<UserTable>(this,R.layout.list_of_users, R.id.user_contact_info, userlist);
            lsContact.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(userlist);
            mAdapter.notifyDataSetChanged();
        }
    }

    private void searchByid(String id)
    {
        List<UserTable> userlist = db.userTableDao().contactInfoId(id);
        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<UserTable>(this,R.layout.list_of_users, R.id.user_contact_info, userlist);
            lsContact.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(userlist);
            mAdapter.notifyDataSetChanged();
        }
    }








    boolean checkString(String fname, String lname, String id)
    {
        if(fname.length() < 1 && lnameEdit.length() < 1 && id.length() < 4)
        {
            Toast.makeText(this, "Something must be filled", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }





}
