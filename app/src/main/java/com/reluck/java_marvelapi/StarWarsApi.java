package com.reluck.java_marvelapi;

import retrofit2.Call;
import retrofit2.http.GET;

public class StarWarsApi {

    public interface GitHubService {
        @GET("films")
        Call<ApiResponse> listRepos();
    }


}
