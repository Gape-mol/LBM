import Data.GestorDeArchivos;
import GUI.InterfazInicioDeSesion;
import GUI.InterfazPrincipal;
import Model.Usuario;

public class LBM {
    public static void main(String[] args) {
        GestorDeArchivos gestor = new GestorDeArchivos();
        InterfazInicioDeSesion loginFrame = new InterfazInicioDeSesion();
        loginFrame.setVisible(true);
    }

}
