package com.example.week4samsungcodingtest.model.datasource.local.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.week4samsungcodingtest.dao.PhotoDao;
import com.example.week4samsungcodingtest.model.photoresponse.PhotoResponse;

@Database(entities = {PhotoResponse.class}, version = 1)
public abstract class FavoritePhotosDatabase extends RoomDatabase {

    public abstract PhotoDao photoDao();
}
