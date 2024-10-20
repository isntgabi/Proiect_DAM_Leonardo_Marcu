package com.example.proiectandroid.Clase;

public class Utilizator {

    private String emailUtilizator;
    private String numeUtilizator;
    private String parolaUtilizator;

    public Utilizator(String numeUtilizator, String parolaUtilizator, String emailUtilizator) {
        this.numeUtilizator = numeUtilizator;
        this.parolaUtilizator = parolaUtilizator;
        this.emailUtilizator = emailUtilizator;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public String getParolaUtilizator() {
        return parolaUtilizator;
    }

    public void setParolaUtilizator(String parolaUtilizator) {
        this.parolaUtilizator = parolaUtilizator;
    }

    public String getEmailUtilizator() {
        return emailUtilizator;
    }

    public void setEmailUtilizator(String emailUtilizator) {
        this.emailUtilizator = emailUtilizator;
    }
}
