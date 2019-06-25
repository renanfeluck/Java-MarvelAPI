package com.reluck.java_marvelapi.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.reluck.java_marvelapi.data.Film;
import com.reluck.java_marvelapi.R;
import com.reluck.java_marvelapi.activities.FilmActivity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Film> mDataset;

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v, v.getContext());
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textTitle.setText(mDataset.get(position).getTitle());
        String teste = mDataset.get(position).getTitle();
        holder.textDate.setText(mDataset.get(position).getReleaseDate());

        holder.view.setOnClickListener(v -> {
            Intent intent = new Intent(holder.view.getContext(), FilmActivity.class);
            intent.putExtra("url", mDataset.get(position).getUrl());
            holder.view.getContext().startActivity(intent);
        });

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public  TextView textTitle;
        public  TextView textDate;
        public  TextView textOpeningCrawl;
        public MyViewHolder(View v, Context context) {
            super(v);
            view = v;
            textTitle = view.findViewById(R.id.textTitle);
            textDate = view.findViewById(R.id.textDate);
            textOpeningCrawl = view.findViewById(R.id.textOpeningCrawl);
        }
    }

    public MyAdapter(List<Film> myDataset) {
        mDataset = myDataset;
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}