package com.dayeong.gdgssu_fork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    TextView tv_title;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        init();
        receiveIntentData();

        tv_title.setText(title);
    }

    public void init() {
        tv_title = (TextView) findViewById(R.id.tv_title);
    }

    public void receiveIntentData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
    }
}
