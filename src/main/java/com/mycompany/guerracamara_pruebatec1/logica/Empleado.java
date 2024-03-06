package com.mycompany.guerracamara_pruebatec1.logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Los @column que se ven a continuacion se crean para que se agreguen con el nombre y orden correcto en la tabla.
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "salario")
    private double salario;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "activo")
    private boolean activo;

    //Constructor Vacio
    public Empleado() {
    }

    //Constructor del id
    public Empleado(Long id) {
        this.id = id;
    }

    //Constructor con parametros
    public Empleado(String nombre, String apellido, String cargo, double salario, Date fechaInicio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
        this.activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    //ToString para mostrar formateado la lista de empleados
    @Override
    public String toString() {
        return String.format("Empleado { ID: %-2d | Nombre: %-10s | Apellido: %-10s | Cargo: %-10s | Salario: %10.2f | Fecha de Inicio: %s}",
                id, nombre, apellido, cargo, salario, new SimpleDateFormat("dd/MM/yyyy").format(fechaInicio));

    }

}
