package com.example.farmacumplido;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.farmacumplido.clases.Medicamento;
import com.example.farmacumplido.clases.listaMedicamentosAdapter;
import com.example.farmacumplido.controladores.MedicamentoController;

import java.util.ArrayList;
import java.util.Collections;


public class MostrarMedicamentosActivity1 extends AppCompatActivity {

    private static final int PETICION1 = 1;
    private RecyclerView rv_medicamentos;
    private listaMedicamentosAdapter mAdapter;
    private ArrayList<Medicamento> medicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_medicamentos);
        //-----------------------------------------------------------
        medicamentos = MedicamentoController.obtenerMedicamentos();
        //fotosMedicamentos= FotoMedicamentoController.obtenerFotosMedicamentos();
        if(medicamentos != null) {
            //-------------------------------------------------------
            // Get a handle to the RecyclerView.
            rv_medicamentos = (RecyclerView) findViewById(R.id.rv_medicamentos);
            // Create an adapter and supply the data to be displayed.
            mAdapter = new listaMedicamentosAdapter(this, medicamentos); //hay que añadir fotosMedicamentos para que se vea la nueva foto
            // Connect the adapter with the RecyclerView.
            rv_medicamentos.setAdapter(mAdapter);
            // Give the RecyclerView a default layout manager.
            rv_medicamentos.setLayoutManager(new LinearLayoutManager(this));
        }
        else{
            Log.i("medicamentos", "no pude recuperar los medicamentos");
        }
        //------------------------------------------------------------
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(medicamentos, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                    mostrarToast("ha pulsado izquierda");
                    // Medicamento c = medicamentos.get(viewHolder.getAdapterPosition());
                    // MedicamentoController.borrarMedicamento(c);
                    medicamentos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    mostrarToast("ha pulsado derecha");
                    medicamentos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(rv_medicamentos);
    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PETICION1) {
            if (resultCode == RESULT_OK) {
                Medicamento c = (Medicamento) data.getSerializableExtra(NuevoMedicamentosActivity.EXTRA_OBJETO_MEDICAMENTO);
                medicamentos.add(c);
                // Notify the adapter, that the data has changed.
                rv_medicamentos.getAdapter().notifyItemInserted(medicamentos.size());
                // Scroll to the bottom.
                rv_medicamentos.smoothScrollToPosition(medicamentos.size());
            }
        }
    }

    public void nuevoMedicamento(View view) {
        Intent intent = new Intent(this, NuevoMedicamentosActivity.class);
        startActivityForResult(intent, PETICION1);
    }

    public void refrescarMedicamentos(View view) {
        medicamentos = MedicamentoController.obtenerMedicamentos();
        if(medicamentos != null) {
            mAdapter.setListaMedicamentos(medicamentos);
            rv_medicamentos.getAdapter().notifyDataSetChanged();
        }
    }

}