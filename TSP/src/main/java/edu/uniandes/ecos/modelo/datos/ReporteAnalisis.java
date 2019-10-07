/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelo.datos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase contenedora de los resultados del análisis practicado a los componentes
 * de un programa/proyecto.
 * @author Umbrella
 */
public class ReporteAnalisis {
    
    /**
     * Atributos principales
     */
    private ArrayList<ReporteAnalisis> hijos;
    private String nombre;
    private HashMap<String, Double>  resultados;
    
    /**
     * Constructor del reporte
     * @param nombre Nombre del reporte
     */
    public ReporteAnalisis(String nombre){
        this.nombre = nombre;
        this.hijos = new ArrayList<ReporteAnalisis>();
        this.resultados = new HashMap<String, Double>(); 
    }
   
    /**
     * Agrega reporte hijo, para el caso de reportes
     * anidados.
     * @param hijo Reporte con resultados asociados a esta clase.
     */
    public void setHijo(ReporteAnalisis hijo){
    	this.hijos.add(hijo);
    }
    
    /**
     * Devuelve listado de los hijos en una lista.
     * @return Listado de reportes hijos.
     */
    public ArrayList<ReporteAnalisis> getHijos(){
    	return this.hijos;
    }
    
    public String getNombre() {
        return nombre;
    }

    /**
     * Define un nombre para este reporte.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Permite acceder a los resultados relacionados con este reporte.
     * @return Retorna HashMap con los resultados donde.
     */
    public HashMap<String, Double> getResultados() {
        return resultados;
    }

    public void setResultado(String nombre, Double valor) {
        this.resultados.put(nombre, valor);
    }
}