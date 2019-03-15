package com.example.likhi.roomlivedata;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "ContactDetails")
public class Contact {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "contact Id")
    String id;
    @ColumnInfo(name = "Contact Name")
    String name;
    @ColumnInfo(name = "Contact Mail Id")
    String mailid;
    @ColumnInfo(name = "COntact Number")
    String number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
