package GUI;

import Model.Biblioteca;
import Model.Usuario;
import Model.UsuarioConectado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la interfaz gráfica principal de la biblioteca.
 * Desde esta ventana se pueden gestionar las operaciones relacionadas con libros, reseñas,
 * préstamos y reservas.
 */
public class InterfazPrincipal extends JFrame {

    private Biblioteca biblioteca;  // Instancia de la clase Biblioteca
    private Usuario usuario;  // Usuario actual conectado a la sesión

    /**
     * Constructor de la clase InterfazPrincipal.
     * Configura los componentes gráficos y define las acciones asociadas a cada botón.
     *
     * @param biblioteca Objeto de tipo {@link Biblioteca} que contiene la información de la biblioteca.
     */
    public InterfazPrincipal(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.usuario = UsuarioConectado.getUsuario(); // Inicializa el usuario conectado.

        setTitle("Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Botones para gestionar libros, reseñas, préstamos, reservas e historial
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
        JButton btnReserva = new JButton("Realizar Reserva");
        JButton btnEstadoReserva = new JButton("Ver Estado de Reserva");
        JButton btnVerReservas = new JButton("Ver Todas las Reservas");

        // Agregar botones a la interfaz
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
        add(btnReserva);
        add(btnEstadoReserva);
        add(btnVerReservas);

        // Configuración de las acciones de los botones

        /**
         * Acción para abrir la interfaz de creación de libros.
         */
        btnCrearLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazCrearLibro crearLibroFrame = new InterfazCrearLibro(biblioteca);
                crearLibroFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de modificación de libros.
         */
        btnModificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazModificarLibro modificarLibroFrame = new InterfazModificarLibro(biblioteca);
                modificarLibroFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de eliminación de libros.
         */
        btnEliminarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazEliminarLibro eliminarLibroFrame = new InterfazEliminarLibro(biblioteca);
                eliminarLibroFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de búsqueda de libros.
         */
        btnBuscarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazBuscarLibro buscarLibroFrame = new InterfazBuscarLibro(biblioteca);
                buscarLibroFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz que muestra todos los libros de la biblioteca.
         */
        btnMostrarBiblioteca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazMostrarBiblioteca mostrarBibliotecaFrame = new InterfazMostrarBiblioteca(biblioteca);
                mostrarBibliotecaFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de agregar reseñas.
         */
        btnAgregarReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazAgregarReview agregarReviewFrame = new InterfazAgregarReview(biblioteca, usuario);
                agregarReviewFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de modificación de reseñas.
         */
        btnModificarReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazModificarReview modificarReviewFrame = new InterfazModificarReview(biblioteca, usuario);
                modificarReviewFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de eliminación de reseñas.
         */
        btnEliminarReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazEliminarReview eliminarReviewFrame = new InterfazEliminarReview(biblioteca, usuario);
                eliminarReviewFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de visualización de reseñas.
         */
        btnMostarReviews.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazMostrarReview mostrarReviewFrame = new InterfazMostrarReview(biblioteca);
                mostrarReviewFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de historial de préstamos del usuario.
         */
        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazHistorial historialPrestamosFrame = new InterfazHistorial(biblioteca, usuario);
                historialPrestamosFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de gestión de préstamos.
         */
        btnPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazPrestamo gestionarPrestamosFrame = new InterfazPrestamo(biblioteca, usuario);
                gestionarPrestamosFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de realización de reservas.
         */
        btnReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazReserva hacerReservaFrame = new InterfazReserva(biblioteca);
                hacerReservaFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz de estado de reservas.
         */
        btnEstadoReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazEstadoReserva verReservaFrame = new InterfazEstadoReserva(biblioteca);
                verReservaFrame.setVisible(true);
                setVisible(false);
            }
        });

        /**
         * Acción para abrir la interfaz que muestra todas las reservas realizadas por el usuario.
         */
        btnVerReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazVerReservas verReservasFrame = new InterfazVerReservas(biblioteca);
                verReservasFrame.setVisible(true);
                setVisible(false);
            }
        });
    }

    /**
     * Método principal para ejecutar la interfaz gráfica de la aplicación.
     * Inicializa la biblioteca y lanza la ventana principal.
     *
     * @param args Argumentos de línea de comandos.
     */
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
