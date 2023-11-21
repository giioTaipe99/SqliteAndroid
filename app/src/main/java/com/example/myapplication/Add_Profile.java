package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Add_Profile extends AppCompatActivity {

    private EditText inputNom;
    private EditText inputAdreça;
    private EditText inputTel;
    private RadioGroup radioGroup;
    private Button btn;
    private String opcionSeleccionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);
        inputNom = findViewById(R.id.inputNom);
        inputAdreça = findViewById(R.id.inputAdreça);
        inputTel = findViewById(R.id.inputTel);
        // Obtén la referencia del Spinner desde el diseño
        Spinner spinnerPhoneType = findViewById(R.id.spinnerPhoneType);

        // Define las opciones del Spinner
        String[] phoneTypes = {"Fix", "Mobil", "Feina"};

        // Crea un adaptador para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, phoneTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asigna el adaptador al Spinner
        spinnerPhoneType.setAdapter(adapter);

        // Maneja el evento de cambio de selección en el RadioGroup
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Encuentra el RadioButton seleccionado por su ID
                RadioButton radioButton = findViewById(checkedId);

                // Obtiene el texto del RadioButton seleccionado
                opcionSeleccionada = radioButton.getText().toString();
            }
        });

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDataBase myDb = new MyDataBase(Add_Profile.this);
                myDb.addProfile(inputNom.getText().toString().trim(),
                        inputAdreça.getText().toString().trim(),
                        Integer.parseInt(inputTel.getText().toString().trim()),
                        opcionSeleccionada.trim());
            }
        });
    }
}


