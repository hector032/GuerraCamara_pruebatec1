package com.mycompany.guerracamara_pruebatec1.igu;

import com.mycompany.guerracamara_pruebatec1.logica.Controladora;
import com.mycompany.guerracamara_pruebatec1.logica.Empleado;
import com.mycompany.guerracamara_pruebatec1.logica.EmpleadoException;
import com.mycompany.guerracamara_pruebatec1.logica.GestorEmpleado;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    //**** CREACION DE INSTANCIAS ****
    Controladora controladora = new Controladora();
    GestorEmpleado gestorEmpleado = new GestorEmpleado();
    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() throws EmpleadoException {
        while (true) {
            try {
                System.out.println("=========================================");
                System.out.println("|          MENU DE GESTION DE           |");
                System.out.println("|            EMPLEADOS                  |");
                System.out.println("=========================================");
                System.out.println("|  1. Agregar un nuevo empleado         |");
                System.out.println("|  2. Listar todos los empleados        |");
                System.out.println("|  3. Buscar empleados por cargo        |");
                System.out.println("|  4. Actualizar información de un      |");
                System.out.println("|     empleado                          |");
                System.out.println("|  5. Eliminar un empleado              |");
                System.out.println("|  6. Salir                             |");
                System.out.println("=========================================");
                System.out.print("Ingrese el número de la opción deseada: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); //Consumir el salto de linea

                switch (opcion) {
                    case 1:
                        //Agregar un nuevo empleado
                        Empleado nuevoEmpleado = gestorEmpleado.solicitarDatosEmpleado();
                        controladora.crearEmpleado(nuevoEmpleado);
                        System.out.println("\nEmpleado agregado correctamente\n");
                        break;
                    case 2:
                        //Listar todos los empleados
                        List<Empleado> listaEmpleados = controladora.traerEmpleados();
                        gestorEmpleado.mostrarListaEmpleados(listaEmpleados);

                        break;
                    case 3:
                        //Buscar empleados por cargo
                        gestorEmpleado.buscarEmpleadosPorCargo();
                        break;
                    case 4:
                        //Actualizar información de un empleado
                        gestorEmpleado.editarEmpleado();
                        break;
                    case 5:
                        //Eliminar un empleado (borrado logico)
                        gestorEmpleado.eliminarEmpleado();
                        break;
                    case 6:
                        // Salir del programa
                        System.out.println("\nSistema cerrado correctamente\n");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOpcion invalida, porfavor ingrese un numero correcto.\n");

                }
            } catch (InputMismatchException e) {
                System.out.println("\nOpcion invalida, porfavor ingrese un numero correcto.\n");
                scanner.nextLine(); //Limpia el buffer del scanner 
            }
        }
    }

}
