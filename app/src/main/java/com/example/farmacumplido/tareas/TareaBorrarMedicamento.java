package com.example.farmacumplido.tareas;

import com.example.farmacumplido.clases.Medicamento;
import com.example.farmacumplido.modelos.MedicamentoDB;

import java.util.concurrent.Callable;


public class TareaBorrarMedicamento implements Callable<Boolean> {
    private Medicamento c = null;

    public TareaBorrarMedicamento(Medicamento c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        boolean borradoOK = MedicamentoDB.borrarMedicamentoTabla(c) ;
        return borradoOK;
    }
}