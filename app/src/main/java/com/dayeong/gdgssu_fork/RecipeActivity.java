package com.dayeong.gdgssu_fork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {
    //recipe shows
    //viewpager with fragment
    //TODO : viewpager indicator 는 일정 시간이 지나면 넘어간다.
    //TODO : 다음 버튼을 누르면 넘어간다.

    private TextView tv_title;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        receiveIntentData();
        setLayout();



    }

    public void setLayout() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText(title);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
    }


    public void receiveIntentData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
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
            // 총 5개의 page를 보여줍니다.
            return 5;
        }

    }
}
