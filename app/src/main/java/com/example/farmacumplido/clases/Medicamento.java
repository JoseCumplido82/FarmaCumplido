package com.example.farmacumplido.clases;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Medicamento implements Serializable {
    private int idmedicamento;
    private String nombre;
    private double precio;
    private int idproveedor;
    private Bitmap foto;

    public Medicamento(int idmedicamento, String nombre, double precio, int idproveedor) {
        this.idmedicamento = idmedicamento;
        this.nombre = nombre;
        this.precio = precio;
        this.idproveedor = idproveedor;
        this.foto=null;
    }

    public Medicamento(int idmedicamento, String nombre, double precio, int idproveedor, Bitmap foto) {
        this.idmedicamento = idmedicamento;
        this.nombre = nombre;
        this.precio = precio;
        this.idproveedor = idproveedor;
        this.foto =foto;
    }
    public Medicamento() {
        this.idmedicamento = 0;
        this.nombre = "";
        this.precio = 0.0;
        this.idproveedor = 1;
        this.foto=null;
    }

    public Medicamento(String nombre, double precio, int idproveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.idproveedor = idproveedor;
        this.foto=null;
    }
//----------------------
    public int getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(int idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }
    //--------------------

    @Override
    public String toString() {
        return "Medicamento{" +
                "idmedicamento=" + idmedicamento +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", idproveedor=" + idproveedor +
                '}';
    }
}
