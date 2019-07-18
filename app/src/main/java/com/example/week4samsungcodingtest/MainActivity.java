package com.example.week4samsungcodingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.week4samsungcodingtest.model.datasource.remote.rxjava.Callback;
import com.example.week4samsungcodingtest.model.datasource.remote.rxjava.PhotoRepo;
import com.example.week4samsungcodingtest.model.photoresponse.PhotoResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    private RecyclerView recyclerView;
    private PhotoListAdapter photoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvPhotos);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);

        PhotoRepo.getPhotoList(this);
    }

    @Override
    public void getPhotoResponseList(List<PhotoResponse> photoResponseList) {

        photoListAdapter = new PhotoListAdapter(photoResponseList);
        recyclerView.setAdapter(photoListAdapter);
    }
}
