package com.example.farmacumplido.clases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class Proveedor implements Serializable {

    private int idproveedor;
    private String nombreProveedor;

    //--------------------------

    public Proveedor(int idproveedor, String nombreProveedor) {
        this.idproveedor = idproveedor;
        this.nombreProveedor = nombreProveedor;
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
        return "Proveedor{" +
                "idproveedor=" + idproveedor +
                ", nombreProveedor='" + nombreProveedor + '\'' +
                '}';
    }
}
