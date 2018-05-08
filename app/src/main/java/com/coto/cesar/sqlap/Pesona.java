package com.coto.cesar.sqlap;

import android.content.Intent;

public class Pesona {
    private Integer id;
    private String name;
    private String curp;
    private String sexo;
    private String nacimiento;
    private Integer edad;
    private String direccion;
    private String telefono;
    private Integer id_Personas;

    public Pesona() {
    }

    public Pesona(Integer id, String name, String curp, String sexo, String nacimiento, Integer edad, String direccion, String telefono, Integer id_Personas) {
        this.id = id;
        this.name = name;
        this.curp = curp;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_Personas = id_Personas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getId_Personas() {
        return id_Personas;
    }

    public void setId_Personas(Integer id_Personas) {
        this.id_Personas = id_Personas;
    }
}
