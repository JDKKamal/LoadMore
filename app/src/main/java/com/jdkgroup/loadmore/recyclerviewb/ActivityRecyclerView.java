package com.jdkgroup.loadmore.recyclerviewb;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.jdkgroup.loadmore.R;
import java.util.List;

public class ActivityRecyclerView extends AppCompatActivity {

    RecyclerView mRecyclerView;

    private Adapter mAdapter;
    private List<Model> alModel;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_b);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mHandler = new Handler();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        setupAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerViewScrollListener() {
            @Override
            public void onScrollUp() {

            }

            @Override
            public void onScrollDown() {

            }

            @Override
            public void onLoadMore() {
                loadMoreData();
            }
        });
    }

    private void setupAdapter() {
        mAdapter = new Adapter(this);
        mAdapter.setHasStableIds(true);
        alModel = getData(0);
        mAdapter.setItems(alModel);
    }

    private void loadMoreData() {

        mAdapter.showLoading(true);
        mAdapter.notifyDataSetChanged();

        // Load data after delay
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Model> newItems = getData(alModel.size());
                alModel.addAll(newItems);
                mAdapter.setItems(alModel); // No need of this
                mAdapter.showLoading(false);
                mAdapter.notifyDataSetChanged();
            }
        }, 1500);

    }

    private List<Model> getData(int start) {
        List<Model> items;
        items = Controller.al_loadmore(start, 10);

        return items;
    }
}
