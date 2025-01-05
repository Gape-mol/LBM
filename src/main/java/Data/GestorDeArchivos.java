package Data;

import Model.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Clase para gestionar el guardado y cargado de archivos de datos
 */

public class GestorDeArchivos {

    /**
     * Metodo para cargar la biblioteca al inicio de la aplicacion
     * @param nombre nombre de la biblioteca en caso de que el usuario no tenga una creada previamente
     * @param direccion direccion fisica de la biblioteca, en caso de que no haya una biblioteca guardada previamente
     * @return Devuelve al usuario una biblioteca vacia en caso de que el usuario no tenga una guardada previamente
     */

    public Biblioteca cargarBiblioteca(String nombre, String direccion){
        Gson gson = new Gson();
        Biblioteca bilioteca = new Biblioteca(nombre, direccion);
        try {
            bilioteca = gson.fromJson(new FileReader("BibliotecaData.json"), Biblioteca.class);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo previo guardado");
        }
        return bilioteca;
    }

    /**
     * Metodo para retornar lista de usuarios creados y guardados
     * @return lista de usuarios, en caso de no encontrar el archivo retorna una lista vacia
     */

    public ArrayList<Usuario> cargarUsuarios(){
        Gson gson = new Gson();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Type usuarioListType = new TypeToken<ArrayList<Usuario>>() {}.getType();
        try {
            usuarios = gson.fromJson(new FileReader("UsuariosData.json"), usuarioListType);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        }
        return usuarios;
    }

    /**
     * Metodo para guardar los datos de la biblioteca
     * @param biblioteca biblioteca de sera guardada en formato "json"
     * @return retorna un valor true en caso de que el archivo se guardara correctamente, falso en el caso contrario
     */

    public boolean guardarBiblioteca(Biblioteca biblioteca) {
        boolean guardado = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("BibliotecaData.json")){
            gson.toJson(biblioteca, writer);
            guardado = true;
        } catch (IOException | JsonSyntaxException e) {
            guardado = false;
        }
        return guardado;
    }

    /**
     * Metodo para guardar lista de usuarios
     * @param usuarios Lista de usuarios que seran guardados en formato "json"
     * @return retorna un valor true en caso de que se hayan guardado correctamente, false en el caso contrario
     */

    public boolean guardarUsuarios(ArrayList<Usuario> usuarios) {
        boolean guardado = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("UsuariosData.json")) {
            gson.toJson(usuarios, writer);
            guardado = true;
        } catch (IOException | JsonIOException e) {
            guardado = false;
        }
        return guardado;
    }

    /**
     * Metodo para guardar las reservas de libros
     * @param reservas lista de reservas que seran guardadas
     * @return retorna un valor de true si la lista se guarda correctamente, false en el caso contrario
     */

    public boolean guardarReservas(ArrayList<Reserva> reservas) {
        boolean guardado = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("ReservasData.json")) {
            gson.toJson(reservas, writer);
            guardado = true;
        } catch (IOException | JsonIOException e) {
            guardado = false;
        }
        return guardado;
    }

    /**
     * Metodo para cargar las reservas guardadas previamentes en formato "json"
     * @return Retorna un lista vacia en caso de no existir una previamente guardada, en caso contrario retorna la lista guardada
     */

    public ArrayList<Reserva> cargarReservas(){
        Gson gson = new Gson();
        ArrayList<Reserva> reservas = new ArrayList<>();

        Type reservaListType = new TypeToken<ArrayList<Reserva>>() {}.getType();
        try {
            reservas = gson.fromJson(new FileReader("ReservasData.json"), reservaListType);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        }
        return reservas;
    }

}
