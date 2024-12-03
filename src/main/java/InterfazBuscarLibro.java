import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazBuscarLibro extends JFrame {

    public InterfazBuscarLibro() {
        setTitle("Buscar Libro");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelISBN = new JLabel("ISBN del libro a buscar:");
        JTextField campoISBN = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        JButton btnVolver = new JButton("Volver");

        add(labelISBN);
        add(campoISBN);
        add(btnBuscar);
        add(btnVolver);

        // Acción para buscar el libro
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = campoISBN.getText();

                // Lógica para buscar el libro (debes agregarla)
                JOptionPane.showMessageDialog(null, "Libro encontrado.");
                setVisible(false);  // Cerrar la ventana
            }
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Ocultar la ventana de buscar libro
                InterfazPrincipal principalFrame = new InterfazPrincipal();
                principalFrame.setVisible(true);  // Mostrar el frame principal
            }
        });
    }
}
