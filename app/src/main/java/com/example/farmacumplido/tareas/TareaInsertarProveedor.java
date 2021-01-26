package com.example.farmacumplido.tareas;

import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.modelos.ProveedorDB;

import java.util.concurrent.Callable;

public class TareaInsertarProveedor implements Callable<Boolean> {
    private Proveedor p = null;

    public TareaInsertarProveedor(Proveedor p) {
        this.p = p;
    }

    @Override
    public Boolean call() throws Exception {
        boolean insertadoOK = ProveedorDB.insertarProveedorTabla(p);
        return insertadoOK;
    }
}
