package com.example.proiectandroid.Clase;

import java.util.ArrayList;

public class dbCheltuieli {
    private static ArrayList<Cheltuieli> listaCheltuieli = new ArrayList<>();

    private static void adaugaCheltuieli(Cheltuieli cheltuieli){
        listaCheltuieli.add(cheltuieli);
    }

    public static double calculeazaTotalCheltuieli() {
        double total = 0;
        for(Cheltuieli cheltuieli : listaCheltuieli) {
            total += cheltuieli.getSumaCheltuiala();
        }
        return total;
    }

    public static ArrayList<Cheltuieli> getListaCheltuieli() {
        return listaCheltuieli;
    }
}
