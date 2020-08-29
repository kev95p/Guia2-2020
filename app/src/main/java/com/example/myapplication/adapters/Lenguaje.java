package com.example.myapplication.adapters;

public class Lenguaje {
    private String nombre;
    private String desarrollador;

    public Lenguaje(String nombre, String desarrollador) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }
}
