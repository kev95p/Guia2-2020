package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.adapters.Lenguaje;
import com.example.myapplication.adapters.LenguajesAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<Lenguaje> lenguajes = new ArrayList<>();
        lenguajes.add(new Lenguaje("Java","Sun Microsystem"));
        lenguajes.add(new Lenguaje("C#","Microsoft"));
        lenguajes.add(new Lenguaje("Python","Guido van Rossum"));
        lenguajes.add(new Lenguaje("C++","Bjarne Stroustrup"));
        lenguajes.add(new Lenguaje("Swift","Apple"));
        lenguajes.add(new Lenguaje("Javascript","Netscape Communications"));

        ListView lista = findViewById(R.id.listView);
        lista.setAdapter(new LenguajesAdapter(this,lenguajes));
    }
}