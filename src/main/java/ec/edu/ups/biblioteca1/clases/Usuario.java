/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca1.clases;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private String correo;
    private String contrasena;

    // Un usuario puede tener 0..* préstamos
    private List<Prestamo> prestamos;

    public Usuario(String nombre, String apellido, String cedula, int edad,
                   String correo, String contrasena) {
        super(nombre, apellido, cedula, edad);
        this.correo = correo;
        this.contrasena = contrasena;
        this.prestamos = new ArrayList<>();
    }

    public String getCorreo() { 
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena; 
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    // Métodos del UML
    public void solicitarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
        System.out.println("  [Usuario] " + getNombre() + " " + getApellido()+ 
                " solicitó préstamo #" + prestamo.getCodigo() + 
                " Libro: " + (prestamo.getLibro() != null? prestamo.getLibro().getTitulo() : "N/A"));
    }

    public void devolverLibro(Libro libro) {
        libro.setDisponible(true);
        System.out.println("  [Usuario] " + getNombre() + " " + getApellido()+ " devolvió: " + libro.getTitulo());
    }

    @Override
    public String toString() {
        return super.toString() + " | Correo: " + correo;
    }
}
