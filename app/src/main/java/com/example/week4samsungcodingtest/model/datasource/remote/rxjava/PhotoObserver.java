package com.example.week4samsungcodingtest.model.datasource.remote.rxjava;

import com.example.week4samsungcodingtest.model.photoresponse.PhotoResponse;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PhotoObserver implements Observer<List<PhotoResponse>> {

    Callback callback;
    private List<PhotoResponse> photoResponseList;

    public PhotoObserver(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<PhotoResponse> photoResponseList) {
        this.photoResponseList = photoResponseList;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        callback.getPhotoResponseList(photoResponseList);
    }
}
