package com.jdkgroup.loadmore.endlessrecyclerview;

import com.jdkgroup.loadmore.R;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> mModels;
    public Adapter(List<Model> models) {
        mModels = models;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_row;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_row = (TextView) itemView.findViewById(R.id.tv_row);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.endlessrecyclerviewadapter, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Model model = mModels.get(position);

        TextView textView = viewHolder.tv_row;
        textView.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }
}