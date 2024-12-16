package GUI;

import Model.Biblioteca;
import Model.Usuario;
import Model.UsuarioConectado;
import Data.GestorDeArchivos;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;

public class InterfazInicioDeSesion extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private Biblioteca biblioteca;
    private ArrayList<Usuario> usuarios;
    private GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();

    public InterfazInicioDeSesion() {
        usuarios = gestorDeArchivos.cargarUsuarios();
        biblioteca = gestorDeArchivos.cargarBiblioteca("Biblioteca", "Calle 123"); //Esto hay que modificarlo para ver como añadimos nosotros la biblioteca
        if(biblioteca == null){
            biblioteca = new Biblioteca("Biblioteca", "Calle 123");
        }


        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel labelUsuario = new JLabel("Usuario:");
        JLabel labelContrasena = new JLabel("Contraseña:");

        campoUsuario = new JTextField(20);
        campoContrasena = new JPasswordField(20);

        JButton btnLogin = new JButton("Iniciar sesión");
        JButton btnCancelar = new JButton("Cancelar");

        panel.add(labelUsuario);
        panel.add(campoUsuario);
        panel.add(labelContrasena);
        panel.add(campoContrasena);
        panel.add(btnLogin);
        panel.add(btnCancelar);

        add(panel);

        btnLogin.addActionListener(e -> {
            String nombreUsuario = campoUsuario.getText();
            String contrasena = new String(campoContrasena.getPassword());

            Usuario usuario = validarUsuario(nombreUsuario, contrasena);

            if (usuario != null) {
                UsuarioConectado.setUsuario(usuario);
                JOptionPane.showMessageDialog(this, "Bienvenido " + usuario.getNombre());

                setVisible(false);

                InterfazPrincipal principalFrame = new InterfazPrincipal(biblioteca);
                principalFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado o contraseña incorrecta.");
            }
        });

        btnCancelar.addActionListener(e -> {
            System.exit(0);
        });
    }

    private Usuario validarUsuario(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }
}
