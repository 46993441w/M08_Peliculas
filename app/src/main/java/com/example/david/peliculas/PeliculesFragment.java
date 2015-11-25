package com.example.david.peliculas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;

import com.example.david.peliculas.provider.peliculas.PeliculasColumns;



public class PeliculesFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{

    //private MovieAdapter adapter;
    private MoviesCursorAdapter adapter;
    private SwipeRefreshLayout srlRefresh;

    public PeliculesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
/*
    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_pelicules, container, false);

        GridView gvRow = (GridView) rootView.findViewById(R.id.llista); // inicialitza la llista

        adapter = new MoviesCursorAdapter(
                getActivity().getApplicationContext(),
                R.layout.listview_row,
                null,
                new String[] { PeliculasColumns.IDPELICULA },
                new int[] { R.id.txtRow },
                0);
        //Inicialitzem el Loader
        getLoaderManager().initLoader(0, null, this);

        gvRow.setAdapter(adapter); //connecta l'adaptador amb el GridView

        gvRow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity().getApplicationContext(), MovieDetall.class);
                i.putExtra("pelicula_id", id);
                startActivity(i);
            }
        });

        /*srlRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.srlRefresh);
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });*/

        return rootView; //torna la vista
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        // li posa al fragment un nou menú, a més, del menú de l'activity
        inflater.inflate(R.menu.pelicules_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_refresh) {
            // quan presiones refresh es recarrega
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * funció que recarrega el listView en funció del tipus de pel·licula que s'hagi seleccionat a
     * la preferència
     */
    public void refresh(){
        // es crea la clase retrofit per accedir a les dades de la api segons els nostres valors
        MovieApi apiClient = new MovieApi();
        apiClient.movies(getActivity().getApplicationContext());
    }

    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                PeliculasColumns.CONTENT_URI,
                null, // todas las columnas
                null, // where
                null, //
                null); // orden);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }
}