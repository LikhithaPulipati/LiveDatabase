package com.example.likhi.roomlivedata;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context con;
    List<Contact> contactslist;

    public MyAdapter(MainActivity mainActivity, List<Contact> contacts) {
        this.con = mainActivity;
        this.contactslist = contacts;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.rowdesign, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MyViewHolder holder, int position) {
        Contact conlist = contactslist.get(position);
        holder.tid.setText(conlist.getId());
        holder.tname.setText(conlist.getName());
        holder.tmail.setText(conlist.getMailid());
        holder.tnum.setText(conlist.getNumber());

        holder.vedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(con,Updateuser.class);
                i.putExtra("uid",holder.tid.getText().toString());
                i.putExtra("uname",holder.tname.getText().toString());
                i.putExtra("umail",holder.tmail.getText().toString());
                i.putExtra("unumber",holder.tnum.getText().toString());
                con.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactslist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tid, tname, tmail, tnum;
            ImageView vedit,vdelete;
        public MyViewHolder(final View itemView) {
            super(itemView);
            tid = itemView.findViewById(R.id.rid);
            tname = itemView.findViewById(R.id.rname);
            tmail = itemView.findViewById(R.id.rmail);
            tnum = itemView.findViewById(R.id.rphone);
            vedit=itemView.findViewById(R.id.edit);
            vdelete=itemView.findViewById(R.id.delete);


            vdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    MainActivity.contactViewModel.delete(contactslist.get(getAdapterPosition()));
                }
            });
        }
    }
}
