package com.jdkgroup.loadmore.recyclerviewb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jdkgroup.loadmore.R;

public class Adapter extends GenericAdapter<Model> {

    public Adapter(Context context) {
        super(context);
    }

    @Override
    public long getYourItemId(int position) {
        return mItems.get(position).getYear();
    }

    @Override
    public RecyclerView.ViewHolder getYourItemViewHolder(ViewGroup parent) {
        return new DemoViewHolder(mInflater.inflate(R.layout.adapter, parent, false));
    }

    @Override
    public void bindYourViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DemoViewHolder) {
            DemoViewHolder viewHolder = (DemoViewHolder) holder;
            viewHolder.tvName.setText(mItems.get(position).getSubject());
        }
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public DemoViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);

        }
    }
}
