package com.example.myapplication;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "usuarios")


public class Usuario {
    @DatabaseField(id=true)
    private int id;
    @DatabaseField
    private String usuarioBd;
    @DatabaseField
    private String passwordBd;

    public Usuario(String usuarioBd, String passwordBd) {
        this.usuarioBd = usuarioBd;
        this.passwordBd = passwordBd;
    }

    public String getUsuarioBd() {
        return usuarioBd;
    }

    public void setUsuarioBd(String usuarioBd) {
        this.usuarioBd = usuarioBd;
    }

    public String getPasswordBd() {
        return passwordBd;
    }

    public void setPasswordBd(String passwordBd) {
        this.passwordBd = passwordBd;
    }
}
