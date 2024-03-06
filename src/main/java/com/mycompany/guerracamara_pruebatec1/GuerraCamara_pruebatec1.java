package com.mycompany.guerracamara_pruebatec1;

import com.mycompany.guerracamara_pruebatec1.igu.Menu;
import com.mycompany.guerracamara_pruebatec1.logica.Controladora;
import com.mycompany.guerracamara_pruebatec1.logica.Empleado;
import com.mycompany.guerracamara_pruebatec1.logica.EmpleadoException;
import com.mycompany.guerracamara_pruebatec1.logica.GestorEmpleado;
import java.util.List;

public class GuerraCamara_pruebatec1 {

    public static void main(String[] args) throws EmpleadoException {
        
        //Instancia y llamada del menu principal
        Menu menu = new Menu();
        menu.mostrarMenu();

        //Instancia del gestor empleado para manejar las operaciones
        GestorEmpleado gestorEmpleado = new GestorEmpleado();

        //Instancia de la controladora para gestionar las operaciones logicas
        Controladora controladora = new Controladora();

        //**** OBTENER EMPLEADO ****
        //Obtener objeto empleado
        Empleado empleado = gestorEmpleado.solicitarDatosEmpleado();
        //Crear un nuevo empleado con los datos recogidos anteriormente
        controladora.crearEmpleado(empleado);

        //**** LISTAR EMPLEADOS ****
        //Obtener la lista de empleados
        List<Empleado> listaEmpleados = controladora.traerEmpleados();
        //Mostrar por pantalla la lista de los empleados
        gestorEmpleado.mostrarListaEmpleados(listaEmpleados);

        //Editar empleado
        gestorEmpleado.editarEmpleado();

    }
}
