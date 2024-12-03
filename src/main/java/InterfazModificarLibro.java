import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazModificarLibro extends JFrame {

    private Biblioteca biblioteca;

    public InterfazModificarLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Modificar Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelISBN = new JLabel("ISBN del libro a modificar:");
        JTextField campoISBN = new JTextField(20);
        JLabel labelTitulo = new JLabel("Nuevo Título:");
        JTextField campoTitulo = new JTextField(20);
        JLabel labelAutor = new JLabel("Nuevo Autor:");
        JTextField campoAutor = new JTextField(20);
        JLabel labelAnio = new JLabel("Nuevo Año:");
        JTextField campoAnio = new JTextField(20);
        JLabel labelEditorial = new JLabel("Nueva Editorial:");
        JTextField campoEditorial = new JTextField(20);

        JButton btnModificar = new JButton("Modificar");
        JButton btnVolver = new JButton("Volver");

        add(labelISBN);
        add(campoISBN);
        add(labelTitulo);
        add(campoTitulo);
        add(labelAutor);
        add(campoAutor);
        add(labelAnio);
        add(campoAnio);
        add(labelEditorial);
        add(campoEditorial);
        add(btnModificar);
        add(btnVolver);

        // Acción para modificar el libro
        btnModificar.addActionListener(e -> {
            String isbn = campoISBN.getText();
            String titulo = campoTitulo.getText();
            String autor = campoAutor.getText();
            int anio = Integer.parseInt(campoAnio.getText());
            String editorial = campoEditorial.getText();

            biblioteca.modificarLibro(isbn, titulo, autor, isbn, editorial, anio);

            JOptionPane.showMessageDialog(null, "Libro modificado correctamente.");
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

