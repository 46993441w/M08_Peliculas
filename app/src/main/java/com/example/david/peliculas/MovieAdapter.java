package com.example.david.peliculas;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.example.david.peliculas.pelis.Results;

/**
 * Created by alumne on 09/11/15.
 */
public class MovieAdapter extends ArrayAdapter<Results> {
    /**
     * Constructor de la classe adapter
     * @param context
     * @param resource
     * @param objects
     */
    public MovieAdapter(Context context, int resource, java.util.List<Results> objects) {
        super(context, resource, objects);
    }

    /**
     * funció que mostra per pantalla els elements
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenim l'objecte en la posició corresponent
        Results item = (Results) getItem(position);

        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(convertView.getContext());
            convertView = inflater.inflate(R.layout.listview_row, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView tvDetail = (TextView) convertView.findViewById(R.id.txtRow);
        ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        tvDetail.setText(item.getPeliculasString());
        Picasso.with(convertView.getContext()).load("http://image.tmdb.org/t/p/w500"+item.getPoster_path()).into(ivPoster);

        // Retornem la View replena per a mostrarla
        return convertView;
    }
}
