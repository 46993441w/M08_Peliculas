package com.example.david.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.peliculas.pelis.Results;
import com.squareup.picasso.Picasso;


public class MovieDetallFragment extends Fragment {

    public MovieDetallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_detall, container, false);
        //connexió que recull l'informació de l'altre activity
        Intent i = getActivity().getIntent();
        Results item = (Results) i.getSerializableExtra("item");

        TextView tvDetall = (TextView) view.findViewById(R.id.tvDetall);
        ImageView ivPoster = (ImageView) view.findViewById(R.id.ivPosterDetall);

        tvDetall.setText(item.getPeliculasFragmentString());
        Picasso.with(getActivity().getApplicationContext()).load("http://image.tmdb.org/t/p/w500"+item.getPoster_path()).into(ivPoster);

        return view;
    }

}
