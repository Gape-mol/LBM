package GUI;

import Data.GestorDeArchivos;
import Model.Biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame {

    private Biblioteca biblioteca;  // Instancia de la clase Biblioteca

    public InterfazPrincipal(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;  // Inicializa la biblioteca

        setTitle("Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton btnCrearLibro = new JButton("Crear Libro");
        JButton btnModificarLibro = new JButton("Modificar Libro");
        JButton btnEliminarLibro = new JButton("Eliminar Libro");
        JButton btnBuscarLibro = new JButton("Buscar Libro");
        JButton btnMostrarBiblioteca = new JButton("Mostrar Biblioteca");

        add(btnCrearLibro);
        add(btnModificarLibro);
        add(btnEliminarLibro);
        add(btnBuscarLibro);
        add(btnMostrarBiblioteca);

        // Acción para crear libro
        btnCrearLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para crear libro
                InterfazCrearLibro crearLibroFrame = new InterfazCrearLibro(biblioteca);  // Pasar la instancia de Biblioteca
                crearLibroFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para modificar libro
        btnModificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para modificar libro
                InterfazModificarLibro modificarLibroFrame = new InterfazModificarLibro(biblioteca);  // Pasar la instancia de Biblioteca
                modificarLibroFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para eliminar libro
        btnEliminarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para eliminar libro
                InterfazEliminarLibro eliminarLibroFrame = new InterfazEliminarLibro(biblioteca);  // Pasar la instancia de Biblioteca
                eliminarLibroFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para buscar libro
        btnBuscarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para buscar libro
                InterfazBuscarLibro buscarLibroFrame = new InterfazBuscarLibro(biblioteca);  // Pasar la instancia de Biblioteca
                buscarLibroFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para mostrar biblioteca completa
        btnMostrarBiblioteca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Hay un error en esta funcion,
                // Mostrar la ventana para mostrar la biblioteca
                InterfazMostrarBiblioteca mostrarBibliotecaFrame = new InterfazMostrarBiblioteca(biblioteca);// Pasar la instancia de Biblioteca
                mostrarBibliotecaFrame.setVisible(true);
                if (mostrarBibliotecaFrame.isVisible()) { // Solo oculta la principal si la nueva ventana se muestra
                    setVisible(false);
                }
            }
        });

        GestorDeArchivos gestor = new GestorDeArchivos();
        if (gestor.guardarBiblioteca(this.biblioteca)) {
            System.out.println("Informacion guardada");
        } else {
            System.out.println("Error al guardar");
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Calle Ficticia 123");

        // Ejecutar la interfaz principal con la biblioteca creada
        SwingUtilities.invokeLater(() -> {
            InterfazPrincipal principal = new InterfazPrincipal(biblioteca);
            principal.setVisible(true);
        });
    }

}
