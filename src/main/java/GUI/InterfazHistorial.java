package GUI;

import Model.Biblioteca;
import Model.Prestamo;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Clase que representa la interfaz gráfica para mostrar el historial de préstamos de un usuario.
 */
public class InterfazHistorial extends JFrame {

    private Biblioteca biblioteca;  // Instancia de la biblioteca
    private Usuario usuario;        // Usuario cuyo historial se va a mostrar

    /**
     * Constructor de la interfaz de historial de préstamos.
     *
     * @param biblioteca Objeto Biblioteca que contiene la información general.
     * @param usuario    Objeto Usuario que contiene el historial de préstamos.
     */
    public InterfazHistorial(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        // Configuración básica de la ventana
        setTitle("Historial de Préstamos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Área de texto para mostrar el historial
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Evita la edición del texto
        JScrollPane scrollPane = new JScrollPane(textArea); // Agregar barra de desplazamiento
        add(scrollPane, BorderLayout.CENTER);

        // Cargar el historial de préstamos
        cargarHistorial(usuario, textArea);

        // Botón para regresar a la ventana principal
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            // Mostrar la interfaz principal y cerrar la actual
            InterfazPrincipal interfazPrincipal = new InterfazPrincipal(biblioteca);
            interfazPrincipal.setVisible(true);
            setVisible(false);
        });

        // Panel para contener el botón
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnVolver);
        add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     * Carga el historial de préstamos del usuario y lo muestra en el área de texto.
     *
     * @param usuario  Usuario cuyos préstamos se van a cargar.
     * @param textArea Área de texto donde se mostrará el historial.
     */
    private void cargarHistorial(Usuario usuario, JTextArea textArea) {
        List<Prestamo> historial = usuario.getPrestamos(); // Obtener la lista de préstamos del usuario

        // Verificar si el historial está vacío
        if (historial.isEmpty()) {
            textArea.append("No hay préstamos registrados.\n");
        } else {
            // Agregar título e iterar sobre el historial para mostrarlo
            textArea.append("Historial de Préstamos de " + usuario.getNombre() + ":\n");
            for (Prestamo prestamo : historial) {
                textArea.append(prestamo.toString() + "\n"); // Mostrar cada préstamo en una línea
            }
        }
    }
}
