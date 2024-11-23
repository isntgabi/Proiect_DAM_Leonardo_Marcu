package com.example.proiectdam_leonardo_marcu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proiectdam_leonardo_marcu.Clase.Cheltuiala;
import com.example.proiectdam_leonardo_marcu.Clase.Venit;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class VizualizareVenituri extends AppCompatActivity {

    private ListView lvVenituri;

    private List<Venit> venituri = new ArrayList<>();

    private ActivityResultLauncher<Intent> launcher;

    private int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vizualizare_venituri);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_venituri);

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
                Intent intent = new Intent(getApplicationContext(), Grafic.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.bottom_venituri) {
                return true;
            }

            return false;
        });

        FloatingActionButton fabAdauga = findViewById(R.id.fabAdaugaVenituri);

        lvVenituri = findViewById(R.id.lvVenituri);

        lvVenituri.setOnItemClickListener((adapterView, view, position, l) -> {
            selectedPosition = position;
            Intent intent = new Intent(getApplicationContext(), Venituri.class);
            intent.putExtra("edit", venituri.get(position));
            launcher.launch(intent);
        });
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getData().hasExtra("venitFromIntent")) {
                Intent intent = result.getData();
                Venit venit = (Venit) intent.getSerializableExtra("venitFromIntent");
                if (venit != null) {
                    venituri.add(venit);
                    VenitAdapter adapter = new VenitAdapter(getApplicationContext(), R.layout.view_venituri, venituri, getLayoutInflater());
                    lvVenituri.setAdapter(adapter);
                }
            } else if (result.getData().hasExtra("edit")) {
                Intent intent = result.getData();
                Venit venit = (Venit) intent.getSerializableExtra("edit");
                if (venit != null) {
                    Venit venitActualizat = venituri.get(selectedPosition);

                    venitActualizat.setSursaVenit(venit.getSursaVenit());
                    venitActualizat.setDenumireVenit(venit.getDenumireVenit());
                    venitActualizat.setDataVenit(venit.getDataVenit());
                    venitActualizat.setBuget(venit.getBuget());
                    venitActualizat.setSumaVenit(venit.getSumaVenit());

                    VenitAdapter adapter = (VenitAdapter) lvVenituri.getAdapter();
                    adapter.notifyDataSetChanged();
                }
            }
        });

        fabAdauga.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Venituri.class);
            launcher.launch(intent);
        });

        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        String token = sharedPreferences.getString("venituri", "default");
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
    }
}