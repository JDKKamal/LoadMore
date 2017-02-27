package com.jdkgroup.loadmore.endlessrecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.jdkgroup.loadmore.R;
import java.util.List;


public class ActivityEndlessRecyclerView extends AppCompatActivity {

    private static RelativeLayout bottomLayout;
    private Context context;
    private List<Model> allModels;
    private Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endlessrecyclerview);
        context = this;
        bottomLayout = (RelativeLayout) findViewById(R.id.loadItemsLayout_recyclerView);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        //rvItems.setLayoutManager(gridLayoutManager);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        allModels = Model.createContactsList(0, 10); //ArrayList start always 0 position
        adapter = new Adapter(allModels);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {

                bottomLayout.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        loaddata();

                        bottomLayout.setVisibility(View.GONE);
                        System.out.println("Notify data" + "" + "-" + (allModels.size() - 1));
                    }
                }, 1000);
            }
        });
    }

    public void loaddata() {
        List<Model> moreModels = Model.createContactsList(adapter.getItemCount(), 10);
        int curSize = adapter.getItemCount();
        allModels.addAll(moreModels);

        //adapter.notifyDataSetChanged();
        if (curSize > allModels.size() - 1) {
            Toast.makeText(getApplicationContext(), "Data not available", Toast.LENGTH_SHORT).show();
        }
    }
}