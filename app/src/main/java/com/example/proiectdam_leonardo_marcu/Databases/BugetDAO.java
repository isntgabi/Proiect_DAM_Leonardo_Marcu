package com.example.proiectdam_leonardo_marcu.Databases;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proiectdam_leonardo_marcu.Clase.BugetAdaugat;

import java.util.List;

@Dao
public interface BugetDAO {
    @Insert
    void insertBuget(BugetAdaugat bugetAdaugat);

    @Query("SELECT * FROM bugete WHERE utilizatorId = :id")
    List<BugetAdaugat> getBugete(Long id);




}
