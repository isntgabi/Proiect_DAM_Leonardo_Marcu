package com.example.proiectdam_leonardo_marcu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.proiectdam_leonardo_marcu.Clase.BugetAdaugat;

public class Buget extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;

    LinearLayout dashboard, profile, budget, venituri, cheltuieli, hystoric, graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buget);
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
            redirectActivity(Buget.this,Dashboard.class);
        });

        profile.setOnClickListener(view -> {
            redirectActivity(Buget.this,Profile.class);
        });
        budget.setOnClickListener(view -> {
            recreate();
        });
        venituri.setOnClickListener(view -> {
            redirectActivity(Buget.this,Venituri.class);
        });
        cheltuieli.setOnClickListener(view -> {
            redirectActivity(Buget.this,Cheltuieli.class);
        });
        hystoric.setOnClickListener(view -> {
            redirectActivity(Buget.this,Istoric.class);
        });
        graph.setOnClickListener(view -> {
            redirectActivity(Buget.this,Grafic.class);
        });

        EditText denumireBuget;
        EditText sumaBuget;
        Button salvareBuget;

        denumireBuget = findViewById(R.id.etDenumireBuget);
        sumaBuget = findViewById(R.id.etSumaBuget);
        salvareBuget = findViewById(R.id.btnAdaugareBuget);

       salvareBuget.setOnClickListener(view -> {
           String denumire = denumireBuget.getText().toString();
           double suma = Double.parseDouble(sumaBuget.getText().toString());

           BugetAdaugat bugetNou = new BugetAdaugat(denumire, suma);
           BugetAdaugat.addBuget(bugetNou);

           Toast.makeText(this, "Bugetul a fost salvat cu succes!", Toast.LENGTH_SHORT).show();

           denumireBuget.setText("");
           sumaBuget.setText("");
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