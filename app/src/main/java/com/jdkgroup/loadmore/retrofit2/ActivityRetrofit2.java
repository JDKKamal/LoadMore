package com.jdkgroup.loadmore.retrofit2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jdkgroup.loadmore.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRetrofit2 extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Model> alMovies;
    Adapter adapter;
    EndPoints api;
    String TAG = "ActivityRetrofit2";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_a);
        context = this;
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        alMovies = new ArrayList<>();

        adapter = new Adapter(this, alMovies);
        adapter.setLoadMoreListener(new Adapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                mRecyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        int index = alMovies.size() - 1;
                        System.out.println("Index " + index);
                        loadMore(index);
                    }
                });
                //Calling loadMore function in Runnable to fix the
                // java.lang.IllegalStateException: Cannot call this method while RecyclerView is computing a layout or scrolling error
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new VerticalLineDecorator(2));
        mRecyclerView.setAdapter(adapter);

        api = ServiceGenerator.createService(EndPoints.class);
        load(0);
    }

    private void load(int index) {
        Call<List<Model>> call = api.getMovies(index);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()) {
                    alMovies.addAll(response.body());
                    adapter.notifyDataChanged();
                } else {
                    Log.e(TAG, " Response Error " + String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.e(TAG, " Response Error " + t.getMessage());
            }
        });
    }

    private void loadMore(int index) {

        //add loading progress view
        alMovies.add(new Model("load"));
        adapter.notifyItemInserted(alMovies.size() - 1);

        Call<List<Model>> call = api.getMovies(index);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()) {

                    //remove loading view
                    alMovies.remove(alMovies.size() - 1);

                    List<Model> result = response.body();
                    if (result.size() > 0) {
                        //add loaded data
                        alMovies.addAll(response.body());
                    } else {//result size 0 means there is no more data available at server
                        adapter.setMoreDataAvailable(false);
                        //telling adapter to stop calling load more as no more server data available
                        Toast.makeText(context, "No More Data Available", Toast.LENGTH_LONG).show();
                    }
                    adapter.notifyDataChanged();
                    //should call the custom method adapter.notifyDataChanged here to get the correct loading status
                } else {
                    Log.e(TAG, " Load More Response Error " + String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.e(TAG, " Load More Response Error " + t.getMessage());
            }
        });
    }
}
