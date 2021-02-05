package com.example.farmacumplido.clases;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmacumplido.MostrarDetalleMedicamentoctivity;
import com.example.farmacumplido.R;

import static com.example.farmacumplido.NuevoMedicamentosActivity.EXTRA_OBJETO_MEDICAMENTO;

public class MedicamentoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txt_nombrem = null;
    public TextView txt_preciom = null;
    public TextView txt_proveedorm = null;
    final listaMedicamentosAdapter lcAdapter;

    public MedicamentoViewHolder(@NonNull View itemView, listaMedicamentosAdapter mAdapter) {
        super(itemView);
        txt_nombrem = (TextView)  itemView.findViewById(R.id.txt_nombrem);
        txt_preciom = (TextView)  itemView.findViewById(R.id.txt_preciom);
        txt_proveedorm = (TextView)  itemView.findViewById(R.id.txt_proveedorm);
        this.lcAdapter = mAdapter;
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        // Get the position of the item that was clicked.
        Log.i("medicamentos", "al hacer click muestro la casilla");
        int mPosition = getLayoutPosition();
        // Use that to access the affected item in mWordList.
        Medicamento medicamento = this.lcAdapter.getListaMedicamentos().get(mPosition);
        // Change the word in the mWordList.
        // Log.i("ciudad","has seleccionado: " + ciudad.toString());
        //  Toast.makeText(lcAdapter.getC(), "has seleccionado: " + ciudad.toString(),Toast.LENGTH_SHORT).show();
        // Notify the adapter, that the data has changed so it can
        // update the RecyclerView to display the data.
        lcAdapter.notifyDataSetChanged();
        Intent intent = new Intent(lcAdapter.getC(), MostrarDetalleMedicamentoctivity.class);
        intent.putExtra(EXTRA_OBJETO_MEDICAMENTO, medicamento);
        lcAdapter.getC().startActivity(intent);
    }
}
