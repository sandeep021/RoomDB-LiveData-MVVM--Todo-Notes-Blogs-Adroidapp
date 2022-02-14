package com.sandeep.github01.repositoyviewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sandeep.github01.modelanddao.NewsModel;

public class MainActivityViewModel extends AndroidViewModel {
    MainActivityRepository mainActivityRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mainActivityRepository = new MainActivityRepository(application);
    }
    //return data to fragments and activity..
    public LiveData<NewsModel> getAllNewModelData(){
        return mainActivityRepository.getAllNewModelData();
    }

    public void insertNewsDatatoDB(NewsModel newsModel){
        mainActivityRepository.insertNewsModelData(newsModel);
    }
}
