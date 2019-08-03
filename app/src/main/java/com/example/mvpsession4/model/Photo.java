package com.example.mvpsession4.model;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("id")
    private int mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("thumbnailUrl")
    private String mThumbnailUrl;


    public Photo(int id, String title, String url, String thumbnailUrl) {
        mId = id;
        mTitle = title;
        mUrl = url;
        mThumbnailUrl = thumbnailUrl;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }
}
