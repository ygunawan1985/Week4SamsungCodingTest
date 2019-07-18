package com.example.week4samsungcodingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week4samsungcodingtest.model.datasource.local.database.FavoritePhotosDatabaseClient;
import com.example.week4samsungcodingtest.model.photoresponse.PhotoResponse;
import com.squareup.picasso.Picasso;

public class PhotoDetails extends AppCompatActivity {

    private TextView tvTitle;
    private ImageView ivPhotoDetails;
    private PhotoResponse photoResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);

//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        getActionBar().hide();

        tvTitle = findViewById(R.id.tvTitle);
        ivPhotoDetails = findViewById(R.id.ivPhotoDetails);

        Intent receivedIntent = getIntent();
        Bundle receivedBundle = receivedIntent.getExtras();
        photoResponse = receivedBundle.getParcelable("photoResponse");

        tvTitle.setText(photoResponse.getTitle());
        Picasso.get().load(photoResponse.getUrl()).into(ivPhotoDetails);

    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_favorite:
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FavoritePhotosDatabaseClient.getInstance(getApplicationContext())
                                .getFavoritePhotosDatabase().photoDao().insertPhotoResponse(photoResponse);

                        PhotoResponse aPhoto = FavoritePhotosDatabaseClient.getInstance(getApplicationContext())
                                .getFavoritePhotosDatabase().photoDao().findPhoto(photoResponse.getAlbumId(), photoResponse.getId());

                        if(aPhoto != null){
                            Log.d("TAG_FAVORITES", "DATABASE CONTAINS THE PHOTO");
                        }
                    }
                });

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
