package com.nccsoft.photosocial.applications;

import android.app.Application;

import com.nccsoft.photosocial.models.ImagesManager;

/**
 * Created by Nhahv on 8/4/2016.
 * <></>
 */

public class MyApplication extends Application {

    public static final String LOCAL_MEDIA = "LOCAL_MEDIA";
    public static final String POSITION = "POSITION";
    public static final String LIST_MEDIA = "LIST_MEDIA";


    @Override
    public void onCreate() {
        super.onCreate();

        new ImagesManager(getApplicationContext());
    }
}
