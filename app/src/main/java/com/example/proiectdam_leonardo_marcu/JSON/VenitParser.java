package com.example.proiectdam_leonardo_marcu.JSON;

import com.example.proiectdam_leonardo_marcu.Clase.Venit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VenitParser {
    private static final String SURSAVENIT = "sursaVenit";
    private static final String DENUMIREVENIT = "denumireVenit";
    private static final String SUMAVENIT = "sumaVenit";
    private static final String DATAVENIT = "dataVenit";
    private static final String UTILIZATORID = "utilizatorId";
    private static final String BUGETID = "bugetId";

    public static List<Venit> parsareJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            return parsareVenituri(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Venit> parsareVenituri(JSONArray jsonArray) throws JSONException {
        List<Venit> venituri = new ArrayList<>();
        for(int i=0;i< jsonArray.length();i++) {
            venituri.add(parsareVenit(jsonArray.getJSONObject(i)));
        }
        return venituri;
    }
    private static Venit parsareVenit(JSONObject jsonObject) throws JSONException {
        String sursa = jsonObject.getString(SURSAVENIT);
        String denumire = jsonObject.getString(DENUMIREVENIT);
        double suma = jsonObject.getDouble(SUMAVENIT);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date data = null;
        try {
            data = sdf.parse(jsonObject.getString(DATAVENIT));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long utilizatorId = jsonObject.getLong(UTILIZATORID);
        long bugetId = jsonObject.getLong(BUGETID);

        return new Venit(sursa,denumire,suma,data,utilizatorId,bugetId);
    }
}
