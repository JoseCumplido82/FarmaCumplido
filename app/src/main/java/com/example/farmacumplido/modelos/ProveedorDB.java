package com.example.farmacumplido.modelos;

import android.util.Log;

import com.example.farmacumplido.clases.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProveedorDB {
    //----------------------------------------------------------....
    public static boolean insertarProveedorTabla(Proveedor p)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "INSERT INTO proveedor (nombreproveedor) VALUES (?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, p.getNombreProveedor());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
    //-----------------------------------------------------------
    public static Proveedor buscarProveedorTabla(String nombre)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        //---------------------------------
        Proveedor proveedorEncontrado = null;
        try {
            ResultSet resultadosql = BaseDB.buscarFilasEnTabla(conexion, "proveedor", "nombreproveedor", nombre);
            //------------------------------------------------
            if(resultadosql == null)
            {
                return null;
            }
            while(resultadosql.next())
            {
                int idproveedor = resultadosql.getInt("idproveedor");
                String nombreproveedor = resultadosql.getString("nombreproveedor");
                proveedorEncontrado = new Proveedor(idproveedor,nombreproveedor);
            }
            resultadosql.close();
            conexion.close();
            return proveedorEncontrado;
        } catch (SQLException e) {
            return null;
        }
    }

    public static ArrayList<Proveedor> obtenerProveedor() {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        ArrayList<Proveedor> proveedorDevuelto = new ArrayList<Proveedor>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from proveedor";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {
                int idproveedor = resultado.getInt("idproveedor");
                String nombreproveedor = resultado.getString("nombreproveedor");
                Proveedor p = new Proveedor(idproveedor, nombreproveedor);
                proveedorDevuelto.add(p);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return proveedorDevuelto;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return proveedorDevuelto;
        }
    }

    public static boolean borrarProveedorTabla(Proveedor p) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "DELETE FROM proveedor WHERE nombreproveedor LIKE ?;";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, p.getNombreProveedor());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean actualizarProveedorTabla(Proveedor p) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "UPDATE proveedor SET nombreproveedor = ? WHERE idproveedor = ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, p.getNombreProveedor());
            pst.setInt(2, p.getIdproveedor());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
//--------------------------------------------------------------
}
