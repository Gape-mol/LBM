import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazModificarLibro extends JFrame {

    public InterfazModificarLibro() {
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
        JLabel labelGenero = new JLabel("Nuevo Género:");
        JTextField campoGenero = new JTextField(20);

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
        add(labelGenero);
        add(campoGenero);
        add(btnModificar);
        add(btnVolver);

        // Acción para modificar el libro
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = campoISBN.getText();
                String titulo = campoTitulo.getText();
                String autor = campoAutor.getText();
                String anio = campoAnio.getText();
                String genero = campoGenero.getText();

                // Lógica para modificar el libro (debes agregarla)
                JOptionPane.showMessageDialog(null, "Libro modificado correctamente.");
                setVisible(false);
            }
        });

        // Acción para volver al frame principal
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Ocultar la ventana de modificar libro
                InterfazPrincipal principalFrame = new InterfazPrincipal();
                principalFrame.setVisible(true);  // Mostrar el frame principal
            }
        });
    }
}
