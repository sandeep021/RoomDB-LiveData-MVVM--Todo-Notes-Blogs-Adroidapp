package com.sandeep.github01.modelanddao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NewsModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NewsModel newsModel);

    @Delete
    void delete(NewsModel newsModel);

    @Query("delete from news_table")
    void deleteAll();

    @Query("Select * from news_table")
    LiveData<NewsModel> getAllNewDataFromDB();
}
