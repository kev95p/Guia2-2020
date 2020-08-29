package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.modelos.Lugar;

import java.util.ArrayList;

public class TarjetaAdapter extends RecyclerView.Adapter<TarjetaAdapter.MyViewHolder> {

    private ArrayList<Lugar> lugares;
    static public ClickListener mClickListener;

    public TarjetaAdapter(ArrayList<Lugar> lugares) {
        this.lugares = lugares;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Lugar l = lugares.get(position);
        holder.txtLugar.setText(l.getName());
        holder.imgLugar.setImageResource(l.getResource());
    }

    @Override
    public int getItemCount() {
        return lugares.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtLugar;
        public ImageView imgLugar;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtLugar = itemView.findViewById(R.id.txtNombreLugar);
            imgLugar = itemView.findViewById(R.id.imgLugar);

            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClickListener.onItemClick(getAdapterPosition(),itemView);
                }
            });
        }
    }

    public interface ClickListener{
        void onItemClick(int position, View v);
    }
}
