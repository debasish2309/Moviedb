package com.example.devde.moviedb.rest;

import com.example.devde.moviedb.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/now_playing")
    Call<MovieResponse> getTopratedMovies(@Query("api_key") String api_key);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id,@Query("api_key") String api_key);
}
