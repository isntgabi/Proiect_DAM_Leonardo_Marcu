package com.example.proiectdam_leonardo_marcu.Databases;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proiectdam_leonardo_marcu.Clase.Venit;

import java.util.List;

@Dao
public interface VenitDAO {

    @Insert
    void insertVenit(Venit venit);

    @Query("SELECT * FROM venituri WHERE utilizatorId = :id")
    List<Venit> getVenituri(Long id);

    @Delete
    void deleteVenit(Venit venit);
}
