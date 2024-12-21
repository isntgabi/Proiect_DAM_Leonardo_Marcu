package com.example.proiectdam_leonardo_marcu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proiectdam_leonardo_marcu.Clase.Badge;
import com.example.proiectdam_leonardo_marcu.FIREBASE.Callback;
import com.example.proiectdam_leonardo_marcu.FIREBASE.FirebaseService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class VizualizareBadgeuri extends AppCompatActivity {

    private EditText etDenumireBadge;
    private Button btnGolire;
    private FloatingActionButton fabSalveaza;
    private FloatingActionButton fabSterge;
    private ListView lvBadges;
    private List<Badge> badges = new ArrayList<>();
    private FirebaseService firebaseService;
    private int indexSelectat = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vizualizare_badgeuri);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firebaseService = FirebaseService.getInstance();

        etDenumireBadge = findViewById(R.id.etDenumireBadge);
        fabSalveaza = findViewById(R.id.fabSalveazaBadge);
        fabSterge = findViewById(R.id.fabStergeBadge);
        lvBadges = findViewById(R.id.lvBadges);
        ArrayAdapter<Badge> adapter = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, badges);
        lvBadges.setAdapter(adapter);

        btnGolire = findViewById(R.id.btnGolireBadge);

        btnGolire.setOnClickListener(view -> {
            etDenumireBadge.setText(null);
            indexSelectat=-1;
        });

        fabSterge.setOnClickListener(view -> {
            if(indexSelectat != -1) {
                firebaseService.deleteBadge(badges.get(indexSelectat));
            }
        });

        fabSalveaza.setOnClickListener(view -> {
            if(indexSelectat==-1) {
                Badge badge = actualizareBadgeFromUI(null);
                firebaseService.insertBadge(badge);
            } else {
                Badge badge = actualizareBadgeFromUI(badges.get(indexSelectat).getId());
                firebaseService.updateBadge(badge);
            }
        });

        firebaseService.addBadgeListener(dataChangeCallback());

        lvBadges.setOnItemClickListener((adapterView, view, position,l) -> {
            indexSelectat = position;
            Badge badge = badges.get(position);
            etDenumireBadge.setText(badge.getDenumire());
        });
    }

    private Badge actualizareBadgeFromUI(String id) {
        SharedPreferences sharedPreferencesU = getSharedPreferences("local", MODE_PRIVATE);
        long utilizatorId = sharedPreferencesU.getLong("utilizatorId", -1);

        Badge badge = new Badge();
        badge.setId(id);
        badge.setDenumire(etDenumireBadge.getText().toString());
        badge.setIdUtilizator(utilizatorId);
        return badge;
    }

    private Callback<List<Badge>> dataChangeCallback() {
        return result -> {
            badges.clear();
            badges.addAll(result);
            ArrayAdapter<Badge> adapter1 = (ArrayAdapter<Badge>) lvBadges.getAdapter();
            adapter1.notifyDataSetChanged();
            etDenumireBadge.setText(null);
        };
    }

}