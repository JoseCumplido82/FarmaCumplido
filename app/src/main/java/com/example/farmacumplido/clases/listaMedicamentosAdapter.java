package com.example.farmacumplido.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmacumplido.R;

import java.util.ArrayList;

public class listaMedicamentosAdapter extends RecyclerView.Adapter<MedicamentoViewHolder> {

    private Context c;
    private ArrayList<Medicamento> listaMedicamentos;
    private LayoutInflater mInflater;

    public listaMedicamentosAdapter(Context c, ArrayList<Medicamento> listaMedicamentos) {
        this.c = c;
        this.listaMedicamentos = listaMedicamentos;
        mInflater = LayoutInflater.from(c);
    }

    public LayoutInflater getmInflater() {
        return mInflater;
    }

    public void setmInflater(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    @NonNull
    @Override
    public MedicamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_medicamento, parent, false);
        return new MedicamentoViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicamentoViewHolder holder, int position) {
        Medicamento medicamentoActual = listaMedicamentos.get(position);
        holder.txt_nombrem.setText("medicamento: " + medicamentoActual.getNombre());
        holder.txt_preciom.setText(String.valueOf("precio: " + medicamentoActual.getPrecio()));
        holder.txt_proveedorm.setText(String.valueOf("idproveedor: " + medicamentoActual.getIdproveedor()));
    }

    @Override
    public int getItemCount() {
        return listaMedicamentos.size();
    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public ArrayList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(ArrayList<Medicamento> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }
}