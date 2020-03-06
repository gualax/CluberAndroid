package com.example.cluber.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.cluber.models.Reserve;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Reserve.class}, version = 4)
@TypeConverters({Converters.class})
public abstract class ReserveRoomDatabase extends RoomDatabase {


    final static String TAG = "DeckRoomDatabase";
    public abstract ReserveDao reserveDao();
    private static volatile ReserveRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public  static final ExecutorService databaseWriteExecutor =  Executors.newFixedThreadPool(NUMBER_OF_THREADS);



    public static ReserveRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (ReserveRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ReserveRoomDatabase.class, "reserve_database")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }

        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            databaseWriteExecutor.execute(()->{
                //Borra la tabla al iniciar
           //     ClubDao clubDao = INSTANCE.clubDao();
           //     clubDao.deleteAll();
            });
        }
    };


}
