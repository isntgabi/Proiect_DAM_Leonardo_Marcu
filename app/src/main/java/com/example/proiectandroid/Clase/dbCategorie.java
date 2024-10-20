package com.example.proiectandroid.Clase;

import java.util.ArrayList;

public class dbCategorie {
    private static ArrayList<Categorie> categorii = new ArrayList<>();

    private static void adaugaCategorie(Categorie categorie){
        categorii.add(categorie);
    }
}
