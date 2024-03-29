package com.reluck.java_marvelapi.activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.reluck.java_marvelapi.data.Film;
import com.reluck.java_marvelapi.R;
import com.reluck.java_marvelapi.providers.StarWarsApi;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FilmActivity extends AppCompatActivity {

    private String url;
    private StarWarsApi starWarsApi = new StarWarsApi();
    private Observable<Film> filmObservable;

    private TextView textTitle;
    private TextView textDate;
    private TextView textOpeningCrawl;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        Bundle intent = getIntent().getExtras();
        url = intent.getString("url");
        System.out.println(url);

        filmObservable = starWarsApi.getMovie(url);

        filmObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( movie -> {
                    updateFilmInfo(movie);
                    System.out.println(movie);
                }, err -> {
                    System.out.println(err);
                });

    }

    private void updateFilmInfo(Film film){
        textTitle = findViewById(R.id.textTitle);
        textDate = findViewById(R.id.textDate);
        textOpeningCrawl = findViewById(R.id.textOpeningCrawl);
        textTitle.setText(film.getTitle());
        textDate.setText(film.getReleaseDate());
        textOpeningCrawl.setText(film.getOpeningCrawl());
    }
}
