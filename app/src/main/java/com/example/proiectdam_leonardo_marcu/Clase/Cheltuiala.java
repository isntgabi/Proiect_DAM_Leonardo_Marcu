package com.example.proiectdam_leonardo_marcu.Clase;

import java.io.Serializable;
import java.util.Date;

public class Cheltuiala implements Serializable {
    String sursaCheltuiala;
    String denumireCheltuiala;
    double sumaCheltuiala;
    Date dataCheltuiala;

    BugetAdaugat bugetAdaugat;

    public Cheltuiala(String sursaCheltuiala, String denumireCheltuiala, double sumaCheltuiala, Date dataCheltuiala, BugetAdaugat bugetAdaugat) {
        this.sursaCheltuiala = sursaCheltuiala;
        this.denumireCheltuiala = denumireCheltuiala;
        this.sumaCheltuiala = sumaCheltuiala;
        this.dataCheltuiala = dataCheltuiala;
        this.bugetAdaugat = bugetAdaugat;
    }

    public String getSursaCheltuiala() {
        return sursaCheltuiala;
    }

    public void setSursaCheltuiala(String sursaCheltuiala) {
        this.sursaCheltuiala = sursaCheltuiala;
    }

    public String getDenumireCheltuiala() {
        return denumireCheltuiala;
    }

    public void setDenumireCheltuiala(String denumireCheltuiala) {
        this.denumireCheltuiala = denumireCheltuiala;
    }

    public double getSumaCheltuiala() {
        return sumaCheltuiala;
    }

    public void setSumaCheltuiala(double sumaCheltuiala) {
        this.sumaCheltuiala = sumaCheltuiala;
    }

    public Date getDataCheltuiala() {
        return dataCheltuiala;
    }

    public void setDataCheltuiala(Date dataCheltuiala) {
        this.dataCheltuiala = dataCheltuiala;
    }

    public BugetAdaugat getBugetAdaugat() {
        return bugetAdaugat;
    }

    public void setBugetAdaugat(BugetAdaugat bugetAdaugat) {
        this.bugetAdaugat = bugetAdaugat;
    }

    @Override
    public String toString() {
        return "Cheltuiala{" +
                "sursaCheltuiala='" + sursaCheltuiala + '\'' +
                ", denumireCheltuiala='" + denumireCheltuiala + '\'' +
                ", sumaCheltuiala=" + sumaCheltuiala +
                ", dataCheltuiala=" + dataCheltuiala +
                ", bugetAdaugat=" + bugetAdaugat +
                '}';
    }
}
