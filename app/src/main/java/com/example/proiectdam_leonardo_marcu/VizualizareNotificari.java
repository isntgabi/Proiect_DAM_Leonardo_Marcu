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

import com.example.proiectdam_leonardo_marcu.Clase.Notificare;
import com.example.proiectdam_leonardo_marcu.FIREBASE.Callback;
import com.example.proiectdam_leonardo_marcu.FIREBASE.FirebaseService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VizualizareNotificari extends AppCompatActivity {

    private EditText etDenumireNotificare;
    private EditText etDataNotificare;
    private FloatingActionButton fabSalveaza;
    private FloatingActionButton fabSterge;
    private ListView lvNotificari;
    private List<Notificare> notificari = new ArrayList<>();
    private FirebaseService firebaseService;
    private int indexSelectat = -1;
    private Button btnGolire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vizualizare_notificari);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firebaseService = FirebaseService.getInstance();

        etDenumireNotificare = findViewById(R.id.etDenumireNotificare);
        etDataNotificare = findViewById(R.id.etDataNotificare);
        fabSalveaza = findViewById(R.id.fabSalveazaNotificare);
        fabSterge = findViewById(R.id.fabStergeNotificare);
        lvNotificari =  findViewById(R.id.lvNotificari);
        ArrayAdapter<Notificare> adapter = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, notificari);
        lvNotificari.setAdapter(adapter);

        btnGolire = findViewById(R.id.btnGolireNotificare);

        btnGolire.setOnClickListener(view -> {
            etDenumireNotificare.setText(null);
            etDataNotificare.setText(null);
            indexSelectat = -1;
        });

        fabSterge.setOnClickListener(view -> {
            if(indexSelectat != -1) {
                firebaseService.deleteNotificare(notificari.get(indexSelectat));
            }
        });

        fabSalveaza.setOnClickListener(view -> {

                if(indexSelectat == -1) {
                    Notificare notificare = actualizareNotificareFromUI(null);
                    firebaseService.insertNotificare(notificare);
                } else {
                    Notificare notificare = actualizareNotificareFromUI(notificari.get(indexSelectat).getId());
                    firebaseService.updateNotificare(notificare);
                }

        });

        firebaseService.addNotificareListener(dataChangeCallback());

        lvNotificari.setOnItemClickListener((adapterView, view, position, l) -> {
            indexSelectat = position;
            Notificare notificare = notificari.get(position);
            etDenumireNotificare.setText(notificare.getMesaj());
            etDataNotificare.setText(notificare.getData().toString());
        });
    }

    private Callback<List<Notificare>> dataChangeCallback() {
        return result -> {
          notificari.clear();
          notificari.addAll(result);
          ArrayAdapter<Notificare> adapter1 = (ArrayAdapter<Notificare>) lvNotificari.getAdapter();
          adapter1.notifyDataSetChanged();
          etDenumireNotificare.setText(null);
          etDataNotificare.setText(null);
        };
    }

    private Notificare actualizareNotificareFromUI(String id) {
        SharedPreferences sharedPreferencesU = getSharedPreferences("local", MODE_PRIVATE);
        long utilizatorId = sharedPreferencesU.getLong("utilizatorId", -1);

        Notificare notificare = new Notificare();
        notificare.setId(id);
        notificare.setMesaj(etDenumireNotificare.getText().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date data = null;
        try {
            data = sdf.parse(etDataNotificare.getText().toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        notificare.setData(data);
        notificare.setIdUtilizator(utilizatorId);

        return notificare;

    }
}