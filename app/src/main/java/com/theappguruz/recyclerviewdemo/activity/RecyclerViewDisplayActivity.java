package com.theappguruz.recyclerviewdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.theappguruz.recyclerviewdemo.adapter.GridLayoutAdapter;
import com.theappguruz.recyclerviewdemo.adapter.LinearLayoutAdapter;
import com.theappguruz.recyclerviewdemo.R;
import com.theappguruz.recyclerviewdemo.adapter.StaggeredGridLayoutAdapter;
import com.theappguruz.recyclerviewdemo.constant.Constant;
import com.theappguruz.recyclerviewdemo.recycleview.CustomRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by Nikunj Popat on 16-12-2015.
 */
public class RecyclerViewDisplayActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMain;
    private ArrayList<String> images = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    CustomRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_display);

        getWidgets();
        initializeImages();
        getLayoutManagerRequest();
    }

    private void getWidgets() {
        recyclerViewMain = (RecyclerView) findViewById(R.id.my_recycler_view);
    }

    private void getLayoutManagerRequest() {
        if (getIntent().getStringExtra(Constant.LAYOUT_MANAGER).equals(Constant.STAGGERED_LAYOUT_MANAGER)) {
            setStaggeredGridLayoutManager();
            setAdapter();
        } else if (getIntent().getStringExtra(Constant.LAYOUT_MANAGER).equals(Constant.GRID_LAYOUT_MANAGER)) {
            setGridLayoutManager();
            setAdapter();
        } else if (getIntent().getStringExtra(Constant.LAYOUT_MANAGER).equals(Constant.LINEAR_LAYOUT_MANAGER)) {
            setLinearLayoutManager();
            setAdapter();
        }
    }

    private void initializeImages() {
        images = new ArrayList<>();
        for (int i = 0; i < Constant.IMAGES.length; i++) {
            images.add(Constant.IMAGES[i]);
        }
        getSupportActionBar().setTitle(getIntent().getStringExtra(Constant.LAYOUT_MANAGER));
    }


    private void setStaggeredGridLayoutManager() {
        recyclerViewMain.setHasFixedSize(true);
        mLayoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        recyclerViewMain.setLayoutManager(mLayoutManager);
        adapter = new StaggeredGridLayoutAdapter(this, images);
    }

    private void setGridLayoutManager() {
        recyclerViewMain.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewMain.setLayoutManager(mLayoutManager);
        adapter = new GridLayoutAdapter(this, images);
    }

    private void setLinearLayoutManager() {
        recyclerViewMain.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerViewMain.setLayoutManager(mLayoutManager);
        adapter = new LinearLayoutAdapter(this, images);
    }

    private void setAdapter() {
        recyclerViewMain.setAdapter(adapter);
    }
}
