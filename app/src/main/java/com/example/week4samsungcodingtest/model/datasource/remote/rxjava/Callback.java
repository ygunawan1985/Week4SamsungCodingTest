package com.example.week4samsungcodingtest.model.datasource.remote.rxjava;

import com.example.week4samsungcodingtest.model.photoresponse.PhotoResponse;

import java.util.List;

public interface Callback {

    void getPhotoResponseList(List<PhotoResponse> photoResponseList);
}
