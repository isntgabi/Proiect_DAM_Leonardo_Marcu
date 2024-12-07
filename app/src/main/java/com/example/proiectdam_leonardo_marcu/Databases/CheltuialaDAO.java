package com.example.proiectdam_leonardo_marcu.Databases;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proiectdam_leonardo_marcu.Clase.Cheltuiala;

import java.util.List;

@Dao
public interface CheltuialaDAO {

    @Insert
    void insertCheltuiala(Cheltuiala cheltuiala);

    @Query("SELECT * FROM cheltuieli WHERE utilizatorId = :id")
    List<Cheltuiala> getCheltuieli(Long id);


}
