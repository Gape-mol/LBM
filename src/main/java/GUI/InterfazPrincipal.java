package GUI;

import Model.Biblioteca;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame {

    private Biblioteca biblioteca;  // Instancia de la clase Biblioteca
    private Usuario usuario;  // Instancia de la clase Usuario (Se necesita para las reviews y estaba  contemplado que hay que crear una pantalla de login)

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
        JButton btnAgregarReview = new JButton("Agregar Reseña");
        JButton btnModificarReview = new JButton("Modificar Reseña");
        JButton btnEliminarReview = new JButton("Eliminar Reseña");
        JButton btnMostarReviews = new JButton("Mostrar Reseñas");
        JButton btnHistorial = new JButton("Mostrar Historial");
        JButton btnPrestamo = new JButton("Realizar Prestamo");

        add(btnCrearLibro);
        add(btnModificarLibro);
        add(btnEliminarLibro);
        add(btnBuscarLibro);
        add(btnMostrarBiblioteca);
        add(btnAgregarReview);
        add(btnModificarReview);
        add(btnEliminarReview);
        add(btnMostarReviews);
        add(btnHistorial);
        add(btnPrestamo);

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
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para mostrar la biblioteca
                InterfazMostrarBiblioteca mostrarBibliotecaFrame = new InterfazMostrarBiblioteca(biblioteca);
                mostrarBibliotecaFrame.setVisible(true);
                // Pasar la instancia de Biblioteca
                if (mostrarBibliotecaFrame.isVisible()) { // Solo oculta la principal si la nueva ventana se muestra
                    setVisible(false);
                }
            }
        });

        // Acción para agregar review
        btnAgregarReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para agregar review
                InterfazAgregarReview agregarReviewFrame = new InterfazAgregarReview(biblioteca, usuario);  // Pasar la instancia de Biblioteca
                agregarReviewFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para modificar reseña
        btnModificarReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazModificarReview modificarReviewFrame = new InterfazModificarReview(biblioteca, usuario);  // Ventana para modificar reseña
                modificarReviewFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para eliminar reseña
        btnEliminarReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazEliminarReview eliminarReviewFrame = new InterfazEliminarReview(biblioteca, usuario);  // Ventana para eliminar reseña
                eliminarReviewFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para mostrar reseñas
        btnMostarReviews.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para mostrar reseñas
                InterfazMostrarReview mostrarReviewFrame = new InterfazMostrarReview(biblioteca);
                mostrarReviewFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para mostrar el historial de préstamos
                InterfazHistorial historialPrestamosFrame = new InterfazHistorial(biblioteca, usuario);
                historialPrestamosFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para gestionar préstamos
        btnPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazPrestamo gestionarPrestamosFrame = new InterfazPrestamo(biblioteca, usuario); // Pasar la instancia de Biblioteca y Usuario
                gestionarPrestamosFrame.setVisible(true);
                setVisible(false); // Ocultar la ventana principal
            }
        });
    }

    public static void main(String[] args) {
        // Crear una instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Calle Ficticia 123");
        Usuario usuario1 = new Usuario("Usuario", 21345);

        // Ejecutar la interfaz principal con la biblioteca creada
        SwingUtilities.invokeLater(() -> {
            InterfazPrincipal principal = new InterfazPrincipal(biblioteca);
            principal.setVisible(true);
        });
    }
}
