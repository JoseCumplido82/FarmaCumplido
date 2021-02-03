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
    Proveedor pseleccionado=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_proveedor1);
        sp_actualizarp = (Spinner) findViewById(R.id.sp_actualizarp);
        //------------------------------
        proveedores = ProveedorController.obtenerProveedores();
        sp_actualizarp.setOnItemSelectedListener(this);
        // creamos el adaptador
        if(proveedores!=null) {
            adapter = new ArrayAdapter<Proveedor>(this, R.layout.support_simple_spinner_dropdown_item, proveedores);
            sp_actualizarp.setAdapter(adapter);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(proveedores!=null){
            pseleccionado = (Proveedor) sp_actualizarp.getItemAtPosition(position);
            Toast.makeText(this, "has elegido el proveedor " + pseleccionado.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void enviarProveedorActivity2(View view){
        if(pseleccionado == null){
            Toast.makeText(this, "debes seleccionar un proveedor", Toast.LENGTH_SHORT).show();
            return;
        }else{
            //si llego aqui tengo provincia
            Intent intent = new Intent(this, ActualizarProveedorActivity2.class);
            intent.putExtra(EXTRA_OBJETO_PROVEEDOR, pseleccionado);
            startActivity(intent);
        }
    }
}
