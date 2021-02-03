package com.example.farmacumplido.tareas;

import com.example.farmacumplido.clases.Medicamento;
import com.example.farmacumplido.controladores.MedicamentoController;
import com.example.farmacumplido.modelos.MedicamentoDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerMedicamentos implements Callable<ArrayList<Medicamento>> {
    @Override
    public ArrayList<Medicamento> call() throws Exception {
        ArrayList<Medicamento> medicamentos = MedicamentoDB.obtenerMedicamentos();
        return medicamentos;
    }
}