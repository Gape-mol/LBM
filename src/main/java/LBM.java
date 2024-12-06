import Data.GestorDeArchivos;
import GUI.InterfazPrincipal;

public class LBM {
    public static void main(String[] args) {
        GestorDeArchivos gestor = new GestorDeArchivos();
        InterfazPrincipal principalFrame = new InterfazPrincipal(gestor.cargarBiblioteca("Biblioteca", "Direccion"));
        principalFrame.setVisible(true);
    }

}
