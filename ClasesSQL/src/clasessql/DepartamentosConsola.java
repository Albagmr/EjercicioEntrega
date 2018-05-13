package clasessql;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Alba
 */
public class DepartamentosConsola {

    Scanner sc = new Scanner(System.in);
    Departamentos dpto = new Departamentos();

    public void listado() throws SQLException {
        try {
            Departamento dep = new Departamento(); //creamos un submenu para mostrar por pantalla
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");
            System.out.println("\t°     Listado departamento     °");
            System.out.println("\t°~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~°");
            System.out.println("\t°   1~ Listado completo        °");
            System.out.println("\t°   2~ Buscar uno              °");
            System.out.println("\t°   0~ Volver al inicio        °");
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");

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
        } catch (NumberFormatException e1) {
            System.out.println("Error: Formato");
        } catch (NullPointerException e2) {
            System.out.println("Error: NullPointer");
        } catch (SQLException e3) {
            System.out.println("Error: SQL");
        }
    }

    //Buscamos un departamento, creando también una tabla para mostrar por pantalla
    public void buscarDpto() throws SQLException {
        try {
            Departamentos dep = new Departamentos();
            Departamento dpto = new Departamento();
            Scanner sc = new Scanner(System.in);
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
            System.out.println("\t°       Buscar departamentos    °");
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");

            System.out.println("~Nombre departamento");
            dpto = dep.buscarUno(sc.nextLine());
            System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
            System.out.printf("\t%-15s |%-15s |%-15s  %n", "Numero Departamento", "Nombre", "Localización");
            System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");
            System.out.printf("\t%-19s |%-15s |%-15s  %n", dpto.getNumDepartamento(), dpto.getNombreDpto(), dpto.getLoc());
            System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        } catch (NumberFormatException e1) {
            System.out.println("Error: Formato");
        } catch (NullPointerException e2) {
            System.out.println("Error: NullPointer");
        } catch (SQLException e3) {
            System.out.println("Error: SQL");
        }

    }

    //creamos un departamento
    public void crearDpto() throws SQLException {
        try {
            Departamento dpto = new Departamento();
            Departamentos dpto2 = new Departamentos();
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
            System.out.println("\t°       Crear departamentos     °");
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
            System.out.println("\t° ~ Numero departamento");
            dpto.setNumDepartamento(Integer.parseInt(sc.nextLine()));
            System.out.println("\t° ~ Nombre departamento");
            dpto.setNombreDpto(sc.nextLine());
            System.out.println("\t° ~ Localización ");
            dpto.setLoc(sc.nextLine());
            System.out.println("\tHan sido creados " + dpto2.Create(dpto));
            System.out.println("\t\"° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °\"");
        } catch (NumberFormatException e1) {
            System.out.println("Error: Formato");
        } catch (NullPointerException e2) {
            System.out.println("Error: NullPointer");
        } catch (SQLException e3) {
            System.out.println("Error: SQL");
        }

    }

    //Eliminamos un departamento
    public void eliminarDpto() throws SQLException {
        try {
            Departamentos dpto2 = new Departamentos();
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
            System.out.println("\t°       Eliminar departamentos  °");
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
            System.out.println(dpto2.Delete(Integer.parseInt(sc.nextLine())) + " han sido borrados.");
            System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
        } catch (NumberFormatException e1) {
            System.out.println("Error: Formato");
        } catch (NullPointerException e2) {
            System.out.println("Error: NullPointer");
        } catch (SQLException e3) {
            System.out.println("Error: SQL");
        }

    }
}
