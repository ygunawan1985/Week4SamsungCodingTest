package com.example.week4samsungcodingtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week4samsungcodingtest.model.photoresponse.PhotoResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder>{
    List<PhotoResponse> photoResponseList;

    public PhotoListAdapter(List<PhotoResponse> photoResponseList) {
        this.photoResponseList = photoResponseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.photo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhotoResponse photoResponse = photoResponseList.get(position);
        String thumbnailUrl = photoResponse.getThumbnailUrl();

        Picasso.get().load(thumbnailUrl).into(holder.ivPhoto);

        holder.setPhotoResponse(photoResponse);
    }

    @Override
    public int getItemCount() {
        return photoResponseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivPhoto;
        PhotoResponse photoResponse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);

            itemView.setOnClickListener(this);
        }

        public PhotoResponse getPhotoResponse() {
            return photoResponse;
        }

        public void setPhotoResponse(PhotoResponse photoResponse) {
            this.photoResponse = photoResponse;
        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(view.getContext(), PhotoDetails.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("photoResponse", photoResponse);
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
        }
    }
}
