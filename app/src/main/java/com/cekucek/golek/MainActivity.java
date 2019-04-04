package com.cekucek.golek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> data = new ArrayList<String>();
        data.add("Januari");
        data.add("Februari");
        data.add("Maret");
        data.add("April");
        data.add("Mei");
        data.add("Juni");
        data.add("Juli");
        data.add("Agustus");
        data.add("September");
        data.add("Oktober");
        data.add("November");
        data.add("Desember");

        adapter = new ListAdapter(this, data);
        ListView listView = (ListView)findViewById(R.id.list_item);
        listView.setAdapter(adapter);

//        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) findViewById(R.id.search);
//        searchView.setOnQueryTextListener((android.support.v7.widget.SearchView.OnQueryTextListener) this);

        SearchView searchView = (SearchView) findViewById(R.id.search);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}
