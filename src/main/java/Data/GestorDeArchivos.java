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

public class GestorDeArchivos {

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
