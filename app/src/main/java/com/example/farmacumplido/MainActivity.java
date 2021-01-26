package com.example.farmacumplido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nuevoProveedor(View view) {
        Intent intent = new Intent(this, NuevoProveedorActivity.class);
        startActivity(intent);
    }

    public void borrarProveedor(View view) {
        Intent intent = new Intent(this, BorrarProveedorActivity.class);
        startActivity(intent);
    }

    public void actualizar_proveedor1(View view) {
        Intent intent = new Intent(this, ActualizarProveedorActivity1.class);
        startActivity(intent);
    }
}