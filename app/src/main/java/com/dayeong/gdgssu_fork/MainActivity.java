package com.dayeong.gdgssu_fork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MultiAutoCompleteTextView;

import com.aml.androidchipbubbletext.ChipBubbleText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] list = {"감자","고구마","호박고구마","오이","당근","양파","마늘"};

        MultiAutoCompleteTextView autoTextView = (MultiAutoCompleteTextView) findViewById(R.id.auto_TextView);
        ChipBubbleText cp = new ChipBubbleText(MainActivity.this, autoTextView, list, 1);
        cp.initialize();

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> recipeList = new ArrayList<>();
        recipeList.add("감자");
        recipeList.add("고구마");
        recipeList.add("호박고구마");
        recipeList.add("오이");
        recipeList.add("당근");
        recipeList.add("양파");
        recipeList.add("마늘");
        recipeList.add("냠냠");
        recipeList.add("맛있오");

        mAdapter = new RecipeAdapter(getApplicationContext(), recipeList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
