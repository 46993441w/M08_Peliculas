package com.example.david.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.david.peliculas.pelis.Results;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class PeliculesFragment extends Fragment {

    private List items;
    private MovieAdapter adapter;

    public PeliculesFragment() {
    }

    /**
     * funció que s'executa cada vegada que es mostra de nou la activitat
     */
    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_pelicules, container, false);
        items = new ArrayList<>(); //llista de Results per al listView
        adapter = new MovieAdapter(getActivity().getApplicationContext(),R.layout.listview_row,items); //connecta l'adaptador amb la llista
        GridView gvRow = (GridView) rootView.findViewById(R.id.llista); // inicialitza la llista
        gvRow.setAdapter(adapter); //connecta l'adaptador amb el listview
        gvRow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Results item = (Results) parent.getItemAtPosition(position);

                Intent i = new Intent(getActivity().getApplicationContext(), MovieDetall.class);
                i.putExtra("item", item);
                startActivity(i);
            }
        });
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
        apiClient.movies(adapter, getActivity().getApplicationContext());
    }
}