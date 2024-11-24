package com.example.proiectdam_leonardo_marcu.Clase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "utilizatori")
public class Utilizator {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String username;
    private String email;
    private String parola;

    public Utilizator(String username, String email, String parola) {
        this.username = username;
        this.email = email;
        this.parola = parola;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
