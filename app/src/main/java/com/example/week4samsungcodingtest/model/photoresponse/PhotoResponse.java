
package com.example.week4samsungcodingtest.model.photoresponse;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "favorites_table", primaryKeys = {"album_id", "id"})
public class PhotoResponse implements Parcelable
{
    @ColumnInfo(name = "album_id")
    @SerializedName("albumId")
    @Expose
    @NonNull
    private Integer albumId;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    @NonNull
    private Integer id;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String title;

    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    private String url;

    @ColumnInfo(name = "thumbnail_url")
    @SerializedName("thumbnailUrl")
    @Expose
    private String thumbnailUrl;
    public final static Parcelable.Creator<PhotoResponse> CREATOR = new Creator<PhotoResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PhotoResponse createFromParcel(Parcel in) {
            return new PhotoResponse(in);
        }

        public PhotoResponse[] newArray(int size) {
            return (new PhotoResponse[size]);
        }

    }
    ;

    protected PhotoResponse(Parcel in) {
        this.albumId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnailUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public PhotoResponse() {
    }

    /**
     * 
     * @param id
     * @param title
     * @param albumId
     * @param thumbnailUrl
     * @param url
     */
    public PhotoResponse(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
        super();
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(albumId);
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(url);
        dest.writeValue(thumbnailUrl);
    }

    public int describeContents() {
        return  0;
    }

}
