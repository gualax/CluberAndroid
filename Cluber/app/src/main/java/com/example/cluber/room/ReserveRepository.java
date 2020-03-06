package com.example.cluber.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.cluber.models.Reserve;

import java.util.ArrayList;
import java.util.List;

public class ReserveRepository {
    private ReserveDao mReserveDao;
    private LiveData<List<Reserve>> mAllReserves;


    public ReserveRepository(Application application) {
        ReserveRoomDatabase db = ReserveRoomDatabase.getDatabase(application);
        mReserveDao = db.reserveDao();
        mAllReserves = mReserveDao.getAllReserves();
    }

    public LiveData<List<Reserve>> getAllReserves() {
        return mAllReserves;
    }

    public LiveData<Reserve> getReserve(int id) {
        return mReserveDao.getReserve(id);
    }

    public Reserve getReserveObject(int id){
        return mReserveDao.getReserveObject(id);
    }

    public void deleteReserve(int id) {
        ReserveRoomDatabase.databaseWriteExecutor.execute(() -> {
            mReserveDao.deleteReserve(id);
        });
    }

    public void insert(Reserve Reserve) {
        ReserveRoomDatabase.databaseWriteExecutor.execute(() -> {
            mReserveDao.insert(Reserve);
        });
    }




    public void update(Reserve reserve) {
        ReserveRoomDatabase.databaseWriteExecutor.execute(() -> {
            mReserveDao.update(reserve);
        });
    }

/*    public void update(int reserveId, ArrayList<Reserve> cardPokeSelected) {
        ReserveRoomDatabase.databaseWriteExecutor.execute(() -> {
            String cards = new Converters().stringFromObject(cardPokeSelected);
            mReserveDao.update(reserveId, cards);
        });
    }*/

}
