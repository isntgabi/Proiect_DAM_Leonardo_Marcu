package com.example.proiectdam_leonardo_marcu.Clase;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(
        tableName = "cheltuieli",
        foreignKeys = {
                @ForeignKey(entity = Utilizator.class, parentColumns = "id", childColumns = "utilizatorId"),
                @ForeignKey(entity = BugetAdaugat.class, parentColumns = "bugetId", childColumns = "bugetId")
        }
)
public class Cheltuiala implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    String sursaCheltuiala;
    String denumireCheltuiala;
    double sumaCheltuiala;
    Date dataCheltuiala;
    Long utilizatorId;
    Long bugetId;

    public Cheltuiala(String sursaCheltuiala, String denumireCheltuiala, double sumaCheltuiala, Date dataCheltuiala, Long bugetId, Long utilizatorId) {
        this.sursaCheltuiala = sursaCheltuiala;
        this.denumireCheltuiala = denumireCheltuiala;
        this.sumaCheltuiala = sumaCheltuiala;
        this.dataCheltuiala = dataCheltuiala;
        this.bugetId = bugetId;
        this.utilizatorId = utilizatorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUtilizatorId() {
        return utilizatorId;
    }

    public void setUtilizatorId(Long utilizatorId) {
        this.utilizatorId = utilizatorId;
    }

    public Long getBugetId() {
        return bugetId;
    }

    public void setBugetId(Long bugetId) {
        this.bugetId = bugetId;
    }

    @Override
    public String toString() {
        return "Cheltuiala{" +
                "sursaCheltuiala='" + sursaCheltuiala + '\'' +
                ", denumireCheltuiala='" + denumireCheltuiala + '\'' +
                ", sumaCheltuiala=" + sumaCheltuiala +
                ", dataCheltuiala=" + dataCheltuiala +
                ", bugetId=" + bugetId +
                ", utilizatorId=" + utilizatorId +
                '}';
    }
}
