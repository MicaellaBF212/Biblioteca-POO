/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca1.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author USER
 */

public class Libro {
    private String titulo;
    private Date publicacion;
    private String genero;
    private String idioma;
    private int numeroPag;
    private String ISBN;
    private boolean disponible; 

    private List<Autor> autores; 
    private Editorial editorial; 

    public Libro(String titulo, Date publicacion, String genero, String idioma,int numeroPag, String ISBN, String nombreEditorial, String paisEditorial) {
        this.titulo = titulo;
        this.publicacion = publicacion;
        this.genero = genero;
        this.idioma = idioma;
        this.numeroPag = numeroPag;
        this.ISBN = ISBN;
        this.disponible = true;
        this.autores = new ArrayList<>();
        this.editorial = new Editorial(nombreEditorial, paisEditorial);
        this.editorial.agregarLibro(this);
    }

    // Getters y Setters
    public String getTitulo() { 
        return titulo; 
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo; 
    }

    public Date getPublicacion() { 
        return publicacion; 
    }
    public void setPublicacion(Date publicacion) {
        this.publicacion = publicacion; 
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) { 
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNumeroPag() { 
        return numeroPag;
    }
    public void setNumeroPag(int numeroPag) {
        this.numeroPag = numeroPag; 
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN; 
    }

    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) { 
        this.disponible = disponible;
    }

    public List<Autor> getAutores() { 
        return autores;
    }
    
    public Editorial getEditorial() { 
        return editorial;
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void editarDatos(String titulo, String genero, String idioma) {
        this.titulo = titulo;
        this.genero = genero;
        this.idioma = idioma;
        System.out.println("  [Libro] Datos actualizados: " + this.titulo);
    }

    public String obtenerInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Información del Libro\n");
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("ISBN: ").append(ISBN).append("\n");
        sb.append("Género: ").append(genero).append("\n");
        sb.append("Idioma: ").append(idioma).append("\n");
        sb.append("Páginas: ").append(numeroPag).append("\n");
        sb.append("Disponible: ").append(disponible ? "Sí" : "No").append("\n");
        sb.append("Editorial: ")
          .append(editorial.getNombreEditorial()).append("(").append(editorial.getPais()).append(")\n");
        sb.append("  Autores    : ");
        for (Autor a : autores) {
            sb.append(a.getNombre()).append(" ").append(a.getApellido()).append("; ");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public void cambiarDispo() {
        this.disponible = !this.disponible;
        System.out.println("  [Libro] Disponibilidad de \"" + titulo + "\": "
                         + (disponible ? "Disponible" : "No disponible"));
    }

    @Override
    public String toString() {
        return "Libro: " + titulo + " | ISBN: " + ISBN+ " | Disponible: " + (disponible ? "Sí" : "No");
    }
}