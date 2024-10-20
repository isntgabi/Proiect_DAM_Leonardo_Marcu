package com.example.proiectandroid.Clase;

import java.util.ArrayList;

public class dbUtilizatori {
    private static ArrayList<Utilizator> utilizatori = new ArrayList<>();

    public static void adaugaUtilizator(Utilizator utilizator)
    {
        utilizatori.add(utilizator);
    }

    public static ArrayList<Utilizator> getUtilizatori() {
        return utilizatori;
    }
}
