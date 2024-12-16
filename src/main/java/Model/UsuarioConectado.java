package Model;

public class UsuarioConectado {

    //Esta clase unicamente se encarga de mantener la sesion del usuario conectado. Esto para no tener que pasar el usuario por cada ventana que se abra.

    private static Usuario UsuarioConectado;

    private UsuarioConectado() {}

    public static void setUsuario(Usuario usuario) {
        UsuarioConectado = usuario;
    }

    public static Usuario getUsuario() {
        return UsuarioConectado;
    }

    public static boolean estaLogueado() {
        return UsuarioConectado != null;
    }

    public static void logout() {
        UsuarioConectado = null;
    }
}
