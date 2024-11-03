package com.example.proiectdam_leonardo_marcu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proiectdam_leonardo_marcu.Clase.Cheltuiala;

import java.text.SimpleDateFormat;
import java.util.List;

public class CheltuialaAdapter extends ArrayAdapter<Cheltuiala> {
    private Context context;
    private int layoutId;
    private List<Cheltuiala> cheltuieli;
    private LayoutInflater layoutInflater;

    public CheltuialaAdapter(@NonNull Context context, int layoutId, @NonNull List<Cheltuiala> cheltuieli, LayoutInflater layoutInflater) {
        super(context, layoutId, cheltuieli);
        this.context = context;
        this.layoutId = layoutId;
        this.cheltuieli = cheltuieli;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = layoutInflater.inflate(layoutId, parent, false);
        Cheltuiala cheltuiala = cheltuieli.get(position);

        TextView tvSursa = view.findViewById(R.id.tvSursaC);
        TextView tvDenumire = view.findViewById(R.id.tvDenumireaC);
        TextView tvSuma = view.findViewById(R.id.tvSumaC);
        TextView tvData = view.findViewById(R.id.tvDataC);
        TextView tvBuget = view.findViewById(R.id.tvBugetC);

        tvSursa.setText(cheltuiala.getSursaCheltuiala());
        tvDenumire.setText(cheltuiala.getSursaCheltuiala());
        tvSuma.setText(String.valueOf(cheltuiala.getSursaCheltuiala()));
        tvData.setText(new SimpleDateFormat("dd.MM.yyyy").format(cheltuiala.getSursaCheltuiala()));
        tvBuget.setText(String.valueOf(cheltuiala.getSursaCheltuiala()));

        return view;
    }
}
