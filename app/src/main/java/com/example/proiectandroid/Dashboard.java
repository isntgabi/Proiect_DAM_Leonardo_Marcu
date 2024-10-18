package com.example.proiectandroid;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.navBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.idIstoric) {
                    Intent intent = new Intent(Dashboard.this, Istoric.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.idCheltuieli) {
                    Intent intent = new Intent(Dashboard.this, AdaugaCheltuieli.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.idVenituri) {
                    Intent intent = new Intent(Dashboard.this, AdaugaVenituri.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.idBugetNou) {
                    Intent intent = new Intent(Dashboard.this, BugetNou.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }

        });
    }


}