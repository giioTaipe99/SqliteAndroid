package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Add_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);
        // Obtén la referencia del Spinner desde el diseño
        Spinner spinnerPhoneType = findViewById(R.id.spinnerPhoneType);

        // Define las opciones del Spinner
        String[] phoneTypes = {"Fix", "Mobil", "Feina"};

        // Crea un adaptador para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, phoneTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asigna el adaptador al Spinner
        spinnerPhoneType.setAdapter(adapter);
    }
}



