package com.dayeong.gdgssu_fork.simpleTimer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.dao.Timer;
import com.dayeong.gdgssu_fork.data.DBManager;
import com.dayeong.gdgssu_fork.timer.TimerActivity;
import com.dayeong.gdgssu_fork.utils.Global;
import com.dayeong.gdgssu_fork.views.BaseFragment;

import java.util.List;

/**
 * 간편 타이머
 */
public class SimpleTimerFragment extends BaseFragment implements SimpleTimerContract.View {

    private static final String TAG = "SimpleTimerFragment";

    private GridView gridView;
    private SimpleTimerAdapter adapter;
    private DBManager dbManager;
    private SimpleTimerContract.UserActionListener listener;

    public SimpleTimerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_timer, container, false);
        init(view);
        return view;
    }


    @Override
    protected void init(View view) {
        dbManager = new DBManager(getActivity(), Global.SIMPLE_TIMER_DB, null, 1);
        checkDB();
        gridView = (GridView) view.findViewById(R.id.fragment_simple_timer_grid);
        adapter = new SimpleTimerAdapter(dbManager.getAllSimpleTimer());
        gridView.setAdapter(adapter);

        listener = new SimpleTimerPresenter(this);
        setListener();
    }

    private void setListener() {
        Log.d(TAG, "df?");
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "dd?");
                listener.startTimer((Timer) adapter.getItem(i));
            }
        });
    }


    private void checkDB() {
        if (dbManager.isEmptySimpleTimer()) {
            dbManager.insertSimpleTimer(new Timer("라면", 60 * 3));
            dbManager.insertSimpleTimer(new Timer("라면", 60 * 3));
            dbManager.insertSimpleTimer(new Timer("라면", 60 * 3));
            dbManager.insertSimpleTimer(new Timer("라면", 60 * 3));
            dbManager.insertSimpleTimer(new Timer("라면", 60 * 3));
            dbManager.insertSimpleTimer(new Timer("Custom", -1));
        }
    }


    class SimpleTimerAdapter extends BaseAdapter {

        private List<Timer> timers;

        public SimpleTimerAdapter(List<Timer> timers) {
            this.timers = timers;
        }

        @Override
        public int getCount() {
            return timers.size();
        }

        @Override
        public Object getItem(int i) {
            return timers.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null)
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_simple_timer, viewGroup, false);
            TextView foodName = (TextView) view.findViewById(R.id.item_simple_timer_food_name);
            foodName.setText(timers.get(i).getName());
            return view;
        }
    }

    @Override
    public void startTimer(Timer timer) {
        Intent intent = new Intent(getActivity(), TimerActivity.class);
        intent.putExtra(Global.TIMER, timer);
        getActivity().startActivity(intent);
    }
}
