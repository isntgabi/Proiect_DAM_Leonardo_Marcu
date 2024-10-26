package com.example.proiectdam_leonardo_marcu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.proiectdam_leonardo_marcu.Clase.Cheltuiala;
import com.example.proiectdam_leonardo_marcu.Clase.Venit;

import java.util.ArrayList;
import java.util.List;

public class Istoric extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;

    private ListView lvLista;

    private List<Cheltuiala> listaCheltuieli = new ArrayList<>();

    private List<Venit> listaVenituri = new ArrayList<>();

    private ListView lvListaVenituri;

    private ActivityResultLauncher<Intent> launcher;

    LinearLayout dashboard, profile, budget, venituri, cheltuieli, hystoric, graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_istoric);
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
            redirectActivity(Istoric.this,Dashboard.class);
        });

        profile.setOnClickListener(view -> {
            redirectActivity(Istoric.this,Profile.class);
        });
        budget.setOnClickListener(view -> {
            redirectActivity(Istoric.this,Buget.class);
        });
        venituri.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Venituri.class);
            launcher.launch(intent);
        });
        cheltuieli.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),Cheltuieli.class);
            launcher.launch(intent);
        });
        hystoric.setOnClickListener(view -> {
            recreate();
        });
        graph.setOnClickListener(view -> {
            redirectActivity(Istoric.this,Grafic.class);
        });

        lvLista = findViewById(R.id.lvLista);
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                Cheltuiala cheltuiala = (Cheltuiala) intent.getSerializableExtra("cheltuialaFromIntent");
                if(cheltuiala != null) {
                    listaCheltuieli.add(cheltuiala);
                    ArrayAdapter<Cheltuiala> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listaCheltuieli);
                    lvLista.setAdapter(adapter);
                }
            }
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