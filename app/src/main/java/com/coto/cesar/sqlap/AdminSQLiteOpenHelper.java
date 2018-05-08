package com.coto.cesar.sqlap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);



    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table personas(" +
                        "ID_registro int(20) primary key," +
                        "nombre varchar(50)," +
                        "curp varchar(50)," +
                        "sexo varchar(50)," +
                        "nacimiento date," +
                        "edad int(20)," +
                        "direccion varchar(50)," +
                        "telefono int(50)," +
                        "ID_Usuario int(11))"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
