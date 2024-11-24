package com.example.proiectdam_leonardo_marcu.Databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proiectdam_leonardo_marcu.Clase.BugetAdaugat;
import com.example.proiectdam_leonardo_marcu.Clase.Utilizator;

@Database(entities = {BugetAdaugat.class, Utilizator.class}, version = 1)
public abstract class BugetDB extends RoomDatabase {
    private static final String dbName = "bugete.db";
    private static BugetDB instance;

    public static BugetDB getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, BugetDB.class, dbName).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract BugetDAO getBugetDAO();
}
