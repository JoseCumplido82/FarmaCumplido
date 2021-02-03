package com.example.farmacumplido.tareas;

import com.example.farmacumplido.clases.Medicamento;
import com.example.farmacumplido.modelos.MedicamentoDB;

import java.util.concurrent.Callable;


public class TareaInsertarMedicamento implements Callable<Boolean> {
    private Medicamento c = null;

    public TareaInsertarMedicamento(Medicamento c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        boolean insertadoOK = MedicamentoDB.insertarMedicamentoTabla(c);
        return insertadoOK;
    }
}