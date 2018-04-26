package com.example.ncrpd.checkin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteUser extends AppCompatActivity {

    private EditText mFnameEdit;
    private EditText mLnameEdit;
    private EditText midEdit;

    private String mFname;
    private String mLname;
    private String mid;

    private Button button;

    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        db = DB.getInstance(this);

        mFnameEdit = findViewById(R.id.delete_first_name);
        mLnameEdit = findViewById(R.id.delete_last_name);
        midEdit = findViewById(R.id.delete_id);





        button = findViewById(R.id.delete_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mid = midEdit.getText().toString();
                mFname = mFnameEdit.getText().toString();
                mLname = mLnameEdit.getText().toString();

                db.userTableDao().deleteUser(mFname, mLname, mid);



            }
        });

    }
}
