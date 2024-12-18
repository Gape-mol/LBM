package GUI;

import Model.Biblioteca;
import Model.Prestamo;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfazHistorial extends JFrame {

    private Biblioteca biblioteca;  // Instancia de la clase Biblioteca
    private Usuario usuario;  // Instancia de la clase Usuario

    public InterfazHistorial(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;

        setTitle("Historial de Préstamos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear un área de texto para mostrar el historial
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Cargar el historial de préstamos del usuario
        cargarHistorial(usuario, textArea);

        // Botón para volver a la ventana principal
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            InterfazPrincipal interfazPrincipal = new InterfazPrincipal(biblioteca);
            interfazPrincipal.setVisible(true);
            setVisible(false); // Ocultar esta ventana
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnVolver);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarHistorial(Usuario usuario, JTextArea textArea) {
        List<Prestamo> historial = usuario.getPrestamos();
        if (historial.isEmpty()) {
            textArea.append("No hay préstamos registrados.\n");
        } else {
            textArea.append("Historial de Préstamos de " + usuario.getNombre() + ":\n");
            for (Prestamo prestamo : historial) {
                textArea.append(prestamo.toString() + "\n");
            }
        }
    }
}
