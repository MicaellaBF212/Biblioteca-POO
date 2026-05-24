/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca1.clases;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class BibliotecaIG {
    private List<Autor> autores = new ArrayList<>();
    private List<Libro> libros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    private Bibliotecario bibliotecario = null;
    private int codigoPrestamo = 1001;
    private TextArea areaResultado;
    
    public BibliotecaIG(){
        Frame ventana = new Frame("Proyecto: Sistema Biblioteca");
        ventana.setSize(400,250);
        ventana.setLocation(350,200);
        ventana.setLayout(new BorderLayout());
        
        Panel centro = new Panel(new GridLayout(3,1,0,15));
        Label lblTitulo = new Label("Sistema de Biblioteca", Label.CENTER);
        Panel panelBtn = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button btnIniciar = new Button("  Iniciar  ");
        panelBtn.add(btnIniciar);
        
        centro.add(lblTitulo);
        centro.add(panelBtn);
        ventana.add(new Panel(), BorderLayout.NORTH);
        ventana.add(centro, BorderLayout.CENTER);
        ventana.add(new Panel(), BorderLayout.SOUTH);
        
        btnIniciar.addActionListener(e -> {
            ventana.dispose();
            registroBibliotecario();
        });
        
        ventana.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        ventana.setVisible(true);
    }
    
    private void registroBibliotecario(){
        Frame ventana = new Frame("Registro del Bibliotecario");
        ventana.setSize(420, 310);
        ventana.setLocation(350,230);
        ventana.setLayout(new BorderLayout(5,5));
        
        Panel norte = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lbl = new Label("Ingrese los datos del Bibliotecario");
        norte.add(lbl);
        
        Panel menu = new Panel(new GridLayout(6,2,5,5));
        TextField txtId = new TextField(20);
        TextField txtNombre = new TextField(20);
        TextField txtApellido = new TextField(20);
        TextField txtCedula = new TextField(20);
        TextField txtEdad = new TextField(20);
        TextField txtHorario = new TextField(20);
        menu.add(new Label("-ID:")); 
        menu.add(txtId);
        menu.add(new Label("-Nombre:")); 
        menu.add(txtNombre);
        menu.add(new Label("-Apellido:")); 
        menu.add(txtApellido);
        menu.add(new Label("-Cedula:")); 
        menu.add(txtCedula);
        menu.add(new Label("-Edad:")); 
        menu.add(txtEdad);
        menu.add(new Label("-Horario:")); 
        menu.add(txtHorario);
        
        Panel sur = new Panel(new BorderLayout());
        Label lblError = new Label("", Label.CENTER);
        Panel panelBtn = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button btnRegistrar = new Button("Registrar datos");
        panelBtn.add(btnRegistrar);
        sur.add(lblError, BorderLayout.NORTH);
        sur.add(panelBtn, BorderLayout.CENTER);
        ventana.add(norte, BorderLayout.NORTH);
        ventana.add(menu, BorderLayout.CENTER);
        ventana.add(sur, BorderLayout.SOUTH);
        
        btnRegistrar.addActionListener(e->{
            String id = txtId.getText().trim();
            String nom = txtNombre.getText().trim();
            String ape = txtApellido.getText().trim();
            String ced = txtCedula.getText().trim();
            String hor = txtHorario.getText().trim();
            
            if (id.isEmpty() || nom.isEmpty() || ced.isEmpty() || ape.isEmpty()){
                lblError.setText("ID, Nombre, Apellido y Cedula son obligatorios");
                return;
            }
            try {
                int edad = Integer.parseInt(txtEdad.getText().trim());
                this.bibliotecario = new Bibliotecario(id, nom, ape, ced, edad, hor);
                ventana.dispose();
                menuPrincipal();
            } catch (NumberFormatException ex) {
                lblError.setText("Edad debe ser un numero");
            }
        });
        ventana.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        ventana.setVisible(true);  
    }
    
    private void menuPrincipal(){
        Frame ventana = new Frame("Menu Principal");
        ventana.setSize(660,560);
        ventana.setLocation(350, 100);
        ventana.setLayout(new BorderLayout(5,5));
        
        Panel norte = new Panel(new GridLayout(2,1));
        Label lblTitulo = new Label("Sistema de gestion de Biblioteca", Label.CENTER);
        Label lblBib = new Label("Bibliotecario: "+bibliotecario.getNombre()+ 
                " "+bibliotecario.getApellido()+"  Horario:"+bibliotecario.getHorario(),Label.CENTER);
        norte.add(lblTitulo);
        norte.add(lblBib);
        
        Panel menu = new Panel(new GridLayout(4,3,8,8));
        Button btn1 = new Button("1. Registrar Autor");
        Button btn2 = new Button("2. Registrar Libro");
        Button btn3 = new Button("3. Registrar Usuario");
        Button btn4 = new Button("4. Realizar Prestamo");
        Button btn5 = new Button("5. Cerrar Prestamo");
        Button btn6 = new Button("6. Devolver Libro");
        Button btn7 = new Button("7. Editar Libro");
        Button btn8 = new Button("8. Ver Libros");
        Button btn9 = new Button("9. Ver Usuarios");
        Button btn10 = new Button("10. Ver Prestamos");
        Button btnSalir = new Button("0. Salir");
        menu.add(btn1);
        menu.add(btn2);
        menu.add(btn3);
        menu.add(btn4);
        menu.add(btn5);
        menu.add(btn6);
        menu.add(btn7);
        menu.add(btn8);
        menu.add(btn9);
        menu.add(btn10);
        menu.add(new Label(""));
        menu.add(btnSalir);
        
        Panel sur = new Panel(new BorderLayout());
        sur.add(new Label("Resultados:"), BorderLayout.NORTH);
        areaResultado = new TextArea("Bibliotecario registrado: " 
                +bibliotecario+ "\n", 9,72,TextArea.SCROLLBARS_VERTICAL_ONLY);
        areaResultado.setEditable(false);
        sur.add(areaResultado, BorderLayout.CENTER);
        ventana.add(norte, BorderLayout.NORTH);
        ventana.add(menu, BorderLayout.CENTER);
        ventana.add(sur, BorderLayout.SOUTH);
        
        btn1.addActionListener(e->registrarAutor());
        btn2.addActionListener(e->registrarLibro());
        btn3.addActionListener(e->registrarUsuario());
        btn4.addActionListener(e->realizarPrestamo());
        btn5.addActionListener(e->cerrarPrestamo());
        btn6.addActionListener(e->devolverLibro());
        btn7.addActionListener(e->editarLibro());
        btn8.addActionListener(e->verLibros());
        btn9.addActionListener(e->verUsuarios());
        btn10.addActionListener(e->verPrestamos());
        btnSalir.addActionListener(e->System.exit(0));
        
        ventana.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        ventana.setVisible(true);
    }
    
    public void registrarAutor(){
        Frame ventana = nuevaVentana("Registrar Autor",400,230);
       
        Panel menu = new Panel(new GridLayout(3,2,5,8));
        TextField txtNombre = new TextField(20);
        TextField txtApellido = new TextField(20);
        TextField txtNacionalidad = new TextField(20);
        menu.add(new Label("-Nombre:"));
        menu.add(txtNombre);
        menu.add(new Label("-Apellido:"));
        menu.add(txtApellido);
        menu.add(new Label("-Nacionalidad:"));
        menu.add(txtNacionalidad);
        
        Panel sur = botones(ventana,"Registrar",e->{
            String nom = txtNombre.getText().trim();
            if(nom.isEmpty()){
                mostrar("Error: El nombre es obligatorio");
                return;
            }
            Autor a = new Autor(nom, txtApellido.getText().trim(), 
                    txtNacionalidad.getText().trim());
            autores.add(a);
            mostrar("Autor registrado: "+a);
            limpiar(txtNombre,txtApellido,txtNacionalidad);
        });
        
        ventana.add(panelTitulo("----- Registrar Autor -----"), BorderLayout.NORTH);
        ventana.add(menu, BorderLayout.CENTER);
        ventana.add(sur, BorderLayout.SOUTH);
        ventana.setVisible(true);
    }
    
    public void registrarLibro(){
        if(autores.isEmpty()){
            mostrar("Primero registre un autor");
            return;
        }
        Frame ventana = nuevaVentana("Registrar Libro", 480,420);
        Panel menu = new Panel(new GridLayout(8,2,5,8));
        TextField txtTitulo = new TextField(20);
        TextField txtGenero = new TextField(20);
        TextField txtIdioma = new TextField(20);
        TextField txtPags = new TextField(20);
        TextField txtIsbn = new TextField(20);
        TextField txtEditorial = new TextField(20);
        TextField txtPais = new TextField(20);
        
        java.awt.List listaAutores = new java.awt.List(3);
        for(Autor a : autores){
            listaAutores.add(a.getNombre()+" "+a.getApellido());
        }
        listaAutores.select(0);
        
        menu.add(new Label("-Titulo:"));
        menu.add(txtTitulo);
        menu.add(new Label("-Genero:"));
        menu.add(txtGenero);
        menu.add(new Label("-Idioma:"));
        menu.add(txtIdioma);
        menu.add(new Label("-# Paginas:"));
        menu.add(txtPags);
        menu.add(new Label("-ISB:"));
        menu.add(txtIsbn);
        menu.add(new Label("-Editorial:"));
        menu.add(txtEditorial);
        menu.add(new Label("-Pais Editorial:"));
        menu.add(txtPais);
        menu.add(new Label("-Seleccionar Autor:"));
        menu.add(listaAutores);
        
        Panel sur = botones(ventana, "Registrar", e->{
            try{
                String tit = txtTitulo.getText().trim();
                String isbn = txtIsbn.getText().trim();
                if(tit.isEmpty() || isbn.isEmpty()){
                    mostrar("Error: Titulo e ISBN son obligatorios");
                    return;
                }
                int idx = listaAutores.getSelectedIndex();
                if(idx<0){
                    mostrar("ERROR: Seleccione un Autor");
                    return;
                }
                int pags = txtPags.getText().trim().isEmpty()?0
                        : Integer.parseInt(txtPags.getText().trim());
                Libro libro = new Libro(tit, new Date(),txtGenero.getText().trim(), 
                        txtIdioma.getText().trim(),pags,isbn, 
                        txtEditorial.getText().trim(), txtPais.getText().trim());
                libro.agregarAutor(autores.get(idx));
                libros.add(libro);
                mostrar("Libro registrado: "+libro);
                limpiar(txtTitulo, txtGenero, txtIdioma, txtPags, txtIsbn, txtEditorial, txtPais);
            }catch(NumberFormatException ex){
                mostrar("ERROR: n de paginas debe ser un numero");
            }
        });
        
        ventana.add(panelTitulo("----- Registrar Libro -----"), BorderLayout.NORTH);
        ventana.add(menu, BorderLayout.CENTER);
        ventana.add(sur, BorderLayout.SOUTH);
        ventana.setVisible(true);
        
    }
    
    public void registrarUsuario(){
        Frame ventana = nuevaVentana("Registrar Usuario", 420,310);
        Panel menu = new Panel(new GridLayout(6,2,5,8));
        TextField txtNombre = new TextField(20);
        TextField txtApellido = new TextField(20);
        TextField txtCedula = new TextField(20);
        TextField txtEdad = new TextField(20);
        TextField txtCorreo = new TextField(20);
        TextField txtClave = new TextField(20);
        menu.add(new Label("-Nombre:"));
        menu.add(txtNombre);
        menu.add(new Label("-Apellido:"));
        menu.add(txtApellido);
        menu.add(new Label("-Cedula:"));
        menu.add(txtCedula);
        menu.add(new Label("-Edad:"));
        menu.add(txtEdad);
        menu.add(new Label("-Correo:"));
        menu.add(txtCorreo);
        menu.add(new Label("-Contrasena:"));
        menu.add(txtClave);
        
        Panel sur = botones(ventana, "Registrar", e->{
            try{
                String nom = txtNombre.getText().trim();
                String ced = txtCedula.getText().trim();
                if(nom.isEmpty() || ced.isEmpty()){
                    mostrar("ERROR: Nombre y Cedula son obligatorios");
                    return;
                }
                int edad = Integer.parseInt(txtEdad.getText().trim());
                Usuario u = new Usuario(nom, txtApellido.getText().trim(), ced, 
                        edad, txtCorreo.getText().trim(), txtClave.getText().trim());
                usuarios.add(u);
                bibliotecario.registrarUsuario(u);
                mostrar("Usuario registrado: "+u);
                limpiar(txtNombre,txtApellido,txtCedula,txtEdad,txtCorreo,txtClave);
            }catch(NumberFormatException ex){
                mostrar("ERROR: Edad debe ser un numero");
            }
        });
        
        ventana.add(panelTitulo("----- Registrar Usuario -----"), BorderLayout.NORTH);
        ventana.add(menu, BorderLayout.CENTER);
        ventana.add(sur, BorderLayout.SOUTH);
        ventana.setVisible(true);
    }
    
    public void realizarPrestamo(){
        if (usuarios.isEmpty()) { 
            mostrar("Primero registre un usuario"); 
            return; 
        }
        List<Libro> disponibles = new ArrayList<>();
        for (Libro l : libros){
            if (l.isDisponible()){
                disponibles.add(l);
            }
        }
        if (disponibles.isEmpty()){
            mostrar("No hay libros disponibles");
            return; 
        }
 
        Frame ventana = nuevaVentana("Realizar Prestamo", 450,290);
        Panel menu = new Panel(new GridLayout(3,2,5,8));
        java.awt.List listaUsuarios = new java.awt.List(3);
        for (Usuario u : usuarios){
            listaUsuarios.add(u.getNombre() + " " + u.getApellido());
        }
        listaUsuarios.select(0);
        java.awt.List listaLibros = new java.awt.List(3);
        for (Libro l : disponibles){
            listaLibros.add(l.getTitulo());
        }
        listaLibros.select(0);
 
        TextField txtDias = new TextField(20);
        menu.add(new Label("-Seleccionar Usuario:")); 
        menu.add(listaUsuarios);
        menu.add(new Label("-Seleccionar Libro:"));   
        menu.add(listaLibros);
        menu.add(new Label("-Dias de Prestamo:"));    
        menu.add(txtDias);
 
        Panel sur = botones(ventana, "Registrar Prestamo", e -> {
            int idxU = listaUsuarios.getSelectedIndex();
            int idxL = listaLibros.getSelectedIndex();
            if (idxU<0){ 
                mostrar("ERROR: Seleccione un usuario"); 
                return; 
            }
            if (idxL<0){ 
                mostrar("ERROR: Seleccione un libro"); 
                return; 
            }
            try {
                int dias = Integer.parseInt(txtDias.getText().trim());
                Date ini = new Date();
                Date fin = new Date(System.currentTimeMillis()+ (long) 
                        dias * 24 * 60 * 60 * 1000);
                Prestamo p = new Prestamo(codigoPrestamo++, ini, fin,
                        usuarios.get(idxU), disponibles.get(idxL));
                prestamos.add(p);
                usuarios.get(idxU).solicitarPrestamo(p);
                mostrar("Prestamo realizado:\n" + p
                        + "\nEstado libro: " + disponibles.get(idxL));
                ventana.dispose();
            } catch (NumberFormatException ex) {
                mostrar("ERROR: Dias debe ser un numero");
            }
        });
        
        ventana.add(panelTitulo("----- Realizar Prestamo -----"), BorderLayout.NORTH);
        ventana.add(menu, BorderLayout.CENTER);
        ventana.add(sur,  BorderLayout.SOUTH);
        ventana.setVisible(true);
    }
    
    public void cerrarPrestamo(){
        List<Prestamo> activos = new ArrayList<>();
        for (Prestamo p : prestamos){
            if (!p.getLibro().isDisponible()){
                activos.add(p);
            }
        }
        if (activos.isEmpty()){ 
            mostrar("No hay prestamos activos"); 
            return; 
        }
 
        Frame ventana = nuevaVentana("Cerrar Prestamo", 450,210);
        Panel menu = new Panel(new GridLayout(1,2,5,8));
        java.awt.List listaPrestamos = new java.awt.List(4);
        for (Prestamo p : activos){
            listaPrestamos.add("#" + p.getCodigo()
                    + " - " + p.getLibro().getTitulo()
                    + " - " + p.getUsuario().getNombre());
        }    
        listaPrestamos.select(0);
        menu.add(new Label("Prestamos activos:")); 
        menu.add(listaPrestamos);
 
        Panel sur = botones(ventana, "Cerrar Prestamo", e -> {
            int idx = listaPrestamos.getSelectedIndex();
            if (idx<0) { 
                mostrar("ERROR: Seleccione un prestamo."); 
                return; 
            }
            activos.get(idx).cerrarPrestamo();
            mostrar("Prestamo #" + activos.get(idx).getCodigo() + " cerrado.\n"
                    + "Libro \"" + activos.get(idx).getLibro().getTitulo()
                    + "\" devuelto.");
            ventana.dispose();
        });
 
        ventana.add(panelTitulo("----- Cerrar Prestamo -----"), BorderLayout.NORTH);
        ventana.add(menu, BorderLayout.CENTER);
        ventana.add(sur,  BorderLayout.SOUTH);
        ventana.setVisible(true);
        
    }
    
    public void devolverLibro(){
        if (usuarios.isEmpty()){ 
            mostrar("No hay usuarios registrados"); 
            return; 
        }
        List<Libro> prestados = new ArrayList<>();
        for (Libro l : libros){
            if (!l.isDisponible()){
                prestados.add(l);
            }
        }
        if (prestados.isEmpty()){ 
            mostrar("No hay libros prestados"); 
            return; 
        }
 
        Frame ventana = nuevaVentana("Devolver Libro", 450,240);
        Panel menu = new Panel(new GridLayout(2,2,5,8));
        java.awt.List listaUsuarios = new java.awt.List(3);
        for (Usuario u : usuarios){
            listaUsuarios.add(u.getNombre() + " " + u.getApellido());
        }
        listaUsuarios.select(0);
 
        java.awt.List listaLibros = new java.awt.List(3);
        for (Libro l : prestados){
            listaLibros.add(l.getTitulo());
        }
        listaLibros.select(0);
        menu.add(new Label("-Seleccionar Usuario:")); 
        menu.add(listaUsuarios);
        menu.add(new Label("-Libro a devolver:"));    
        menu.add(listaLibros);
 
        Panel sur = botones(ventana, "Devolver", e -> {
            int idxU = listaUsuarios.getSelectedIndex();
            int idxL = listaLibros.getSelectedIndex();
            if (idxU<0 || idxL<0) {
                mostrar("ERROR: Seleccione usuario y libro"); 
                return;
            }
            usuarios.get(idxU).devolverLibro(prestados.get(idxL));
            mostrar("Libro \"" + prestados.get(idxL).getTitulo()
                    + "\" devuelto por "
                    + usuarios.get(idxU).getNombre() + " "
                    + usuarios.get(idxU).getApellido() + ".");
            ventana.dispose();
        });
 
        ventana.add(panelTitulo("----- Devolver Libro -----"), BorderLayout.NORTH);
        ventana.add(menu, BorderLayout.CENTER);
        ventana.add(sur,  BorderLayout.SOUTH);
        ventana.setVisible(true);
    }
    
    public void editarLibro(){
        if (libros.isEmpty()){ 
            mostrar("No hay libros registrados"); 
            return; 
        }
 
        Frame ventana = nuevaVentana("Editar Libro", 460,320);
        Panel menu = new Panel(new GridLayout(4,2,5,8));
        java.awt.List listaLibros = new java.awt.List(3);
        for (Libro l : libros){
            listaLibros.add(l.getTitulo());
        }
        listaLibros.select(0);
        TextField txtNuevoTitulo = new TextField(20);
        TextField txtNuevoGenero = new TextField(20);
        TextField txtNuevoIdioma = new TextField(20);
        txtNuevoTitulo.setText(libros.get(0).getTitulo());
        txtNuevoGenero.setText(libros.get(0).getGenero());
        txtNuevoIdioma.setText(libros.get(0).getIdioma());
        
        listaLibros.addItemListener(e -> {
            int idx = listaLibros.getSelectedIndex();
            if (idx>=0) {
                txtNuevoTitulo.setText(libros.get(idx).getTitulo());
                txtNuevoGenero.setText(libros.get(idx).getGenero());
                txtNuevoIdioma.setText(libros.get(idx).getIdioma());
            }
        });
        menu.add(new Label("-Seleccionar Libro:")); 
        menu.add(listaLibros);
        menu.add(new Label("-Nuevo Titulo:"));      
        menu.add(txtNuevoTitulo);
        menu.add(new Label("-Nuevo Genero:"));      
        menu.add(txtNuevoGenero);
        menu.add(new Label("-Nuevo Idioma:"));      
        menu.add(txtNuevoIdioma);
 
        Panel sur = botones(ventana, "Guardar Cambios", e -> {
            int idx = listaLibros.getSelectedIndex();
            if (idx<0){ 
                mostrar("ERROR: Seleccione un libro"); 
                return; 
            }
            String tit = txtNuevoTitulo.getText().trim();
            if (tit.isEmpty()){ 
                mostrar("ERROR: El titulo no puede estar vacio"); 
                return; 
            }
            libros.get(idx).editarDatos(tit,
                    txtNuevoGenero.getText().trim(),
                    txtNuevoIdioma.getText().trim());
            mostrar("Libro actualizado:\n" + libros.get(idx));
            ventana.dispose();
        });
 
        ventana.add(panelTitulo("----- Editar Libro -----"), BorderLayout.NORTH);
        ventana.add(menu, BorderLayout.CENTER);
        ventana.add(sur,  BorderLayout.SOUTH);
        ventana.setVisible(true);
        
    }
    
    public void verLibros(){
        if (libros.isEmpty()){ 
            mostrar("No hay libros registrados"); 
            return; 
        }
        StringBuilder sb = new StringBuilder("----- Lista de Libros -----\n");
        for (Libro l : libros){
            sb.append(l.obtenerInfo()).append("\n");
        }
        mostrar(sb.toString());
    }
    
    public void verUsuarios(){
        if (usuarios.isEmpty()){ 
            mostrar("No hay usuarios registrados"); 
            return; 
        }
        StringBuilder sb = new StringBuilder("----- Lista de Usuarios -----\n");
        for (Usuario u : usuarios){
            sb.append(u).append("\n");
        }
        mostrar(sb.toString());
    }
    
    public void verPrestamos(){
        if (prestamos.isEmpty()){ 
            mostrar("No hay prestamos registrados"); 
            return; }
        StringBuilder sb = new StringBuilder("----- Lista de Prestamos -----\n");
        for (Prestamo p : prestamos){
            sb.append(p).append("\n");
        }
        mostrar(sb.toString());
    }
    
    //Metodos auxiliares)
    private Frame nuevaVentana(String titulo, int ancho, int alto){
        Frame ventana = new Frame(titulo);
        ventana.setSize(ancho,alto);
        ventana.setLocation(500,180);
        ventana.setLayout(new BorderLayout(5,5));
        ventana.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                ventana.dispose();
            }
        });
        return ventana;
    }
    
    private Panel panelTitulo(String texto){
        Panel panel = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lbl = new Label(texto);
        panel.add(lbl);
        return panel;
    }
    
    private Panel botones(Frame ventana, String labelAccion, ActionListener accion){
        Panel panel = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button b1 = new Button(labelAccion);
        Button bc = new Button("Cerrar");
        b1.addActionListener(accion);
        bc.addActionListener(e->ventana.dispose());
        panel.add(b1);
        panel.add(bc);
        return panel;
    }
    
    private void mostrar(String texto){
        areaResultado.setText(texto);
    }
    
    //Argumentos Variables
    //Los puntos significan que se puede recibir cualquier cantidad de textfield
    private void limpiar(TextField... campos){
        for(TextField tf : campos){
            tf.setText("");
        }
    }
    
}
