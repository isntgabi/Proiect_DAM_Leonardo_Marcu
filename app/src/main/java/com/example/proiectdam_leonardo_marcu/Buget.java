package com.example.proiectdam_leonardo_marcu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proiectdam_leonardo_marcu.Clase.BugetAdaugat;
import com.example.proiectdam_leonardo_marcu.Databases.AplicatieDB;

public class Buget extends AppCompatActivity {

    private boolean isEditing = false;

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

        EditText denumireBuget;
        EditText sumaBuget;
        Button salvareBuget;

        denumireBuget = findViewById(R.id.etDenumireBuget);
        sumaBuget = findViewById(R.id.etSumaBuget);
        salvareBuget = findViewById(R.id.btnAdaugareBuget);

        Intent editIntent = getIntent();
        if(editIntent.hasExtra("edit")) {
            isEditing = true;
            BugetAdaugat buget = (BugetAdaugat) editIntent.getSerializableExtra("edit");

            denumireBuget.setText(buget.getDenumireBuget());
            sumaBuget.setText(String.valueOf(buget.getSumaBuget()));
        }

       salvareBuget.setOnClickListener(view -> {
           String denumire = denumireBuget.getText().toString();
           double suma = Double.parseDouble(sumaBuget.getText().toString());

           SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
           long utilizatorId = sharedPreferences.getLong("utilizatorId", -1);

           BugetAdaugat bugetNou = new BugetAdaugat(denumire, suma, utilizatorId);

           // Inserez in baza de date
           AplicatieDB.getInstance(this).getBugetDAO().insertBuget(bugetNou);

           Intent intent = getIntent();
           if(isEditing) {
               intent.putExtra("edit", bugetNou);
               isEditing=false;
           } else {
               intent.putExtra("bugetFromIntent", bugetNou);
           }setResult(RESULT_OK, intent);
           finish();

           Toast.makeText(this, "Bugetul a fost salvat cu succes!", Toast.LENGTH_SHORT).show();

//           denumireBuget.setText("");
//           sumaBuget.setText("");
       });


    }



}