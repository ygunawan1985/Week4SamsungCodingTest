package com.example.week4samsungcodingtest.model.datasource.remote.retrofit;

import com.example.week4samsungcodingtest.model.photoresponse.PhotoResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

import static com.example.week4samsungcodingtest.model.datasource.remote.retrofit.UrlConstants.PATH;

public interface PhotoObservableService {

    @GET(PATH)
    Observable<List<PhotoResponse>> getPhotoResponseList();
}
