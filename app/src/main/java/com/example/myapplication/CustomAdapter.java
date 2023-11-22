package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList name_text, adreça_text, telefon_text, entrega_text;

    // Constructor que recibe la lista de datos
    public CustomAdapter(Context context, ArrayList name_text, ArrayList adreça_text, ArrayList telefon_text, ArrayList entrega_text) {
        this.context = context;
        this.name_text = name_text;
        this.adreça_text = adreça_text;
        this.telefon_text = telefon_text;
        this.entrega_text = entrega_text;
    }

    // Método llamado cuando se necesita crear un nuevo ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_profile, parent, false);
        return new MyViewHolder(view);
    }

    // Método llamado para asignar datos a un ViewHolder específico
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    // Método que devuelve la cantidad de elementos en la lista de datos
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // Clase interna que representa cada elemento en la RecyclerView
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name_text;
        private TextView telefon_text;
        private TextView adreça_text;
        private TextView entrega_text;
        public MyViewHolder(View itemView) {
            super(itemView);
            name_text = itemView.findViewById(R.id.name_text); // Reemplaza R.id.text_view con el ID real de tu TextView en el diseño del elemento
            telefon_text = itemView.findViewById(R.id.telefon_text);
            adreça_text = itemView.findViewById(R.id.adreça_text);
            entrega_text = itemView.findViewById(R.id.entrega_text);
        }

        // Método para asignar datos a la vista dentro de ViewHolder
        public void bind(String data) {
            name_text.setText(data);
            telefon_text.setText(data);
            adreça_text.setText(data);
            entrega_text.setText(data);
        }
    }
}
