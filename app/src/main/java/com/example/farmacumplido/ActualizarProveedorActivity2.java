package com.example.farmacumplido;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.controladores.ProveedorController;

import java.util.ArrayList;

public class  ActualizarProveedorActivity2 extends AppCompatActivity {

    Proveedor pseleccionado = null;
    EditText edt_actualizar_ipd = null;
    EditText edt_actualizar_nombrep = null;
    ImageView img_proveedor =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_proveedor2);
        edt_actualizar_ipd = (EditText) findViewById(R.id.edt_actualizar_idp);
        edt_actualizar_nombrep = (EditText) findViewById(R.id.edt_actualizar_nombrep);
        img_proveedor = (ImageView)findViewById(R.id.img_proveedor);
        Intent intent = getIntent();
        if(intent != null)
        {
            pseleccionado = (Proveedor) intent.getSerializableExtra(ActualizarProveedorActivity1.EXTRA_OBJETO_PROVEEDOR);
            if(pseleccionado!=null)
            {
                edt_actualizar_ipd.setText(String.valueOf(pseleccionado.getIdproveedor()));
                edt_actualizar_ipd.setEnabled(false);
                edt_actualizar_nombrep.setText(pseleccionado.getNombreProveedor());

                Bitmap fotobm= pseleccionado.getFoto();
                if(fotobm!=null){
                    img_proveedor.setImageBitmap(fotobm);
                }

            }
        }
    }

    public void actualizarProveedor(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("actualizar el proveedor?");
        //alerta1.setMessage(" no -> cancelar, si-> actualizar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //actualizar proveedor
                int idp = Integer.valueOf(String.valueOf(edt_actualizar_ipd.getText()));
                String nombrep = String.valueOf(edt_actualizar_nombrep.getText());
                Proveedor p = new Proveedor(idp, nombrep);
                boolean actualizarOK = ProveedorController.actualizarProveedor(p);
                // recargar combo (o desde la base de datos volver a solicitar too)
                if(actualizarOK)
                {
                    ActualizarProveedorActivity1.adapter.clear();
                    ArrayList<Proveedor> proveedores = ProveedorController.obtenerProveedores();
                    ActualizarProveedorActivity1.adapter.addAll(proveedores);
                    mostrarToast("proveedor actualizado correctamente");
                }
                else{
                    mostrarToast("el proveedor no se pudo actualizar");
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

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

}