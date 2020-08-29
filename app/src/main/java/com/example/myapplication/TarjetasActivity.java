package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.adapters.TarjetaAdapter;
import com.example.myapplication.modelos.Lugar;

import java.util.ArrayList;

public class TarjetasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TarjetaAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjetas);

        recyclerView = findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final ArrayList<Lugar> lugares = new ArrayList<>();
        lugares.add(new Lugar("Everest",R.drawable.everesti));
        lugares.add(new Lugar("Sonsonate",R.drawable.sonsonate));
        lugares.add(new Lugar("Paris",R.drawable.paris));
        lugares.add(new Lugar("Antartida",R.drawable.antartida));

        // specify an adapter (see also next example)
        mAdapter = new TarjetaAdapter(lugares);
        TarjetaAdapter.mClickListener = new TarjetaAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(TarjetasActivity.this, lugares.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        };
        recyclerView.setAdapter(mAdapter);
    }
}