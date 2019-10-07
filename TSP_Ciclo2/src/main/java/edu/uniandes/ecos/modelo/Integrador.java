package edu.uniandes.ecos.modelo;

import java.util.ArrayList;

import edu.uniandes.ecos.modelo.datos.Proyecto;
import edu.uniandes.ecos.modelo.logica.ContadorJava;
import edu.uniandes.ecos.modelo.logica.IContador;
import edu.uniandes.ecos.modelo.logica.ManejadorProyectos;

/**
 *
 * @author JAVIER
 */
public class Integrador {
    
    public ArrayList<Proyecto> contarElementosPrograma() throws Exception{
        try{
            IContador contador = new ContadorJava();
            ArrayList<Proyecto> proyectos = ManejadorProyectos.obtenerProyectos("projects");
            return contador.contar(proyectos);
        }
        catch(Exception e){
            throw new Exception("Error en el metodo ejercicio1 del integrado, detalle: " + e.getMessage());
        }
    }
    
}
