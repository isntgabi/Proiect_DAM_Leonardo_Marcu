package com.example.proiectdam_leonardo_marcu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText parola;
    Button conectare;

    TextView inregistrare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.etUsername);
        parola = findViewById(R.id.etParola);
        conectare = findViewById(R.id.btnConectare);
        inregistrare = findViewById(R.id.tvInregistrare);

        inregistrare.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Inregistrare.class);
            startActivity(intent);
        });

        conectare.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Istoric.class);
            startActivity(intent);
        });


    }
}