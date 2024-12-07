package com.example.proiectdam_leonardo_marcu.Clase;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(
        tableName = "venituri",
        foreignKeys = {
                @ForeignKey(entity = Utilizator.class, parentColumns = "id", childColumns = "utilizatorId"),
                @ForeignKey(entity = BugetAdaugat.class, parentColumns = "bugetId", childColumns = "bugetId")
        }
)
public class Venit implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String sursaVenit;
    private String denumireVenit;
    private double sumaVenit;
    private Date dataVenit;

    // Foreign keys
    private Long utilizatorId;
    private Long bugetId; // Referință către buget

    public Venit(String sursaVenit, String denumireVenit, double sumaVenit, Date dataVenit, Long utilizatorId, Long bugetId) {
        this.sursaVenit = sursaVenit;
        this.denumireVenit = denumireVenit;
        this.sumaVenit = sumaVenit;
        this.dataVenit = dataVenit;
        this.utilizatorId = utilizatorId;
        this.bugetId = bugetId;
    }

    // Getteri și setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Venit{" +
                "sursaVenit='" + sursaVenit + '\'' +
                ", denumireVenit='" + denumireVenit + '\'' +
                ", sumaVenit=" + sumaVenit +
                ", dataVenit=" + dataVenit +
                ", bugetId=" + bugetId +
                '}';
    }
}
