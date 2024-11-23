package com.example.proiectdam_leonardo_marcu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proiectdam_leonardo_marcu.Clase.BugetAdaugat;
import com.example.proiectdam_leonardo_marcu.Clase.Cheltuiala;

import java.util.List;

public class BugetAdapter extends ArrayAdapter<BugetAdaugat> {

    private Context context;
    private int layoutId;
    private List<BugetAdaugat> bugete;
    private LayoutInflater layoutInflater;

    public BugetAdapter(@NonNull Context context, int layoutId, @NonNull List<BugetAdaugat> bugete, LayoutInflater layoutInflater) {
        super(context, layoutId, bugete);
        this.context = context;
        this.layoutId = layoutId;
        this.bugete = bugete;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = layoutInflater.inflate(layoutId, parent, false);
        BugetAdaugat buget = bugete.get(position);

        TextView tvDenumire = view.findViewById(R.id.tvDenumireBugetB);
        TextView tvSuma = view.findViewById(R.id.tvSumaBuget);

        tvDenumire.setText(buget.getDenumireBuget());
        tvSuma.setText(String.valueOf(buget.getSumaBuget()));

        return view;
    }
}
