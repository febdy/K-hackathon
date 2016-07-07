package com.dayeong.gdgssu_fork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import com.badoualy.stepperindicator.StepperIndicator;
import com.dayeong.gdgssu_fork.timer.TimerFragment;
import com.dayeong.gdgssu_fork.utils.Global;
import com.dayeong.gdgssu_fork.views.CircleTimer;

public class RecipeActivity extends FragmentActivity implements CircleTimer.OnTimerListener{
    private static final String TAG = "RECIPE_ACTIVITY";
    private static final int NUM_PAGES = 5;
    //
    private TextView tv_title;
    private String title;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private StepperIndicator indicator;

    private int recipeTime;
    private String recipeContents;
    private int recipeContentsNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        tv_title = (TextView) findViewById(R.id.tv_title);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        indicator = (StepperIndicator) findViewById(R.id.indicator);

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(0);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                PageFragment fragment = (PageFragment) mPagerAdapter.getItem(position);
                fragment.startTimer(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        indicator.setViewPager(mViewPager);
        indicator.setStepCount(NUM_PAGES);

        receiveIntentData();

        tv_title.setText(title);


   }


    @Override
    public void completeTimer() {
        int currentIdx = mViewPager.getCurrentItem();
        if (currentIdx < NUM_PAGES - 1) {
            Log.d(TAG, "timer complete" + currentIdx);
            currentIdx++;
            mViewPager.setCurrentItem(currentIdx, true);
            indicator.setCurrentStep(currentIdx);
        }
        // next fragment 이동.
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
            return NUM_PAGES;  // 총 5개의 page를 보여줍니다.
        }

    }

    public void receiveIntentData() {
        Intent intent = getIntent();
        title = intent.getStringExtra(Global.TITLE);
    }
}
