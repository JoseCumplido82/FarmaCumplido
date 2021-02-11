package com.example.farmacumplido;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.controladores.ProveedorController;

import java.util.ArrayList;

public class BorrarProveedorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sp_borrarp = null;
    Proveedor pseleccionado = null;
    ArrayAdapter<Proveedor> adapter = null;
    ArrayList<Proveedor> proveedores = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_proveedor);
        sp_borrarp = (Spinner) findViewById(R.id.sp_borrarp);
        if(sp_borrarp != null) {
            sp_borrarp.setOnItemSelectedListener(this);
            proveedores = ProveedorController.obtenerProveedores();
            if(proveedores != null) {
                adapter = new ArrayAdapter<Proveedor>(this, R.layout.item_proveedor, proveedores);
                sp_borrarp.setAdapter(adapter);
            }
        }
    }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void borrarProveedor(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("borrar el proveedor?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(pseleccionado == null)
                {
                    mostrarToast("selecciona un proveedor");
                    return;
                }
                //borrar proveedor
                boolean borradoOK = ProveedorController.borrarProveedor(pseleccionado);
                // recargar combo (o desde la base de datos volver a solicitar todo, o quitar solamente el item borrado)
                if(borradoOK)
                {
                    mostrarToast("proveedor borrado correctamente");
                    // opcion 1, leemos todas los proveedores de la base de datos otra vez
                    adapter.clear();
                    proveedores = ProveedorController.obtenerProveedores();
                    adapter.addAll(proveedores);
                    //  adapter.add(new Proveedor("proveedor3"));
                    // opcion 2, borramos del adaptador el proveedor borrada
                    //  adapter.remove(pseleccionado);
                }
                else{
                    mostrarToast("el proveedor no se pudo borrar");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Proveedor p = (Proveedor) sp_borrarp.getItemAtPosition(position);
        pseleccionado = p;
        //  Toast.makeText(this, p.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}