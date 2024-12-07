package com.example.proiectdam_leonardo_marcu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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
import com.example.proiectdam_leonardo_marcu.Databases.AplicatieDB;
import com.example.proiectdam_leonardo_marcu.JSON.CheltuialaParser;
import com.example.proiectdam_leonardo_marcu.JSON.HttpsManager;
import com.example.proiectdam_leonardo_marcu.JSON.VenitParser;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class VizualizareCheltuieli extends AppCompatActivity {

    private ListView lvCheltuieli;

    private List<Cheltuiala> cheltuieli = new ArrayList<>();

    private ActivityResultLauncher<Intent> launcher;

    private int selectedPosition;

    private CheltuialaAdapter adapter;

    private static final String url = "https://www.jsonkeeper.com/b/AQXF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vizualizare_cheltuieli);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_cheltuieli);

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

        lvCheltuieli = findViewById(R.id.lvCheltuieli);

        SharedPreferences shp = getSharedPreferences("local", MODE_PRIVATE);
        long utilizatorId = shp.getLong("utilizatorId", -1);

        lvCheltuieli.setOnItemClickListener((adapterView, view, position, l) -> {
            selectedPosition = position;
            Intent intent = new Intent(getApplicationContext(), Cheltuieli.class);
            intent.putExtra("edit", cheltuieli.get(position));
            launcher.launch(intent);
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getData().hasExtra("cheltuialaFromIntent")) {
                Intent intent = result.getData();
                Cheltuiala cheltuiala = (Cheltuiala) intent.getSerializableExtra("cheltuialaFromIntent");
                if (cheltuiala != null) {
                    //cheltuieli.add(cheltuiala);
                    AplicatieDB.getInstance(getApplicationContext()).getCheltuialaDAO().insertCheltuiala(cheltuiala);
                    cheltuieli.clear();
                    cheltuieli.addAll(AplicatieDB.getInstance(getApplicationContext()).getCheltuialaDAO().getCheltuieli(utilizatorId));
                    adapter.notifyDataSetChanged();
                }
            } else if (result.getData().hasExtra("edit")) {
                Intent intent = result.getData();
                Cheltuiala cheltuiala = (Cheltuiala) intent.getSerializableExtra("edit");
                if (cheltuiala != null) {
                    Cheltuiala cheltuialaActualizata = cheltuieli.get(selectedPosition);

                    cheltuialaActualizata.setSursaCheltuiala(cheltuiala.getSursaCheltuiala());
                    cheltuialaActualizata.setDenumireCheltuiala(cheltuiala.getDenumireCheltuiala());
                    cheltuialaActualizata.setDataCheltuiala(cheltuiala.getDataCheltuiala());
                    cheltuialaActualizata.setBugetId(cheltuiala.getBugetId());
                    cheltuialaActualizata.setSumaCheltuiala(cheltuiala.getSumaCheltuiala());

                    CheltuialaAdapter adapter = (CheltuialaAdapter) lvCheltuieli.getAdapter();
                    adapter.notifyDataSetChanged();
                }
            }
        });

        List<BugetAdaugat> bugete = AplicatieDB.getInstance(getApplicationContext()).getBugetDAO().getBugete(utilizatorId);

        adapter = new CheltuialaAdapter(getApplicationContext(), R.layout.view_cheltuieli, cheltuieli, getLayoutInflater(), bugete);
        lvCheltuieli.setAdapter(adapter);

        FloatingActionButton fabAdauga = findViewById(R.id.fabAdaugaCheltuieli);
        fabAdauga.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Cheltuieli.class);
            launcher.launch(intent);
        });

        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        String token = sharedPreferences.getString("cheltuieli", "default");
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();

        Retea();
    }

    private void Retea() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                HttpsManager manager = new HttpsManager(url);
                String json = manager.procesare();
                new Handler(getMainLooper()).post(() -> {
                    getCheltuieli(json);
                });
            }
        };
        thread.start();
    }

    private void getCheltuieli(String json) {
        cheltuieli.addAll(CheltuialaParser.parsareJson(json));
        adapter.notifyDataSetChanged();
    }
}