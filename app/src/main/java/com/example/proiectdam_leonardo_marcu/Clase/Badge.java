package com.example.proiectdam_leonardo_marcu.Clase;

import java.io.Serializable;

public class Badge implements Serializable {
    private String id;
    private long idUtilizator;
    private String denumire;

    public Badge() {

    }

    public Badge(long idUtilizator, String denumire) {
        this.idUtilizator = idUtilizator;
        this.denumire = denumire;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(long idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "Badge: " + denumire;
    }
}
