package com.example.proiectdam_leonardo_marcu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.proiectdam_leonardo_marcu.Clase.BugetAdaugat;
import com.example.proiectdam_leonardo_marcu.Clase.Cheltuiala;
import com.example.proiectdam_leonardo_marcu.Databases.AplicatieDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cheltuieli extends AppCompatActivity {

    private boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cheltuieli);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, systemBars.top, 0, 0);
            return insets;
        });


        Spinner spinnerBugete = findViewById(R.id.spnBuget);

        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        long utilizatorId = sharedPreferences.getLong("utilizatorId", -1);

        ArrayAdapter<BugetAdaugat> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, AplicatieDB.getInstance(getApplicationContext()).getBugetDAO().getBugete(utilizatorId)
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBugete.setAdapter(adapter);

        Button salvare = findViewById(R.id.btnAdaugareCheltuiala);
        EditText etSursa = findViewById(R.id.etSursaCheltuiala);
        EditText etDenumire = findViewById(R.id.etDenumireCheltuiala);
        EditText etSuma = findViewById(R.id.etSumaCheltuiala);
        EditText etData = findViewById(R.id.etDataCheltuiala);

        Intent editIntent = getIntent();
        if(editIntent.hasExtra("edit")) {
            isEditing = true;
            Cheltuiala cheltuiala = (Cheltuiala) editIntent.getSerializableExtra("edit");

            etSursa.setText(cheltuiala.getSursaCheltuiala());
            etDenumire.setText(cheltuiala.getDenumireCheltuiala());
            etSuma.setText(String.valueOf(cheltuiala.getSumaCheltuiala()));
            etData.setText(new SimpleDateFormat("dd.MM.yyyy").format(cheltuiala.getDataCheltuiala()));
            for(int i=0;i<spinnerBugete.getCount();i++) {
                BugetAdaugat buget = adapter.getItem(i);
                if (cheltuiala.getBugetId().equals(buget.getBugetId())) {
                    spinnerBugete.setSelection(i);
                    break;
                }
            }
        }
        salvare.setOnClickListener(view -> {
            String sursa = etSursa.getText().toString();
            String denumire = etDenumire.getText().toString();

            if (sursa.isEmpty() || denumire.isEmpty() || etSuma.getText().toString().isEmpty() || etData.getText().toString().isEmpty()) {
                Toast.makeText(this, "Completați toate câmpurile!", Toast.LENGTH_SHORT).show();
                return;
            }

            double suma = Double.parseDouble(etSuma.getText().toString());
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date dataCheltuiala = null;
            try {
                dataCheltuiala = sdf.parse(etData.getText().toString());
            } catch (ParseException e) {
                Toast.makeText(this, "Data introdusă nu este validă!", Toast.LENGTH_SHORT).show();
                return;
            }

            BugetAdaugat bugetSelectat = (BugetAdaugat) spinnerBugete.getSelectedItem();

            if (bugetSelectat == null) {
                Toast.makeText(this, "Selectați un buget valid!", Toast.LENGTH_SHORT).show();
                return;
            }

            Long bugetId = bugetSelectat.getBugetId();

            Cheltuiala cheltuiala = new Cheltuiala(sursa, denumire, suma, dataCheltuiala, bugetId, utilizatorId);

            Toast.makeText(this, "Cheltuiala a fost adăugată cu succes!", Toast.LENGTH_SHORT).show();

            Intent intent = getIntent();
            if(isEditing) {
                intent.putExtra("edit", cheltuiala);
            } else {
                intent.putExtra("cheltuialaFromIntent", cheltuiala);
            }
            setResult(RESULT_OK, intent);
            finish();
        });

    }

}