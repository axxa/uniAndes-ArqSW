/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelo.logica;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.uniandes.ecos.modelo.datos.ClasePrograma;
import edu.uniandes.ecos.modelo.datos.Proyecto;

/**
 * Clase encargada de contar líneas de código y métodos definidos dentro de un proyecto Java,
 * implementa una interfaz contador genérico.
 * @author Umbrella
 * @version 1.0.20150404
 * @since 1.0.20150404
 */
public class ContadorJava implements IContador{
	
	
	/**
	 * Recorre el listado de proyectos de forma recursiva para extraer sus archivos
	 * java y contar los elementos de interés. En este caso líneas de código y métodos
	 * por cada clase.
	 * @param proyectos Listado de proyectos que serán analizados.
	 * @return Listado de proyectos actualizados con los valores del cada conteo.
	 */
    private ArrayList<Proyecto> contarPartesProyecto(ArrayList<Proyecto> proyectos){
        
        try {
            for(int i = 0; i < proyectos.size(); i++){
                ArrayList<ClasePrograma> listaDatosClase = new ArrayList<ClasePrograma>();
                Iterator iterator = proyectos.get(i).getRutaArchivosJava().entrySet().iterator();
                
                while(iterator.hasNext()){
                
                	Map.Entry entry = (Map.Entry) iterator.next();
                    long numeroLineas = 0;
                    int numeroMetodos = 0;
                    FileReader fr = new FileReader((String)entry.getValue());
                    BufferedReader bf = new BufferedReader(fr);
                    String linea = bf.readLine();
                    
                    while(linea!=null) {
                        //Numero de lineas en la clase
                        if(!linea.trim().equals(""))
                            numeroLineas++;
                        //Numero de metodos de la clase
                        if(esMetodo(linea))
                            numeroMetodos++;
                        linea = bf.readLine();
                    }
                    
                    ClasePrograma datosClase = new ClasePrograma((String) entry.getKey(), numeroLineas, numeroMetodos);
                    listaDatosClase.add(datosClase);
                    proyectos.get(i).setDatosClase(listaDatosClase);
                    
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContadorJava.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(ContadorJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proyectos;
    }

    /**
     * Método encargado de verificar si la línea actual define o no un método
     * en Java.
     * @param linea String correspondiente a la línea de código leida.
     * @return Verdadero si la linea es un método, de lo contrario retorna falso.
     */
    private boolean esMetodo(String linea){
    	
    	if ((linea.contains("public") || linea.contains("private") || linea.contains("protected"))&& linea.contains("(") && linea.contains(")") && linea.contains("{")){
    		return true;
    	}
    	return false;
    }
    
    /**
     * Implementación del método principal definido en la interfaz.
     */
	public ArrayList<Proyecto> contar(ArrayList<Proyecto> proyectos) {
		return contarPartesProyecto(proyectos);		
	}
}
