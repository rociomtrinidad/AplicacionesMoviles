package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemListaAdapter extends RecyclerView.Adapter<ItemListaAdapter.ItemViewHolder>{

    private List<ItemLista> items;

    public ItemListaAdapter(List<ItemLista> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item,parent,false);

        return new ItemViewHolder(itemLista);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
    holder.tvPersonaje.setText(items.get(position).getPersonaje());
    holder.tvCasa.setText(items.get(position).getCasa());
    holder.tvLibro.setText(items.get(position).getLibro());
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView tvPersonaje;
        TextView tvCasa;
        TextView tvLibro;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPersonaje=itemView.findViewById(R.id.item_personaje);
            tvCasa=itemView.findViewById(R.id.item_casa);
            tvLibro=itemView.findViewById(R.id.item_libro);
        }
    }
}
