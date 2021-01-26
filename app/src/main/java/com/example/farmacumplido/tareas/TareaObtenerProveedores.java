package com.example.farmacumplido.tareas;

import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.modelos.ProveedorDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerProveedores implements Callable<ArrayList<Proveedor>> {


    @Override
    public ArrayList<Proveedor> call() throws Exception {
        ArrayList<Proveedor> proveedores= ProveedorDB.obtenerProveedor();
        return proveedores;
    }
}
