package com.dayeong.gdgssu_fork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.badoualy.stepperindicator.StepperIndicator;
import com.dayeong.gdgssu_fork.utils.Global;

public class RecipeActivity extends FragmentActivity {
    //
    private TextView tv_title;
    private String title;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private StepperIndicator indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        tv_title = (TextView) findViewById(R.id.tv_title);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        indicator = (StepperIndicator) findViewById(R.id.indicator);

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);


        indicator.setViewPager(mViewPager);

        indicator.setStepCount(5);
//        indicator.setCurrentStep(2);

        receiveIntentData();
        tv_title.setText(title);


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

    public void receiveIntentData() {
        Intent intent = getIntent();
        title = intent.getStringExtra(Global.TITLE);
    }
}
