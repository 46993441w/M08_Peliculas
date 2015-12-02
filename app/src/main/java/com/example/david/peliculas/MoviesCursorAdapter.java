package com.example.david.peliculas;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.example.david.peliculas.provider.peliculas.PeliculasCursor;

public class MoviesCursorAdapter extends SimpleCursorAdapter {

    private final Context context;

    public MoviesCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenim l'objecte en la posició corresponent
        Cursor cursor = getCursor();
        PeliculasCursor peliculesCursor = new PeliculasCursor(cursor);
        peliculesCursor.moveToPosition(position);
        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listview_row, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView tvDetail = (TextView) convertView.findViewById(R.id.txtRow);
        ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        tvDetail.setText(peliculesCursor.getTitle());
        Picasso.with(context).load("http://image.tmdb.org/t/p/w500"+peliculesCursor.getPosterPath()).into(ivPoster);

        // Retornem la View replena per a mostrarla
        return convertView;
    }
}