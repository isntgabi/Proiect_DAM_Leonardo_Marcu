package com.example.proiectdam_leonardo_marcu.Clase;

import java.util.ArrayList;
import java.util.List;

public class BugetAdaugat {

    private static final List<BugetAdaugat> bugete = new ArrayList<>();
    String denumireBuget;
    double sumaBuget;

    public BugetAdaugat(String denumireBuget, double sumaBuget) {
        this.denumireBuget = denumireBuget;
        this.sumaBuget = sumaBuget;
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

    @Override
    public String toString() {
        return denumireBuget;
    }
    public static List<BugetAdaugat> getBugete() {
        return bugete;
    }

    public static void addBuget(BugetAdaugat buget) {
        bugete.add(buget);
    }
}
