package com.sandeep.github01.repositoyviewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.sandeep.github01.database.DataBaseAPP;
import com.sandeep.github01.modelanddao.NewsModel;
import com.sandeep.github01.modelanddao.NewsModelDao;
import com.sandeep.github01.retrofit.CallBackInterface;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivityRepository implements CallBackInterface {
    Executor myExecutor;
    DataBaseAPP dataBaseAPP;
    NewsModelDao newsModelDao;
    //dao
    //mutable data

    public MainActivityRepository(Context context){
        dataBaseAPP = DataBaseAPP.getInstance(context);
        myExecutor = Executors.newFixedThreadPool(2);
        newsModelDao = dataBaseAPP.newsModelDao();
    }
    //api call

    //insert data
    public void insertNewsModelData(NewsModel newsModel){
        myExecutor.execute(()->newsModelDao.insert(newsModel));
    }
    //return data
    //return live edata
    public LiveData<NewsModel> getAllNewModelData(){
        return newsModelDao.getAllNewDataFromDB();
    }

    @Override
    public void onSuccessResponse(Object o, String tag) {
        //recieve and post data
    }

    @Override
    public void onErrorResponse(Object o, String key) {
        //recieve error
    }
}
