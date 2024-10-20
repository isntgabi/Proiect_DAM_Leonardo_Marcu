package com.example.proiectandroid.Clase;

import java.util.ArrayList;

public class dbBuget {
    private static ArrayList<Buget> listaBugete = new ArrayList<>();

    public static void adaugaBuget(Buget buget)
    {
        listaBugete.add(buget);
    }

}
