package com.nccsoft.photosocial.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nccsoft.photosocial.R;
import com.nccsoft.photosocial.activities.PreviewActivity;
import com.nccsoft.photosocial.adapters.TopLikeAdapter;
import com.nccsoft.photosocial.applications.MyApplication;
import com.nccsoft.photosocial.models.ImagesManager;
import com.nccsoft.photosocial.models.LocalMedia;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopLikedFragment extends Fragment implements TopLikeAdapter.OnClickPreview {

    private static final int NUMBER_COLUMN = 3;

    private TopLikeAdapter mAdapter;
    private List<LocalMedia> mListLocalMedia = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_flow_layout, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

        mListLocalMedia = ImagesManager.getListAll();
////        StaggeredGridView gridNewPhoto =
////                (StaggeredGridView) view.findViewById(R.id.list_item);
//
//        RecyclerView gridNewPhoto =
//                (RecyclerView) view.findViewById(R.id.list_item);
//
//
//        mAdapter =
//                new TopLikeAdapter(getActivity(), mListLocalMedia);
//        mAdapter.setOnClickPreview(this);
//        gridNewPhoto.setAdapter(mAdapter);
//        gridNewPhoto.setLayoutManager
//                (new FlowLayoutManager());


    }


    @Override
    public void onClickPreviews(int position) {
        Intent intent = new Intent(getActivity(), PreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(MyApplication.POSITION, position);
        bundle.putParcelable(MyApplication.LIST_MEDIA, Parcels.wrap(mListLocalMedia));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
