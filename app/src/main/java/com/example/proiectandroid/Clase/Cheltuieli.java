package com.example.proiectandroid.Clase;

import java.util.Date;

public class Cheltuieli {
    private String denumireCheltuiala;
    private String sursaCheltuiala;
    private float sumaCheltuiala;
    private Date dataCheltuiala;
    private Buget bugetSelectat;

    public Cheltuieli(String denumireCheltuiala, Date dataCheltuiala, float sumaCheltuiala, String sursaCheltuiala, Buget bugetSelectat) {
        this.denumireCheltuiala = denumireCheltuiala;
        this.dataCheltuiala = dataCheltuiala;
        this.sumaCheltuiala = sumaCheltuiala;
        this.sursaCheltuiala = sursaCheltuiala;
        this.bugetSelectat = bugetSelectat;
    }

    public String getDenumireCheltuiala() {
        return denumireCheltuiala;
    }

    public void setDenumireCheltuiala(String denumireCheltuiala) {
        this.denumireCheltuiala = denumireCheltuiala;
    }

    public String getSursaCheltuiala() {
        return sursaCheltuiala;
    }

    public void setSursaCheltuiala(String sursaCheltuiala) {
        this.sursaCheltuiala = sursaCheltuiala;
    }

    public float getSumaCheltuiala() {
        return sumaCheltuiala;
    }

    public void setSumaCheltuiala(float sumaCheltuiala) {
        this.sumaCheltuiala = sumaCheltuiala;
    }

    public Date getDataCheltuiala() {
        return dataCheltuiala;
    }

    public void setDataCheltuiala(Date dataCheltuiala) {
        this.dataCheltuiala = dataCheltuiala;
    }

    public Buget getBugetSelectat() {
        return bugetSelectat;
    }

    public void setBugetSelectat(Buget bugetSelectat) {
        this.bugetSelectat = bugetSelectat;
    }
}
