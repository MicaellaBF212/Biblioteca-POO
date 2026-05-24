/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca1.clases;

/**
 *
 * @author User
 */
public class Persona {
    private String nombre; 
    private String apellido;
    private String cedula;
    private int edad;

    public Persona(String nombre, String apellido, String cedula, int edad) {
        this.nombre = nombre;     
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
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

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) { 
        this.cedula = cedula; 
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido + " | Cédula: " + cedula + " | Edad: " + edad;
    }
}
