package com.example.proiectdam_leonardo_marcu.Databases;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proiectdam_leonardo_marcu.Clase.Utilizator;

import java.util.List;

@Dao
public interface UtilizatorDAO {

    @Insert
    void insertUtilizator(Utilizator utilizator);

    @Query("SELECT * FROM utilizatori")
    List<Utilizator> getUtilizatori();

    @Query("SELECT * FROM utilizatori WHERE id=:idCautat")
    Utilizator getUtilizatorById(Long idCautat);

    @Query("SELECT EXISTS (SELECT * FROM utilizatori WHERE username = :numeLuat)")
    boolean esteLuat(String numeLuat);

    @Query("SELECT EXISTS (SELECT * FROM utilizatori WHERE username = :user AND parola = :pass LIMIT 1)")
    boolean login(String user, String pass);

    @Query("SELECT * FROM utilizatori WHERE username = :user AND parola = :pass LIMIT 1")
    Utilizator getUtilizator(String user, String pass);
}
