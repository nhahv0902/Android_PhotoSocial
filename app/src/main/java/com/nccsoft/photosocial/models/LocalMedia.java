package com.nccsoft.photosocial.models;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.parceler.Parcel;

/**
 * Created by nhahv on 2015/8/5.
 * <></>
 */

@Parcel
public class LocalMedia {

    public String path;
    public int width, height;
    public float ratio;

    public LocalMedia() {
    }

    public LocalMedia(String path) {
        this.path = path;
        setWidthHeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getRatio() {
        return ratio;
    }

    public String getPath() {
        return path;
    }

    private void setWidthHeight() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);

        width = bitmap.getWidth();
        height = bitmap.getHeight();
        ratio = (float) height / (float) width;
    }
}
