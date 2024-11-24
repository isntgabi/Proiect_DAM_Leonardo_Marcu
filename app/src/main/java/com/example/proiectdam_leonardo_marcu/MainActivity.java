package com.example.proiectdam_leonardo_marcu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proiectdam_leonardo_marcu.Clase.Utilizator;
import com.example.proiectdam_leonardo_marcu.Databases.UtilizatorDB;

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

        UtilizatorDB dbInstance = UtilizatorDB.getInstance(getApplicationContext());

        conectare.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = parola.getText().toString();
            if(dbInstance.getUtilizatorDAO().login(user,pass))
            {

                //pentru a transmite id-ul intre clase corespunzator
                Utilizator utilizator = dbInstance.getUtilizatorDAO().getUtilizator(user,pass);
                SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putLong("utilizatorId", utilizator.getId()); // Salvare ID utilizator
                editor.apply();


                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Acest utilizator nu exista!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}