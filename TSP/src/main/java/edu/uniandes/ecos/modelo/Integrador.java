package edu.uniandes.ecos.modelo;

import java.util.ArrayList;

import edu.uniandes.ecos.modelo.datos.Proyecto;
import edu.uniandes.ecos.modelo.datos.ReporteAnalisis;
import edu.uniandes.ecos.modelo.logica.AnalizadorJava;
import edu.uniandes.ecos.modelo.logica.ContadorJava;
import edu.uniandes.ecos.modelo.logica.IContador;
import edu.uniandes.ecos.modelo.logica.ManejadorProyectos;

/**
 *
 * @author Umbrella
 */
public class Integrador {
    
    private ArrayList<Proyecto> proyectos;
    
    public Integrador(){
        this.proyectos = ManejadorProyectos.obtenerProyectos("projects");
    }
    
    public ArrayList<Proyecto> contarElementosPrograma() throws Exception{
        try{
            IContador contador = new ContadorJava();
            return contador.contar(this.proyectos);
        }
        catch(Exception e){
            throw new Exception("Error en el metodo contarElementosPrograma del integrador, detalle: " + e.getMessage());
        }
    }

    public ArrayList<ReporteAnalisis> analizarPrograma() throws Exception{
        try{
            AnalizadorJava analizador = new AnalizadorJava(this.proyectos);
            return analizador.analizar();
        }
        catch(Exception e){
            throw new Exception("Error en el metodo analizarPrograma del integrador, detalle: " + e.getMessage());
        }
    }
    
}
