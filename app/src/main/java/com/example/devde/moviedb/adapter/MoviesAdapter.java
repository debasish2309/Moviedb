package com.example.devde.moviedb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.devde.moviedb.GlideApp;
import com.example.devde.moviedb.R;
import com.example.devde.moviedb.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{

    private List<Movie> movies;
   // private int rowlayout;
    private Context context;

    public MoviesAdapter(List<Movie> movies, /*int rowlayout,*/ Context applicationContext) {
        this.movies = movies;
     //   this.rowlayout = rowlayout;
        this.context = context;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.moviedescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteCount().toString());
        //holder.imageView.setImageResource(Integer.parseInt(movies.get(position).getPosterPath()));

        //String poster = "https://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath();
        /*String poster = "http://api.themoviedb.org/3/movie/now_playing?api_key=0ce7227febd49ffdf2da55d1c5aa607f" + movies.get(position).getPosterPath();

        GlideApp.with(context)
                .load(poster)
                .centerCrop()
                .into(holder.imageView);*/
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout movieslayout;
        TextView movieTitle,data,moviedescription,rating;
        ImageView imageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
           // movieslayout = itemView.findViewById(R.id.movies_layout);
            imageView = itemView.findViewById(R.id.imageview);
            movieTitle = itemView.findViewById(R.id.title);
            data = itemView.findViewById(R.id.subtitle);
            moviedescription = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);

        }
    }
}
