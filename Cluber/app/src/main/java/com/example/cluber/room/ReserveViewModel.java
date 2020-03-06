package com.example.cluber.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.cluber.Firebase.FirebaseStore;
import com.example.cluber.models.Club;
import com.example.cluber.models.Reserve;

import java.util.List;

public class ReserveViewModel extends AndroidViewModel {


    private ReserveRepository mRepository;
    private LiveData<List<Reserve>> mAllReserves;
    private LiveData<Reserve> mReserve;
    FirebaseStore fireStoreReserve;


    public ReserveViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ReserveRepository(application);
        fireStoreReserve = new FirebaseStore();
        mAllReserves = mRepository.getAllReserves();
    }

    public LiveData<List<Reserve>> getAllDecks() { return mAllReserves;}



    public LiveData<Reserve> getmReserve(int id) {
        return mRepository.getReserve(id);
    }


    public void insert(Reserve reserve){
   //     fireStoreReserve.insertReserve(reserve); // inserta el deck en la base de datos de firebase
        mRepository.insert(reserve);
    }

        public Reserve getReserveObject(int id){
        return  mRepository.getReserveObject(id);
    }

    public void update(Reserve reserve){
        mRepository.update(reserve);
        //fireStoreReserve.updateReserve(reserve); // inserta el deck en la base de datos de firebase
    }

    public void deleteReserve(int id){
      //  fireStoreReserve.deleteDeck(id);
        mRepository.deleteReserve(id);
    }

}
