package com.example.farmacumplido.clases;

import android.graphics.Bitmap;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class Proveedor implements Serializable {

    private int idproveedor;
    private String nombreProveedor;
    private Bitmap foto;

    //--------------------------

    public Proveedor(int idproveedor, String nombreProveedor, Bitmap foto) {
        this.idproveedor = idproveedor;
        this.nombreProveedor = nombreProveedor;
        this.foto = foto;
    }
    public Proveedor(int idproveedor, String nombreProveedor) {
        this.idproveedor = idproveedor;
        this.nombreProveedor = nombreProveedor;
        this.foto = null;
    }
    public  Proveedor(String nombreProveedor) {this.nombreProveedor = nombreProveedor;}

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    //---------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proveedor)) return false;
        Proveedor proveedor = (Proveedor) o;
        return idproveedor == proveedor.idproveedor;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(idproveedor);
    }

    @Override
    public String toString() {
        return nombreProveedor;
    }
}
