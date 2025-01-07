package GUI;

import Model.Biblioteca;
import Model.Prestamo;
import Model.Libro;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa la interfaz gráfica para gestionar préstamos de libros.
 * Permite registrar préstamos asociados a un usuario específico en la biblioteca.
 */
public class InterfazPrestamo extends JFrame {

    private Biblioteca biblioteca; // Instancia de la biblioteca que contiene la colección de libros
    private Usuario usuario; // Usuario asociado al préstamo
    private JTextField txtFechaPrestamo; // Campo de texto para ingresar la fecha de préstamo
    private JTextField txtFechaDevolucion; // Campo de texto para ingresar la fecha de devolución
    private JTextField txtLibro; // Campo de texto para ingresar el ISBN del libro

    /**
     * Constructor de la clase InterfazPrestamo.
     * Configura los componentes de la interfaz y define las acciones asociadas.
     *
     * @param biblioteca Objeto de tipo {@link Biblioteca} que contiene los datos de la biblioteca.
     * @param usuario    Objeto de tipo {@link Usuario} que realizará el préstamo.
     */
    public InterfazPrestamo(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        setTitle("Gestionar Préstamos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        // Etiquetas y campos de texto
        JLabel lblFechaPrestamo = new JLabel("Fecha de Préstamo (dd/MM/yyyy):");
        JLabel lblFechaDevolucion = new JLabel("Fecha de Devolución (dd/MM/yyyy):");
        JLabel lblLibro = new JLabel("ISBN del Libro:");

        txtFechaPrestamo = new JTextField();
        txtFechaDevolucion = new JTextField();
        txtLibro = new JTextField();

        // Botones de acción
        JButton btnRealizarPrestamo = new JButton("Realizar Préstamo");
        JButton btnVolver = new JButton("Volver");

        // Agregar los componentes a la ventana
        add(lblFechaPrestamo);
        add(txtFechaPrestamo);
        add(lblFechaDevolucion);
        add(txtFechaDevolucion);
        add(lblLibro);
        add(txtLibro);
        add(btnRealizarPrestamo);
        add(btnVolver);

        /**
         * Acción asociada al botón "Realizar Préstamo".
         * Valida los datos ingresados, busca el libro por su ISBN y registra el préstamo.
         * En caso de error, muestra un mensaje informativo al usuario.
         */
        btnRealizarPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Formateador para convertir las fechas ingresadas como texto
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    // Parseo de las fechas ingresadas
                    Date fechaPrestamo = sdf.parse(txtFechaPrestamo.getText());
                    Date fechaDevolucion = sdf.parse(txtFechaDevolucion.getText());
                    String isbnLibro = txtLibro.getText(); // Obtener el ISBN del libro ingresado

                    // Buscar el libro en la biblioteca por su ISBN
                    Libro libro = biblioteca.buscarLibroPorIsbn(isbnLibro);

                    if (libro != null) {
                        // Crear un objeto de tipo Prestamo y asociarlo al usuario
                        Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDevolucion, libro);
                        usuario.agregarPrestamo(prestamo); // Registrar el préstamo en el historial del usuario
                        JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito!");
                    } else {
                        // Mostrar mensaje si el libro no fue encontrado
                        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                    }
                } catch (Exception ex) {
                    // Manejo de excepciones en caso de errores al procesar las fechas o el préstamo
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al realizar el préstamo.");
                }
            }
        });

        /**
         * Acción asociada al botón "Volver".
         * Cierra la ventana actual y regresa a la ventana principal de la aplicación.
         */
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazPrincipal principalFrame = new InterfazPrincipal(biblioteca); // Crea la ventana principal
                principalFrame.setVisible(true); // Hace visible la ventana principal
                setVisible(false); // Oculta la ventana actual
            }
        });
    }
}
