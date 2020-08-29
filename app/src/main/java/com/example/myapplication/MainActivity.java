package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {


    private static final String[] COMIDA = new String[] {
            "Pizza", "Pollo Frito", "Tacos", "Pasta", "Sopa","Ensalda"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //text name
        final EditText txtNombre = findViewById(R.id.txtNombree);
        txtNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Toast.makeText(MainActivity.this, "onFocus", Toast.LENGTH_SHORT).show();
            }
        });

        // caja de texto con autocompletado
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,COMIDA);

        AutoCompleteTextView autoTxtComida = findViewById(R.id.autoTxtComida);
        autoTxtComida.setAdapter(adapter);

        //radio button

        RadioGroup radioGroup = findViewById(R.id.rgOpcionesLenguajes);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idRadioButton) {
                switch (idRadioButton){
                    case R.id.rbJava:
                        Toast.makeText(MainActivity.this, "Java", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbCplus:
                        Toast.makeText(MainActivity.this, "C++", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbCsharp:
                        Toast.makeText(MainActivity.this, "C#", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        //btn Enviar

        Button btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombre.getText().toString().trim();
                boolean valido = true;
                if(nombre.equals("")){
                    txtNombre.setError("Nombre requerido");
                    valido = false;
                }

                if(valido){
                    enviarData();
                }
            }
        });

        btnEnviar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //Intent intent = new Intent(MainActivity.this,ListActivity.class);
                Intent intent = new Intent(MainActivity.this,TarjetasActivity.class);
                startActivity(intent);
                return true;
            }
        });

    }

    void enviarData(){
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                    int progreso = 0;
                    while (progreso < 100){
                        //simular proceso
                        try{
                            Thread.sleep(100);
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        progreso++;

                        //actualizar progresbar
                        final int finalProgreso = progreso;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(finalProgreso);
                            }
                        });

                    }


            }
        }).start();

    }


}