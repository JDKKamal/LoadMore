package com.jdkgroup.loadmore.recycleviewa;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jdkgroup.loadmore.R;

import java.util.List;

public class ActivityRecyclerView extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<Model> alModel;
    protected Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_a);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        handler = new Handler();

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        alModel = Controller.al_loadmore(0, 10); //ArrayList start always 0 position
        mAdapter = new Adapter(alModel, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        if (alModel.isEmpty()) {
            mRecyclerView.setVisibility(View.GONE);

        } else {
            mRecyclerView.setVisibility(View.VISIBLE);
        }

        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                alModel.add(null);
                mAdapter.notifyItemInserted(alModel.size() - 1);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //   remove progress item
                        alModel.remove(alModel.size() - 1);
                        mAdapter.notifyItemRemoved(alModel.size());

                        //add items one by one
                        int start = alModel.size();
                        int end = start + 5;

                        List<Model> moreContacts = Controller.al_loadmore(start, 10);
                        alModel.addAll(moreContacts);

                        //mAdapter.setLoaded();
                    }
                }, 1000);
            }
        });
    }

    // load initial data
    private void loadData() {
        Controller.al_loadmore(0, 5);
    }
}