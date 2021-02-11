package com.example.farmacumplido;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.controladores.ProveedorController;

import java.util.ArrayList;

public class ActualizarProveedorActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public static final String EXTRA_OBJETO_PROVEEDOR = "objetoProveedor" ;
    Spinner sp_actualizarp =null;
    ArrayList<Proveedor> proveedores =null;
    public static ArrayAdapter<Proveedor> adapter =null;
    static Proveedor pseleccionado=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_proveedor1);
        sp_actualizarp = (Spinner) findViewById(R.id.sp_actualizarp);
        if(sp_actualizarp!=null){
            sp_actualizarp.setOnItemSelectedListener(this);
            proveedores=ProveedorController.obtenerProveedores();
            for(Proveedor p : proveedores){
                System.out.println(p.toString());
            }
           if(proveedores!=null){
                adapter = new ArrayAdapter<Proveedor>(this, R.layout.item_proveedor, proveedores);
              sp_actualizarp.setAdapter(adapter);
           }
        }

    }

    public void siguienteactualizarProveedor(View view) {
        Intent intent = new Intent(this, ActualizarProveedorActivity2.class);
        intent.putExtra(EXTRA_OBJETO_PROVEEDOR, pseleccionado);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Proveedor p = (Proveedor) sp_actualizarp.getItemAtPosition(position);
        pseleccionado = p;
        }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
