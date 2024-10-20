package com.example.proiectandroid.Clase;

import java.util.ArrayList;

public class dbVenituri {
    private static ArrayList<Venit> listaVenituri = new ArrayList<>();

    public static void adaugaVenit(Venit venit) {
        listaVenituri.add(venit);
    }

    public static double calculeazaTotalVenituri() {
        double total = 0;
        for(Venit venit : listaVenituri) {
            total += venit.getSumaVenit();
        }
        return total;
    }

    public static ArrayList<Venit> getVenituri() {
        return listaVenituri;
    }
}
