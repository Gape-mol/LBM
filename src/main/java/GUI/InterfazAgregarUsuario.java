package GUI;

import Data.GestorDeArchivos;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfazAgregarUsuario extends JFrame {

    private GestorDeArchivos gestorDeArchivos;
    private ArrayList<Usuario> usuarios;

    public InterfazAgregarUsuario() {
        gestorDeArchivos = new GestorDeArchivos();
        usuarios = gestorDeArchivos.cargarUsuarios();

        setTitle("Agregar Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel labelNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(20);
        JLabel labelIdentificacion = new JLabel("Identificación:");
        JTextField campoIdentificacion = new JTextField(20);
        JCheckBox checkAdmin = new JCheckBox("Administrador");

        JButton btnGuardar = new JButton("Guardar");
        JButton btnVolver = new JButton("Volver");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelNombre)
                                .addComponent(labelIdentificacion)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(campoNombre)
                                .addComponent(campoIdentificacion)
                                .addComponent(checkAdmin)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVolver)
                                        .addComponent(btnGuardar)
                                )
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelNombre)
                                .addComponent(campoNombre)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelIdentificacion)
                                .addComponent(campoIdentificacion)
                        )
                        .addComponent(checkAdmin)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnVolver)
                                .addComponent(btnGuardar)
                        )
        );

        add(panel);

        // Acción para guardar usuario
        btnGuardar.addActionListener(e -> {
            try {
                String nombre = campoNombre.getText();
                int identificacion = Integer.parseInt(campoIdentificacion.getText());
                boolean esAdmin = checkAdmin.isSelected();

                Usuario nuevoUsuario = new Usuario(nombre, identificacion);
                usuarios.add(nuevoUsuario);
                if (!gestorDeArchivos.guardarUsuarios(usuarios)) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el usuario.");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
                    setVisible(false);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "La identificación debe ser un número entero.");
            }
        });

        // Acción para volver
        btnVolver.addActionListener(e -> {
            setVisible(false);
        });
    }
}
