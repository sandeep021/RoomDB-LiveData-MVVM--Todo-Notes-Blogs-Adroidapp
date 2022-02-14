package com.sandeep.github01.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sandeep.github01.modelanddao.NewsModel;
import com.sandeep.github01.modelanddao.NewsModelDao;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {NewsModel.class}, version = 1, exportSchema = false)
public abstract class DataBaseAPP extends RoomDatabase {
    //dao bnao abstract
    public abstract NewsModelDao newsModelDao();

    private static final String DB_NAME = "GITHUB01_DB";
    private static DataBaseAPP instance;

    public static synchronized DataBaseAPP getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DataBaseAPP.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public void deleteDatabase(){
        Executor myExecutor = Executors.newFixedThreadPool(1);
        myExecutor.execute(()->instance.clearAllTables());
    }
}
