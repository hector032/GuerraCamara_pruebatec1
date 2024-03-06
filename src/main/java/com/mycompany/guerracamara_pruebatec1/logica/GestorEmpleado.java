package com.mycompany.guerracamara_pruebatec1.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//Clase encargada de gestionar las operaciones relacionadas con los empleados.
public class GestorEmpleado {

    //Instancia de objeto controladora
    Controladora controladora = new Controladora();
    private Scanner scanner;

    public GestorEmpleado(Controladora controladora) {
        this.controladora = controladora;
        this.scanner = new Scanner(System.in);
    }

    //Constructor que inicializa solo el objeto Scanner
    public GestorEmpleado() {
        scanner = new Scanner(System.in);
    }

    //Metodo para validar una cadena recibida, lanzando una excepcion personalizada si no cumple con los criterios
    public boolean validarEntradaString(String cadena) throws EmpleadoException {
        //El siguiente if verifica que la cadena no esté vacia y que pueda tener:
        //1. Tildes
        //2. Espacios entre caracteres (pj: Maria de los Angeles)
        //3. Al menos 3 caracteres   
        if (cadena.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$") && cadena.length() > 2 && !cadena.isEmpty()) {
            return true;
        } else {
            //Generamos una exepcion personalizada cuando no se cumpla con los de arriba.
            throw new EmpleadoException("Valor invalido, debe contener solo letras y tener al menos 3 caracteres.");
        }
    }

    //Metodo para buscar un empleado por id
    public Empleado buscarEmpleado() {
        System.out.println("Ingrese el ID del empleado:");
        Long idEmpleado = scanner.nextLong();
        scanner.nextLine(); //Consumir el salto de línea
        return controladora.buscarEmpleado(idEmpleado);

    }

    //Metodo para solicitar datos de un empleado
    public Empleado solicitarDatosEmpleado() {
        String nombre = "";
        String apellido = "";
        String cargo = "";

        while (true) {
            System.out.println("Ingrese el nombre del empleado:");
            nombre = scanner.nextLine();
            try {
                validarEntradaString(nombre);
                break;
            } catch (EmpleadoException e) {
                System.out.println("Error:  " + e.getMessage());
            }
        }
        while (true) {
            System.out.println("Ingrese el apellido del empleado:");
            apellido = scanner.nextLine();
            try {
                validarEntradaString(apellido);
                break;
            } catch (EmpleadoException e) {
                System.out.println("Error:  " + e.getMessage());
            }
        }
        while (true) {
            System.out.println("Ingrese el cargo del empleado:");
            cargo = scanner.nextLine();
            try {
                validarEntradaString(cargo);
                break;
            } catch (EmpleadoException e) {
                System.out.println("Error:  " + e.getMessage());
            }
        }

        double salario = solicitarSalario();

        Date fechaInicio = solicitarFecha();

        return new Empleado(nombre, apellido, cargo, salario, fechaInicio);
    }

    //Metodo para mostrar una lista de empleados
    public void mostrarListaEmpleados(List<Empleado> listaEmpleados) {
        if (listaEmpleados != null && !listaEmpleados.isEmpty()) {
            for (Empleado empleado : listaEmpleados) {
                if (empleado.isActivo()) {
                    System.out.println(empleado.toString());
                }
            }
        } else {
            System.out.println("No existen empleados en el sistema");
        }
    }

    //Metodo para filtrar empleados por cargo
    public void buscarEmpleadosPorCargo() {
        System.out.println("Ingrese el cargo del empleado que desea buscar:");
        String cargo = scanner.nextLine();

        //Obtener la lista de empleados con el cargo especificado
        List<Empleado> empleadosPorCargo = controladora.buscarEmpleadosPorCargo(cargo);

        if (empleadosPorCargo.isEmpty()) {
            System.out.println("No se encontraron empleados con el cargo especificado.");
        } else {
            System.out.println("Empleados con el cargo '" + cargo + "':");
            //Mostrar los empleados encontrados
            mostrarListaEmpleados(empleadosPorCargo);
        }
    }
    
    //Metodo para actualizar los datos de un empleado existente
    public void editarEmpleado() throws EmpleadoException {

        Empleado empleado = buscarEmpleado();
        boolean continuar = true;
        //Vericiamos que exista un empleado con el id ingresado
        if (empleado == null) {
            System.out.println("Empleado no encontrado");
            continuar = false;
        } else {
            System.out.println("Empleado encontrado: " + empleado);
        }

        while (continuar != false) {
            System.out.println("Seleccione el campo que desea editar:");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Cargo");
            System.out.println("4. Salario");
            System.out.println("5. Fecha de Inicio");
            System.out.println("6. Guardar");
            System.out.println("7. Cancelar");

            try {
                int opcionCampo = scanner.nextInt();
                scanner.nextLine(); //Limpiar el buffer

                switch (opcionCampo) {

                    case 1:
                        //Editar nombre
                        boolean nombreValido = false;
                        while (!nombreValido) {
                            System.out.println("Ingrese el nuevo nombre:");
                            String nuevoNombre = scanner.nextLine();
                            try {
                                if (validarEntradaString(nuevoNombre)) {
                                    empleado.setNombre(nuevoNombre);
                                    nombreValido = true; //Si el nombre es valido, salimos del bucle
                                } else {
                                    throw new EmpleadoException("Nombre invalido. Debe contener solo letras y tener al menos 3 caracteres.");
                                }
                            } catch (EmpleadoException ex) {
                                System.out.println("Error: " + ex.getMessage());
                            }
                        }
                        break;

                    case 2:
                        //Editar apellido
                        boolean apellidoValido = false;
                        while (!apellidoValido) {
                            System.out.println("Ingrese el nuevo apellido:");
                            String nuevoApellido = scanner.nextLine();
                            try {
                                if (validarEntradaString(nuevoApellido)) {
                                    empleado.setApellido(nuevoApellido);
                                    apellidoValido = true; //Si el apellido es valido, salimos del bucle
                                } else {
                                    throw new EmpleadoException("Apellido invalido. Debe contener solo letras y tener al menos 3 caracteres.");
                                }
                            } catch (EmpleadoException ex) {
                                System.out.println("Error: " + ex.getMessage());
                            }
                        }
                        break;

                    case 3:
                        //Editar cargo
                        boolean cargoValido = false;
                        while (!cargoValido) {
                            System.out.println("Ingrese el nuevo cargo:");
                            String nuevoCargo = scanner.nextLine();
                            try {
                                if (validarEntradaString(nuevoCargo)) {
                                    empleado.setCargo(nuevoCargo);
                                    cargoValido = true; //Si el cargo es valido, salimos del bucle
                                } else {
                                    throw new EmpleadoException("Cargo invalido. Debe contener solo letras y tener al menos 3 caracteres.");
                                }
                            } catch (EmpleadoException ex) {
                                System.out.println("Error: " + ex.getMessage());
                            }
                        }
                        break;

                    case 4:
                        //Editar salario
                        double nuevoSalario = solicitarSalario();
                        empleado.setSalario(nuevoSalario);
                        break;
                    case 5:
                        //Editar fecha de inicio
                        Date nuevaFechaInicio = solicitarFecha();
                        empleado.setFechaInicio(nuevaFechaInicio);
                        break;
                    case 6:
                        //Guardar
                        //Actualiza los datos introducidos 
                        controladora.editarEmpleado(empleado);
                        return;
                    case 7:
                        //Salir del menu
                        //Cancelamos la operación
                        System.out.println("Edición del empleado Cancelada.");
                        continuar = false;
                        return;
                    default:
                        System.out.println("Opcion invalida, porfavor ingrese un numero correcto.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida, debes ingresar un numero correspondiente al menu");
                scanner.nextLine(); //Limpiar el buffer para evitar un bucle infinito
            }
        }
    }
    
    //Metodo para hacer un borrado logico de un empleado
    public void eliminarEmpleado() {
        Empleado empleado = buscarEmpleado();
        if (empleado != null) {
            controladora.desactivarEmpleado(empleado.getId());
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
    
    //Metodo para solicitar el salario con todas las validaciones correspondientes
    public double solicitarSalario() {
        double salario = 0;
        boolean salarioValido = false;
        while (!salarioValido) {
            System.out.println("Ingrese el salario del empleado:");
            try {
                salario = Double.parseDouble(scanner.nextLine());
                if (salario >= 0) {
                    salarioValido = true;
                } else {
                    System.out.println("El salario no puede ser negativo, ingrese un valor valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al leer el salario, ingrese un valor numerico valido.");
            }
        }
        return salario;
    }
    
    //Metodo para solicitar la fecha con todas las validaciones correspondientes
    public Date solicitarFecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); //Validamos que el formato fecha tiene que ser estrictamente correcto

        while (true) {
            System.out.print("Ingrese la fecha de inicio del empleado en el siguiente formato (dd-MM-yyyy): ");
            String fechaStr = scanner.nextLine();

            try {
                Date fecha = dateFormat.parse(fechaStr);
                return fecha;
            } catch (ParseException e) {
                System.out.println("Fecha inválida, ingrese una fecha valida en el formato especificado.");
            }
        }
    }

}
