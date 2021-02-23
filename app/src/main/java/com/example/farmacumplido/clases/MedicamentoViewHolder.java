package com.example.farmacumplido.clases;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmacumplido.MostrarDetalleMedicamentoctivity;
import com.example.farmacumplido.R;

import java.io.ByteArrayOutputStream;

import static com.example.farmacumplido.NuevoMedicamentosActivity.EXTRA_OBJETO_MEDICAMENTO;

public class MedicamentoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txt_nombrem = null;
    public TextView txt_preciom = null;
    public TextView txt_proveedorm = null;
    public ImageView img_medicamento=null;
    public static final String EXTRA_IMAGEN_MEDICAMENTO ="IMAGEN MEDICAMENTO" ;

    final listaMedicamentosAdapter lcAdapter;

    public MedicamentoViewHolder(@NonNull View itemView, listaMedicamentosAdapter mAdapter) {
        super(itemView);
        txt_nombrem = (TextView)  itemView.findViewById(R.id.txt_nombrem);
        txt_preciom = (TextView)  itemView.findViewById(R.id.txt_preciom);
        txt_proveedorm = (TextView)  itemView.findViewById(R.id.txt_proveedorm);
        img_medicamento =(ImageView)  itemView.findViewById(R.id.img_medicamento);
        this.lcAdapter = mAdapter;
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int mPosition = getLayoutPosition();
        Medicamento medicamento = this.lcAdapter.getListaMedicamentos().get(mPosition);
        Log.i("medicamento","has seleccionado: " + medicamento.toString());
        lcAdapter.notifyDataSetChanged();
        Intent intent = new Intent(lcAdapter.getC(), MostrarDetalleMedicamentoctivity.class);
        //envio la imagen
        Medicamento m1= new Medicamento(medicamento.getNombre(), medicamento.getPrecio(), medicamento.getIdproveedor());
        intent.putExtra(EXTRA_OBJETO_MEDICAMENTO, m1);
        Bitmap fotobm = medicamento.getFoto();
            //para ver si la foto viene a null
                if(medicamento.getFoto()!=null){
                    System.out.println("hay foto");
                }else if(medicamento.getFoto()==null)
                {
                    System.out.println("no hay foto");
                }

        if(fotobm != null)
        {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            fotobm.compress(Bitmap.CompressFormat.PNG, 0, stream);
            byte[] byteArray = stream.toByteArray();
            intent.putExtra(EXTRA_IMAGEN_MEDICAMENTO, byteArray);
        }
        lcAdapter.getC().startActivity(intent);
    }
}
