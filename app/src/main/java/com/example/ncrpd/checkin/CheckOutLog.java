package com.example.ncrpd.checkin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CheckOutLog extends AppCompatActivity {
    private DB db;
    private ListView mTaskListView;
    private ArrayAdapter<CheckOutTable> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_log);


        db = DB.getInstance(this);

        mTaskListView = findViewById(R.id.list_view_checkout);
        viewUserList();
    }

    private void viewUserList() {
        List<CheckOutTable> userlist = db.checkOutTableDao().newCheckout();

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<CheckOutTable>(this, R.layout.list_of_checkin, R.id.user_info, userlist);
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(userlist);
            mAdapter.notifyDataSetChanged();
        }

    }


}
