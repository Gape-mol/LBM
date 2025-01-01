package Model;

public class UsuarioConectado {

    /**
     * Clase para gestionar la sesión del usuario conectado.
     * Esta clase asegura que la información del usuario conectado esté disponible de forma global
     * sin necesidad de pasar la instancia del usuario entre ventanas o componentes.
     */
    private static Usuario UsuarioConectado;

    /**
     * Instancia estática del usuario conectado.
     * Solo puede haber un usuario conectado al mismo tiempo.
     */
    private UsuarioConectado() {}

    /**
     * Establece el usuario conectado.
     *
     * @param usuario el usuario que inicia sesión en el sistema.
     */
    public static void setUsuario(Usuario usuario) {
        UsuarioConectado = usuario;
    }

    /**
     * Obtiene el usuario conectado.
     *
     * @return el usuario actualmente conectado, o {@code null} si no hay usuario conectado.
     */
    public static Usuario getUsuario() {
        return UsuarioConectado;
    }

    /**
     * Verifica si hay un usuario conectado.
     *
     * @return {@code true} si hay un usuario conectado, de lo contrario {@code false}.
     */
    public static boolean estaLogueado() {
        return UsuarioConectado != null;
    }

    /**
     * Cierra la sesión del usuario conectado.
     * <p>
     * Establece la instancia del usuario conectado como {@code null}.
     */
    public static void logout() {
        UsuarioConectado = null;
    }
}
