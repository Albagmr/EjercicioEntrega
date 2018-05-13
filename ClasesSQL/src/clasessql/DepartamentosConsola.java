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
public class DepartamentosConsola {

    Scanner sc = new Scanner(System.in);
    Departamentos dpto = new Departamentos();

    public void listado() throws SQLException {
        Departamento dep = new Departamento();
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println("°     Listado departamento      °");
        System.out.println("°~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~°");
        System.out.println("    1~ Listado completo         °");
        System.out.println("    2~ Buscar uno               °");
        System.out.println("    0~ Volver al inicio         °");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");

        switch (Integer.parseInt(sc.nextLine())) {
            case 0:
                return;
            case 1:
                dpto.listarTodos();
                System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");
                for (int i = 0; i < dpto.departamento.size(); i++) {
                    dep = dpto.departamento.get(i);
                    System.out.printf("|%-5d |%-15s |%-20s | %n", dep.getNumDepartamento(), dep.getNombreDpto(), dep.getLoc());
                }
                System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");
                break;
            case 2:
                dep = dpto.listarUno(Integer.parseInt(sc.nextLine()));

                System.out.printf("|%-5d |%-15s |%-20s | %n", dep.getNumDepartamento(), dep.getNombreDpto(), dep.getLoc());
                break;
            default:
                System.out.println("\tNo es correcta la opción elegida");

        }
    }

    public void buscarDpto() throws SQLException {
        Departamentos dep = new Departamentos();
        Departamento dpto = new Departamento();
        Scanner sc = new Scanner(System.in);
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println("°       Buscar departamentos    °");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");

        System.out.println("~Nombre departamento");
        dpto = dep.buscarUno(sc.nextLine());
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.printf("|%-15s |%-15s |%-15s | %n", "Numero Departamento", "\t\tNombre", "\tLocalización");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.printf("|%-15s |%-15s |%-15s | %n", dpto.getNumDepartamento(), dpto.getNombreDpto(), dpto.getLoc());
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");

    }

    public void crearDpto() throws SQLException {
        Departamento dpto = new Departamento();
        Departamentos dpto2 = new Departamentos();
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println("°       Crear departamentos     °");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println("° ~ Numero departamento");
        dpto.setNumDepartamento(Integer.parseInt(sc.nextLine()));
        System.out.println("° ~ Nombre departamento");
        dpto.setNombreDpto(sc.nextLine());
        System.out.println("° ~ Localización ");
        dpto.setLoc(sc.nextLine());
        System.out.println("Han sido creados " + dpto2.Create(dpto));
        System.out.println("\"° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °\"");

    }

    public void eliminarDpto() throws SQLException {
        Departamentos dpto2 = new Departamentos();
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println("°       Eliminar departamentos  °");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        System.out.println(" " + dpto2.Delete(Integer.parseInt(sc.nextLine())) + " han sido borrados.");
        System.out.println("\"° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °\"");

    }
}
