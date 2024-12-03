import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazMostrarBiblioteca extends JFrame {

    public InterfazMostrarBiblioteca() {
        setTitle("Mostrar Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea areaBiblioteca = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaBiblioteca);
        areaBiblioteca.setEditable(false);

        JButton btnVolver = new JButton("Volver");

        add(scrollPane, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);

        // Lógica para mostrar la biblioteca completa (debes agregarla)
        areaBiblioteca.setText("Aquí se mostrarían todos los libros de la biblioteca.");

        // Acción para volver al frame principal
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Ocultar la ventana de mostrar biblioteca
                InterfazPrincipal principalFrame = new InterfazPrincipal();
                principalFrame.setVisible(true);  // Mostrar el frame principal
            }
        });
    }
}
