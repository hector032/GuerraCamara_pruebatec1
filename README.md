
# Proyecto para la Gestión de Empleados

Este proyecto es una aplicación para la gestión de empleados desarrollada en Java utilizando JPA (Java Persistence API) para el acceso a la base de datos montada en MySQL.

El objetivo de esta aplicación es proporcionar funcionalidades para la gestión de empleados de una empresa. Coniste en realizar operaciones básicas como crear, leer, actualizar y eliminar empleados, así como listar todos los empleados activos.

# Funciones de la aplicación

Inicialmente la aplicacion muestra un menú con las siguientes opciones:

* Creación de empleados: permite agregar nuevos empleados al sistema (nombre, apellidos, cargo, salario, fecha de inicio)
* Listado de empleados: proporciona una lista de todos los empleados actualmente activos en la empresa.
* Buscar empleado por cargo: muestra un listado de empleados que tengan el mismo cargo
* Editar de empleados: posibilita la modificación de la información de un empleado existente mediante un identificador, a continuación muestra un menú de opciones para editar el/los atributos del usuario (nombre, apellidos, cargo, salario, fecha de inicio)
* Eliminación de empleados: permite dar de baja a un empleado del sistema mediante un borardo lógico en la base de datos
* Salir: Cierra la aplicación

# Validaciones

* Validación de entrada de cadena: Se validan los campos: nombre, apellido y cargo de tal manera que contengan solo caracteres alfabéticos con tildes y espacios, con una longitud mínima de 3 caracteres.

* Validación de salario: Se verifica que el salario ingresado sea un número válido (double) y no negativo.

* Validación de fecha: Se valida que la fecha de inicio ingresada tenga el formato correcto (dd-MM-yyyy) y sea una fecha válida.

# Supuestos

* Se asume que la fecha de inicio de un empleado puede ser tanto una fecha pasada como futura.

* Se asume que el salario de un empleado debe ingresarse en formato decimal, utilizando el punto (.) como separador decimal. Por ejemplo, 5000.00 representaría un salario mensual de 5000 euros.

* Se asume que el usuario conoce los id de los empleados que desea editar, eliminar o buscar.


# Configuración del Proyecto

    1. Clonar este repositorio github.com/hector032/GuerraCamara_pruebatec1

    2. Ejecuta la aplicación para iniciarla 

    3. Utilizar las opciones disponibles del gestionador de empleados

# IMPORTANTE
La configuración de la unidad de persistencia está en el archivo persistence.xml.

El fichero sql se encuentra en la raiz del proyecto (empleados.sql)

## Authors

- [@hector032](https://www.github.com/hector032)
