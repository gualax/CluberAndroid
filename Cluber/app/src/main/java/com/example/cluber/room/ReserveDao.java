package com.example.cluber.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cluber.models.Reserve;

import java.util.List;

@Dao
public interface ReserveDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Reserve reserve);


    @Query("DELETE FROM reserve_table")
    void deleteAll();

    @Update
    void update(Reserve reserve);

    @Query("SELECT * FROM reserve_table")
    LiveData<List<Reserve>> getAllReserves();


    @Query("SELECT * FROM reserve_table WHERE id=:id")
    LiveData<Reserve> getReserve(int id);

    @Query("SELECT * FROM reserve_table WHERE id=:id")
    Reserve getReserveObject(int id);

    @Query("DELETE FROM reserve_table WHERE id=:id")
    void deleteReserve(int id);

    @Query("UPDATE reserve_table SET tableId = :tableId WHERE id = :reserveId")
    void update(int reserveId, String tableId);

}
