package com.example.farmacumplido.tareas;

import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.modelos.ProveedorDB;

import java.util.concurrent.Callable;

public class TareaActualizarProveedor implements Callable<Boolean> {
    private Proveedor p;
    public TareaActualizarProveedor(Proveedor p){
        this.p=p;
    }
    @Override
    public Boolean call() throws Exception {
        boolean actualizarOK= ProveedorDB.actualizarProveedorTabla(this.p);
        return actualizarOK;
    }
}
