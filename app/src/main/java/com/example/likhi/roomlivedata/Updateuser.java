package com.example.likhi.roomlivedata;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Updateuser extends AppCompatActivity {
    EditText upid,upname,upmail,upphone;
    Button upbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuser);
        upid=findViewById(R.id.uid);
        upname=findViewById(R.id.uname);
        upmail=findViewById(R.id.umail);
        upphone=findViewById(R.id.uphone);
        upbtn=findViewById(R.id.btnusave);

        upid.setEnabled(false);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String s=getIntent().getStringExtra("uid");
        String s1=getIntent().getStringExtra("uname");
        String s2=getIntent().getStringExtra("umail");
        String s3=getIntent().getStringExtra("unumber");
        upid.setText(s);
        upname.setText(s1);
        upmail.setText(s2);
        upphone.setText(s3);
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void usave(View view) {

        Contact contact=new Contact();
        contact.setId(upid.getText().toString());
        contact.setName(upname.getText().toString());
        contact.setMailid(upmail.getText().toString());
        contact.setNumber(upphone.getText().toString());
        MainActivity.contactViewModel.update(contact);
        finish();
    }
}
