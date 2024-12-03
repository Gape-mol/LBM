import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearLibro extends JFrame {

    private Biblioteca biblioteca;

    public InterfazCrearLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Crear Libro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel labelTitulo = new JLabel("Título:");
        JTextField campoTitulo = new JTextField(20);
        JLabel labelAutor = new JLabel("Autor:");
        JTextField campoAutor = new JTextField(20);
        JLabel labelISBN = new JLabel("ISBN:");
        JTextField campoISBN = new JTextField(20);
        JLabel labelAnio = new JLabel("Año:");
        JTextField campoAnio = new JTextField(20);
        JLabel labelEditorial = new JLabel("Editorial:");
        JTextField campoEditorial = new JTextField(20);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnVolver = new JButton("Volver");

        add(labelTitulo);
        add(campoTitulo);
        add(labelAutor);
        add(campoAutor);
        add(labelISBN);
        add(campoISBN);
        add(labelAnio);
        add(campoAnio);
        add(labelEditorial);
        add(campoEditorial);
        add(btnGuardar);
        add(btnVolver);

        // Acción para guardar el libro
        btnGuardar.addActionListener(e -> {
            String titulo = campoTitulo.getText();
            String autor = campoAutor.getText();
            String isbn = campoISBN.getText();
            int anio = Integer.parseInt(campoAnio.getText());
            String editorial = campoEditorial.getText();

            biblioteca.crearLibro(titulo, autor, isbn, editorial, anio);

            JOptionPane.showMessageDialog(null, "Libro guardado correctamente.");
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(e -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true); // Volver a la ventana principal
        });
    }
}
