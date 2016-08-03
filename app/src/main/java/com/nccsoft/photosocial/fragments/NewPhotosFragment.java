package com.nccsoft.photosocial.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.nccsoft.photosocial.R;
import com.nccsoft.photosocial.adapters.NewPhotosAdapter;
import com.nccsoft.photosocial.models.LocalMedia;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewPhotosFragment extends Fragment implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {

    private NewPhotosAdapter mAdapter;
    private List<LocalMedia> mListLocalMedia;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_photos, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

        mListLocalMedia = new ArrayList<>();
//        StaggeredGridView gridNewPhoto =
//                (StaggeredGridView) view.findViewById(R.id.list_item);

        RecyclerView gridNewPhoto =
                (RecyclerView) view.findViewById(R.id.list_item);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        gridNewPhoto.setLayoutManager(sglm);
        mAdapter =
                new NewPhotosAdapter(getActivity(), mListLocalMedia);

        gridNewPhoto.setAdapter(mAdapter);
//        gridNewPhoto.setOnScrollListener(this);
//        gridNewPhoto.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getActivity(), "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        Logger.d("onScrollStateChanged:" + scrollState);
    }

    private boolean mHasRequestedMore;

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Logger.d("onScroll firstVisibleItem:" + firstVisibleItem +
                " visibleItemCount:" + visibleItemCount +
                " totalItemCount:" + totalItemCount);
        // our handling
        if (!mHasRequestedMore) {
            int lastInScreen = firstVisibleItem + visibleItemCount;
            if (lastInScreen >= totalItemCount) {
                Logger.d("onScroll lastInScreen - so load more");
                mHasRequestedMore = true;
                onLoadMoreItems();
            }
        }
    }

    private void onLoadMoreItems() {
        final List<LocalMedia> sampleData = new ArrayList<>();
        sampleData.addAll(mListLocalMedia);
        for (LocalMedia data : sampleData) {
//            mAdapter.add(data);
        }
        // stash all the data in our backing store
        mListLocalMedia.addAll(sampleData);
        // notify the adapter that we can update now
        mAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;
    }

}
