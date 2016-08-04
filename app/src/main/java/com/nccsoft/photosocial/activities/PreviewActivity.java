package com.nccsoft.photosocial.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.nccsoft.photosocial.R;
import com.nccsoft.photosocial.applications.MyApplication;
import com.nccsoft.photosocial.fragments.PreviewFragment;
import com.nccsoft.photosocial.models.LocalMedia;
import com.orhanobut.logger.Logger;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class PreviewActivity extends AppCompatActivity {

    private List<LocalMedia> mListLocalMedia = new ArrayList<>();
    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        getDataFromIntent();
        initViews();
    }

    public void getDataFromIntent() {
        Intent intent = getIntent();
        try {
            Bundle bundle = intent.getExtras();

            mListLocalMedia =
                    Parcels.unwrap(bundle.getParcelable(MyApplication.LIST_MEDIA));

            mPosition = bundle.getInt(MyApplication.POSITION);
        } catch (NullPointerException e) {
            Logger.d(e.toString());
        }
    }

    private void initViews() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mListLocalMedia);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(mPosition);
    }


    private static class ViewPagerAdapter extends FragmentPagerAdapter {


        private List<LocalMedia> mListLocalMedia;

         ViewPagerAdapter(FragmentManager fm, List<LocalMedia> medias) {
            super(fm);
            mListLocalMedia = medias;
        }

        @Override
        public Fragment getItem(int position) {
            return PreviewFragment.getInstances(mListLocalMedia.get(position));
        }

        @Override
        public int getCount() {
            return mListLocalMedia.size();
        }
    }
}
