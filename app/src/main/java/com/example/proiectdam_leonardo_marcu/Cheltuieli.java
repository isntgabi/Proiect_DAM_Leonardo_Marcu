package com.example.proiectdam_leonardo_marcu;

import android.app.Activity;
import android.content.Intent;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cheltuieli extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;

    LinearLayout dashboard, profile, budget, venituri, cheltuieli, hystoric, graph;

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

        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.meniu);
        dashboard = findViewById(R.id.dashboard);
        profile = findViewById(R.id.profile);
        budget = findViewById(R.id.budget);
        venituri = findViewById(R.id.venituri);
        cheltuieli = findViewById(R.id.cheltuieli);
        hystoric = findViewById(R.id.istoric);
        graph = findViewById(R.id.grafic);

        menu.setOnClickListener(view -> {
            openDrawer(drawerLayout);
        });

        dashboard.setOnClickListener(view -> {
            redirectActivity(Cheltuieli.this,Dashboard.class);
        });

        profile.setOnClickListener(view -> {
            redirectActivity(Cheltuieli.this,Profile.class);
        });
        budget.setOnClickListener(view -> {
            redirectActivity(Cheltuieli.this,Buget.class);
        });
        venituri.setOnClickListener(view -> {
            redirectActivity(Cheltuieli.this,Venituri.class);
        });
        cheltuieli.setOnClickListener(view -> {
            recreate();
        });
        hystoric.setOnClickListener(view -> {
            redirectActivity(Cheltuieli.this,Istoric.class);
        });
        graph.setOnClickListener(view -> {
            redirectActivity(Cheltuieli.this,Grafic.class);
        });

        Spinner spinnerBugete = findViewById(R.id.spnBuget);

        ArrayAdapter<BugetAdaugat> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, BugetAdaugat.getBugete()
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBugete.setAdapter(adapter);

        Button salvare = findViewById(R.id.btnAdaugareCheltuiala);
        EditText etSursa = findViewById(R.id.etSursaCheltuiala);
        EditText etDenumire = findViewById(R.id.etDenumireCheltuiala);
        EditText etSuma = findViewById(R.id.etSumaCheltuiala);
        EditText etData = findViewById(R.id.etDataCheltuiala);
        salvare.setOnClickListener(view -> {
            String sursa = etSursa.getText().toString();
            String denumire = etDenumire.getText().toString();

            if (sursa.isEmpty() || denumire.isEmpty() || etSuma.getText().toString().isEmpty() || etData.getText().toString().isEmpty()) {
                Toast.makeText(this, "Completați toate câmpurile!", Toast.LENGTH_SHORT).show();
                return;
            }

            double suma = Double.parseDouble(etSuma.getText().toString());
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date dataCheltuiala;
            try {
                dataCheltuiala = sdf.parse(etData.getText().toString());
            } catch (ParseException e) {
                Toast.makeText(this, "Data introdusă nu este validă!", Toast.LENGTH_SHORT).show();
                return;
            }

            BugetAdaugat bugetSelectat = (BugetAdaugat) spinnerBugete.getSelectedItem();
            Cheltuiala cheltuiala = new Cheltuiala(sursa, denumire, suma, dataCheltuiala, bugetSelectat);

            Toast.makeText(this, "Cheltuiala a fost adăugată cu succes!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Istoric.class);
            intent.putExtra("cheltuialaFromIntent", cheltuiala);
            setResult(RESULT_OK, intent);
            finish();
        });

    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();

    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}