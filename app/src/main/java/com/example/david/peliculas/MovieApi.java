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
    private final String API_KEY = "7b5e30851a9285340e78c201c4e4ab99"; //clau

    public MovieApi(){
        // al crear la clase es connecta amb la api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PELICULAS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(TheMoviedb.class);
    }

    /**
     *  Mètode que obté el resultat de la connexió amb la api
     * @param adapter   adaptador que està connectat amb el listView
     * @param context   el context de la activitat que el crida
     */
    public void movies(final ArrayAdapter<String> adapter, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        // torna el valor de la ppreferencia listMovies, en cas de que encara no tingui cap valor
        // torna per valor defecte popular
        String tipus = preferences.getString("listMovies","popular");
        // fa la connexió amb la api amb la clau i el tipus de cerca que es vol
        Call<Peliculas> pelisCall = service.getMovie(
                tipus, API_KEY
        );
        pelisCall.enqueue(new Callback<Peliculas>() {
            /**
             * Mètode quant tot ha anat bé
             * @param response    La resposta que rep de la connexió
             * @param retrofit    El retrofit amb el que es connecta
             */
            @Override
            public void onResponse(Response<Peliculas> response, Retrofit retrofit) {
                // la resposta la torna objecte, que hem creat prèviament,
                Peliculas pelis = response.body();
                //creem una llista per posar les pel·lícules que es mostraran al listview
                ArrayList<String> pelisStrings = new ArrayList<>();
                for (Results resultat : pelis.getResults()) {
                    // torna el string desitgat per mostrar
                    String pelisString = getPeliculasString(resultat);
                    // afegim es string a la llista
                    pelisStrings.add(pelisString);
                }
                // modifiquem el adaptador per a que mostri els canvis
                adapter.clear();
                adapter.addAll(pelisStrings);
            }

            /**
             * Mètode quant alguna cosa ha sortit malament
             * @param t
             */
            @Override
            public void onFailure(Throwable t) {
                Log.e("Update movies", Arrays.toString(t.getStackTrace()));
            }
        });
    }

    private String getPeliculasString(Results resultat) {
        String titol = resultat.getTitle(); // titol de la pel·lícula
        Double votos = resultat.getVote_average(); // vots de la pel·lícula
        String descripcion = resultat.getOverview(); // descripció de la pel·lícula
        String dateString = resultat.getRelease_date(); // data de la pel·lícula
        return String.format("%s - %s - %s%n%s",
                titol, votos, dateString , descripcion
        ); // retorna un String amb el format especificat amb els tant percent
    }
}