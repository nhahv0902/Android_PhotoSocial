package com.nccsoft.photosocial.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nccsoft.photosocial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopLikedFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_top_liked, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

    }
}
