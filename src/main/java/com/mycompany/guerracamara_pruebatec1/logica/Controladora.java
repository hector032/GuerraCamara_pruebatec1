package com.mycompany.guerracamara_pruebatec1.logica;

import com.mycompany.guerracamara_pruebatec1.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    //Instancia controladora de persistencia
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //Creamos un nuevo empleado respetando el manejo de errores.
    public boolean crearEmpleado(Empleado empleado) {
        try {
            controlPersis.crearEmpleado(empleado);
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear empleado: " + e.getMessage());
            return false;
        }
    }

    //Listamos todos los empleados activos
    public List<Empleado> traerEmpleados() {
        return controlPersis.traerEmpleados();
    }

    //Buscamos un empleado mediante el id
    public Empleado buscarEmpleado(Long idEmpleado) {
        return controlPersis.buscarEmpleado(idEmpleado);
    }

    //Actualizamos un empleado respetando el manejo de errores
    public void editarEmpleado(Empleado empleado) {
        try {
            controlPersis.editarEmpleado(empleado);
            System.out.println("Empleado editado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al editar empleado: " + e.getMessage());
        }
    }

    //Borrado logico de un empleado(Activo=false)
    public void desactivarEmpleado(Long idEmpleado) {
        Empleado empleado = buscarEmpleado(idEmpleado);
        empleado.setActivo(false);
        controlPersis.editarEmpleado(empleado);
    }

    //Filtramos listado de los empleados por cargo
    public List<Empleado> buscarEmpleadosPorCargo(String cargo) {
        return controlPersis.buscarEmpleadosPorCargo(cargo);
    }

}
