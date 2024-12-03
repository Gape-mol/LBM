import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEliminarLibro extends JFrame {

    private Biblioteca biblioteca;

    public InterfazEliminarLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

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
        btnEliminar.addActionListener(e -> {
            String isbn = campoISBN.getText();
            biblioteca.eliminarLibroPorIsbn(isbn);

            JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }
}
