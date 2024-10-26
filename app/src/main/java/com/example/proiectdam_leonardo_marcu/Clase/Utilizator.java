package com.example.proiectdam_leonardo_marcu.Clase;

public class Utilizator {
    String username;
    String email;
    String parola;

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
}
