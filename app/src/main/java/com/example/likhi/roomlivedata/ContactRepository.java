package com.example.likhi.roomlivedata;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class ContactRepository {
    public static ContactDAO contactDAO;
    LiveData<List<Contact>> getAllData;


    public ContactRepository(Context context) {

        ContactDatabase database = ContactDatabase.getInstance(context);
        contactDAO = database.contactDAO();
        getAllData = contactDAO.getAllContact();
    }

    public LiveData<List<Contact>> getAllContact() {
        return getAllData;
    }

    public void insertData(Contact contact) {
        new InsertTask().execute(contact);
    }

    class InsertTask extends AsyncTask<Contact, Void, Void> {

        @Override
        protected Void doInBackground(Contact... contacts) {

            contactDAO.insertContact(contacts[0]);
            return null;
        }
    }

    public void deleteAll() {

        new DeleteAllTask().execute();
    }
    class DeleteAllTask extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            contactDAO.deleteAll();
            return null;
        }
    }

    public void delete(Contact contact) {
        new DeleteTask().execute(contact);
    }

    class DeleteTask extends AsyncTask<Contact, Void, Void> {

        @Override
        protected Void doInBackground(Contact... contacts) {
            contactDAO.deleteContact(contacts[0]);
            return null;
        }
    }
    public void update(Contact contact){
        new UpdateTask().execute(contact);
    }
    class UpdateTask extends AsyncTask<Contact,Void,Void>{

        @Override
        protected Void doInBackground(Contact... contacts) {
            contactDAO.updateContact(contacts[0]);
            return null;
        }
    }


}
