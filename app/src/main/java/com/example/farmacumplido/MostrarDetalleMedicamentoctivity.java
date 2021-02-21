package com.example.farmacumplido;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.farmacumplido.clases.Medicamento;

public class MostrarDetalleMedicamentoctivity extends AppCompatActivity {

    TextView txt_detalle_nombrem = null;
    TextView txt_detalle_precio = null;
    TextView txt_detalle_idproveedor = null;
    ImageView img_detalle_medicamento=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalle_medicamento);
        txt_detalle_nombrem = findViewById(R.id.txt_detalle_nombrem);
        txt_detalle_precio = findViewById(R.id.txt_detalle_precio);
        txt_detalle_idproveedor = findViewById(R.id.txt_detalle_idproveedor);
        img_detalle_medicamento = findViewById(R.id.img_medicamento);
        Intent intent = getIntent();
        if(intent != null)
        {
            Medicamento c = (Medicamento) intent.getSerializableExtra(NuevoMedicamentosActivity.EXTRA_OBJETO_MEDICAMENTO);
            txt_detalle_nombrem.setText(c.getNombre());
            txt_detalle_precio.setText("precio: " + String.valueOf(c.getPrecio()));
            txt_detalle_idproveedor.setText("idproveedor: " + String.valueOf(c.getIdproveedor()));
        }
    }
}