package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

import java.util.ArrayList;

public class LenguajesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Lenguaje> lenguajes;

    public LenguajesAdapter(Context context, ArrayList<Lenguaje> lenguajes){
        this.context = context;
        this.lenguajes = lenguajes;
    }

    @Override
    public int getCount() {
        return lenguajes.size();
    }

    @Override
    public Object getItem(int i) {
        return lenguajes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.lenguaje_item,null);

        Lenguaje currentLeng = lenguajes.get(i);

        TextView txtLenguaje = v.findViewById(R.id.txtLenguaje);
        TextView txtDesarrollador = v.findViewById(R.id.txtDesarrollador);
        txtLenguaje.setText(currentLeng.getNombre());
        txtDesarrollador.setText(currentLeng.getDesarrollador());
        return v;
    }
}
