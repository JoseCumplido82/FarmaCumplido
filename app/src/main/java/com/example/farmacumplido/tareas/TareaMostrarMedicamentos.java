package com.example.farmacumplido.tareas;

import com.example.farmacumplido.clases.Medicamento;
import com.example.farmacumplido.modelos.MedicamentoDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaMostrarMedicamentos  implements Callable<ArrayList<Medicamento>> {
    private ArrayList<Medicamento> medicamentos = null;
    @Override
    public ArrayList<Medicamento> call() throws Exception {
        medicamentos = MedicamentoDB.obtenerMedicamentos();
        return medicamentos;
    }
}