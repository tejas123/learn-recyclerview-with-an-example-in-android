package com.theappguruz.recyclerviewdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.theappguruz.recyclerviewdemo.R;
import com.theappguruz.recyclerviewdemo.constant.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMainStaggeredGridLayout;
    private Button btnMainGridLayout;
    private Button btnMainLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWidgets();
        bindWidgetsWithEvents();
    }

    private void bindWidgetsWithEvents() {
        btnMainStaggeredGridLayout.setOnClickListener(this);
        btnMainGridLayout.setOnClickListener(this);
        btnMainLinearLayout.setOnClickListener(this);
    }

    private void getWidgets() {
        btnMainStaggeredGridLayout = (Button) findViewById(R.id.btnMainStaggeredGridLayout);
        btnMainGridLayout = (Button) findViewById(R.id.btnMainGridLayout);
        btnMainLinearLayout = (Button) findViewById(R.id.btnMainLinearLayout);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, RecyclerViewDisplayActivity.class);
        if (v.getId() == R.id.btnMainStaggeredGridLayout) {
            intent.putExtra(Constant.LAYOUT_MANAGER, Constant.STAGGERED_LAYOUT_MANAGER);
        } else if (v.getId() == R.id.btnMainGridLayout) {
            intent.putExtra(Constant.LAYOUT_MANAGER, Constant.GRID_LAYOUT_MANAGER);
        } else if (v.getId() == R.id.btnMainLinearLayout) {
            intent.putExtra(Constant.LAYOUT_MANAGER, Constant.LINEAR_LAYOUT_MANAGER);
        }
        startActivity(intent);
    }
}
