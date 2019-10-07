package edu.uniandes.ecos.modelo.datos;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Clase DataEjercicio1_DatosProyecto parametriza los datos del programa
 * @author Umbrella
 * @version 1.0.20150404
 * @since 1.0.20150404
 */
public class Proyecto {
	
    private String nombreProyecto;
    
    private HashMap<String,String> rutaArchivosJava;
    
    private ArrayList<ClasePrograma> datosClase;
    /**
     * DataEjercicio1_DatosProyecto
     * @param nombreProyecto:String
     * @param rutaArchivosJava:HashMap(String,String)
     */
    public Proyecto(String nombreProyecto, HashMap<String,String> rutaArchivosJava) {
        this.nombreProyecto = nombreProyecto;
        this.rutaArchivosJava = rutaArchivosJava;
    }

    public HashMap<String, String> getRutaArchivosJava() {
        return rutaArchivosJava;
    }

    public void setRutaArchivosJava(HashMap<String, String> rutaArchivosJava) {
        this.rutaArchivosJava = rutaArchivosJava;
    }
    
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public ArrayList<ClasePrograma> getDatosClase() {
        return datosClase;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public void setDatosClase(ArrayList<ClasePrograma> datosClase) {
        this.datosClase = datosClase;
    }
}
