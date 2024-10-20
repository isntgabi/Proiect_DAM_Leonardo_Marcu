package com.example.proiectandroid.Clase;

import java.util.Date;

public class Venit {
    private String sursaVenit;
    private String denumireVenit;
    private Date dataVenit;
    private float sumaVenit;
    private Buget bugetSelectat;

    public Venit(String sursaVenit, String denumireVenit, Date dataVenit, float sumaVenit, Buget bugetSelectat) {
        this.sursaVenit = sursaVenit;
        this.denumireVenit = denumireVenit;
        this.dataVenit = dataVenit;
        this.sumaVenit = sumaVenit;
        this.bugetSelectat = bugetSelectat;
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

    public Date getDataVenit() {
        return dataVenit;
    }

    public void setDataVenit(Date dataVenit) {
        this.dataVenit = dataVenit;
    }

    public float getSumaVenit() {
        return sumaVenit;
    }

    public void setSumaVenit(float sumaVenit) {
        this.sumaVenit = sumaVenit;
    }

    public Buget getBugetSelectat() {
        return bugetSelectat;
    }

    public void setBugetSelectat(Buget bugetSelectat) {
        this.bugetSelectat = bugetSelectat;
    }
}
