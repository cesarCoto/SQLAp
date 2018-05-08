package com.coto.cesar.sqlap;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Date;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //se enlza el listView
    ListView listView;

    //se crea un array que contendra los titulos
    ArrayList<String> info;
    // se crea un array que contendra las personas
    ArrayList<Pesona> pesonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se enlazan las vistas
        listView = findViewById(R.id.listView);

        //se llama al metodo consultar para asignar los datos al listado
        consultar();

        // se crea un adaptador para poder reaizar el listado
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,info);
        listView.setAdapter(adaptador);


        //se asigna un onClick a los elementos del listado
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //se optiene el nombre de la persona
                Pesona pesona = pesonas.get(position);
                String name = pesona.getName();

                //se inizializa la otra actividad manndando como parametro el nomnbre de la persona.
                Intent i = new Intent(MainActivity.this,ContenidoActivity.class);
                i.putExtra("Nombre",name);
                startActivity(i);

            }
        });

        addNewUser();
    }

    public void  addNewUser() {
        AdminSQLiteOpenHelper admin =
                new AdminSQLiteOpenHelper(this,"administracion",null,1);

        String [] nombre = {"Cesar","Alexis","Karla","Karina"};
        String [] curp = {"CSAS", "ASAF","KASAS","KLQEQ"};
        String [] sexo = {"M","M","F","F"};
        String [] nacimiento ={"2000/11/20","2012/12/20","2011/10/25","2013/10/30"};
        String [] edad ={"12","15","10","21"};
        String [] direccion ={"12","15","10","21"};
        String [] telefonono = {"12121","21212","21212","21212"};
        String [] idUsuario = {"1","2","3","4"};

        /**Se optiene el premiso para generar una base de datos de escritura**/
        SQLiteDatabase db = admin.getWritableDatabase();

        /**content Values es el que nos ayuda a agregar los valores a la tabla**/
        ContentValues registro = new ContentValues();

        /**Se usa el ciclo for para agregar todas las vistas de manera rapida**/
        for (int i = 0; i<4; i++){
            /**se agregan los valores a la talba*/
            registro.put("ID_registro",i+1);
            registro.put("nombre",nombre[i]);
            registro.put("curp",curp[i]);
            registro.put("sexo",sexo[i]);
            registro.put("nacimiento",nacimiento[i]);
            registro.put("edad",edad[i]);
            registro.put("direccion",direccion[i]);
            registro.put("telefono",telefonono[i]);
            registro.put("ID_Usuario",idUsuario[i]);

            /**Se inserta el contenido de la tabla a la base de datos*/
            db.insert("personas",null,registro);
            Toast.makeText(this, edad[i], Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    private void consultar() {

        // se optiene del acceso a la base de datos
        AdminSQLiteOpenHelper admin =
                new AdminSQLiteOpenHelper(this,"administracion",null,1);

        SQLiteDatabase db = admin.getReadableDatabase();

        Pesona pesona = null;
        pesonas = new ArrayList<Pesona>();

        // se optienen todos los datos de la base de datos
        Cursor cursor=db.rawQuery("SELECT * FROM personas",null);

        while (cursor.moveToNext()){
            pesona=new Pesona();
            pesona.setId(cursor.getInt(0));
            pesona.setName(cursor.getString(1));
            pesona.setCurp(cursor.getString(2));
            pesona.setSexo(cursor.getString(3));
            pesona.setNacimiento(cursor.getString(4));
            pesona.setEdad(cursor.getInt(5));
            pesona.setDireccion(cursor.getString(6));
            pesona.setTelefono(cursor.getString(7));
            pesona.setId_Personas(cursor.getInt(8));


            pesonas.add(pesona);
        }
        // se crea la lista
        obtenerLista();

    }
    private void obtenerLista() {
        info=new ArrayList<String>();

        for (int i=0; i<pesonas.size();i++){
            info.add(pesonas.get(i).getId()+" - "
                    +pesonas.get(i).getName());
        }

    }
}
