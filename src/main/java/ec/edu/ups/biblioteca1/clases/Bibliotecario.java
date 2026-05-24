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

public class Bibliotecario extends Persona {
    private String id;
    private String horario;

    private List<Usuario> usuariosRegistrados;

    public Bibliotecario(String id, String nombre, String apellido,String cedula, int edad, String horario) {
        super(nombre, apellido, cedula, edad);
        this.id = id;
        this.horario = horario;
        this.usuariosRegistrados = new ArrayList<>();
    }

    public String getId() { 
        return id; 
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getHorario() {
        return horario; 
    }
    
    public void setHorario(String horario) {
        this.horario = horario; 
    }

    public List<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados; 
    }

   
    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.add(usuario);
        System.out.println("  [Bibliotecario] " + getNombre() + " registró al usuario: " + usuario.getNombre() + " " + usuario.getApellido());
    }

    public void registrarLibro(Libro libro) {
        System.out.println("  Bibliotecario: " + getNombre()+ " registró el libro: \""+ libro.getTitulo() + "\" | ISBN: " + libro.getISBN());
    }

    @Override
    public String toString() {
        return "Bibliotecario ID: " + id + " | " + super.toString()+ " | Horario: " + horario;
    }
}
