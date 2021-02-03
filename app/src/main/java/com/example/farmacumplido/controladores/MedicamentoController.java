package com.example.farmacumplido.controladores;

import android.widget.TextView;

import com.example.farmacumplido.clases.Medicamento;
import com.example.farmacumplido.tareas.TareaBorrarMedicamento;
import com.example.farmacumplido.tareas.TareaInsertarMedicamento;
import com.example.farmacumplido.tareas.TareaMostrarMedicamentos;
import com.example.farmacumplido.tareas.TareaObtenerMedicamentos;

import java.util.ArrayList;
        import java.util.concurrent.ExecutionException;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import java.util.concurrent.FutureTask;
        import java.util.concurrent.TimeUnit;

public class MedicamentoController {

    public static ArrayList<Medicamento> obtenerMedicamentos()
    {
        ArrayList<Medicamento> medicamentosDevueltos = null;
        FutureTask t = new FutureTask (new TareaObtenerMedicamentos());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            medicamentosDevueltos= (ArrayList<Medicamento>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
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
        return medicamentosDevueltos;
    }
    //---------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    public static void MostrarMedicamentos(TextView txt_medicamentos)
    {
        FutureTask t = new FutureTask (new TareaMostrarMedicamentos());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            ArrayList<Medicamento> medicamentosDevueltos= (ArrayList<Medicamento>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
            String texto_medicamentos ="MEDICAMENTOS \n";
            if(medicamentosDevueltos != null) {
                for (Medicamento c : medicamentosDevueltos) {
                    texto_medicamentos += c.toString() + "\n";
                }
                txt_medicamentos.setText(texto_medicamentos);

            }
            else {
                txt_medicamentos.setText("no se recuperaron los medicamentos");
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------
    public static boolean InsertarMedicamento(Medicamento c)
    {
        FutureTask t = new FutureTask(new TareaInsertarMedicamento(c));
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

    public static boolean borrarMedicamento(Medicamento cseleccionado) {
        FutureTask t = new FutureTask(new TareaBorrarMedicamento(cseleccionado));
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
    //---------------------------------------------------------------------------


}
