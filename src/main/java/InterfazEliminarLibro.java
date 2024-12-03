import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEliminarLibro extends JFrame {

    public InterfazEliminarLibro() {
        setTitle("Eliminar Libro");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelISBN = new JLabel("ISBN del libro a eliminar:");
        JTextField campoISBN = new JTextField(20);
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnVolver = new JButton("Volver");

        add(labelISBN);
        add(campoISBN);
        add(btnEliminar);
        add(btnVolver);

        // Acción para eliminar el libro
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = campoISBN.getText();

                // Lógica para eliminar el libro (debes agregarla)
                JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
                setVisible(false);  // Cerrar la ventana
            }
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Ocultar la ventana de eliminar libro
                InterfazPrincipal principalFrame = new InterfazPrincipal();
                principalFrame.setVisible(true);  // Mostrar el frame principal
            }
        });
    }
}
