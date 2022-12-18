package com.tssdao.mytssapp;

public enum Agencias {

    AGENCIA1(1, "Av. Ayacucho", "agencia1"),
    AGENCIA2(2, "C. Hamiraya", "agencia2"),
    AGENCIA3(3, "Av. Beneméritos", "agencia3"),
    AGENCIA4(4, "Av. José Ballivian", "agencia4");

    private int numero;
    private String ubicacion;
    private String nombre;

    private Agencias(int numero, String ubicacion, String nombre) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
