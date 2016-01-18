package com.example.myapplication;

/**
 * Created by محمد on 18/01/2016.
 */
public class ImageEntry {
    private String mTitle;
    private String mThumbnailUrl;
    private String mDate;

    public ImageEntry(String title, String thumbnailUrl,String date) {
        super();
        mTitle = title;
        mThumbnailUrl = thumbnailUrl;
        mDate=date;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }
    public String getDate() {
        return mDate;
    }
}