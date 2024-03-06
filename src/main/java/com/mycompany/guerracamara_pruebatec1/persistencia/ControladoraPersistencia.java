package com.mycompany.guerracamara_pruebatec1.persistencia;

import com.mycompany.guerracamara_pruebatec1.logica.Empleado;
import java.util.List;

public class ControladoraPersistencia {

    //Instancia del controlador JPA para manipular la entidad Empleado en la base de datos
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();

    //Metodo para crear un nuevo empleado en la base de datos
    public void crearEmpleado(Empleado empleado) {
        empleJPA.create(empleado);
    }

    //Metodo para obtener una lista de todos los empleados no borrados de la base de datos
    public List<Empleado> traerEmpleados() {
        return empleJPA.findEmpleadoNoBorrados();
    }

    //Metodo para buscar un empleado en la base de datos por su id
    public Empleado buscarEmpleado(Long idEditar) {
        return empleJPA.findEmpleado(idEditar);
    }

    //Metodo para actualizar los datos de un empleado en la base de datos
    public void editarEmpleado(Empleado empleado) {
        try {
            empleJPA.edit(empleado);
        } catch (Exception ex) {
            System.out.println("Error al editar el empleado:");
            ex.printStackTrace();
        }
    }

    //Metodo para filtrar empleados en la base de datos por su cargo
    public List<Empleado> buscarEmpleadosPorCargo(String cargo) {
        return empleJPA.findEmpleadoPorCargo(cargo);
    }

}
