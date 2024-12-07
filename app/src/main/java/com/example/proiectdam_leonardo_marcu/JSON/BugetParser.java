package com.example.proiectdam_leonardo_marcu.JSON;

import com.example.proiectdam_leonardo_marcu.Clase.BugetAdaugat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BugetParser {
    private static final String DENUMIREBUGET = "denumireBuget";
    private static final String SUMABUGET = "sumaBuget";
    private static final String UTILIZATORID = "utilizatorId";


    public static List<BugetAdaugat> parsareJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            return parsareBugete(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<BugetAdaugat> parsareBugete(JSONArray jsonArray) throws JSONException {
        List<BugetAdaugat> bugete = new ArrayList<>();
        for(int i=0;i< jsonArray.length();i++) {
            bugete.add(parsareBuget(jsonArray.getJSONObject(i)));
        }
        return bugete;
    }
    private static BugetAdaugat parsareBuget(JSONObject jsonObject) throws JSONException {
        String denumire = jsonObject.getString(DENUMIREBUGET);
        double suma = jsonObject.getDouble(SUMABUGET);
        long utilizatorId = jsonObject.getLong(UTILIZATORID);

        return new BugetAdaugat(denumire,suma,utilizatorId);
    }
}
