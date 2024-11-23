package com.example.proiectdam_leonardo_marcu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proiectdam_leonardo_marcu.Clase.Venit;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class VenitAdapter extends ArrayAdapter<Venit> {

    private Context context;
    private int layoutId;
    private List<Venit> venituri;

    private LayoutInflater layoutInflater;

    public VenitAdapter(@NonNull Context context, int layoutId, List<Venit> venituri, LayoutInflater layoutInflater) {
        super(context, layoutId, venituri);
        this.context = context;
        this.layoutId = layoutId;
        this.venituri = venituri;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = layoutInflater.inflate(layoutId, parent, false);
        Venit venit = venituri.get(position);

        TextView tvSursa = view.findViewById(R.id.tvSursaV);
        TextView tvDenumire = view.findViewById(R.id.tvDenumireaV);
        TextView tvSuma = view.findViewById(R.id.tvSumaV);
        TextView tvData = view.findViewById(R.id.tvDataV);
        TextView tvBuget = view.findViewById(R.id.tvBugetV);

        tvSursa.setText(venit.getSursaVenit());
        tvDenumire.setText(venit.getDenumireVenit());
        tvSuma.setText(String.valueOf(venit.getSumaVenit()));
        tvData.setText(new SimpleDateFormat("dd MMMM yyyy", Locale.forLanguageTag("ro")).format(venit.getDataVenit()));
        tvBuget.setText(String.valueOf(venit.getBuget()));

        return view;
    }
}
