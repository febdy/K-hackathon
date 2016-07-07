package com.dayeong.gdgssu_fork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import github.chenupt.springindicator.SpringIndicator;

public class RecipeActivity extends FragmentActivity {
    //
    private TextView tv_title;
    private String title;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private SpringIndicator mSpringIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        setLayout();
        receiveIntentData();
        tv_title.setText(title);

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // 해당하는 page의 Fragment를 생성합니다.
            return PageFragment.create(position);
        }

        @Override
        public int getCount() {
            return 5;  // 총 5개의 page를 보여줍니다.
        }

    }
    public void setLayout() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        mSpringIndicator = (SpringIndicator) findViewById(R.id.indicator);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mSpringIndicator.setViewPager(mViewPager);
    }

    public void receiveIntentData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");

    }
}
