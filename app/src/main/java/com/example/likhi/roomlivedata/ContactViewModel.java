package com.example.likhi.roomlivedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    public ContactRepository conrepository;
    public LiveData<List<Contact>> listLiveData;

    public ContactViewModel(@NonNull Application application) {
        super(application);

        conrepository = new ContactRepository(application);

        listLiveData = conrepository.getAllContact();

    }

    public void insert(Contact contact) {
        conrepository.insertData(contact);
    }

    public LiveData<List<Contact>> getContactData() {
        return listLiveData;
    }

    public void delete(Contact contact) {
        conrepository.delete(contact);
    }

    public void update(Contact contact) {
        conrepository.update(contact);
    }

   public void deleteall(){
        conrepository.deleteAll();
   }

}
