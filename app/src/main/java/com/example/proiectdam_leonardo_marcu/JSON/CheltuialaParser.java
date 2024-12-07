package com.example.proiectdam_leonardo_marcu.JSON;

import com.example.proiectdam_leonardo_marcu.Clase.Cheltuiala;
import com.example.proiectdam_leonardo_marcu.Clase.Venit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheltuialaParser {
    private static final String SURSA = "sursaCheltuiala";
    private static final String DENUMIREA = "denumireCheltuiala";
    private static final String SUMA = "sumaCheltuiala";
    private static final String DATA = "dataCheltuiala";
    private static final String UTILIZATORID = "utilizatorId";
    private static final String BUGETID = "bugetId";

    public static List<Cheltuiala> parsareJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            return parsareCheltuieli(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Cheltuiala> parsareCheltuieli(JSONArray jsonArray) throws JSONException {
        List<Cheltuiala> cheltuieli = new ArrayList<>();
        for(int i=0;i< jsonArray.length();i++) {
            cheltuieli.add(parsareCheltuiala(jsonArray.getJSONObject(i)));
        }
        return cheltuieli;
    }
    private static Cheltuiala parsareCheltuiala(JSONObject jsonObject) throws JSONException {
        String sursa = jsonObject.getString(SURSA);
        String denumire = jsonObject.getString(DENUMIREA);
        double suma = jsonObject.getDouble(SUMA);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date data = null;
        try {
            data = sdf.parse(jsonObject.getString(DATA));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long utilizatorId = jsonObject.getLong(UTILIZATORID);
        long bugetId = jsonObject.getLong(BUGETID);

        return new Cheltuiala(sursa,denumire,suma,data,bugetId,utilizatorId);
    }
}
