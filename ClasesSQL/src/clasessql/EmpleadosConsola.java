/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasessql;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Usuario 1 DAM
 */
public class EmpleadosConsola {

    Scanner sc = new Scanner(System.in);
    Empleados emp = new Empleados();

    public void listado() throws SQLException {
        Empleado empl = new Empleado();
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println("°     Listado Empleados         °");
        System.out.println("°~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~°");
        System.out.println("    1~ Listado completo         °");
        System.out.println("    2~ Buscar uno               °");
        System.out.println("    0~ Volver al inicio         °");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                emp.ReadTodos();
                System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °  ");
                System.out.printf("|%-15s |%-15s |%-15s |\t%15s| |%-20s| |%-10s| |%-10s| |%-10s| %n", "Numero Empleado", "Apellido", "Oficio", "Director", "Fecha contratación", "Salario", "Comision", "Num.dpto");
                System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");

                for (int i = 0; i < emp.empleados.size(); i++) {
                    empl = emp.empleados.get(i);
                    System.out.println(empl.getNumEmpleado() + " " + empl.getApellido() + " " + empl.getOficio() + " " + empl.getDirector() + " " + empl.getFechaAlt() + " " + empl.getSalario() + " " + empl.getComision() + " " + empl.getNumeroDepartamento());

                }
                System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");

                break;
            case 2:
                empl = emp.Read(Integer.parseInt(sc.nextLine()));
                System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °  ");
                System.out.printf("|%-15s |%-15s |%-15s |\t%15s| |%-20s| |%-10s| |%-10s| |%-10s| %n", "Numero Empleado", "Apellido", "Oficio", "Director", "Fecha contratación", "Salario", "Comision", "Num.dpto");
                System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");

                System.out.printf("|%-15s |%-15s |%-15s |\t%15s| |%-20s| |%-10s| |%-10s| |%-10s| %n", empl.getNumEmpleado(), empl.getApellido(), empl.getOficio(), empl.getDirector(), empl.getFechaAlt(), empl.getSalario(), empl.getComision(), empl.getNumeroDepartamento());
                System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");

                break;

        }
    }

    public void buscarUno() throws SQLException {
        Empleados emp = new Empleados();
        Empleado empl = new Empleado();
        Scanner sc = new Scanner(System.in);
        System.out.println("~ Apellido del empleado: ");
        empl = emp.buscarUno(sc.nextLine());
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °  ");
        System.out.printf("|%-15s |%-15s |%-15s |\t%15s| |%-20s| |%-10s| |%-10s| |%-10s| %n", "Numero Empleado", "Apellido", "Oficio", "Director", "Fecha contratación", "Salario", "Comision", "Num.dpto");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");

        System.out.printf("|%-15s |%-15s |%-15s |\t%15s| |%-20s| |%-10s| |%-10s| |%-10s| %n", empl.getNumEmpleado(), empl.getApellido(), empl.getOficio(), empl.getDirector(), empl.getFechaAlt(), empl.getSalario(), empl.getComision(), empl.getNumeroDepartamento());
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");

    }

    public void crearEmp() throws SQLException {
        Empleados emp = new Empleados();
        Empleado empl = new Empleado();
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println("°       Crear empleado          °");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println(" ~ Número empleado: ");
        empl.setNumEmpleado(Integer.parseInt(sc.nextLine()));
        System.out.println("");
        System.out.print(" ~ Apellido: ");
        empl.setApellido(sc.nextLine());
        System.out.println("");
        System.out.print(" ~ Oficio: ");
        empl.setOficio(sc.nextLine());
        System.out.println("");
        System.out.print(" ~Director: ");
        empl.setDirector(Integer.parseInt(sc.nextLine()));
        System.out.println("");
        System.out.print(" ~ Fecha de alta: ");
        java.sql.Date jsqlD = java.sql.Date.valueOf(sc.nextLine());
        empl.setFechaAlt(jsqlD);
        System.out.println("");
        System.out.print(" ~ Salario: ");
        empl.setSalario(Float.parseFloat(sc.nextLine()));
        System.out.println("");
        System.out.print(" ~Comision: ");
        empl.setComision(Float.parseFloat(sc.nextLine()));
        System.out.println("");
        System.out.print(" ~ Número departamento: ");
        empl.setNumeroDepartamento(Integer.parseInt(sc.nextLine()));

        System.out.println(emp.create(empl) + " han sido registrados.");
    }

    public void eliminarEmpleado() throws SQLException {
        Empleados emp2 = new Empleados();
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println("°       Eliminar empleado       °");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");

        System.out.println(emp2.Delete(Integer.parseInt(sc.nextLine()))+ " ha sido eliminado.");

    }
}
