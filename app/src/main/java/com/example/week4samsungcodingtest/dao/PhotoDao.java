package com.example.week4samsungcodingtest.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.week4samsungcodingtest.model.photoresponse.PhotoResponse;

@Dao
public interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPhotoResponse(PhotoResponse photoResponse);

    @Delete
    void deletePhotoResponse(PhotoResponse photoResponse);

    @Query("SELECT * from favorites_table WHERE album_id = :albumId AND id = :id")
    PhotoResponse findPhoto(Integer albumId, Integer id);

}
