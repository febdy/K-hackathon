package com.dayeong.gdgssu_fork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dayeong.gdgssu_fork.utils.Global;

public class RecipeActivity extends AppCompatActivity {

    private TextView tv_title;
    private String title;

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
        title = intent.getStringExtra(Global.TITLE);
    }
}
