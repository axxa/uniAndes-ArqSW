package edu.uniandes.ecos.modelo.datos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ClasePrograma define cada clase encontrada en el programa completo y 
 * parametriza los datos como numero de lineas, numero de metodos y
 * la implementacion de los metodos.
 * @author Umbrella
 * @version 1.0.20150404
 * @since 1.0.20150404
 */
public class ClasePrograma {
    private String NombreClase;
    private long numeroLineas;
    private int numeroMetodos;
    private HashMap<String, ArrayList<String>> metodos;

    
    /**
     * DataEjercicio1_DatosClase
     * @param NombreClase:String
     * @param numeroLineas:long
     * @param numeroMetodos:int 
     */
    public ClasePrograma(String NombreClase, long numeroLineas, int numeroMetodos) {
        this.NombreClase = NombreClase;
        this.numeroLineas = numeroLineas;
        this.numeroMetodos = numeroMetodos;
        this.metodos = new HashMap<String, ArrayList<String>>();
    }
    
    public String getNombreClase() {
        return NombreClase;
    }

    public long getNumeroLineas() {
        return numeroLineas;
    }

    public int getNumeroMetodos() {
        return numeroMetodos;
    }

    public void setNombreClase(String NombreClase) {
        this.NombreClase = NombreClase;
    }

    public void setNumeroLineas(long numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    public void setNumeroMetodos(int numeroMetodos) {
        this.numeroMetodos = numeroMetodos;
    }    
    
    public HashMap<String, ArrayList<String>> getMetodos() {
        return this.metodos;
    }

    public void addMetodo(String nombre, ArrayList<String> cuerpo) {
        this.metodos.put(nombre, cuerpo);
    }
    
    public ArrayList<String> getCuerpoMetodo(String nombre) {
        return this.metodos.get(nombre);
    }
}
