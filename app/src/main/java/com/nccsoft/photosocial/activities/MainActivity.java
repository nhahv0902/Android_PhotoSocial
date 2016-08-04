package com.nccsoft.photosocial.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.nccsoft.photosocial.R;
import com.nccsoft.photosocial.fragments.NewPhotosFragment;
import com.nccsoft.photosocial.fragments.TopLikedFragment;
import com.nccsoft.photosocial.fragments.UploadFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationBar.OnTabSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        BottomNavigationBar mNavigationBar =
                (BottomNavigationBar) findViewById(R.id.navigation_bar);

        mNavigationBar.setTabSelectedListener(this);
        mNavigationBar.setBackgroundColor(Color.parseColor("#8D6E63"));
        mNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_picture_un_select,
                        R.string.news_photos)
                        .setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.ic_camera_un_select,
                        R.string.upload)
                        .setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.ic_like_un_select,
                        R.string.top_like)
                        .setActiveColorResource(R.color.white))
                .setFirstSelectedPosition(0)
                .initialise();

        mNavigationBar.setAutoHideEnabled(false);

        // setup view pager
        List<Fragment> mListFragment = new ArrayList<>();
        mListFragment.add(new NewPhotosFragment());
        mListFragment.add(new UploadFragment());
        mListFragment.add(new TopLikedFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mListFragment);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((BottomNavigationBar) findViewById(R.id.navigation_bar)).selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onTabSelected(int position) {
        ((ViewPager) findViewById(R.id.view_pager)).setCurrentItem(position);
        Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mListFragments;

        ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mListFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mListFragments.get(position);
        }

        @Override
        public int getCount() {
            return mListFragments.size();
        }
    }
}
