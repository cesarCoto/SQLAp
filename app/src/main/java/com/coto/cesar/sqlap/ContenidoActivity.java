package com.coto.cesar.sqlap;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContenidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);


        //se optiene el acceso a la barra de estado de la app
        ActionBar actionBar = getSupportActionBar();

        //se optiene la informacion que hay en el intent
        Bundle bundle = getIntent().getExtras();

        //se convierte la informacion
        String name = bundle.getString("Nombre");

        //se asigna el nombre que se paso de la otra actividad
        actionBar.setTitle(name);
    }
}
