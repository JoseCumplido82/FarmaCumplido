package com.example.farmacumplido.tareas;

import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.modelos.ProveedorDB;

import java.util.concurrent.Callable;

public class TareaBorrarProveedor implements Callable<Boolean> {
    private Proveedor p = null;

    public TareaBorrarProveedor(Proveedor p) {
        this.p = p;
    }

    @Override
    public Boolean call() throws Exception {
        boolean borradoOK = ProveedorDB.borrarProveedorTabla(p);
        return borradoOK;
    }
}
