package com.example.proiectandroid.Clase;

public class Istoric {
    private Cheltuieli cheltuiala;
    private Venit venit;

    public Istoric(Cheltuieli cheltuiala, Venit venit) {
        this.cheltuiala = cheltuiala;
        this.venit = venit;
    }

    public Cheltuieli getCheltuiala() {
        return cheltuiala;
    }

    public void setCheltuiala(Cheltuieli cheltuiala) {
        this.cheltuiala = cheltuiala;
    }

    public Venit getVenit() {
        return venit;
    }

    public void setVenit(Venit venit) {
        this.venit = venit;
    }
}
