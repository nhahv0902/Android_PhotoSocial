package com.nccsoft.photosocial.models;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhahv on 15/11/19.
 * <></>
 */
public class ImagesManager {


    public static final int TYPE_ALL_IMAGE = 1;
    public static final int TYPE_INTERNAL = 2;
    public static final int TYPE_SD_CARD = 3;
    public static int TYPE_IMAGE_MANAGER = TYPE_ALL_IMAGE;

    private static List<LocalMedia> mListAll = new ArrayList<>();
    private static List<LocalMedia> mListExternal = new ArrayList<>();
    private static List<LocalMedia> mListInternal = new ArrayList<>();

    private final Context mContext;

    public ImagesManager(Context context) {
        mContext = context;
        loadImageAll();
        loadImageExternal();
        loadImageInternal();
    }

    private void loadImageAll() {
        mListAll.addAll
                (getImages(mContext,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI));
        mListAll.addAll
                (getImages(mContext,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
    }

    private void loadImageExternal() {
        mListExternal.addAll
                (getImages(mContext,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI));

    }

    private void loadImageInternal() {
        mListInternal.addAll
                (getImages(mContext,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI));

    }

    private List<LocalMedia> getImages(Context context, Uri uris) {

        List<LocalMedia> listLocalMedia = new ArrayList<>();
        Cursor cursor = context
                .getContentResolver()
                .query(uris, new String[]{"_data"}, null, null, null, null);
        if (cursor == null) {
            return listLocalMedia;
        }

        cursor.moveToFirst();

        int indexData = cursor.getColumnIndex("_data");

        while (!cursor.isAfterLast()) {
            listLocalMedia.add(new LocalMedia(cursor.getString(indexData)));
            cursor.moveToNext();
        }
        cursor.close();
        return listLocalMedia;
    }

    public static List<LocalMedia> getListAll() {
        return mListAll;
    }

    public static List<LocalMedia> getListExternal() {
        return mListExternal;
    }

    public static List<LocalMedia> getListInternal() {
        return mListInternal;
    }
}
