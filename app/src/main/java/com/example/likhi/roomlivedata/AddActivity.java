package com.example.likhi.roomlivedata;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText name,id,mail,phone;
    Button btsave;
    ContactViewModel conviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        id=findViewById(R.id.aid);
        name=findViewById(R.id.aname);
        mail=findViewById(R.id.amail);
        phone=findViewById(R.id.aphone);
        btsave=findViewById(R.id.btnasave);

        conviewmodel=ViewModelProviders.of(this).get(ContactViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void Save(View view) {

        Contact contact=new Contact();
        contact.setId(id.getText().toString());
        contact.setName(name.getText().toString());
        contact.setMailid(mail.getText().toString());
        contact.setNumber(phone.getText().toString());
        conviewmodel.insert(contact);
        Toast.makeText(this, "data inserted successfully", Toast.LENGTH_SHORT).show();
        finish();

    }
}
