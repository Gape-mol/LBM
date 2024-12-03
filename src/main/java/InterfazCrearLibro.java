import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearLibro extends JFrame {

    public InterfazCrearLibro() {
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
        JLabel labelGenero = new JLabel("Género:");
        JTextField campoGenero = new JTextField(20);

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
        add(labelGenero);
        add(campoGenero);
        add(btnGuardar);
        add(btnVolver);

        // Acción para guardar el libro
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                String isbn = campoISBN.getText();
                String anio = campoAnio.getText();
                String genero = campoGenero.getText();

                // Agregar lógica para guardar el libro aquí
                JOptionPane.showMessageDialog(null, "Libro guardado correctamente.");
                setVisible(false); // Cerrar la ventana de creación
            }
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Cerrar la ventana actual
                InterfazPrincipal principalFrame = new InterfazPrincipal();
                principalFrame.setVisible(true); // Mostrar el frame principal
            }
        });
    }
}
