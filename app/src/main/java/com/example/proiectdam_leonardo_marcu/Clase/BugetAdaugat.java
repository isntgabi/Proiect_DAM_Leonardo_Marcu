package com.example.proiectdam_leonardo_marcu.Clase;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "bugete", foreignKeys = @ForeignKey(
        entity = Utilizator.class,
        parentColumns = "id",
        childColumns = "utilizatorId"))
public class BugetAdaugat implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long bugetId;
    String denumireBuget;
    double sumaBuget;

    //foreign key
    private long utilizatorId;

    public BugetAdaugat(String denumireBuget, double sumaBuget, long utilizatorId) {
        this.denumireBuget = denumireBuget;
        this.sumaBuget = sumaBuget;
        this.utilizatorId = utilizatorId;
    }

    public double getSumaBuget() {
        return sumaBuget;
    }

    public void setSumaBuget(double sumaBuget) {
        this.sumaBuget = sumaBuget;
    }

    public String getDenumireBuget() {
        return denumireBuget;
    }

    public void setDenumireBuget(String denumireBuget) {
        this.denumireBuget = denumireBuget;
    }

    public long getUtilizatorId() {
        return utilizatorId;
    }

    public void setUtilizatorId(long utilizatorId) {
        this.utilizatorId = utilizatorId;
    }

    public long getBugetId() {
        return bugetId;
    }

    public void setBugetId(long bugetId) {
        this.bugetId = bugetId;
    }

    @Override
    public String toString() {
        return denumireBuget;
    }
}
