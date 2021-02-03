package com.example.farmacumplido;
import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

import com.example.farmacumplido.clases.Medicamento;
import com.example.farmacumplido.clases.Proveedor;
import com.example.farmacumplido.controladores.MedicamentoController;
import com.example.farmacumplido.controladores.ProveedorController;

import java.util.ArrayList;


public class NuevoMedicamentosActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_MEDICAMENTO = "medicamento";
    Spinner sp_nuevom_proveedor = null;
    Proveedor pseleccionado = null;
    ArrayAdapter<Proveedor> adapter = null;
    ArrayList<Proveedor> proveedores = null;
    EditText edt_nuevom_nombre = null;
    EditText edt_nuevom_precio = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_medicamento);
        edt_nuevom_nombre = findViewById(R.id.edt_nuevom_nombre);
        edt_nuevom_precio = findViewById(R.id.edt_nuevom_precio);
        sp_nuevom_proveedor = (Spinner) findViewById(R.id.sp_nuevom_proveedor);
        if(sp_nuevom_proveedor != null) {
            sp_nuevom_proveedor.setOnItemSelectedListener(this);
            proveedores = ProveedorController.obtenerProveedores();
            if(proveedores != null) {
                adapter = new ArrayAdapter<Proveedor>(this, R.layout.item_proveedor, proveedores);
                sp_nuevom_proveedor.setAdapter(adapter);
            }
        }
    }
    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void insertarMedicamento(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("quieres guardar el medicamento?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(pseleccionado == null)
                {
                    mostrarToast("selecciona un proveedor");
                    return;
                }
                Medicamento c = null;
                try{
                    String nombre = String.valueOf(edt_nuevom_nombre.getText());
                    double precio = Double.valueOf(String.valueOf(edt_nuevom_precio.getText()));
                    c = new Medicamento(nombre, precio, pseleccionado.getIdproveedor());

                }catch (Exception e)
                {
                    mostrarToast("error, revisa los datos introducidos");
                }
                //insertar Ciudad
                boolean insertadoOK = MedicamentoController.InsertarMedicamento(c);
                if(insertadoOK)
                {
                    mostrarToast("medicamento insertado correctamente");
                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_OBJETO_MEDICAMENTO, c);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    mostrarToast("no se pudo crear el medicamento");
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
        Proveedor p = (Proveedor) sp_nuevom_proveedor.getItemAtPosition(position);
        pseleccionado = p;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}