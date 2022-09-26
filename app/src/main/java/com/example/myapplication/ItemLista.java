package com.example.myapplication;

public class ItemLista {
    private String personaje;
    private String casa;
    private String libro;

    public ItemLista(String personaje, String casa, String libro) {
        this.personaje = personaje;
        this.casa = casa;
        this.libro = libro;
    }



    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }
}
