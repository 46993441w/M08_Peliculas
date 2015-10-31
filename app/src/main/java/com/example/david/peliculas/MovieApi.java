package com.example.david.peliculas;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.david.peliculas.pelis.Peliculas;
import com.example.david.peliculas.pelis.Results;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Callback;
import retrofit.Response;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;

interface TheMoviedb {
    @GET("3/movie/{tipus}")
    Call<Peliculas> getMovie(
            @Path("tipus") String tipus,
            @Query("api_key") String apikey);

}

public class MovieApi {

    private final TheMoviedb service;
    private final String PELICULAS_BASE_URL = "http://api.themoviedb.org";
    private final String API_KEY = "7b5e30851a9285340e78c201c4e4ab99";

    public MovieApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PELICULAS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(TheMoviedb.class);
    }

    public void movies(final ArrayAdapter<String> adapter, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String tipus = preferences.getString("listMovies","popular");
        Call<Peliculas> pelisCall = service.getMovie(
                tipus, API_KEY
        );
        pelisCall.enqueue(new Callback<Peliculas>() {
            @Override
            public void onResponse(Response<Peliculas> response, Retrofit retrofit) {
                Peliculas pelis = response.body();
                ArrayList<String> pelisStrings = new ArrayList<>();
                for (Results resultat : pelis.getResults()) {
                    String pelisString = getPeliculasString(resultat);
                    pelisStrings.add(pelisString);
                }
                adapter.clear();
                adapter.addAll(pelisStrings);
            }
            @Override
            public void onFailure(Throwable t) {
                Log.e("Update movies", Arrays.toString(t.getStackTrace()));
            }
        });
    }

    private String getPeliculasString(Results resultat) {
        String titol = resultat.getTitle();
        Double votos = resultat.getVote_average();
        String descripcion = resultat.getOverview();
        String dateString = resultat.getRelease_date();
        return String.format("%s - %s - %s%n%s",
                titol, votos, dateString , descripcion
        );
    }
}
