/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uniandes.ecos.modelo.logica;


import java.util.ArrayList;

import edu.uniandes.ecos.modelo.datos.Proyecto;

/**
 * Interfaz que abstrae la lógica del conteo de atributos del programa
 * que se desea analizar.
 * @author Umbrella
 */
public interface IContador {
	
	/**
	 * Método encargado de realizar el conteo de los datos requeridos para
	 * analizar un programa.
	 * @param listaProyectos: Listado de proyectos a ser analizados.
	 * fuente del programa que será analizado.
	 * @return Retorna un listado con el resultado del conteo. 
	 */
	public ArrayList<Proyecto> contar(ArrayList<Proyecto> listaProyectos);
}
