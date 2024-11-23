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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Grafic extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grafic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_grafic);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.bottom_dashboard) {
                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.bottom_buget) {
                Intent intent = new Intent(getApplicationContext(), VizualizareBugete.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.bottom_cheltuieli) {
                Intent intent = new Intent(getApplicationContext(), VizualizareCheltuieli.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.bottom_grafic) {
                return true;
            } else if (item.getItemId() == R.id.bottom_venituri) {
                Intent intent = new Intent(getApplicationContext(), VizualizareVenituri.class);
                startActivity(intent);
                return true;
            }

            return false;
        });
    }

}