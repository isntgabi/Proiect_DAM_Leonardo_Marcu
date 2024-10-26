package com.example.proiectdam_leonardo_marcu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;

    LinearLayout dashboard, profile, budget, venituri, cheltuieli, hystoric, graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
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
            recreate();
        });

        profile.setOnClickListener(view -> {
            redirectActivity(Dashboard.this,Profile.class);
        });
        budget.setOnClickListener(view -> {
            redirectActivity(Dashboard.this,Buget.class);
        });
        venituri.setOnClickListener(view -> {
            redirectActivity(Dashboard.this,Venituri.class);
        });
        cheltuieli.setOnClickListener(view -> {
            redirectActivity(Dashboard.this,Cheltuieli.class);
        });
        hystoric.setOnClickListener(view -> {
            redirectActivity(Dashboard.this,Istoric.class);
        });
        graph.setOnClickListener(view -> {
            redirectActivity(Dashboard.this,Grafic.class);
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