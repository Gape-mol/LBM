import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame {

    public InterfazPrincipal() {
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
                InterfazCrearLibro crearLibroFrame = new InterfazCrearLibro();
                crearLibroFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para modificar libro
        btnModificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para modificar libro
                InterfazModificarLibro modificarLibroFrame = new InterfazModificarLibro();
                modificarLibroFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para eliminar libro
        btnEliminarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para eliminar libro
                InterfazEliminarLibro eliminarLibroFrame = new InterfazEliminarLibro();
                eliminarLibroFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para buscar libro
        btnBuscarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para buscar libro
                InterfazBuscarLibro buscarLibroFrame = new InterfazBuscarLibro();
                buscarLibroFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });

        // Acción para mostrar biblioteca completa
        btnMostrarBiblioteca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana para mostrar la biblioteca
                InterfazMostrarBiblioteca mostrarBibliotecaFrame = new InterfazMostrarBiblioteca();
                mostrarBibliotecaFrame.setVisible(true);
                setVisible(false);  // Ocultar la ventana principal
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfazPrincipal principal = new InterfazPrincipal();
                principal.setVisible(true);
            }
        });
    }
}
