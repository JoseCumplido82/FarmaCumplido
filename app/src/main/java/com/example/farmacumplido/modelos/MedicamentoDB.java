package com.example.farmacumplido.modelos;

import android.util.Log;

import com.example.farmacumplido.clases.Medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MedicamentoDB {
    //-----------------------------------------------------------
    public static ArrayList<Medicamento> obtenerMedicamentos()
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            System.out.println("no se ha podido conectar con la base datos");
            return null;
        }
        ArrayList<Medicamento> medicamentosDevueltos = new ArrayList<Medicamento>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT * from medicamento";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {

                System.out.println("llega al resultado del while pero no coge los atributos del medicamento");
                int idmedicamento= resultado.getInt("idmedicamento");
                String nombre = resultado.getString("nombre");
                double precio= resultado.getDouble("precio");
                int idproveedor= resultado.getInt("idproveedor");
                Medicamento m = new Medicamento(idmedicamento, nombre, precio, idproveedor);
                medicamentosDevueltos.add(m);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return medicamentosDevueltos;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return null;
        }
    }
    //-------------------------------------------------------
    public static boolean insertarMedicamentoTabla(Medicamento m)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "INSERT INTO medicamento (nombre, precio, idproveedor) VALUES (?, ?, ?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, m.getNombre());
            pst.setDouble(2,  m.getPrecio());
            pst.setInt(3, m.getIdproveedor());
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
    public static boolean borrarMedicamentoTabla(Medicamento m)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "DELETE FROM medicamento WHERE idmedicamento = ?;";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setInt(1, m.getIdmedicamento());
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
    //---------------------------------------------------------------
    public static boolean actualizarMedicamentoTabla(Medicamento m)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "UPDATE medicamento SET nombre = ?, precio = ?, idproveedor = ? WHERE (idmedicamento = ?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, m.getNombre());
            pst.setDouble(2, m.getPrecio());
            pst.setInt(3, m.getIdproveedor());
            pst.setInt(4, m.getIdmedicamento());
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
    public static Medicamento buscarMedicamentoTabla(String nombre)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        //---------------------------------
        Medicamento medicamentoEncontrado = null;
        try {
            String ordensql = "select * from medicamento where nombre like ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, nombre);
            ResultSet resultadosql = pst.executeQuery();
            //------------------------------------------------
            while(resultadosql.next())
            {
                int idmedicamento = resultadosql.getInt("idmedicamento");
                String nombremedicamento = resultadosql.getString("nombre");
                double precio = resultadosql.getDouble("precio");
                int idproveedor = resultadosql.getInt("idproveedor");
                medicamentoEncontrado = new Medicamento(idmedicamento,nombremedicamento, precio, idproveedor);
            }
            resultadosql.close();
            pst.close();
            conexion.close();
            return medicamentoEncontrado;
        } catch (SQLException e) {
            return null;
        }
    }


//--------------------------------------------------------------

}
