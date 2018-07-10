package com.example.devde.moviedb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.devde.moviedb.adapter.MoviesAdapter;
import com.example.devde.moviedb.model.Movie;
import com.example.devde.moviedb.model.MovieResponse;
import com.example.devde.moviedb.rest.ApiClient;
import com.example.devde.moviedb.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String API_KEY = "0ce7227febd49ffdf2da55d1c5aa607f";


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        if(API_KEY.isEmpty()) {
            Toast.makeText(this.getContext(), "please enter api key", Toast.LENGTH_SHORT).show();
        }

        final RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ApiInterface apiservice = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiservice.getTopratedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies , /*R.layout.list_item_movie,*/getContext().getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

                Log.e(TAG, t.toString());

            }
        });
        return view;
    }

}
