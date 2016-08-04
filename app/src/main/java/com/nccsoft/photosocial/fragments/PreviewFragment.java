package com.nccsoft.photosocial.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.nccsoft.photosocial.R;
import com.nccsoft.photosocial.applications.MyApplication;
import com.nccsoft.photosocial.models.LocalMedia;
import com.nccsoft.photosocial.photoviews.PhotoView;

import org.parceler.Parcels;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreviewFragment extends Fragment {


    public static PreviewFragment getInstances(LocalMedia localMedia) {

        PreviewFragment instances = new PreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(MyApplication.LOCAL_MEDIA, Parcels.wrap(localMedia));
        instances.setArguments(bundle);
        return instances;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_preview, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        LocalMedia item =
                Parcels.unwrap(getArguments().getParcelable(MyApplication.LOCAL_MEDIA));


        PhotoView photoView = (PhotoView) view.findViewById(R.id.image_photo);
        photoView.enable();
        if (item != null) {
            Glide.with(this).load(item.getPath()).into(photoView);
        }
    }

}
