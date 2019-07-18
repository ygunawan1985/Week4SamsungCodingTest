package com.example.week4samsungcodingtest.model.datasource.remote.rxjava;

import com.example.week4samsungcodingtest.model.datasource.remote.retrofit.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PhotoRepo {
    public static void getPhotoList(Callback callback){
        new RetrofitHelper()
                .getObservableService()
                .getPhotoResponseList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PhotoObserver(callback));
    }
}
