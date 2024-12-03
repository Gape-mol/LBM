import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazMostrarBiblioteca extends JFrame {

    private Biblioteca biblioteca;

    public InterfazMostrarBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Mostrar Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea areaLibros = new JTextArea();
        areaLibros.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaLibros);

        JButton btnVolver = new JButton("Volver");

        // Mostrar los libros
        if (biblioteca.getLibros().isEmpty()) {
            areaLibros.setText("La biblioteca está vacía, no hay libros por mostrar.");
        } else {
            StringBuilder librosInfo = new StringBuilder();
            for (Libro libro : biblioteca.getLibros()) {
                librosInfo.append("Título: ").append(libro.getTitulo())
                        .append("\nAutor: ").append(libro.getAutor())
                        .append("\nISBN: ").append(libro.getIsbn())
                        .append("\nEditorial: ").append(libro.getEditorial())
                        .append("\nAño: ").append(libro.getYear())
                        .append("\n\n");
            }
            areaLibros.setText(librosInfo.toString());
        }

        add(scrollPane, BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);

        // Acción para volver al menú principal
        btnVolver.addActionListener((ActionEvent e) -> {
            setVisible(false);
            new InterfazPrincipal(biblioteca).setVisible(true);
        });
    }
}
