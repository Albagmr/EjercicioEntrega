/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasessql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author Usuario 1 DAM
 */
/*
Hacer también los metodos: CREATE-READ-UPDATE-DELETE
 */
public class Empleados {

    private Connection conexion;
    ArrayList<Empleado> empleados;

    public Empleados() {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int create(Empleado emp) throws SQLException {
        int filas;
        String sql = "INSERT INTO empleados VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, emp.getNumEmpleado());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDirector());
        sentencia.setDate(5, emp.getFechaAlt());
        sentencia.setFloat(6, emp.getSalario());
        sentencia.setFloat(7, emp.getComision());
        sentencia.setInt(8, emp.getNumeroDepartamento());
        filas = sentencia.executeUpdate();
        return filas;

    }

    public Empleado Read(int numEmpleado) throws SQLException {
        Empleado emp = null;
        String sql = "SELECT emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no WHERE emp_no=? ";
        PreparedStatement sent = conexion.prepareCall(sql);
        sent.setInt(1, numEmpleado);
        Statement sentencia = conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs = sentencia.getResultSet();
        while (rs.next()) {
            emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7), rs.getInt(8));

            
        }
        return emp;
    }
    public ArrayList<Empleado> ReadTodos() throws SQLException { //Nos tiene que devolver un departamento
        Empleado emp;
        empleados = new ArrayList<>();//inicializamos el arraylist
        String sql = "SELECT * FROM empleados";
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery(sql);
        rs.first();//el result set para que no nos entre en el -1. ponemos que nos apunte al primero.
        while (rs.next()) {

            emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7), rs.getInt(8));
        }
        return empleados;
    }
    public int update (int numEmpleado, Empleado emp) throws SQLException{
        int filas;
        String sql= "UPDATE Empleado SET emp_no='?' WHERE apellido='?' oficio='?' dir='?' fecha_alt='?' salario='?' comision='?' dept_no='?'";
        PreparedStatement sentencia;
        sentencia= conexion.prepareCall(sql);
        sentencia.setInt(1, emp.getNumEmpleado());
        sentencia.setString(2,emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDirector());
        sentencia.setDate(5, emp.getFechaAlt());
        sentencia.setFloat(6, emp.getSalario());
        sentencia.setFloat (7, emp.getComision());
        sentencia.setInt(8, emp.getNumeroDepartamento());
        filas=sentencia.executeUpdate();
        return filas;  
    }
    public int Delete(int numEmpleado) throws SQLException{
        int filas;
        String sql="DELETE FROM Empleado WHERE emp_no='?'";
        PreparedStatement sentencia;
        sentencia= conexion.prepareCall(sql);
        sentencia.setInt(1, numEmpleado);
        filas=sentencia.executeUpdate();
        return filas;
    }
    public void close()throws SQLException{
        conexion.close();
    }
     public Empleado buscarUno(String Apellido) throws SQLException {
        Empleado emp= null;

        String sql = "SELECT * FROM departamentos WHERE apellido = ?";
        PreparedStatement sentencia= conexion.prepareStatement(sql);
        sentencia.setString(1,Apellido);
        ResultSet rs = sentencia.executeQuery();
        if(rs.first())//el result set para que no nos entre en el -1. ponemos que nos apunte al primero.
        {
            emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7), rs.getInt(8));
     
        }
        return emp;
    }
 
}
