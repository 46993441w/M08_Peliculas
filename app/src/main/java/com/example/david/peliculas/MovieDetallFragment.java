package com.example.david.peliculas;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.peliculas.pelis.Peliculas;
import com.example.david.peliculas.pelis.Results;
import com.example.david.peliculas.provider.peliculas.PeliculasColumns;
import com.example.david.peliculas.provider.peliculas.PeliculasCursor;
import com.squareup.picasso.Picasso;


public class MovieDetallFragment extends Fragment {

    public MovieDetallFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_detall, container, false);
        super.onCreate(savedInstanceState);

        // Unim el codi en les Views del Layout
        TextView tvDetall = (TextView) view.findViewById(R.id.tvDetall);
        TextView tvDescripcio = (TextView) view.findViewById(R.id.tvDescripcio);
        ImageView ivPoster = (ImageView) view.findViewById(R.id.ivPosterDetall);

        // connexió que recull l'informació de l'altre activity
        Long movie_id = getActivity().getIntent().getLongExtra("pelicula_id", -1);
        Cursor cursor = getActivity().getApplicationContext().getContentResolver().query(
                PeliculasColumns.CONTENT_URI,
                null,
                PeliculasColumns._ID + " = ?",
                new String[]{String.valueOf(movie_id)},
                null
        );

        PeliculasCursor peliculesCursor = new PeliculasCursor(cursor);
        peliculesCursor.moveToNext();

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        tvDetall.setText(peliculesCursor.getTitle());
        tvDescripcio.setText(peliculesCursor.getOverview());
        //Picasso.with(getActivity().getApplicationContext()).load("http://image.tmdb.org/t/p/w500"+item.getPoster_path()).into(ivPoster);
        Picasso.with(getActivity().getApplicationContext()).load("http://image.tmdb.org/t/p/w500"+peliculesCursor.getPosterPath()).into(ivPoster);
        return view;
    }

}
