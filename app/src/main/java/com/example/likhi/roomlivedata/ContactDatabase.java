package com.example.likhi.roomlivedata;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase {

    public abstract ContactDAO contactDAO();

    public static ContactDatabase instance;

    public static ContactDatabase getInstance(Context con) {
        if (instance == null) {
            instance = Room.databaseBuilder(con, ContactDatabase.class,
                    "NEWContacDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
