/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelo.logica;

import edu.uniandes.ecos.modelo.datos.ClasePrograma;
import java.util.ArrayList;

import edu.uniandes.ecos.modelo.datos.Proyecto;
import edu.uniandes.ecos.modelo.datos.ReporteAnalisis;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que lleva a cabo el análisis de los componentes de cada proyecto.
 * @author Umbrella
 */
public class AnalizadorJava {
    
    /**
     * Atributos principales
     */
    private ArrayList<Proyecto> proyectos;
    private BufferedReader bf;
    private ArrayList<ReporteAnalisis> reportes;
    
    /**
     * Constructor del analizador
     * @param proyectos Listado de proyectos/programas que serán analizados.
     */
    public AnalizadorJava(ArrayList<Proyecto> proyectos){
        this.proyectos = proyectos;
    }
    
    /**
     * Método principal que inica el análisis del programa.
     * @return Listado con resultados del análisis
     */
    public ArrayList<ReporteAnalisis> analizar() {
        analizarProyectos();
        return this.reportes;
    }
    
    /**
     * Recorre el listado de proyectos de forma recursiva para extraer sus archivos
     * java y contar los elementos de interés. En este caso líneas de código y métodos
     * por cada clase.
     * @param proyectos Listado de proyectos que serán analizados.
     * @return Listado de proyectos actualizados con los valores del cada conteo.
     */
    private Proyecto extraerMetodosProyecto(Proyecto proyecto){
        
        try {
            
            ArrayList<ClasePrograma> listaClases = new ArrayList<ClasePrograma>();
            Iterator iterator = proyecto.getRutaArchivosJava().entrySet().iterator();
            

            while(iterator.hasNext()){
                
                ClasePrograma clase;
                
                Map.Entry entry = (Map.Entry) iterator.next();
                
                try {
                    clase = proyecto.getClase((String) entry.getKey());
                } catch (Exception e) {
                	//System.out.println("No se encontró clase, creando una nueva");
                    clase = new ClasePrograma((String) entry.getKey(), 0, 0);
                }
                                
                FileReader fr = new FileReader((String)entry.getValue());
                this.bf = new BufferedReader(fr);
                String linea = this.bf.readLine();
                
                while(linea!=null) {
                    // Extrae el cuerpo del método
                    if(esMetodo(linea)){
                        
                        ArrayList<String> metodo = this.extraerMetodo();
                        clase.addMetodo(linea.replace("{", ""), metodo);
                    }
                    
                    linea = this.bf.readLine();
                }
                
                listaClases.add(clase);
            
            }
            
            proyecto.setDatosClase(listaClases);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContadorJava.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(ContadorJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proyecto;
    }

    
    /**
     * Lleva a cabo el análisis necesario sobre un proyecto delegando el análisis
     * de sus clases.
     */
    private void analizarProyectos(){
        this.reportes = new ArrayList<ReporteAnalisis>();
        
        for (Proyecto proyecto : this.proyectos) {
            proyecto = this.extraerMetodosProyecto(proyecto);
            ReporteAnalisis reporte = new ReporteAnalisis(proyecto.getNombreProyecto());
            
            for (ClasePrograma clase : proyecto.getDatosClase()) {
                this.analizarClase(clase, reporte);
            }
            this.reportes.add(reporte);
            
        }
    }
    
    /**
     * Lleva a cabo el análisis necesario sobre una clase delegando el análisis
     * de sus metodos.
     * @param clase ClasePrograma que será analizada
     * @param padre Reporte del proyecto al que se asociarán los resultados.
     */
    private void analizarClase(ClasePrograma clase, ReporteAnalisis padre){
        ReporteAnalisis reporte = new ReporteAnalisis(clase.getNombreClase());

        for (Map.Entry metodo : clase.getMetodos().entrySet()) {    
            this.analizarMetodo(metodo, reporte);
        }
        padre.setHijo(reporte);
    }
    
    /**
     * Lleva a cabo el análisis necesario sobre un método de clase.
     * @param metodo Método de clase que será analizada
     * @param padre Reporte de la clase al que se asociarán los resultados.
     */
    private void analizarMetodo(Map.Entry metodo, ReporteAnalisis padre){
        ReporteAnalisis reporte = new ReporteAnalisis((String) metodo.getKey());
        int arcos = 1;
        int nodos = 1;
        
        for (String linea : (ArrayList<String>) metodo.getValue()) {
			
        	if (linea.contains("if")){
                    arcos +=3;
                    nodos += 3;
                }
        	
        	if (linea.contains("Write") || linea.contains("return") || linea.contains("else")){
                    if (arcos > 1)
                        arcos++;
                    nodos++;
        	}
				
        }
                
        reporte.setResultado("Complejidad McCabe", (double) Calculador.calcularMcCabe(arcos, nodos));
        padre.setHijo(reporte);
    }
    

    /**
     * Extrae las líneas de código que implementan un método.
     * @return Listado de strings con cada línea de la implementación.
     * @throws IOException
     */
    private ArrayList<String> extraerMetodo() throws IOException {
        ArrayList<String> metodo = new ArrayList<String>();
        String linea = this.bf.readLine();
        Boolean sentenciaAbierta = false;
        
        while (sentenciaAbierta == true || !linea.trim().equals("}")){
            
        	if (this.abreSentencia(linea))
            	sentenciaAbierta = true;
        		
            if (this.cierraSentencia(sentenciaAbierta, linea))
            	sentenciaAbierta = false;
        	
            linea = linea.trim();
        	
            if(!linea.equals("")){
                metodo.add(linea);
            }
            
            linea = this.bf.readLine();
            
        }
        
        return metodo;
    }

    /**
     * Revisa si la linea encontrada está abriendo alguna sentencia de control.
     * @param linea
     * @return Falso o Verdadero.
     */
    private boolean abreSentencia(String linea) {
        return linea.contains("{");
    }
    
    /**
     * Revisa si la linea encontrada está cerrando alguna sentencia de control.
     * @param sentenciaAbierta
     * @param linea
     * @return Falso o Verdadero.
     */
    private boolean cierraSentencia(Boolean sentenciaAbierta, String linea) {
        return sentenciaAbierta && linea.contains("}");
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
}
