package com.example.farmacumplido.controladores;

import com.example.farmacumplido.clases.Medicamento;
import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.tareas.TareaActualizarProveedor;
import com.example.farmacumplido.tareas.TareaBorrarProveedor;
import com.example.farmacumplido.tareas.TareaInsertarProveedor;
import com.example.farmacumplido.tareas.TareaObtenerProveedores;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ProveedorController {
    public static boolean insertarProveedor(Proveedor p){
        FutureTask t = new FutureTask(new TareaInsertarProveedor(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }

    public static ArrayList<Proveedor> obtenerProveedores() {
        ArrayList<Proveedor> proveedoresDevueltos = null;
        FutureTask t = new FutureTask (new TareaObtenerProveedores());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            proveedoresDevueltos= (ArrayList<Proveedor>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return proveedoresDevueltos;
    }

    public static boolean borrarProveedor(Proveedor p)
    {
        FutureTask t = new FutureTask(new TareaBorrarProveedor(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }

    public static boolean actualizarProveedor(Proveedor p) {
        FutureTask t = new FutureTask(new TareaActualizarProveedor(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try {
            actualizadoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return actualizadoOK;
        }
    }
}
