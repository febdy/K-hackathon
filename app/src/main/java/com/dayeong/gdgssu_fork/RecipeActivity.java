package com.dayeong.gdgssu_fork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {
    //recipe shows
    //viewpager with fragment
    //TODO : viewpager indicator 는 일정 시간이 지나면 넘어간다.
    //TODO : 다음 버튼을 누르면 넘어간다.

    TextView tv_title;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        setLayout();
        receiveIntentData();

        tv_title.setText(title);
    }

    public void setLayout() {
        tv_title = (TextView) findViewById(R.id.tv_title);
    }

    public void receiveIntentData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
    }
}
