package com.example.proiectdam_leonardo_marcu.Clase;

import java.io.Serializable;
import java.util.Date;

public class Venit implements Serializable {
    String sursaVenit;
    String denumireVenit;
    double sumaVenit;
    Date dataVenit;

    BugetAdaugat bugetAdaugat;

    public Venit(String sursaVenit, String denumireVenit, double sumaVenit, Date dataVenit, BugetAdaugat bugetAdaugat) {
        this.sursaVenit = sursaVenit;
        this.denumireVenit = denumireVenit;
        this.sumaVenit = sumaVenit;
        this.dataVenit = dataVenit;

        this.bugetAdaugat = bugetAdaugat;
    }

    public String getSursaVenit() {
        return sursaVenit;
    }

    public void setSursaVenit(String sursaVenit) {
        this.sursaVenit = sursaVenit;
    }

    public String getDenumireVenit() {
        return denumireVenit;
    }

    public void setDenumireVenit(String denumireVenit) {
        this.denumireVenit = denumireVenit;
    }

    public double getSumaVenit() {
        return sumaVenit;
    }

    public void setSumaVenit(double sumaVenit) {
        this.sumaVenit = sumaVenit;
    }

    public Date getDataVenit() {
        return dataVenit;
    }

    public void setDataVenit(Date dataVenit) {
        this.dataVenit = dataVenit;
    }


    public BugetAdaugat getBuget() {
        return bugetAdaugat;
    }

    public void setBuget(BugetAdaugat bugetAdaugat) {
        this.bugetAdaugat = bugetAdaugat;
    }

    @Override
    public String toString() {
        return "Venit{" +
                "sursaVenit='" + sursaVenit + '\'' +
                ", denumireVenit='" + denumireVenit + '\'' +
                ", sumaVenit=" + sumaVenit +
                ", dataVenit=" + dataVenit +
                ", bugetAdaugat=" + bugetAdaugat +
                '}';
    }
}
