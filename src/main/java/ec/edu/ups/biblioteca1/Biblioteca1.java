/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.biblioteca1;

/**
 *
 * @author User
 */

import ec.edu.ups.biblioteca1.clases.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Biblioteca1 {
    static Scanner sc = new Scanner(System.in);
    static List<Autor>autores = new ArrayList<>();
    static List<Libro>libros = new ArrayList<>();
    static List<Usuario>usuarios = new ArrayList<>();
    static List<Prestamo> prestamos = new ArrayList<>();
    static Bibliotecario bibliotecario = null;
    static int codigoPrestamo = 1001;
    
    public static void main(String[] args) {
        BibliotecaIG bibliotecaIG = new BibliotecaIG();
        System.out.println(bibliotecaIG);
    }

//        System.out.println("      SISTEMA DE BIBLIOTECA - BIBLIO1       ");
//
//
//        // Registrar Bibliotecario al inicio
//        System.out.println("\n--- Datos del Bibliotecario ---");
//        System.out.print("ID: ");
//        String bibId = sc.nextLine();
//        System.out.print("Nombre: ");
//        String bibNombre = sc.nextLine();
//        System.out.print("Apellido: ");
//        String bibApellido = sc.nextLine();
//        System.out.print("Cedula: ");
//        String bibCedula = sc.nextLine();
//        System.out.print("Edad: ");
//        int bibEdad = sc.nextInt();
//        sc.nextLine();
//        System.out.print("Horario: ");
//        String bibHorario = sc.nextLine();
//
//        bibliotecario = new Bibliotecario(
//                bibId, bibNombre, bibApellido, bibCedula, bibEdad, bibHorario);
//        System.out.println("Bibliotecario registrado: " + bibliotecario);
//
//        int opcion = -1;
//        while (opcion != 0) {
//
//
//            System.out.println("              MENU PRINCIPAL                ");
//            System.out.println("1.  Registrar Autor");
//            System.out.println("2.  Registrar Libro");
//            System.out.println("3.  Registrar Usuario");
//            System.out.println("4.  Realizar Prestamo");
//            System.out.println("5.  Cerrar Prestamo");
//            System.out.println("6.  Devolver Libro");
//            System.out.println("7.  Editar Libro");
//            System.out.println("8.  Ver Libros");
//            System.out.println("9. Ver Usuarios");
//            System.out.println("10. Ver Prestamos");
//            System.out.println("0.  Salir");
//            System.out.println("--------------------------------------------");
//            System.out.print("Seleccione una opcion: ");
//            opcion = sc.nextInt();
//            sc.nextLine();
//
//            switch (opcion) {
//
//                case 1:
//
//                    System.out.println("\n--- Registrar Autor ---");
//                    System.out.print("Nombre: ");
//                    String autNombre = sc.nextLine();
//                    System.out.print("Apellido: ");
//                    String autApellido = sc.nextLine();
//                    System.out.print("Nacionalidad: ");
//                    String autNac = sc.nextLine();
//
//                    Autor autor = new Autor(autNombre, autApellido, autNac);
//                    autores.add(autor);
//                    System.out.println("Autor registrado: " + autor);
//                    break;
//
//                case 2:
//
//                    System.out.println("\n--- Registrar Libro ---");
//                    if (autores.size() == 0) {
//                        System.out.println("Primero registre un autor");
//                        break;
//                    }
//
//                    System.out.print("Titulo: ");
//                    String libTitulo = sc.nextLine();
//                    System.out.print("Genero: ");
//                    String libGenero = sc.nextLine();
//                    System.out.print("Idioma: ");
//                    String libIdioma = sc.nextLine();
//                    System.out.print("Numero de paginas: ");
//                    int libPaginas = sc.nextInt();
//                    sc.nextLine();
//                    System.out.print("ISBN: ");
//                    String libISBN = sc.nextLine();
//                    
//                    System.out.println("-----Datos de la Editorial-----");
//                    System.out.println("Nombre de la editorial: ");
//                    String edNombre = sc.nextLine();
//                    System.out.println("Pais de la editorial: ");
//                    String edPais = sc.nextLine();
//
//                    System.out.println("Autores disponibles:");
//                    for (int i = 0; i < autores.size(); i++) {
//                        System.out.println("  " + (i + 1) + ". "
//                                + autores.get(i).getNombre()
//                                + " " + autores.get(i).getApellido());
//                    }
//                    int numAut = -1;
//                    while(numAut<1 || numAut>autores.size()){
//                        System.out.print("Seleccione autor (numero): ");
//                        numAut = sc.nextInt();
//                        sc.nextLine();
//                        if (numAut < 1 || numAut > autores.size()) {
//                            System.out.println("Opcion invalida");
//                        }
//                    }
//                    Autor autorSel = autores.get(numAut - 1);
//
//                    
//                    Libro libro = new Libro(libTitulo, new Date(), libGenero,
//                            libIdioma, libPaginas, libISBN, edNombre, edPais);
//                    libro.agregarAutor(autorSel);
//                    libros.add(libro);
//                    bibliotecario.registrarLibro(libro);
//                    break;
//
//                case 3:
//
//                    System.out.println("\n--- Registrar Usuario ---");
//                    System.out.print("Nombre: ");
//                    String usNombre = sc.nextLine();
//                    System.out.print("Apellido: ");
//                    String usApellido = sc.nextLine();
//                    System.out.print("Cedula: ");
//                    String usCedula = sc.nextLine();
//                    System.out.print("Edad: ");
//                    int usEdad = sc.nextInt();
//                    sc.nextLine();
//                    System.out.print("Correo: ");
//                    String usCorreo = sc.nextLine();
//                    System.out.print("Contrasena: ");
//                    String usContrasena = sc.nextLine();
//
//                    Usuario usuario = new Usuario(usNombre, usApellido,
//                            usCedula, usEdad, usCorreo, usContrasena);
//                    usuarios.add(usuario);
//                    bibliotecario.registrarUsuario(usuario);
//                    break;
//
//                case 4:
//
//                    System.out.println("\n--- Realizar Prestamo ---");
//
//                    if (usuarios.size() == 0) {
//                        System.out.println("Primero registre un usuario");
//                        break;
//                    }
//                    
//                    List<Libro> disponibles = new ArrayList<>();
//                    for (int i = 0; i < libros.size(); i++) {
//                        if (libros.get(i).isDisponible()) {
//                            disponibles.add(libros.get(i));
//                            
//                        }   
//                    }
//                    if (disponibles.size() == 0) {
//                        System.out.println("No hay libros disponibles");
//                        break;
//                    }
//                   
//                    System.out.println("Usuarios:");
//                    for (int i = 0; i < usuarios.size(); i++) {
//                        System.out.println("  " + (i + 1) + ". "
//                                + usuarios.get(i).getNombre()
//                                + " " + usuarios.get(i).getApellido());
//                    }
//                    
//                    int numUs = -1;
//                    while(numUs<1 || numUs>usuarios.size()){
//                        System.out.print("Seleccione usuario (numero): ");
//                        numUs = sc.nextInt();
//                        sc.nextLine();
//                        if (numUs < 1 || numUs > usuarios.size()) {
//                            System.out.println("Opcion invalida");
//                        }
//                    }
//                    
//                    System.out.println("Libros disponibles:");
//                    for (int i = 0; i < disponibles.size(); i++) {
//                        System.out.println("  " + (i + 1) + ". "
//                                + disponibles.get(i).getTitulo());
//                    }
//                    
//                    int numLib = -1;
//                    while(numLib<1 || numLib>disponibles.size()){
//                        System.out.print("Seleccione libro (numero): ");
//                        numLib = sc.nextInt();
//                        sc.nextLine();
//
//                        if (numLib < 1 || numLib > disponibles.size()) {
//                            System.out.println("Opcion invalida");
//                            break;
//                        }
//                    }
//                   
//                    System.out.print("Dias de prestamo: ");
//                    int dias = sc.nextInt();
//                    sc.nextLine();
//
//                    Date fechaFin = new Date(System.currentTimeMillis()
//                            + (long) dias * 24 * 60 * 60 * 1000);
//
//                    Prestamo prestamo = new Prestamo(codigoPrestamo++,
//                            new Date(), fechaFin,
//                            usuarios.get(numUs - 1),
//                            disponibles.get(numLib - 1));
//                    prestamos.add(prestamo);
//                    usuarios.get(numUs - 1).solicitarPrestamo(prestamo);
//                    System.out.println("Estado: " + disponibles.get(numLib - 1));
//                    break;
//
//                case 5:
//                    
//                    System.out.println("\n--- Cerrar Prestamo ---");
//
//                    List<Prestamo> activos = new ArrayList<>();
//                    for (int i = 0; i < prestamos.size(); i++) {
//                        if (!prestamos.get(i).getLibro().isDisponible()) {
//                            activos.add(prestamos.get(i));
//                        }
//                    }
//                    if (activos.size() == 0) {
//                        System.out.println("No hay prestamos activos.");
//                        break;
//                    }
//                    System.out.println("Prestamos activos:");
//                    for (int i = 0; i < activos.size(); i++) {
//                        System.out.println("  " + (i + 1) + ". Prestamo #"
//                                + activos.get(i).getCodigo()
//                                + " - " + activos.get(i).getLibro().getTitulo()
//                                + " - " + activos.get(i).getUsuario().getNombre()
//                                + " " + activos.get(i).getUsuario().getApellido());
//                    }
//                    
//                    int numPres = -1;
//                    while(numPres<1 || numPres>activos.size()){
//                        System.out.print("Seleccione prestamo a cerrar (numero): ");
//                        numPres = sc.nextInt();
//                        sc.nextLine();
//
//                        if (numPres < 1 || numPres > activos.size()) {
//                            System.out.println("Opcion invalida");
//                            break;
//                        }
//                    }
//                    
//                    activos.get(numPres - 1).cerrarPrestamo();
//                    break;
//
//                case 6:
//
//                    System.out.println("\n--- Devolver Libro ---");
//
//                    if (usuarios.size() == 0) {
//                        System.out.println("No hay usuarios registrados");
//                        break;
//                    }
//                    
//                    List<Libro> prestados = new ArrayList<>();
//                    for (int i = 0; i < libros.size(); i++) {
//                        if (!libros.get(i).isDisponible()) {
//                            prestados.add(libros.get(i));                            
//                        }   
//                    }
//                    
//                    if (prestados.size() == 0) {
//                        System.out.println("No hay libros prestados");
//                        break;
//                    }
//
//                    System.out.println("Usuarios:");
//                    for (int i = 0; i < usuarios.size(); i++) {
//                        System.out.println("  " + (i + 1) + ". "
//                                + usuarios.get(i).getNombre()
//                                + " " + usuarios.get(i).getApellido());
//                    }
//                    
//                    int numUsD = -1;
//                    while(numUsD<1 || numUsD>usuarios.size()){
//                        System.out.print("Seleccione usuario (numero): ");
//                        numUsD = sc.nextInt();
//                        sc.nextLine();
//
//                        if (numUsD < 1 || numUsD > usuarios.size()) {
//                            System.out.println("Opcion invalida");
//                            break;
//                        }
//                    }
//                
//                    System.out.println("Libros prestados:");
//                    for (int i = 0; i < prestados.size(); i++) {
//                        System.out.println("  " + (i + 1) + ". "
//                                + prestados.get(i).getTitulo());
//                    }
//                    
//                    int numLibD = -1;
//                    while(numLibD<1 || numLibD>prestados.size()){
//                        System.out.print("Seleccione libro a devolver (numero): ");
//                        numLibD = sc.nextInt();
//                        sc.nextLine();
//
//                        if (numLibD < 1 || numLibD > prestados.size()) {
//                            System.out.println("Opcion invalida");
//                            break;
//                        }
//                    }
//                    
//                    usuarios.get(numUsD - 1).devolverLibro(prestados.get(numLibD - 1));
//                    break;
//
//                case 7:
//
//                    System.out.println("\n--- Editar Libro ---");
//
//                    if (libros.size() == 0) {
//                        System.out.println("No hay libros registrados.");
//                        break;
//                    }
//                    System.out.println("Libros:");
//                    for (int i = 0; i < libros.size(); i++) {
//                        System.out.println("  " + (i + 1) + ". "
//                                + libros.get(i).getTitulo());
//                    }
//                    
//                    int numLibE = -1;
//                    while(numLibE<1 || numLibE>libros.size()){
//                        System.out.print("Seleccione libro (numero): ");
//                        numLibE = sc.nextInt();
//                        sc.nextLine();
//
//                        if (numLibE < 1 || numLibE > libros.size()) {
//                            System.out.println("Opcion invalida");
//                            break;
//                        }
//                    }
//                    
//                    Libro libroEditar = libros.get(numLibE - 1);
//                    System.out.println("Datos actuales:");
//                    System.out.println("  Titulo : " + libroEditar.getTitulo());
//                    System.out.println("  Genero : " + libroEditar.getGenero());
//                    System.out.println("  Idioma : " + libroEditar.getIdioma());
//
//                    System.out.print("Nuevo titulo: ");
//                    String nuevoTitulo = sc.nextLine();
//                    System.out.print("Nuevo genero: ");
//                    String nuevoGenero = sc.nextLine();
//                    System.out.print("Nuevo idioma: ");
//                    String nuevoIdioma = sc.nextLine();
//
//                    libroEditar.editarDatos(nuevoTitulo, nuevoGenero, nuevoIdioma);
//                    break;
//
//                case 8:
//
//                    System.out.println("\n--- Lista de Libros ---");
//                    if (libros.size() == 0) {
//                        System.out.println("No hay libros registrados.");
//                        break;
//                    }
//                    for (int i = 0; i < libros.size(); i++) {
//                        libros.get(i).obtenerInfo();
//                    }
//                    break;
//
//                case 9:
//                   
//                    System.out.println("\n--- Lista de Usuarios ---");
//                    if (usuarios.size() == 0) {
//                        System.out.println("No hay usuarios registrados.");
//                        break;
//                    }
//                    for (int i = 0; i < usuarios.size(); i++) {
//                        System.out.println("  " + usuarios.get(i));
//                    }
//                    break;
//
//                case 10:
//                   
//                    System.out.println("\n--- Lista de Prestamos ---");
//                    if (prestamos.size() == 0) {
//                        System.out.println("No hay prestamos registrados.");
//                        break;
//                    }
//                    for (int i = 0; i < prestamos.size(); i++) {
//                        System.out.println("  " + prestamos.get(i));
//                    }
//                    break;
//
//                case 0:
//                    System.out.println("\nHasta luego!");
//                    break;
//
//                default:
//                    System.out.println("Opcion invalida.");
//            }
//        }
//
//        sc.close();
//    }
}
