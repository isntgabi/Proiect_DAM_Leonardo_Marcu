package com.example.proiectdam_leonardo_marcu.Databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.proiectdam_leonardo_marcu.Clase.BugetAdaugat;
import com.example.proiectdam_leonardo_marcu.Clase.Cheltuiala;
import com.example.proiectdam_leonardo_marcu.Clase.Utilizator;
import com.example.proiectdam_leonardo_marcu.Clase.Venit;

@TypeConverters({Converters.class})
@Database(entities = {BugetAdaugat.class, Utilizator.class, Venit.class, Cheltuiala.class}, version = 3, exportSchema = false)
public abstract class AplicatieDB extends RoomDatabase {
    private static final String dbName = "aplicatie.db";
    private static AplicatieDB instance;

    public static AplicatieDB getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, AplicatieDB.class, dbName).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract BugetDAO getBugetDAO();
    public abstract UtilizatorDAO getUtilizatorDAO();
    public abstract VenitDAO getVenitDAO();
    public abstract CheltuialaDAO getCheltuialaDAO();
}
