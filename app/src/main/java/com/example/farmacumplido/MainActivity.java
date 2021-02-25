package com.example.farmacumplido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

    public void actualizarProveedor(View view) {
        Intent intent = new Intent(this, ActualizarProveedorActivity1.class);
        startActivity(intent);
    }

    public void mostrar_medicamentos(View view) {
        Intent intent = new Intent(this, MostrarMedicamentosActivity1.class);
        startActivity(intent);
    }

    public void mostrarFarmacia(View view) {
        String direccionmapa = "Calle Seseña Nuevo, 21, 45223 Seseña, Toledo";
        Uri url = Uri.parse("geo:0,0?q=" + direccionmapa);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}