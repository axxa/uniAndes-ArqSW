package edu.uniandes.ecos.modelo.logica;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import edu.uniandes.ecos.modelo.datos.Proyecto;
/**
 * Clase ManejadorProyectos recorre todas las carpetas del programa para encontrar clases
 * @author Umbrella
 * @version 1.0.20150404
 * @since 1.0.20150404
 */
public class ManejadorProyectos {
	

	/**
     * obtenerProyectos
     * @param ruta:String
     * @return proyectos:ArrayList(DataEjercicio1_DatosProyecto)
     */
    public static ArrayList<Proyecto> obtenerProyectos(String ruta){
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        File directorio = new File(ruta);
        File listaProyectos[] = directorio.listFiles();
        
        for(int i = 0; i<listaProyectos.length; i++){
            String nombreProyecto = listaProyectos[i].getName();
            HashMap<String,String> rutaArchivosJava = new HashMap<String,String>();
            ManejadorProyectos.obtenerArchivosJava(listaProyectos[i].getPath(), rutaArchivosJava);

            if (!rutaArchivosJava.isEmpty()){
            	Proyecto proyecto = new Proyecto(nombreProyecto, rutaArchivosJava);
            	proyectos.add(proyecto);
            }
        }
        
        return proyectos;
    }
    /**
     * obtenerArchivosJava
     * @param ruta:String
     * @param rutaArchivosJava:HashMap(String,String)
     */
    private static void obtenerArchivosJava(String ruta, HashMap<String,String> rutaArchivosJava){
        File directorio = new File(ruta);
        File listaDirectorios[] = directorio.listFiles();
        for(int i = 0; i<listaDirectorios.length; i++){
            if(listaDirectorios[i].isDirectory())
                obtenerArchivosJava(listaDirectorios[i].getAbsolutePath(), rutaArchivosJava);
            else{
                if(listaDirectorios[i].getName().contains(".java"))
                    rutaArchivosJava.put(listaDirectorios[i].getName(),listaDirectorios[i].getAbsolutePath());
            }
        }
    }
}
