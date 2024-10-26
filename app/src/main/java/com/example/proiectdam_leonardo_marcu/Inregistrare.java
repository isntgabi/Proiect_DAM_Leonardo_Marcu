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

public class Inregistrare extends AppCompatActivity {

    EditText username;
    EditText email;
    EditText parola;
    Button inregistrare;
    TextView conectare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inregistrare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.etUsername2);
        email = findViewById(R.id.etEmail);
        parola = findViewById(R.id.etParola2);
        inregistrare = findViewById(R.id.btnInregistrare);
        conectare = findViewById(R.id.tvConnect);

        conectare.setOnClickListener(view -> {
            Intent intent = new Intent(Inregistrare.this, MainActivity.class);
            startActivity(intent);
        });
    }
}