package com.reluck.java_marvelapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v, v.getContext());
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public  TextView textView;
        public MyViewHolder(View v, Context context) {
            super(v);
            view = v;
            textView = view.findViewById(R.id.textTest);
        }
    }

    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }






    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}