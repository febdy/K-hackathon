package com.dayeong.gdgssu_fork.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dayeong.gdgssu_fork.R;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class CircleTimer extends RelativeLayout {

    private static final String TAG = "CircleTimer";

    private TextView titleText;
    private TextView timeText;
    private TextView maxTimeText;

    private Button startBtn;
    private Button stopBtn;
    private Button resetBtn;

    private ProgressBar progressBar;

    private int currentTime;
    private int maxTime;
    private boolean isRun = true;
    private Handler handler = new Handler();

    private Thread timerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    if (!isRun || currentTime > maxTime)
                        continue;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            setTimeText(currentTime);
                            progressBar.setProgress(currentTime++);
                        }
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public CircleTimer(Context context) {
        super(context);
        init();
    }

    public CircleTimer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleTimer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.circle_timer, this);

        titleText = (TextView) findViewById(R.id.circle_timer_title);
        timeText = (TextView) findViewById(R.id.circle_timer_time);
        maxTimeText = (TextView) findViewById(R.id.circle_timer_max_time);

        startBtn = (Button) findViewById(R.id.circle_timer_start);
        stopBtn = (Button) findViewById(R.id.circle_timer_stop);
        resetBtn = (Button) findViewById(R.id.circle_timer_reset);

        progressBar = (ProgressBar) findViewById(R.id.circle_timer_bar);

        setListener();
        timerThread.start();
    }

    public void setTitle(String title) {
        titleText.setText(title);
    }

    public String getTitle() {
        return titleText.getText().toString();
    }

    public void setCurrentTime(int time) {
        currentTime = time;
        progressBar.setProgress(time);
        setTimeText(time);
    }

    private void setTimeText(int time) {
        StringBuilder sb = new StringBuilder();
        int temp;
        if ((temp = time / 60) > 0) {
            if (temp < 10)
                sb.append("0");
            sb.append(temp + ":");
            time %= 60;
        }
        if (time < 10)
            sb.append("0");
        sb.append(time);
        timeText.setText(sb.toString());
    }

    public void setMaxTime(int max) {
        maxTime = max;
        progressBar.setMax(max);
        StringBuilder sb = new StringBuilder();
        int temp;
        if ((temp = max / 60) > 0) {
            if (temp < 10)
                sb.append("0");
            sb.append(temp + ":");
            max %= 60;
        }
        if (max < 10)
            sb.append("0");
        sb.append(max);
        maxTimeText.setText(sb.toString());
    }

    public void setListener() {
        startBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "스타트 클릭");
                isRun = true;
            }
        });

        stopBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "스톱 클릭");
//                if (!timerThread.isInterrupted())
//                    timerThread.interrupt();
                isRun = false;
            }
        });

        resetBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "리셋 클릭");
                currentTime = 0;
            }
        });
    }
}
