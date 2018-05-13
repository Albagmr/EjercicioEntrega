package clasessql;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Alba
 */
public class ClasesSQL {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        DepartamentosConsola depc = new DepartamentosConsola();
        EmpleadosConsola empc = new EmpleadosConsola();
        /**
         * Bucle que, mientras sea "true" seguirá dentro de él.
         */
        while (continuar == true) {
            System.out.println("\t○ ○ ○ ○ ○ ○ ○ ○ ○ ○ ○ ○ ○ ");
            System.out.println("\t○       Elija una opción     ○");
            System.out.println("\t○~~~~~~~~~~~~~~~~~~~~~~~~~~~~○");
            System.out.println("\t○ 1~ Listado departamentos   ○");
            System.out.println("\t○ 2~ Buscar departamentos    ○");
            System.out.println("\t○ 3~ Crear departamento      ○");
            System.out.println("\t○ 4~ Eliminar departamento   ○");
            System.out.println("\t○~~~~~~~~~~~~~~~~~~~~~~~~~~~~○");
            System.out.println("\t○ 5~ Listado empleados       ○");
            System.out.println("\t○ 6~ Buscar empleados        ○");
            System.out.println("\t○ 7~ Crear empleado          ○");
            System.out.println("\t○ 8~ Eliminar empleado       ○");
            System.out.println("\t○~~~~~~~~~~~~~~~~~~~~~~~~~~~~○");
            System.out.println("\t○ 0~ Salir                   ○");
            System.out.println("\t○ ○ ○ ○ ○ ○ ○ ○ ○ ○ ○ ○ ○");
            switch (Integer.parseInt(sc.nextLine())) {
                case 0:
                    return;
                //Busqueda de Listado departamento
                case 1:
                    depc.listado();
                    break;
                //Busqueda de buscar departamento
                case 2:
                    depc.buscarDpto();
                    break;
                //Busqueda de crear departamento
                case 3:
                    depc.crearDpto();
                    break;
                //Busqueda de eliminar departamento
                case 4:
                    depc.eliminarDpto();
                    break;
                //Busqueda de listado empleados
                case 5:
                    empc.listado();
                    break;
                //Busqueda de un empleado
                case 6:
                    empc.buscarUno();
                    break;
                //Busqueda de crear un empleado
                case 7:
                    empc.crearEmp();
                    break;
                //Busqueda de eliminar un empleado
                case 8:
                    empc.eliminarEmpleado();
                    break;

            }
        }
    }
}
