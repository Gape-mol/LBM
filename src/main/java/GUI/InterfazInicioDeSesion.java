package GUI;

import Model.Biblioteca;
import Model.Usuario;
import Model.UsuarioConectado;
import Data.GestorDeArchivos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase que representa la interfaz gráfica para el inicio de sesión de un usuario.
 * Permite al usuario ingresar su nombre de usuario y contraseña para acceder a la aplicación.
 */
public class InterfazInicioDeSesion extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private Biblioteca biblioteca;
    private ArrayList<Usuario> usuarios;
    private GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();

    /**
     * Constructor de la clase InterfazInicioDeSesion.
     * Inicializa la interfaz gráfica, carga los usuarios y la biblioteca, y configura los botones y campos necesarios.
     */
    public InterfazInicioDeSesion() {
        usuarios = gestorDeArchivos.cargarUsuarios();
        biblioteca = gestorDeArchivos.cargarBiblioteca("Biblioteca", "Calle 123");

        if (biblioteca == null) {
            biblioteca = new Biblioteca("Biblioteca", "Calle 123");
        }

        // Configuración de la ventana de inicio de sesión
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

        /**
         * Acción asociada al botón "Iniciar sesión".
         * Valida el nombre de usuario y la contraseña ingresados y, si son correctos,
         * permite el acceso a la interfaz principal. Si son incorrectos, muestra un mensaje de error.
         */
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

        /**
         * Acción asociada al botón "Cancelar".
         * Cierra la aplicación cuando el usuario decide cancelar el inicio de sesión.
         */
        btnCancelar.addActionListener(e -> {
            System.exit(0);
        });
    }

    /**
     * Valida el nombre de usuario y la contraseña ingresados.
     * Busca al usuario en la lista de usuarios y, si existe, lo devuelve.
     * Si no se encuentra, retorna null.
     *
     * @param nombreUsuario El nombre de usuario ingresado.
     * @param contrasena    La contraseña ingresada.
     * @return El usuario validado, o null si no se encuentra.
     */
    private Usuario validarUsuario(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }
}
