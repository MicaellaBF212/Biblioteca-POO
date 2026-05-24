/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca1.clases;

import java.util.Date;
/**
 *
 * @author USER
 */

public class Prestamo {
    private int codigo;
    private Date fechaIni;
    private Date fechaFin;

    // Asociación 0..* con Usuario y 0..* con Libro según UML
    private Usuario usuario;
    private Libro libro;

    public Prestamo(int codigo, Date fechaIni, Date fechaFin, Usuario usuario, Libro libro) {
        this.codigo = codigo;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.libro = libro;
        // Al crear el préstamo el libro queda no disponible
        if (libro != null) {
            libro.setDisponible(false);
        }
    }

    public int getCodigo() { 
        return codigo; 
    }
    public void setCodigo(int codigo) { 
        this.codigo = codigo; 
    }

    public Date getFechaIni() {
        return fechaIni; 
    }
    public void setFechaIni(Date fechaIni) { 
        this.fechaIni = fechaIni; 
    }

    public Date getFechaFin() { 
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin; 
    }

    public Usuario getUsuario() { 
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario; 
    }

    public Libro getLibro() { 
        return libro; 
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    // Método del UML
    public void cerrarPrestamo() {
        if (libro != null) {
            libro.setDisponible(true);
        }
        System.out.println("  [Préstamo] Préstamo #" + codigo + " cerrado.");
        System.out.println("  [Préstamo] Libro \""+ (libro != null ? libro.getTitulo() : "N/A") + "\" devuelto a la biblioteca.");
    }

    @Override
    public String toString() {
        return "Préstamo #" + codigo
             + " | Inicio: " + fechaIni
             + " | Fin: " + fechaFin
             + " | Libro: " + (libro != null ? libro.getTitulo() : "N/A")
             + " | Usuario: " + (usuario != null
                 ? usuario.getNombre() + " " + usuario.getApellido() : "N/A");
    }
}

