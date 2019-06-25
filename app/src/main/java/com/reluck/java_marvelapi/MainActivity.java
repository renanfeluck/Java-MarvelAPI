package com.reluck.java_marvelapi;

import android.app.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends Activity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Film> myDataset = new ArrayList<Film>();
    private Observable<ApiResponse> filmsObservable;
    private StarWarsApi starWarsApi = new StarWarsApi();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        filmsObservable = starWarsApi.getMovies();

        filmsObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( movies -> {
                    movies.getResults().forEach(movie -> {
                        myDataset.add(movie);
                    });
                    initRecylcer();
                });

    }

    private void initRecylcer(){
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
    }

}
