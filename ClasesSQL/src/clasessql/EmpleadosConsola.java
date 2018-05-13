package clasessql;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Alba
 */
public class EmpleadosConsola {

    Scanner sc = new Scanner(System.in);
    Empleados emp = new Empleados();

    /**
     * Creamos el método listado en el cual, mostramos por pantalla los casos
     * que podemos seleccionar en nuestra aplicacion: listado completo, buscar
     * empleado o volver al inicio.
     *
     * @throws SQLException
     */
    public void listado() throws SQLException {
        try {
            Empleado empl = new Empleado();
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");
            System.out.println("\t°     Listado Empleados        °");
            System.out.println("\t°~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~°");
            System.out.println("\t°    1~ Listado completo       °");
            System.out.println("\t°    2~ Buscar empleado        °");
            System.out.println("\t°    0~ Volver al inicio       °");
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");
            switch (Integer.parseInt(sc.nextLine())) {
                case 0:
                    return;
                case 1:
                    emp.ReadTodos();
                    System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
                    System.out.printf("\t°%-15s |%-15s |%-15s |%-5s| |%-10s| |%-10s| |%-10s| |%-10s° %n", "Numero Empleado", "Apellido", "Oficio", "Jefe", "Fec.Contr", "Salario", "Comision", "Num.dpto");
                    System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °");
                    for (int i = 0; i < emp.empleados.size(); i++) {
                        empl = emp.empleados.get(i);

                        System.out.printf("\t°%-15s |%-15s |%-15s |%-5s| |%-10s| |%-10s| |%-10s| |%-10s° %n", empl.getNumEmpleado(), empl.getApellido(), empl.getOficio(), empl.getDirector(), empl.getFechaAlt(), empl.getSalario(), empl.getComision(), empl.getNumeroDepartamento());
                        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");
                    }
                    break;
                case 2:
                    empl = emp.Read(Integer.parseInt(sc.nextLine()));
                    System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");
                    System.out.printf("°%-15s |%-15s |%-15s |%-5s| |%-10s| |%-10s| |%-10s| |%-10s° %n", "Numero Empleado", "Apellido", "Oficio", "Jefe", "Fec.Contr", "Salario", "Comision", "Num.dpto");
                    System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");

                    System.out.printf("°%-15s |%-15s |%-15s |%-5s| |%-10s| |%-10s| |%-10s| |%-10s° %n", empl.getNumEmpleado(), empl.getApellido(), empl.getOficio(), empl.getDirector(), empl.getFechaAlt(), empl.getSalario(), empl.getComision(), empl.getNumeroDepartamento());
                    System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");
                    break;
            }
        } catch (NumberFormatException e1) {
            System.out.println("Error: Formato");
        } catch (NullPointerException e2) {
            System.out.println("Error: NullPointer");
        } catch (SQLException e3) {
            System.out.println("Error: SQL");
        }
    }

    /**
     * Creamos el metodo buscar uno en el cual, mostramos todos los datos del
     * empleado
     *
     * @throws SQLException
     */
    public void buscarUno() throws SQLException {
        Empleados emp = new Empleados();
        Empleado empl = new Empleado();
        Scanner sc = new Scanner(System.in);
        System.out.println("\t~ Apellido del empleado: ");
        empl = emp.buscarUno(sc.nextLine());
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");
        System.out.printf("°%-15s |%-15s |%-15s |%-5s| |%-10s| |%-10s| |%-10s| |%-10s° %n", "Numero Empleado", "Apellido", "Oficio", "Jefe", "Fec.Contr", "Salario", "Comision", "Num.dpto");
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ");

        System.out.printf("°%-15s |%-15s |%-15s |%-5s| |%-10s| |%-10s| |%-10s| |%-10s° %n", empl.getNumEmpleado(), empl.getApellido(), empl.getOficio(), empl.getDirector(), empl.getFechaAlt(), empl.getSalario(), empl.getComision(), empl.getNumeroDepartamento());
        System.out.println("° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");

    }

    //Creamos un nuevo empleado
    public void crearEmp() throws SQLException {
        try {
            Empleados emp = new Empleados();
            Empleado empl = new Empleado();
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");
            System.out.println("\t°       Crear empleado         °");
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");
            System.out.println("\t ~ Número empleado: ");
            empl.setNumEmpleado(Integer.parseInt(sc.nextLine()));
            System.out.println("");
            System.out.print("\t ~ Apellido: ");
            empl.setApellido(sc.nextLine());
            System.out.println("");
            System.out.print("\t ~ Oficio: ");
            empl.setOficio(sc.nextLine());
            System.out.println("");
            System.out.print("\t ~Director: ");
            empl.setDirector(Integer.parseInt(sc.nextLine()));
            System.out.println("");
            System.out.print("\t ~ Fecha de alta: ");
            java.sql.Date jsqlD = java.sql.Date.valueOf(sc.nextLine());
            empl.setFechaAlt(jsqlD);
            System.out.println("");
            System.out.print("\t ~ Salario: ");
            empl.setSalario(Float.parseFloat(sc.nextLine()));
            System.out.println("");
            System.out.print("\t ~Comision: ");
            empl.setComision(Float.parseFloat(sc.nextLine()));
            System.out.println("");
            System.out.print("\t ~ Número departamento: ");
            empl.setNumeroDepartamento(Integer.parseInt(sc.nextLine()));

            System.out.println(emp.create(empl) + " han sido registrados.");
        } catch (NumberFormatException e1) {
            System.out.println("Error: Formato");
        } catch (NullPointerException e2) {
            System.out.println("Error: NullPointer");
        } catch (SQLException e3) {
            System.out.println("Error: SQL");
        }
    }

    //Eliminamos un empleado
    public void eliminarEmpleado() throws SQLException {
        try {
            Empleados emp2 = new Empleados();
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");
            System.out.println("\t°       Eliminar empleado      °");
            System.out.println("\t° ° ° ° ° ° ° ° ° ° ° ° ° ° ° °°");

            System.out.println(emp2.Delete(Integer.parseInt(sc.nextLine())) + " ha sido eliminado.");
        } catch (NumberFormatException e1) {
            System.out.println("Error: Formato");
        } catch (NullPointerException e2) {
            System.out.println("Error: NullPointer");
        } catch (SQLException e3) {
            System.out.println("Error: SQL");
        }
    }
}
