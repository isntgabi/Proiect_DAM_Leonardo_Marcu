package com.example.proiectdam_leonardo_marcu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proiectdam_leonardo_marcu.Clase.BugetAdaugat;
import com.example.proiectdam_leonardo_marcu.Clase.Cheltuiala;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class VizualizareBugete extends AppCompatActivity {

    private ListView lvBugete;

    private List<BugetAdaugat> bugete = new ArrayList<>();

    private ActivityResultLauncher<Intent> launcher;

    private int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vizualizare_bugete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_buget);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.bottom_dashboard) {
                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.bottom_buget) {
                return true;
            } else if (item.getItemId() == R.id.bottom_cheltuieli) {
                Intent intent = new Intent(getApplicationContext(), VizualizareCheltuieli.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.bottom_grafic) {
                Intent intent = new Intent(getApplicationContext(), Grafic.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.bottom_venituri) {
                Intent intent = new Intent(getApplicationContext(), VizualizareVenituri.class);
                startActivity(intent);
                return true;
            }

            return false;
        });

        lvBugete = findViewById(R.id.lvBugete);
        lvBugete.setOnItemClickListener((adapterView, view, position, l) -> {
            selectedPosition = position;
            Intent intent = new Intent(getApplicationContext(), Buget.class);
            intent.putExtra("edit", bugete.get(position));
            launcher.launch(intent);
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getData().hasExtra("bugetFromIntent")) {
                Intent intent = result.getData();
                BugetAdaugat buget = (BugetAdaugat) intent.getSerializableExtra("bugetFromIntent");
                if (buget != null) {
                    bugete.add(buget);
                    //ArrayAdapter<BugetAdaugat> adapter = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bugete);
                    BugetAdapter adapter = new BugetAdapter(getApplicationContext(), R.layout.view_bugete, bugete, getLayoutInflater());
                    lvBugete.setAdapter(adapter);
                }
            } else if (result.getData().hasExtra("edit")) {
                Intent intent = result.getData();
                BugetAdaugat buget = (BugetAdaugat) intent.getSerializableExtra("edit");
                if (buget != null) {
                    BugetAdaugat bugetActualizat = bugete.get(selectedPosition);
                    bugetActualizat.setDenumireBuget(buget.getDenumireBuget());
                    bugetActualizat.setSumaBuget(buget.getSumaBuget());
                    BugetAdapter adapterA = (BugetAdapter) lvBugete.getAdapter();
                    adapterA.notifyDataSetChanged();
                }
            }
        });

        FloatingActionButton fabAdauga = findViewById(R.id.fabAdaugaBuget);
        fabAdauga.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Buget.class);
            launcher.launch(intent);
        });

        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        String token = sharedPreferences.getString("bugete", "default");
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
    }
}