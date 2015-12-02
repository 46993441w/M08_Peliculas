package com.example.david.peliculas;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.david.peliculas.pelis.Peliculas;
import com.example.david.peliculas.pelis.Results;
import com.example.david.peliculas.provider.peliculas.PeliculasColumns;
import com.example.david.peliculas.provider.peliculas.PeliculasContentValues;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * interface de la API de TheMovieDB
 */
interface TheMoviedb {
    // a la url principal li col·loca el get i el que està entre {} ho substitueix pel tipus de
    // pel·lícules que vol veure i a més li col·loca al final amb un interrogant la clau de la api
    @GET("3/movie/{tipus}")
    Call<Peliculas> getMovie(
            @Path("tipus") String tipus, // tipus de pel·lícules
            @Query("api_key") String apikey); // clau de la api
}

/**
 * Classe Retrofit
 */
public class MovieApi {

    private final TheMoviedb service; // interface
    private final String PELICULAS_BASE_URL = "http://api.themoviedb.org"; // base per a la api
    private final String API_KEY = "4624e31346570edb5d18b1092b824632"; //clau
    private final Context context;

    public MovieApi(Context context){
        // al crear la clase es connecta amb la api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PELICULAS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(TheMoviedb.class);
        this.context = context;
    }

    /**
     *  Mètode que obté el resultat de la connexió amb la api
     */
    public void update() {

        UpdateMoviesTask updateMovies = new UpdateMoviesTask();
        updateMovies.execute();
    }

    /**
     *  Mètode que obté el resultat de la connexió amb la api
     * @param tipus   el tipus de llista que es vol mostrar
     */
    public void movies(String tipus) {


    }

    private void deleteOldMovies(long syncTime) {
        context.getContentResolver().delete(
                PeliculasColumns.CONTENT_URI,
                PeliculasColumns.SYNCTIME + " < ?",
                new String[]{Long.toString(syncTime)}
        );
    }

    public void processCall(Call<Peliculas> pelisCall,final String movieList, final long syncTime) {
        try {
            Response<Peliculas> response = pelisCall.execute();
            if (response.isSuccess()) {
                // la resposta la torna objecte, que hem creat prèviament,
                Peliculas pelis = response.body();

                ContentValues[] bulkToInsert;
                List<ContentValues> mValueList = new ArrayList<>();
                for (Results result : pelis.getResults()) {
                    PeliculasContentValues values = new PeliculasContentValues();

                    values.putTitle(result.getTitle());
                    values.putAdult(result.getAdult());
                    values.putBackdropPath(result.getBackdrop_path());
                    values.putVoteAverage(result.getVote_average());
                    values.putVoteCont(result.getVote_cont());
                    values.putVideo(result.getVideo());
                    values.putIdpelicula(result.getId());
                    values.putOriginalLanguage(result.getOriginal_language());
                    values.putOriginalTitle(result.getOriginal_title());
                    values.putOverview(result.getOverview());
                    values.putPopularity(result.getPopularity());
                    values.putPosterPath(result.getPoster_path());
                    values.putReleaseDate(result.getRelease_date());
                    values.putSynctime(syncTime);
                    values.putMovieslist(movieList);

                    Picasso.with(context).load(result.getPoster_path()).fetch();
                    mValueList.add(values.values());
                }
                bulkToInsert = new ContentValues[mValueList.size()];
                mValueList.toArray(bulkToInsert);
                context.getContentResolver().bulkInsert(PeliculasColumns.CONTENT_URI, bulkToInsert);
            } else {
                Log.e("Update movies", response.errorBody().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class UpdateMoviesTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            String popular = "popular";
            String valor = "top_rated";

            // fa la connexió amb la api amb la clau i el tipus de cerca que es vol
            Call<Peliculas> pelisCall = service.getMovie(
                    popular, API_KEY
            );
            long syncTime = System.currentTimeMillis();

            processCall(pelisCall, popular, syncTime);

            pelisCall = service.getMovie(
                    valor, API_KEY
            );
            processCall(pelisCall, valor, syncTime);

            deleteOldMovies(syncTime);

            return null;
        }
    }
}
