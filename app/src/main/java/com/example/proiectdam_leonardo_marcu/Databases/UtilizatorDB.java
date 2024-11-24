package com.example.proiectdam_leonardo_marcu.Databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proiectdam_leonardo_marcu.Clase.Utilizator;

@Database(entities = {Utilizator.class}, version = 1, exportSchema = false)
public abstract class UtilizatorDB extends RoomDatabase {
    private static final String dbName = "utilizatori.db";
    private static UtilizatorDB instance;

    public static UtilizatorDB getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, UtilizatorDB.class, dbName).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract UtilizatorDAO getUtilizatorDAO();
}
