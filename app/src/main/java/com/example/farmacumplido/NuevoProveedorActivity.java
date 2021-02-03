package com.example.farmacumplido;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.controladores.ProveedorController;

public class NuevoProveedorActivity extends AppCompatActivity {

    EditText edt_nombrep = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_proveedor);
        edt_nombrep = findViewById(R.id.edt_nombrep);
    }

    public void insertarProveedor(View view) {
        String nombrep = String.valueOf(edt_nombrep.getText());
        if(nombrep.isEmpty())
        {
            edt_nombrep.setError("escribe algo en el nombre del proveedor");
            return;
        }
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("guardar el proveedor?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Proveedor p = new Proveedor(nombrep);
                boolean insercionOK = ProveedorController.insertarProveedor(p);
                mostrarToast(insercionOK);
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();
    }

    public void mostrarToast(boolean insercionOK)
    {
        if(insercionOK)
        {
            Toast.makeText(this,"proveedor guardado correctamente", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"No se pudo guardar el proveedor", Toast.LENGTH_SHORT).show();
        }
    }
}