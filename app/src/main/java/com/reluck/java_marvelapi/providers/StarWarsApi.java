package com.reluck.java_marvelapi.providers;

import com.reluck.java_marvelapi.data.ApiResponse;
import com.reluck.java_marvelapi.data.Film;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class StarWarsApi {

    private final String BASE_URL = "https://swapi.co/api/";

    public StarWarsApi() {
    }

    public interface StarWarsService {
        @GET("films")
        Observable<ApiResponse> listFilms();

        @GET("{id}")
        Observable<Film> getFilm(@Path("id") String id);
    }


    public Observable<ApiResponse> getMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        StarWarsService service = retrofit.create(StarWarsService.class);

        return service.listFilms();
    }

    public Observable<Film> getMovie(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        StarWarsService service = retrofit.create(StarWarsService.class);

        String id = url.split(BASE_URL)[1];

        return service.getFilm(id);
    }



}
