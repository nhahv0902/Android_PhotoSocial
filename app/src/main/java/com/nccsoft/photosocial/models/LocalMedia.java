package com.nccsoft.photosocial.models;


import android.os.Parcel;

import java.io.Serializable;

/**
 * Created by nhahv on 2015/8/5.
 * <></>
 */
public class LocalMedia implements Serializable {

    private String path;

    public LocalMedia(String path) {
        this.path = path;
    }

    public LocalMedia(Parcel in) {
        path = in.readString();
    }


    public String getPath() {
        return path;
    }
}
