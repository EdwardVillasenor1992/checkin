package com.example.ncrpd.checkin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CheckingLog extends AppCompatActivity {

    private DB db;
    private ListView mTaskListView;
    private ArrayAdapter<CheckinLogTable> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_log);

        db = DB.getInstance(this);

        mTaskListView = findViewById(R.id.list_view_users);
        viewUserList();



    }



    private void viewUserList() {
        List<CheckinLogTable> userlist = db.checkinLogTableDao().newUser();

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<CheckinLogTable>(this, R.layout.list_of_checkin, R.id.user_info, userlist);
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(userlist);
            mAdapter.notifyDataSetChanged();
        }

    }
}
