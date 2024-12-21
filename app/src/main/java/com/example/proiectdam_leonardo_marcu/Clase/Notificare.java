package com.example.proiectdam_leonardo_marcu.Clase;

import java.io.Serializable;
import java.util.Date;

public class Notificare implements Serializable {
    private String id;
    private long idUtilizator;
    private String mesaj;
    private Date data;

    public Notificare() {
    }

    public Notificare(long idUtilizator, String mesaj, Date data) {
        this.idUtilizator = idUtilizator;
        this.mesaj = mesaj;
        this.data = data;
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

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Notificare: " + mesaj + ". Data: " + data;
    }
}
