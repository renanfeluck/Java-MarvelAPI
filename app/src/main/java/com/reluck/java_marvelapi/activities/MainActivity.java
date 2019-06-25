package com.reluck.java_marvelapi.activities;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.reluck.java_marvelapi.data.ApiResponse;
import com.reluck.java_marvelapi.data.Film;
import com.reluck.java_marvelapi.adapters.MyAdapter;
import com.reluck.java_marvelapi.R;
import com.reluck.java_marvelapi.providers.StarWarsApi;

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

    @SuppressLint("CheckResult")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        ProgressBar progressBar = findViewById(R.id.progressBar);

        filmsObservable = starWarsApi.getMovies();

        filmsObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( movies -> {
                    movies.getResults().forEach(movie -> {
                        myDataset.add(movie);
                    });
                    initRecylcer();
                    progressBar.setVisibility(View.GONE);
                }, error -> {
                    Toast toast = Toast.makeText(this,"Error" + error, Toast.LENGTH_SHORT);
                    toast.show();
                    progressBar.setVisibility(View.GONE);
                    System.out.println(error);
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
