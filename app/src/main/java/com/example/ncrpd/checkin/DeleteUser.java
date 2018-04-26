package com.example.ncrpd.checkin;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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


                AlertDialog.Builder builder = new AlertDialog.Builder(DeleteUser.this);
                builder.setTitle("Deleting");
                builder.setMessage("Are you sure you want to delete " + mFname + " " + mLname +
                " " + mid);
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        db.userTableDao().deleteUser(mFname, mLname, mid);
                        AlertDialog.Builder builder = new AlertDialog.Builder(DeleteUser.this);
                        builder.setTitle("User deleted");
                        builder.setMessage(mFname + " " + mLname +
                                " " + mid + " has been deleted");

                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });


                        AlertDialog alertD = builder.create();
                        alertD.show();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();



            }
        });

    }
}
