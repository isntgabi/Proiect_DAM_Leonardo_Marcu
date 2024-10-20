package com.example.proiectandroid.Clase;

public class Buget {
    private String denumire;
    private int suma;

    public Buget(String denumire, int suma) {
        this.denumire = denumire;
        this.suma = suma;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }


}
