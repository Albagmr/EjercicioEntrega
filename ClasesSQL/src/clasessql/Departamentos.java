/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasessql;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Usuario 1 DAM
 */
public class Departamentos {

    private Connection conexion;
     ArrayList<Departamento> departamento;

    public Departamentos() {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int Create(Departamento dep) throws SQLException {
        int filas;
        String sql = "INSERT INTO departamentos VALUES (?,?,?)";
        PreparedStatement sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, dep.getNumDepartamento());
        sentencia.setString(2, dep.getNombreDpto());
        sentencia.setString(3, dep.getLoc());
        filas = sentencia.executeUpdate();
        return filas;

    }

    public Departamento Read(int jk) throws SQLException { //Nos tiene que devolver un departamento
        Departamento dep = null;
        String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, jk);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        dep = new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3));
        return dep;
    }
    public ArrayList<Departamento> ReadTodos() throws SQLException { //Nos tiene que devolver un departamento
        Departamento dep;
        departamento = new ArrayList<>();//inicializamos el arraylist
        String sql = "SELECT * FROM departamentos";
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery(sql);
        rs.first();//el result set para que no nos entre en el -1. ponemos que nos apunte al primero.
        while (rs.next()) {

            dep = new Departamento();

            dep.setNumDepartamento(rs.getInt(1));

            dep.setNombreDpto(rs.getString(2));

            dep.setLoc(rs.getString(3));

            departamento.add(dep);
        }
        return departamento;
    }

   

    public int Update(int numDepartamento, Departamento dep) throws SQLException {
        int filas;
        String sql = "UPDATE Departamento SET NombreDpto='?' WHERE dept_no ='?' loc='?'";
        PreparedStatement sentencia;

        sentencia = conexion.prepareCall(sql);
        sentencia.setInt(2, dep.getNumDepartamento());
        sentencia.setString(1, dep.getNombreDpto());
        sentencia.setString(3, dep.getLoc());
        filas = sentencia.executeUpdate();

        return filas;
    }

    public int Delete(int numDepartamento) throws SQLException {
        int filas;
        String sql = "DELETE FROM DEPARTAMENTO WHERE dept_no ='?'";
        PreparedStatement sentencia;
        sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, numDepartamento);
        filas = sentencia.executeUpdate();
        return filas;

    }

    public void close() throws SQLException {
        conexion.close();

    }

    public void listarTodos() throws SQLException {// en este arraylist voy a meter los tipos de departamentos
        ReadTodos();
    }

    public Departamento listarUno(int l) throws SQLException {//intermediario; 

        return Read(l);
    }
 public Departamento buscarUno(String NombreDpto) throws SQLException {
        Departamento dep= null;

        String sql = "SELECT * FROM departamentos WHERE dnombre = ?";
        PreparedStatement sentencia= conexion.prepareStatement(sql);
        sentencia.setString(1,NombreDpto);
        ResultSet rs = sentencia.executeQuery();
        if(rs.first())//el result set para que no nos entre en el -1. ponemos que nos apunte al primero.
        {
            dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));
     //       departamento.add(dep);
        }
        return dep;
    }
 
}
