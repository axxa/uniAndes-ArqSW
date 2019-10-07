package edu.uniandes.ecos.modelo.datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Clase Proyecto parametriza los datos del programa
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
        return this.rutaArchivosJava;
    }

    public void setRutaArchivosJava(HashMap<String, String> rutaArchivosJava) {
        this.rutaArchivosJava = rutaArchivosJava;
    }
    
    public String getNombreProyecto() {
        return this.nombreProyecto;
    }

    public ArrayList<ClasePrograma> getDatosClase() {
        return this.datosClase;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public void setDatosClase(ArrayList<ClasePrograma> datosClase) {
        this.datosClase = datosClase;
    }

    public boolean contieneClase(String nombre) {
        boolean contiene = false;
        
        for (ClasePrograma clase : this.datosClase) {
            if(nombre.equals(clase.getNombreClase())){
                contiene = true;
                break;
            }    
        }
        return contiene;
    }
    
    public ClasePrograma getClase(String nombre) throws Exception{
        ClasePrograma clasePrograma = null;
        
        if (this.contieneClase(nombre)){
            for (ClasePrograma clase : this.datosClase) {
                if(nombre.equals(clase.getNombreClase())){
                    clasePrograma = clase;
                    break;
                }    
            }
        } else {
            throw new Exception("Error: No se encuentra la clase " + nombre + "en el proyecto " + this.getNombreProyecto());
        }
        
        return clasePrograma;
    }
}
