package com.example.week4samsungcodingtest.model.datasource.local.database;

import android.content.Context;

import androidx.room.Room;

public class FavoritePhotosDatabaseClient {
    private Context mContext;
    public static FavoritePhotosDatabaseClient mInstance;
    private FavoritePhotosDatabase favoritePhotosDatabase;

    public FavoritePhotosDatabaseClient(Context mContext) {
        this.mContext = mContext;
        favoritePhotosDatabase = Room.databaseBuilder(mContext, FavoritePhotosDatabase.class,
                "FavoritePhotosDatabase").fallbackToDestructiveMigration().build();
    }

    public static synchronized FavoritePhotosDatabaseClient getInstance(Context mContext) {
        if(mInstance == null){
            mInstance = new FavoritePhotosDatabaseClient(mContext);
        }
        return mInstance;
    }

    public FavoritePhotosDatabase getFavoritePhotosDatabase() {
        return favoritePhotosDatabase;
    }
}
